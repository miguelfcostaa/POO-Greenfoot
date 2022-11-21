import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoS extends Actor {
    HealthGirl hg = new HealthGirl();
    HealthBoy hb = new HealthBoy();
    FoodBoy fb = new FoodBoy();
    FoodGirl fg = new FoodGirl();
    DropBoy wb = new DropBoy();
    DropGirl wg = new DropGirl();
    MadeiraA m = new MadeiraA();
    Calhau c = new Calhau();
    Score scr = new Score();
    private Text ind=new Text();                //cria uma referencia para o texto
    public void act() {
        getWorld().addObject(ind, 400, 650);
        Actor text = getOneIntersectingObject(Text.class);
        //Muda de mundo quando precionadas as teclas
        if (c.getPedra() >= 48){
            if (Greenfoot.isKeyDown("E") && Greenfoot.isKeyDown("I")){
                if (isTouching(Boy.class) || isTouching(Girl.class)){
                    //Cria referencias para as variaveis
                    HealthGirl hg = new HealthGirl();
                    HealthBoy hb = new HealthBoy();
                    FoodBoy fb = new FoodBoy();
                    FoodGirl fg = new FoodGirl();
                    DropBoy wb = new DropBoy();
                    DropGirl wg = new DropGirl();
                    MadeiraA m = new MadeiraA();
                    Calhau c = new Calhau();
                    Score scr = new Score();
                    Greenfoot.setWorld(new SosMundo(hb.getHealthB(),hg.getHealthG(),fb.getFoodB(),fg.getFoodG(),wb.getWaterB(),wg.getWaterG(),m.getMadeira(),c.getPedra(),scr.getScore()));
                }
            }
        }     
        if (isTouching(Boy.class)||isTouching(Girl.class)){
            ind.setText("[E] e [I] : É preciso ter mais de 48 pedras.");
        }
        if(!isTouching(Boy.class) || isTouching(Girl.class)){
            ind.setText("");
        }
    } 
}
