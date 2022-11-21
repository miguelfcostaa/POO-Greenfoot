import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MadeiraA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MadeiraA extends Actor
{
    /**
     * Act - do whatever the MadeiraA wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int madeira = 0;
    Score scr = new Score();            //cria uma referencia para o score
    public static int getMadeira(){
        return madeira;
    }
    public void setMadeira(int m){
        madeira = m; 
    }
    public void addMadeira(int m){
        madeira += m;
    }
    public void act() 
    {
        madeiraApanhada();
    }   
    //Quando no mundo MyWorld, quando a madeira for clicada ela desaparece.
    public void madeiraApanhada(){
        if(getWorld() instanceof MyWorld){
            if(Greenfoot.mousePressed(this)){
                getWorld().removeObject(this);
                addMadeira(1);
                scr.addScore(10);
            }
        } 
    }
}
