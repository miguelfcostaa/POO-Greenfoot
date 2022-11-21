import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int score;
    public int getScore(){
        return score;
    }
    public void setScore(int scr){
        score = scr;
    }
    public void addScore(int scr){
        score += scr;
    }
    public void removeScore(int scr){
        score -= scr;
    }
    public void act(){
        
    }    
}
