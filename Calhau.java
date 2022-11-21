
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Calhau here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calhau extends Actor {   
    private static int pedra = 0;
    private int y = 0;
    public void act() {
        if (getWorld() instanceof PartePedra){
            cair();         //Fazer o Actor mover-se para baixo.
            caiuNoChao();   //Toca no Actor limite e desaparece.
        }
        if (getWorld() instanceof MyWorld){
            if(Greenfoot.mousePressed(this)){
                getWorld().removeObject(this);
                addPedra(1);//incrementa o numero da pedra em 1
            }
        }
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
    public static int getPedra(){
        return pedra;
    }
    public void setPedra(int p){
        pedra = p;
    }
    public void addPedra(int p){
        pedra += p;
    }
    public void removePedra(int p){
        pedra -= p;
    }
    
}
