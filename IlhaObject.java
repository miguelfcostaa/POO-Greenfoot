import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IlhaObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IlhaObject extends Actor
{
    /**
     * Act - do whatever the IlhaObject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        chegouIlha();
    }    
    //Muda de mundo quando o raft toca no actor IlhaObject
    public void chegouIlha(){
        Oceano thisWorld = (Oceano)getWorld();
        if(isTouching(Raft.class)){
            //cria as referencias para as variaveis
            HealthGirl hg = new HealthGirl();
            HealthBoy hb = new HealthBoy();
            FoodBoy fb = new FoodBoy();
            FoodGirl fg = new FoodGirl();
            DropBoy wb = new DropBoy();
            DropGirl wg = new DropGirl();
            MadeiraA m = new MadeiraA();
            Calhau c = new Calhau();
            Score scr = new Score();
            scr.addScore(1000);
            Greenfoot.setWorld(new Ilha(hb.getHealthB(),hg.getHealthG(),fb.getFoodB(),fg.getFoodG(),wb.getWaterB(),wg.getWaterG(),m.getMadeira(),c.getPedra(),scr.getScore()));
        }
    }
}
