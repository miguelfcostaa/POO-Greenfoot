import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GirlTrab here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GirlTrab extends Girl
{
    /**
     * Act - do whatever the GirlTrab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int DELTA = 5;
    HealthGirl hg = new HealthGirl();           //cria uma referencia para a HealthGirl.   
    FoodGirl fg = new FoodGirl();               //cria uma referencia para a FoodGirl.
    DropGirl wg = new DropGirl();               //cria uma referencia para a DropGirl.
    public void act() 
    {
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
        if (hg.getHealthG() <= 0){        
            hg.setHealthG(0);
            Greenfoot.playSound("morrer.wav");
            Greenfoot.delay(100);
            Greenfoot.stop(); //jogo acaba
        }
        if (hg.getHealthG()>100){
            hg.setHealthG(100); //limites para a vida
        }
        if (fg.getFoodG() >100){
            fg.setFoodG(100); //limites para a fome
        }
        if (wg.getWaterG() >100){
            wg.setWaterG(100); //limites para a sede
        }
    }
}
