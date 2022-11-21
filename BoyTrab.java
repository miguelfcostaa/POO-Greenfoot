import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoyTrab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoyTrab extends Boy
{
    /**
     * Act - do whatever the BoyTrab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int DELTA = 5;
    HealthBoy hb = new HealthBoy();         //cria uma referencia para a HealthBoy.    
    FoodBoy fb = new FoodBoy();             //cria uma referencia para a FoodBoy.
    DropBoy wb = new DropBoy();             //cria uma referencia para a DropBoy.
    public void act(){
        checkKeyPress();            //Codigo para fazer a personagens andar quando precionado as teclas.
        vida();                     //Dá limite à variavel da vida.
    }    
    public void checkKeyPress(){
        if (Greenfoot.isKeyDown("E")){
            setLocation(getX()-DELTA, getY());   // move-se para a esquerda 
        }
        if (Greenfoot.isKeyDown("I")){
            setLocation(getX()+DELTA, getY());   // move-se para a direita       
        }
    }
    public void vida(){
        if (hb.getHealthB() <= 0){        
            hb.setHealthB(0);
            Greenfoot.playSound("morrer.wav");
            Greenfoot.delay(100);
            Greenfoot.stop(); //jogo acaba
        }
        if (hb.getHealthB()>100){
            hb.setHealthB(100); //limites para a vida
        }
        if (fb.getFoodB() >100){
            fb.setFoodB(100); //limites para a fome
        }
        if (wb.getWaterB() >100){
            wb.setWaterB(100); //limites para a sede
        }
    }
}
