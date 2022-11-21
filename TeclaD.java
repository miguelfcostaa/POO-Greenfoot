import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TeclaL here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeclaD extends Actor
{
    /**
     * Act - do whatever the TeclaL wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem1,imagem2;
    public void act() 
    {
        identifica();       //muda a imagem do actor
    } 
    public TeclaD(){
        imagem1 = new GreenfootImage("tecla-down.png");
        imagem2 = new GreenfootImage("tecla-down2.png");
    }
    public void identifica(){
        if(Greenfoot.isKeyDown("down")){
            setImage(imagem2);
        }
        else{
            setImage(imagem1);
        } 
    }  
}
