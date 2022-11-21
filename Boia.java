import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boia extends Actor
{
    /**
     * Act - do whatever the Boia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0;
    public void act() {
        move(-2);           //movimenta-se no sentido, da direita para a esquerda
        touchEdge();        //se tocar na borda, desaparece.
        randomTurns();      //faz o actor Boia ande aos Ss
    }  
    public void touchEdge(){
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    public void randomTurns(){
        if(counter == 50){
            turn(45);
        }
        if(counter == 200){
            turn(-90);
        }
        if(counter == 300){
            turn(90);
            counter = 100;
        }
        counter++;
    }
}
