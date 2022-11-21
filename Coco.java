import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coco here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coco extends Actor
{
    /**
     * Act - do whatever the Coco wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        if (getWorld() instanceof Oceano){
            move();
            touchEdge();    //se tocar na borda, desaparece.
        }
        if (getWorld() instanceof MyWorld){
            //cria referencias para as variaveis
            HealthGirl hg = new HealthGirl();
            HealthBoy hb = new HealthBoy();
            FoodBoy fb = new FoodBoy();
            FoodGirl fg = new FoodGirl();
            DropBoy wb = new DropBoy();
            DropGirl wg = new DropGirl();
            Score scr = new Score();
            if(Greenfoot.mousePressed(this)){
                getWorld().removeObject(this);
                wb.addWaterB(15); //adiciona 15 de Sede ao Rapaz
                wg.addWaterG(15); //adiciona 15 de Sede a Rapariga
                fb.addFoodB(10); //adiciona 10 de Fome ao Rapaz
                fg.addFoodG(10); //adiciona 10 de Fome a Rapariga
                hb.addHealthB(5);  //adiciona  5 de vida do Rapaz
                hg.addHealthG(5);  //adiciona 5 de vida da Rapariga
                scr.addScore(10);
            }
        }
    }    
    public void touchEdge(){
        if (isAtEdge()){
            getWorld().removeObject(this); //remove o objeto se tocar na borda do mundo
        }
    }
    public void move(){
        move(-6); //movimenta-se no sentido negativo, da direita para a esquerda
    }
}
