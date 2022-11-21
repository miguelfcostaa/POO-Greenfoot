import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Petroleo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Petroleo extends Actor
{
    /**
     * Act - do whatever the Petroleo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        move(-3);       //movimenta-se no sentido, da direita para a esquerda
        touchEdge();    //se tocar na borda, desaparece.
    }  
    public void touchEdge(){
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}

