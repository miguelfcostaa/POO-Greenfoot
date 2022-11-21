import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TeclaR here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeclaR extends Actor
{
    /**
     * Act - do whatever the TeclaR wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem1,imagem2;
    public void act() 
    {
        identifica();               //muda a imagem do actor
    } 
    public TeclaR(){
        imagem1 = new GreenfootImage("tecla-right.png");
        imagem2 = new GreenfootImage("tecla-right2.png");
    }
    public void identifica(){
        if(Greenfoot.isKeyDown("right")){
            setImage(imagem2);
        }
        else{
            setImage(imagem1);
        } 
    }    
}
