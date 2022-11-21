import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tubarao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tubarao extends Actor
{
    /**
     * Act - do whatever the Tubarao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0,counter1 = 0;
    public void act() 
    {
        move(-2);
        touchEdge();            //Se tocar no limite do mundo desaparece
    } 
    public void touchEdge(){
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }  
}
