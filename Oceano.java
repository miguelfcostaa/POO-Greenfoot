import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oceano extends World{
    private int counter = 0, counter2 = 0, counter3 = 0;   
    private int imageCount = 0;
    private GreenfootImage bgImage = new GreenfootImage("oceanoworld.jpg");
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
        checkSpawning(); //utiliza 1 contador para adicionar actors ao mundo, outro para adicionar um boss uma unica vez, e outro para parar tudo.
        
        showText("Madeira: "+m.getMadeira(), 733, 785); //texto com a quantidade de madeira no inventario
        showText("Pedra: "+c.getPedra(), 725, 765); //texto com a quantidade de pedra no inventario
        
        showText("W: " +wb.getWaterB(), 64,63);//Sede do Rapaz
        showText("F: " +fb.getFoodB(), 65,38);//Comida do Rapaz
        showText("H: " +hb.getHealthB(), 65,13);//Vida do Rapaz
        
        showText("W: " +wg.getWaterG(), 736,63);//Sede da Rapariga
        showText("F: " +fg.getFoodG(),735,38);//Comida da Rapariga
        showText("H: " +hg.getHealthG(), 735,13);//Vida da Rapariga
        
        showText("Score: "+scr.getScore(), 400, 13);
        
        imageCount -= 1;
        drawBackgroundImage();
    }

    public void drawBackgroundImage(){
        if (imageCount <-bgImage.getWidth()){
            imageCount+= bgImage.getWidth();
        }
        int temp = imageCount;
        getBackground().drawImage(bgImage, temp, 0);
        getBackground().drawImage(bgImage, temp + bgImage.getWidth(), 0);
    }

    public Oceano(){
        super(800, 800, 1); //cria um mundo 800x800 pixels
    }

    public Oceano(int HB, int HG, int FB, int FG, int WB, int WG, int madeira, int pedra, int score){
        super(800, 800, 1); //cria um mundo 800x800 pixels
        setPaintOrder(Ilha.class,Raft.class,Boia.class,Banana.class);
        //Greenfoot.playSound("som-ambiente.wav"); //musica de fundo
        
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

        prepareMundo(); //adiciona os atores ao mundo
        
        IndicadoresB();
        IndicadoresG(); //Indicadores de vida dos jogadores
    } 

    private void prepareMundo(){
        removeObjects(getObjects(Actor.class)); //limpar o mundo

        addObject(new Raft(), 80,330);
        addObject(new Pause(), 25, 775);
        addObject(new TeclaD(), 79, 775);
        addObject(new TeclaA(), 129, 775);
        addObject(new TeclaR(), 179, 775);
        addObject(new TeclaW(), 129, 727);
    }

    private void checkSpawning(){
        int y = Greenfoot.getRandomNumber(700-100);
        if(counter3 < 2500){
            if (counter == 80){
                //Aqui vamos adicionar uma nova Madeira no mundo.
                addObject(new Madeira(), 800, y);
            }
            if (counter == 140){
                //Aqui vamos adicionar um novo Petroleo no mundo.
                addObject(new Petroleo(), 800, y);
            }
            if (counter == 190){
                //Aqui vamos adicionar uma nova Banana no mundo.
                addObject(new Banana(), 800, y);
            }
            if (counter == 240){
                //Aqui vamos adicionar uma nova Boia no mundo.
                addObject(new Boia(), 800, y);
            }
            if (counter == 280){
                //Aqui vamos adicionar um novo Coco no mundo.
                addObject(new Coco(), 800, y);
                counter = 0;
            }
            if (counter2 == 1500){
                //Aqui vamos adicionar um novo Shark no mundo.
                addObject(new Shark(), 800, y);
                counter2 = 0;
            }
        }
        if (counter3 == 3000){
            //Aqui vamos adicionar a Ilha, e assim que tocar na Ilha, muda para o mundo da Ilha
            addObject(new IlhaObject(), 800, 350);
            counter = 281; counter2 = 1501;
        }
        else{
            counter++;
            counter2++;
            counter3++;
        }
    }
    //Indicadores de vida , fome e sede para o rapaz.
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
