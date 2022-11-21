import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ar extends Actor
{
    /**
     * Act - do whatever the Ar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Score scr = new Score();        //cria uma referencia ao Actor Score.
    private Text ind=new Text();    //cria uma referencia para o texto.
    public void act() {
        Apanhar();          //Assim que os personagens tocam nas teclas indicadas o actor desaparece.
    }    
    public void Apanhar(){
        getWorld().addObject(ind, 400, 650);
        Actor text = getOneIntersectingObject(Text.class);
        if (isTouching(Boy.class)){
            if (Greenfoot.isKeyDown("E")){
                getWorld().removeObject(this);
                scr.addScore(20);
                getWorld().removeObject(ind);
            }
            ind.setText("[E]: Apanhar ar.");
        }
        else if (isTouching(Girl.class)){
            if (Greenfoot.isKeyDown("I")){
                getWorld().removeObject(ind);
                getWorld().removeObject(this);
                scr.addScore(20);
            }
            ind.setText("[I]: Apanhar ar.");
        }
    }
}
