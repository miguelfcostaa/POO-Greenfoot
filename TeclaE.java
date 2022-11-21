import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TeclaE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeclaE extends Actor
{

    private GreenfootImage imagem1,imagem2;
    public void act() 
    {
        identifica();           //muda a imagem do actor
    } 
    public TeclaE(){
        imagem1 = new GreenfootImage("tecla-e.png");
        imagem2 = new GreenfootImage("tecla-e2.png");
    }
    public void identifica(){
        if(Greenfoot.isKeyDown("E")){
            setImage(imagem2);
        }
        else{
            setImage(imagem1);
        } 
    }   
}
