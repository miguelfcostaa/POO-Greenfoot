import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PartePedra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PartePedra extends World{
    private int counter = 0,counter2 = 0,counter3 = 0;
    HealthGirl hg = new HealthGirl();   //cria uma referencia ao Actor HealthGirl
    HealthBoy hb = new HealthBoy();     //cria uma referencia ao Actor HealthBoy  
    FoodBoy fb = new FoodBoy();     //cria uma referencia ao Actor FoodBoy 
    FoodGirl fg = new FoodGirl();   //cria uma referencia ao Actor FoodGirl  
    DropBoy wb = new DropBoy();     //cria uma referencia ao Actor DropBoy  
    DropGirl wg = new DropGirl();   //cria uma referencia ao Actor DropGirlthGirl  
    MadeiraA m = new MadeiraA();    //cria uma referencia ao Actor MadeiraA 
    Calhau c = new Calhau();        //cria uma referencia ao Actor Calhau
    Score scr = new Score();        //cria uma referencia ao Actor Score
    public void act(){
        checkSpawning(); //utiliza 1 contador para adicionar pedras ao mundo, outro para adicionar bigornas, e outro para parar tudo.
        showText("Madeira: "+m.getMadeira(), 633, 685); //texto com a quantidade de madeira no inventario
        showText("Pedra: "+c.getPedra(), 625, 665); //texto com a quantidade de pedra no inventario
        
        showText("W: " +wb.getWaterB(), 64,63);//Sede do Rapaz
        showText("F: " +fb.getFoodB(), 65,38);//Comida do Rapaz
        showText("H: " +hb.getHealthB(), 65,13);//Vida do Rapaz
        
        showText("W: " +wg.getWaterG(), 736,63);//Sede da Rapariga
        showText("F: " +fg.getFoodG(),735,38);//Comida da Rapariga
        showText("H: " +hg.getHealthG(), 735,13);//Vida da Rapariga
        
        showText("Score: "+scr.getScore(), 400, 13);
    }
    public PartePedra(){    
        super(800, 800, 1); 
    }
    public PartePedra(int HB, int HG, int FB, int FG, int WB, int WG, int madeira, int pedra, int score){    
        super(800, 800, 1); //cria um mundo 800x800
        setPaintOrder(Bigorna.class,Vagao.class,BoyTrab.class,GirlTrab.class);
        
        //Busca os valores recebidos e atualiza os valores novos
        wb.setWaterB(WB); 
        wg.setWaterG(WG); 
        fb.setFoodB(FB); 
        fg.setFoodG(FG); 
        hb.setHealthB(HB);  
        hg.setHealthG(HG);
        c.setPedra(pedra);
        m.setMadeira(madeira);
        scr.setScore(score);
        

        populate(); //coloca os atores no mundo

        addObject(new Limite(),160,720);
        addObject(new Limite(),340,720);  //coloca os limites no mundo
        addObject(new Limite(),560,720);
        addObject(new Limite(),740,720);
        
        IndicadoresB(); //Indicadores de vida dos jogadores
        IndicadoresG();
    }
    public void populate(){
        addObject(new GirlTrab(), 220, 690);
        addObject(new BoyTrab(), 85, 690); 
        addObject(new Vagao(), 150, 690);
        
        addObject(new Limite(),160,720);
        addObject(new Limite(),340,720);  //coloca os limites no mundo
        addObject(new Limite(),560,720);
        addObject(new Limite(),740,720);
        
        addObject(new TeclaE(), 100, 750);
        addObject(new TeclaI(), 700, 750);
    }
    private void checkSpawning(){
        int x = Greenfoot.getRandomNumber(600-200); //busca um numero random entre 600 e 200
        int x2 = Greenfoot.getRandomNumber(800);
        if(counter3 < 1500){
            if (counter == 110){
                addObject(new Calhau(), x, 0);
            }
            if (counter == 200){
                addObject(new Apple(), x, 0);
                counter = 0;
            }
            if (counter2 == 125){
                addObject(new Bigorna(), x2, 0);
            }
            if (counter2 == 175){
                addObject(new Bigorna(), x2, 0);
                counter2 = 0;
            }
        }
        if (counter3 == 1500){
            counter = 111; counter2 = 126;
            addObject(new LimiteBack(), 0, 690);
        }
        else{
            counter++;
            counter2++;
            counter3++;
        }
    }
    public void IndicadoresB(){
        addObject(new DropBoy(),15,59);
        addObject(new DropBoy2(),15,59);
        
        addObject(new HealthBoy(),15,15);
        addObject(new HealthBoy2(),15,15);
        
        addObject(new FoodBoy(),15,35);
        addObject(new FoodBoy2(),15,35);
    }
    //Indicadores de vida , fome e sede para a rapariga.
    public void IndicadoresG(){
        addObject(new DropGirl(),785,59);
        addObject(new DropGirl2(),785,59);
        
        addObject(new HealthGirl(),785,15);
        addObject(new HealthGirl2(),785,15);
        
        addObject(new FoodGirl(),785,35);
        addObject(new FoodGirl2(),785,35);
    }
}
