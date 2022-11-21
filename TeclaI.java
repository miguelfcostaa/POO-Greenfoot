import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TeclaI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeclaI extends Actor
{
    /**
     * Act - do whatever the TeclaI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem1,imagem2;
    public void act() 
    {
        identifica();           //muda a imagem do actor
    } 
    public TeclaI(){
        imagem1 = new GreenfootImage("tecla-i.png");
        imagem2 = new GreenfootImage("tecla-i2.png");
    }
    public void identifica(){
        if(Greenfoot.isKeyDown("I")){
            setImage(imagem2);
        }
        else{
            setImage(imagem1);
        } 
    }  
}
