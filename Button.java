import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor{
    /**
     * Act - do whatever the Botton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private GreenfootImage imagem1,imagem2;
    private Text offele=new Text();
    private Faisca faisca;                      //cria uma referencia ao Actor Faisca
    private boolean faiscaOn = true;
    Score scr = new Score();                    //cria uma referencia ao Actor HealthBoy
    public void act() {
        if(faiscaOn == true){
            getWorld().addObject(faisca, 305, 410);
        }
        ativaButton();                  //Quando o personagem Boy precionar a tecla indicada o actor button ira mudar a imagem e o actor faisca ira desaparecer.
    }    
    public Button(){
        imagem1 = new GreenfootImage("actor-green.png");
        imagem2 = new GreenfootImage("actor-red.png");
        faisca = new Faisca();
    }
    
    public void ativaButton(){
        getWorld().addObject(offele, 400, 650);
        Actor text = getOneIntersectingObject(Text.class);
        if (isTouching(Boy.class)){
            if (Greenfoot.isKeyDown("E")){
                faiscaOn = false;
                getWorld().removeObject(faisca);
                setImage(imagem2);
                scr.addScore(25);
            }
            offele.setText("[E]: Desligar eletricidade.");
        }    
        if(!isTouching(Boy.class))
            offele.setText("");
    }
}
