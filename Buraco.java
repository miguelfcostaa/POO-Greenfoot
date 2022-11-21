import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Burraco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buraco extends Actor
{
    /**
     * Act - do whatever the Burraco wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int counter = 0;  //cria uma variavel para contar quantas vezes é colocada a pedra
    Calhau c = new Calhau();        //cria uma referencia ao Actor Calhau.
    Score scr = new Score();          //cria uma referencia ao Actor Score.
    public void act() {
        colocaPedra();              //Coloca o actor pedra quando clicado no actor buraco.
        if(counter == 48){
            Greenfoot.setWorld(new GameOver(scr.getScore(),"You Win.png"));
            Greenfoot.delay(100);
            Greenfoot.stop();
        }
    }  
    private void colocaPedra(){   
        if(isTouching(Boy.class)){    
            if (Greenfoot.mouseClicked(this)){
                if (c.getPedra() > 0){
                    c.removePedra(1);
                    scr.addScore(30);
                }
                addCounter(1);
                getWorld().addObject(new Rock(), getX(), getY());
            }
            else if (c.getPedra() <= 0){
                c.setPedra(0);
            }
        }
        if(isTouching(Girl.class)){
            if (Greenfoot.mouseClicked(this)){
                if (c.getPedra() > 0){
                    c.removePedra(1);
                    scr.addScore(30);
                }
                getWorld().addObject(new Rock(), getX(), getY());
                addCounter(1);
            }
            else if (c.getPedra() <= 0){
                c.setPedra(0);
            }
        }
    } 
    public int getCounter(){
        return counter;
    }
    public void setCounter(int c){
        counter = c;
    }
    public void addCounter(int c){
        counter += c;
    }
}
