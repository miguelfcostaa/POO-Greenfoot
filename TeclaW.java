import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class W here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeclaW extends Actor
{
    /**
     * Act - do whatever the W wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem1,imagem2;
    public void act() 
    {
        identifica();               //muda a imagem do actor
    } 
    public TeclaW(){
        imagem1 = new GreenfootImage("tecla-w.png");
        imagem2 = new GreenfootImage("tecla-w2.png");
    }
    public void identifica(){
        if(Greenfoot.isKeyDown("W")){
            setImage(imagem2);
        }
        else{
            setImage(imagem1);
        } 
    }
}
