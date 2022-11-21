import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GirlSea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GirlSea extends Girl
{
    /**
     * Act - do whatever the GirlSea wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int DELTA = 3;
    HealthGirl hg = new HealthGirl();    //cria uma referencia ao Actor HealthGirl
    FoodGirl fg = new FoodGirl();        //cria uma referencia ao Actor FoodGirl
    DropGirl wg = new DropGirl();        //cria uma referencia ao Actor DropGirl 
    Score scr = new Score();             //cria uma referencia ao Actor Score
    public void act() 
    {
        checkKeyPress();            //Codigo para fazer a personagens andar quando precionado as teclas.
        vida();                     //Dá limite à variavel da vida.
        dano();                     //Perde vida quando Toca nos actor referidos.
        apanhaPeixe();              //Quando toca nos peixes ganha vida, agua e fome e elimina os peixes
    }    
    public void checkKeyPress(){
        if (Greenfoot.isKeyDown("left")){
            setLocation(getX()-DELTA, getY());   // move-se para a esquerda
        }
        if (Greenfoot.isKeyDown("right")){
            setLocation(getX()+DELTA, getY());   // move-se para a direita      
        }
        if (Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+DELTA);   // move-se para baixo
        } 
        if (Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-DELTA);   // move-se para cima
        }
    }
    public void dano(){
        Actor peixezombie = getOneIntersectingObject(PeixeZombie.class);
        Actor tubarao = getOneIntersectingObject(Tubarao.class);
        if(peixezombie != null){
            Greenfoot.delay(20);
            Greenfoot.playSound("au.wav");
            getWorld().removeObject(peixezombie);
            hg.removeHealthG(50); //retira 50 de vida do Rapaz   
        }
        if(tubarao != null){
            Greenfoot.delay(20);
            Greenfoot.playSound("au.wav");
            getWorld().removeObject(tubarao);
            hg.removeHealthG(100); //retira 100 de vida do Rapaz  
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
        if (fg.getFoodG()>100){
            fg.setFoodG(100); //limites para a fome
        }
        if (wg.getWaterG() >100){
            wg.setWaterG(100); //limites para a sede
        }
    }
    public void apanhaPeixe(){
        Actor peixeamarelo = getOneIntersectingObject(PeixeAmarelo.class);
        Actor peixeazul = getOneIntersectingObject(PeixeAzul.class);
        Actor peixevermelho = getOneIntersectingObject(PeixeVermelho.class);
        if(peixeamarelo != null){
            getWorld().removeObject(peixeamarelo);
            Greenfoot.playSound("comer.wav");
            fg.addFoodG(10); //adiciona 10 de Fome ao Rapaz
            hg.addHealthG(5);  //adiciona  5 de vida do Rapaz  
            scr.addScore(10);
        }
        if(peixeazul != null){
            getWorld().removeObject(peixeazul);
            Greenfoot.playSound("comer.wav");
            fg.addFoodG(10); //adiciona 10 de Fome ao Rapaz
            hg.addHealthG(5);  //adiciona  5 de vida do Rapaz  
            scr.addScore(10);
        } 
        if(peixevermelho != null){
            getWorld().removeObject(peixevermelho);
            Greenfoot.playSound("comer.wav");
            fg.addFoodG(10); //adiciona 10 de Fome ao Rapaz
            hg.addHealthG(5);  //adiciona  5 de vida do Rapaz    
            scr.addScore(10);
        }
    }
}