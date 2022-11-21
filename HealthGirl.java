import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heart2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthGirl extends Actor{
    private static int healthG;
    private GreenfootImage imagem;
    Score scr=new Score();              //cria uma referencia ao Actor Score
    public int getHealthG(){
        return healthG;
    }
    public void setHealthG(int hg){
        healthG = hg;
    }
    public void addHealthG(int hg){
        healthG += hg;
    }
    public void removeHealthG(int hg){
        healthG -= hg;
    }
        //Quando a vida chega a zero, da um som e o jogo para
    public void act(){
        if(getHealthG() <= 0){
            setHealthG(0);
            Greenfoot.playSound("morrer.wav");
            Greenfoot.setWorld(new GameOver(scr.getScore(),"Game Over.png"));
            Greenfoot.delay(100);
            Greenfoot.stop();
        }
        else if(getHealthG() >= 100){
            setHealthG(100);
        }
        //Muda a transparcencia do Actor conforme a variavel da vida
        imagem = getImage();
        imagem.setTransparency(255*getHealthG()/100);
    }
}
