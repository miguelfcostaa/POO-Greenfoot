import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pause here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pause extends Actor
{
    /**
     * Act - do whatever the Pause wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem1,imagem2;
    private Text offele=new Text();          //cria uma referencia para o texto
    public void act() 
{
        pause();
    }
    public Pause(){
        imagem1 = new GreenfootImage("pause-button.png");
        imagem2 = new GreenfootImage("play-button.png");
    }
    //cria um button pause.
    //Quando precionado a tecla p pausa o jogo.
    //Quando precionado a tecla o volta a funcionar.
    public void pause(){
        if(Greenfoot.isKeyDown("P")){
            while(!Greenfoot.isKeyDown("O")){
                Greenfoot.delay(1);
                setImage(imagem2);
                //getWorld().showText("PAUSED", 400,400);
                getWorld().addObject(offele, 400, 400);
                offele.setText("PAUSED");
            }
        }
        if(Greenfoot.isKeyDown("O")){
            setImage(imagem1);
            offele.setText("");
        }
    }
}
