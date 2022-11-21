import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ilha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ilha extends World {
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
        
        showText("Madeira: "+m.getMadeira(), 733, 785); //texto com a quantidade de madeira no inventario
        showText("Pedra: "+c.getPedra(), 725, 765); //texto com a quantidade de pedra no inventario
        
        showText("W: " +wb.getWaterB(), 64,63);//Sede do Rapaz
        showText("F: " +fb.getFoodB(), 65,38);//Comida do Rapaz
        showText("H: " +hb.getHealthB(), 65,13);//Vida do Rapaz
        
        showText("W: " +wg.getWaterG(), 736,63);//Sede da Rapariga
        showText("F: " +fg.getFoodG(),735,38);//Comida da Rapariga
        showText("H: " +hg.getHealthG(), 735,13);//Vida da Rapariga
        
        showText("Score: "+scr.getScore(), 400, 13);
    }
    public Ilha(){
        super(800, 800, 1); //Cria um mundo 800x800 com resuluçao de 1 pixel
    }
    public Ilha(int HB, int HG, int FB, int FG, int WB, int WG, int madeira, int pedra, int score){
        super(800, 800, 1); //Cria um mundo 800x800 com resuluçao de 1 pixel
        
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
        IndicadoresG(); //Indicadores de vida dos jogadores
        IndicadoresB();
    }
    public void populate(){
        //Criação do cenario.
        addObject(new Lago(),260,310);
        addObject(new Floresta(),348,405);
        addObject(new Rocha(),467,166);
        addObject(new SoS(), 640, 450);
        addObject(new Palmeira3(),163,151);
        addObject(new Girl(),500,320);
        addObject(new Boy(),500,390);
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
