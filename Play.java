import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Actor
{
    //Quando o actor é clicado o jogo comeca
    public void act(){
        if(Greenfoot.mousePressed(this)){
            Greenfoot.setWorld(new MyWorld());
       }
    }
}