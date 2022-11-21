import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SosMundo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SosMundo extends World {
    HealthGirl hg = new HealthGirl();   //cria uma referencia ao Actor HealthGirl
    HealthBoy hb = new HealthBoy();     //cria uma referencia ao Actor HealthBoy  
    FoodBoy fb = new FoodBoy();     //cria uma referencia ao Actor FoodBoy 
    FoodGirl fg = new FoodGirl();   //cria uma referencia ao Actor FoodGirl  
    DropBoy wb = new DropBoy();     //cria uma referencia ao Actor DropBoy  
    DropGirl wg = new DropGirl();   //cria uma referencia ao Actor DropGirlthGirl  
    MadeiraA m = new MadeiraA();    //cria uma referencia ao Actor MadeiraA 
    Calhau c = new Calhau();        //cria uma referencia ao Actor Calhau
    Score scr = new Score();        //cria uma referencia ao Actor Score
    Buraco b = new Buraco();      //cria uma referencia ao Actor Burraco
    public void act(){

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
    public SosMundo(){
        super(800, 800, 1);
    }
    public SosMundo(int HB, int HG, int FB, int FG, int WB, int WG, int madeira, int pedra,int score){    
        super(800, 800, 1); //cria um mundo 800x800
        
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
        b.setCounter(0);
        
        setPaintOrder(Boy.class,Girl.class,Rock.class,Buraco.class);
        //Indicadores de vida dos jogadores
        IndicadoresB(); 
        IndicadoresG();
        
        //coloca os atores no mundo
        addObject(new Boy(), 100, 100); 
        addObject(new Girl(), 150, 100);
        //serve para voltar à ilha
        addObject(new LimiteBack(),0,0);
        
        sinalSos(); //adiciona o actor Burraco para desenhar o S.O.S.
    }
    public void sinalSos(){
        addObject(new Buraco(), 100, 360);
        addObject(new Buraco(), 120, 375);
        addObject(new Buraco(), 150, 380);
        addObject(new Buraco(), 180, 375);
        addObject(new Buraco(), 200, 360);
        addObject(new Buraco(), 205, 330);
        addObject(new Buraco(), 180, 310);           //S
        addObject(new Buraco(), 150, 300);
        addObject(new Buraco(), 120, 290);
        addObject(new Buraco(), 100, 270);
        addObject(new Buraco(),  95, 245);
        addObject(new Buraco(), 110, 220);
        addObject(new Buraco(), 135, 215);
        addObject(new Buraco(), 160, 215);
        addObject(new Buraco(), 190, 220);
        
        addObject(new Buraco(), 300, 360);
        addObject(new Buraco(), 320, 375);
        addObject(new Buraco(), 350, 380);
        addObject(new Buraco(), 380, 375);
        addObject(new Buraco(), 400, 360);
        addObject(new Buraco(), 410, 330);
        addObject(new Buraco(), 415, 300);           //O
        addObject(new Buraco(), 418, 270);
        addObject(new Buraco(), 415, 240);
        addObject(new Buraco(), 400, 210);
        addObject(new Buraco(), 370, 200);
        addObject(new Buraco(), 340, 200);
        addObject(new Buraco(), 310, 210);
        addObject(new Buraco(), 290, 230);
        addObject(new Buraco(), 285, 260);
        addObject(new Buraco(), 280, 290);
        addObject(new Buraco(), 275, 320);
        addObject(new Buraco(), 285, 340);
        
        addObject(new Buraco(), 500, 310);
        addObject(new Buraco(), 520, 325);
        addObject(new Buraco(), 550, 330);
        addObject(new Buraco(), 580, 325);
        addObject(new Buraco(), 600, 310);
        addObject(new Buraco(), 605, 280);
        addObject(new Buraco(), 580, 260);           //S
        addObject(new Buraco(), 550, 250);
        addObject(new Buraco(), 520, 240);
        addObject(new Buraco(), 500, 220);
        addObject(new Buraco(), 495, 195);
        addObject(new Buraco(), 510, 170);
        addObject(new Buraco(), 535, 165);
        addObject(new Buraco(), 560, 165);
        addObject(new Buraco(), 590, 170);
        
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
