import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    Score scr = new Score();        //cria uma referencia ao Actor Score
    public GameOver(int score, String n){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600,600, 1);
        
        setBackground(n);
        scr.setScore(score);
        
        showText("Score: "+scr.getScore(), 300, 500);
    }
}
