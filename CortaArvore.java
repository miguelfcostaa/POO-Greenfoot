import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CortaArvore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CortaArvore extends World {
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
        showText("Madeira: "+m.getMadeira(), 633, 685); //texto com a quantidade de madeira no inventario
        showText("Pedra: "+c.getPedra(), 625, 665); //texto com a quantidade de pedra no inventario
        
        showText("W: " +wb.getWaterB(), 64,63);//Sede do Rapaz
        showText("F: " +fb.getFoodB(), 65,38);//Comida do Rapaz
        showText("H: " +hb.getHealthB(), 65,13);//Vida do Rapaz
        
        showText("W: " +wg.getWaterG(), 636,63);//Sede da Rapariga
        showText("F: " +fg.getFoodG(), 635,38);//Comida da Rapariga
        showText("H: " +hg.getHealthG(), 635,13);//Vida da Rapariga
        
        showText("Score: "+scr.getScore(), 400, 13);
    }
    public CortaArvore(){
        super(700, 700, 1); 
    }
    public CortaArvore(int HB, int HG, int FB, int FG, int WB, int WG, int madeira, int pedra,int score){    
        super(700, 700, 1); //cria um mundo 700x700
        setPaintOrder(Boy.class, Girl.class,Arvore.class,LimiteBack.class,Limite.class);
        
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
        IndicadoresB(); //Indicadores de vida dos jogadores
        IndicadoresG();
    }
    public void populate(){
        addObject(new Girl(),600,553);
        addObject(new Boy(),100,553);
        addObject(new Limite(),160,526);
        addObject(new Limite(),540,526);
        addObject(new Limite(),160,583);
        addObject(new Limite(),540,583);
        addObject(new Arvore(),350,435);
        addObject(new LimiteV(),300,400);
        addObject(new LimiteV(),420,400);
        addObject(new LimiteBack(),1,580);
        addObject(new LimiteBack(),699,580);
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
        addObject(new DropGirl(),685,59);
        addObject(new DropGirl2(),685,59);
        
        addObject(new HealthGirl(),685,15);
        addObject(new HealthGirl2(),685,15);
        
        addObject(new FoodGirl(),685,35);
        addObject(new FoodGirl2(),685,35);
    }
}
