import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class S here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeclaA extends Actor
{
    /**
     * Act - do whatever the S wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem1,imagem2;
    public void act() 
    {
        identifica();   //muda a imagem do actor
    } 
    public TeclaA(){
        imagem1 = new GreenfootImage("tecla-a.png");
        imagem2 = new GreenfootImage("tecla-a2.png");
    }
    public void identifica(){
        if(Greenfoot.isKeyDown("A")){
            setImage(imagem2);
        }
        else{
            setImage(imagem1);
        } 
    }   
}
