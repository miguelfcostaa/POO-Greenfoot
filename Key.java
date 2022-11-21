import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Key extends Actor
{
    /**
     * Act - do whatever the Key wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int key = 0;
    public void act() 
    {
        inv();
    }    
    //Remove o actor quando é clicado. E adiciona à variavel key
    public void inv(){
        if(Greenfoot.mousePressed(this)){
            getWorld().removeObject(this);
            addKey(1);
        }
    }
    public static int getKey() {
        return key;
    }
    public void setKey(int Key) {
        key = Key;
    }
    public void addKey(int k){
        key += k;
    }
    public void removeKey(int k){
        key -= k;
    }
}
