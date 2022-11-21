import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PeixeVermelho here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PeixeVermelho extends Actor
{
    /**
     * Act - do whatever the PeixeVermelho wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int counter = 0,counter1 = 0;
    public void act() 
    {
        virarImagem();              //vira a imagem para outra direção
        move(3);
        touchEdge();                //Se tocar no limite do mundo, move-se noutra direção
        randomTurns();              //Movimentar-se aliatoriamente.
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
    public void randomTurns(){
        if(counter == 50){
            turn(Greenfoot.getRandomNumber(30-10));
        }
        if(counter == 100){
            turn(Greenfoot.getRandomNumber(180));
            counter = 0;
        }
        counter++;
    }
}
