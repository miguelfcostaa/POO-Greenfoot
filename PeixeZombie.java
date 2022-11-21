import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PeixeZombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PeixeZombie extends Actor
{
    /**
     * Act - do whatever the PeixeZombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0,counter1 = 0;
    public void act() 
    {
        virarImagem();              //vira a imagem para outra direção
        move(2);
        touchEdge();                //Se tocar no limite do mundo, move-se noutra direção
    } 
    public void touchEdge(){
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
    public void virarImagem(){
        if(counter1 == 1){
            getImage().mirrorHorizontally();
        }
        counter1++;
    }
}
