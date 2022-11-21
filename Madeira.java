import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Petroleo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Madeira extends Actor{
    public void act() {
        if (getWorld() instanceof Oceano){
            move();
            touchEdge();    //se tocar na borda, desaparece.
        }
    }    
    public void touchEdge(){
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    public void move(){
        move(-6); //movimenta-se no sentido negativo, da direita para a esquerda
    }
}
