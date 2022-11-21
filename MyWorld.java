    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class MyWorld here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class MyWorld extends World {
    Caixa caixa = new Caixa();      //cria uma referencia ao Actor Caixa
    Caixa1 caixa1 = new Caixa1();   //cria uma referencia ao Actor Caixa1
    Caixa2 caixa2 = new Caixa2();   //cria uma referencia ao Actor Caixa2   
    HealthGirl hg = new HealthGirl();   //cria uma referencia ao Actor HealthGirl
    HealthBoy hb = new HealthBoy();     //cria uma referencia ao Actor HealthBoy  
    FoodBoy fb = new FoodBoy();     //cria uma referencia ao Actor FoodBoy 
    FoodGirl fg = new FoodGirl();   //cria uma referencia ao Actor FoodGirl  
    DropBoy wb = new DropBoy();     //cria uma referencia ao Actor DropBoy  
    DropGirl wg = new DropGirl();   //cria uma referencia ao Actor DropGirlthGirl  
    MadeiraA m = new MadeiraA();    //cria uma referencia ao Actor MadeiraA 
    Calhau c = new Calhau();        //cria uma referencia ao Actor Calhau
    Key k = new Key();      //cria uma referencia ao Actor Key
    Score scr = new Score();        //cria uma referencia ao Actor Score
    public void act(){
        
        showText("Madeira: "+m.getMadeira(), 733, 785); //texto com a quantidade de madeira no inventario
        showText("Pedra: "+c.getPedra(), 725, 765); //texto com a quantidade de pedra no inventario
        showText("Key: "+k.getKey(), 725,745);  //texto com a quantidade de keys no inventario
        
        showText("W: " +wb.getWaterB(), 64,63);//Sede do Rapaz
        showText("F: " +fb.getFoodB(), 65,38);//Comida do Rapaz
        showText("H: " +hb.getHealthB(), 65,13);//Vida do Rapaz
        
        showText("W: " +wg.getWaterG(), 736,63);//Sede da Rapariga
        showText("F: " +fg.getFoodG(),735,38);//Comida da Rapariga
        showText("H: " +hg.getHealthG(), 735,13);//Vida da Rapariga
        
        showText("Score: "+scr.getScore(), 400, 13);
    }
    public MyWorld(){
        super(800, 800, 1); //Cria um mundo 800x800 com resuluçao de 1 pixel

        setPaintOrder(Boy.class,Button.class,MadeiraA.class,Calhau.class,Key.class);
        setBackground("world-barco.jpg");
        
        puzzle();   //coloca os atores no mundo
        IndicadoresB(); //Indicadores de vida dos jogadores
        IndicadoresG();
        
        //adiciona as variaveis valores iniciais
        hg.setHealthG(30);
        hb.setHealthB(30);
        fb.setFoodB(40);
        fg.setFoodG(40);
        wb.setWaterB(20);
        wg.setWaterG(20);
        scr.setScore(0);
        m.setMadeira(0);
        c.setPedra(0);
        k.setKey(0);
               
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
    
    /**
     * Codigo para a criação do puzzle inicial.
     * Criar todos os objectos presentes nessa scene.
     */
    public void puzzle(){
        addObject(new Balsa(),getWidth()-120,getHeight()-590);
        addObject(new Porta(),getWidth()-613,getHeight()-317);
        addObject(new Porta(),getWidth()-265,getHeight()-436);
        addObject(new Button(),getWidth()-259,getHeight()-230);
        //addObject(new Faisca(),getWidth()-515,getHeight()-390);
        addObject(new Ar(),getWidth()-455,getHeight()-345);
        addObject(new Ar(),getWidth()-385,getHeight()-345);
        addObject(caixa,120,470);
        addObject(caixa1,480,470);
        addObject(caixa2,430,600);
        //paredes de limite
        //baixo
        addObject(new Limite(),getWidth()-560,getHeight()-165);
        addObject(new Limite(),getWidth()-300,getHeight()-165);
        //meio-direita
        addObject(new Limite(),getWidth()-300,getHeight()-305);
        addObject(new Limite(),getWidth()-425,getHeight()-305);
        //meio-esquerda
        addObject(new Limite(),getWidth()-810,getHeight()-305);
        //meio-teto-direita
        addObject(new Limite(),getWidth()-580,getHeight()-430);
        addObject(new Limite(),getWidth()-455,getHeight()-430);
        //meio-teto-esquerda
        addObject(new Limite(),getWidth()-70,getHeight()-430);
        //cima-esquerda
        addObject(new Limite(),getWidth()-280,getHeight()-562);
        addObject(new Limite(),getWidth()-400,getHeight()-562);
        //cima-direita
        addObject(new Limite(),getWidth()-810,getHeight()-562);
        //vertical
        addObject(new LimiteV(),getWidth()-710,getHeight()-350);
        addObject(new LimiteV(),getWidth()-180,getHeight()-310);
        //Personagens
        addObject(new Girl(),getWidth()-220,getHeight()-340);
        addObject(new Boy(),getWidth()-550,getHeight()-200);
    }
}

