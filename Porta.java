import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Porta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Porta extends Actor{
    Score scr = new Score();                    //cria uma referencia para o score
    //Quando os personagens tem uma Key e estao a tocar no actor, ele move-se para o lado
    public void act() {
        Key k = new Key();
        if (k.getKey() >= 1 && (isTouching(Boy.class) || isTouching(Girl.class))){
            if (Greenfoot.isKeyDown("G")){
                setLocation(getX()-70,getY());
                k.removeKey(1);
                scr.addScore(5);
            }
        }
    }    
}
