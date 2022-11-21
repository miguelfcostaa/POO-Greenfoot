import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class limiteV here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LimiteV extends Actor
{
    /**
     * Act - do whatever the limiteV wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem;
    public void act() 
    {
        //Faz o actor limiteV ser invisivel
        imagem = getImage();
        imagem.setTransparency(0);
    }     
}
