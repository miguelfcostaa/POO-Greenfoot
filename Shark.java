import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shark extends Actor
{
    /**
     * Act - do whatever the Shark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
 
    public void act(){
        move(-3);
        touchEdge();        //Se tocar no limite do mundo, desaparece
    }  
    public void touchEdge(){
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
