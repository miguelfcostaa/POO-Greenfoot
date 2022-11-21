import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rocha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rocha extends Actor
{
    /**
     * Act - do whatever the Rocha wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Text ind=new Text();
    public void act() {
        getWorld().addObject(ind, 400, 650);
        Actor text = getOneIntersectingObject(Text.class);
        //Verifica se estao a tocar no actor.
        //Aparece um texto a mostrar que teclas precionar
        //Muda o mundo para CortaArvore quando precionadas as teclas
        if (isTouching(Boy.class) || isTouching(Girl.class)){
            ind.setText("[E] e [I]");
            if (Greenfoot.isKeyDown("E") && Greenfoot.isKeyDown("I")){
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
                Greenfoot.setWorld(new PartePedra(hb.getHealthB(),hg.getHealthG(),fb.getFoodB(),fg.getFoodG(),wb.getWaterB(),wg.getWaterG(),m.getMadeira(),c.getPedra(),scr.getScore()));
            }
        }
        if(!isTouching(Boy.class) || isTouching(Girl.class)){
            ind.setText("");
        }
    }  
}
