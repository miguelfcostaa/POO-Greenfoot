import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bigorna here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bigorna extends Actor
{
    /**
     * Act - do whatever the Bigorna wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int y = 0;
    public void act() 
    {
        cair();         //Fazer o Actor mover-se para baixo.
        caiuNoChao();   //Toca no Actor limite e desaparece.
    } 
    public void caiuNoChao(){
        if(isTouching(Limite.class)){
            getWorld().removeObject(this);
        }
    }
    public void cair(){
        y++;
        if (y != 0){
            setLocation(getX(), getY()+y/6);
        } 
    }    
}
