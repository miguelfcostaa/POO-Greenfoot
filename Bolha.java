import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bolha here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bolha extends Actor
{
    /**
     * Act - do whatever the Bolha wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        setRotation(270);           //Roda em direçao Norte.
        move(10);
        if (isAtEdge()){            //Elimina o objecto assim que esta na edge.
            getWorld().removeObject(this);
        }
    }
}
