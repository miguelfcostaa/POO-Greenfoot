import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBoy extends Actor
{
    /**
     * Act - do whatever the Heart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int healthB;
    private GreenfootImage imagem;
    Score scr=new Score();              //cria uma referencia ao Actor Score
    public int getHealthB(){
        return healthB;
    }
    public void setHealthB(int hb){
        healthB = hb;
    }
    public void addHealthB(int hb){
        healthB += hb;
    }
    public void removeHealthB(int hb){
        healthB -= hb;
    }
    public HealthBoy(){

    }
    //Quando a vida chega a zero, da um som e o jogo para
    public void act(){
        if(getHealthB() <= 0){
            setHealthB(0);
            Greenfoot.playSound("morrer.wav");
            Greenfoot.setWorld(new GameOver(scr.getScore(),"Game Over.png"));
            Greenfoot.delay(100);
            Greenfoot.stop();
        }
        else if(getHealthB() >= 100){
            setHealthB(100);
        }
        //Muda a transparcencia do Actor conforme a variavel da vida
        imagem = getImage();
        imagem.setTransparency(255*getHealthB()/100);
    }
    
}

