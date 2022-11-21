import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Texto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor{

    public Text(){  
        this("");  
    }  
 
    public Text(String text){
        setText(text);  
    }  
 
    public void setText(String text){     
        if(getWorld() instanceof Ilha){
            setImage(new GreenfootImage(text, 24, Color.BLACK, new Color(0, 0, 0, 0)));
        }
        else{
            setImage(new GreenfootImage(text, 24, Color.WHITE, new Color(0, 0, 0, 0)));  
        }
    }   
}
