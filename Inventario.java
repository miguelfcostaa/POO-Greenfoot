import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inventario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventario extends Actor
{
    /**
     * Act - do whatever the Inventario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Text inv=new Text();        //Cria uma referencia para o Texto
    public void act(){
    } 
    public void inventario(){
        getWorld().addObject(inv, 400, 650);
        Actor text = getOneIntersectingObject(Text.class);
        inv.setText("Madeira:" );
    }
}
