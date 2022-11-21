import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balsa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balsa extends Actor
{
    /**
     * Act - do whatever the Balsa wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld MyGame;
    private int n = 0;
    private Text balsa=new Text();      //cria uma referencia para o texto.
    public void act() {
       soltarBalsa();
       //Quando a balsa toca no limite do mundo, muda para o mundo Oceano.
       if (isAtEdge()){
            HealthGirl hg = new HealthGirl();//cria uma referencia ao Actor HealthGirl
            HealthBoy hb = new HealthBoy(); //cria uma referencia ao Actor HealthBoy
            FoodBoy fb = new FoodBoy();     //cria uma referencia ao Actor FoodBoy
            FoodGirl fg = new FoodGirl();   //cria uma referencia ao Actor FoodGirl
            DropBoy wb = new DropBoy();     //cria uma referencia ao Actor DropBoy
            DropGirl wg = new DropGirl();   //cria uma referencia ao Actor DropGirl
            MadeiraA m = new MadeiraA();    //cria uma referencia ao Actor MadeiraA
            Calhau c = new Calhau();        //cria uma referencia ao Actor Calhau
            Score scr = new Score();        //cria uma referencia ao Actor Score
            scr.addScore(1000);
            Greenfoot.setWorld(new Oceano(hb.getHealthB(),hg.getHealthG(),fb.getFoodB(),fg.getFoodG(),wb.getWaterB(),wg.getWaterG(),m.getMadeira(),c.getPedra(),scr.getScore()));
       }
    }    
    //Faz o actor Balsa subir quando os personagens precionam as teclas indicadas pelo texto.
    public void soltarBalsa(){
        getWorld().addObject(balsa, 400, 650);
        Actor text = getOneIntersectingObject(Text.class);
        if (Greenfoot.isKeyDown("E") && Greenfoot.isKeyDown("I")){
            if (isTouching(Boy.class) && isTouching(Girl.class)){
               n = 1;
            }
            if(n==1){
                setRotation(90);
                move(-4);
            }
        }
        if (isTouching(Boy.class) && isTouching(Girl.class)){
            balsa.setText("(E) e (I): Soltar a balsa.");
        }
        else if(!isTouching(Boy.class))
            balsa.setText("");
    }
}
