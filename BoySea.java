import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoySea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoySea extends Boy
{
    /**
     * Act - do whatever the BoySea wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int DELTA = 3;
    HealthBoy hb = new HealthBoy(); //cria uma referencia ao Actor HealthBoy
    FoodBoy fb = new FoodBoy();     //cria uma referencia ao Actor FoodBoy
    DropBoy wb = new DropBoy();    //cria uma referencia ao Actor DropBoy 
    Score scr = new Score();        //cria uma referencia ao Actor Score
    public void act() 
    {
        checkKeyPress();            //Codigo para fazer a personagens andar quando precionado as teclas.
        vida();                     //Dá limite à variavel da vida.
        dano();                     //Perde vida quando Toca nos actor referidos.
        apanhaPeixe();              //Quando toca nos peixes ganha vida, agua e fome e elimina os peixes.
    }    
    public void checkKeyPress(){
        if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-DELTA, getY());   // move-se para a esquerda
        }
        if (Greenfoot.isKeyDown("D")){
            setLocation(getX()+DELTA, getY());   // move-se para a direita      
        }
        if (Greenfoot.isKeyDown("S")){
            setLocation(getX(), getY()+DELTA);   // move-se para baixo
        } 
        if (Greenfoot.isKeyDown("W")){
            setLocation(getX(), getY()-DELTA);   // move-se para cima
        }
    }
    public void dano(){
        Actor peixezombie = getOneIntersectingObject(PeixeZombie.class);
        Actor tubarao = getOneIntersectingObject(Tubarao.class);
        Fundo thisFundo = (Fundo)getWorld();
        if(peixezombie != null){
            Greenfoot.delay(20);
            Greenfoot.playSound("au.wav");
            getWorld().removeObject(peixezombie);
            hb.removeHealthB(50); //retira 50 de vida do Rapaz   
        }
        if(tubarao != null){
            Greenfoot.delay(20);
            Greenfoot.playSound("au.wav");
            getWorld().removeObject(tubarao);
            hb.removeHealthB(100); //retira 100 de vida do Rapaz  
        }
    }
    public void vida(){
        Fundo thisFundo = (Fundo)getWorld();
        if (hb.getHealthB() <= 0){        
            hb.setHealthB(0);
            Greenfoot.playSound("morrer.wav");
            Greenfoot.delay(100);
            Greenfoot.stop(); //jogo acaba
        }
        if (hb.getHealthB()>100){
            hb.setHealthB(100); //limites para a vida
        }
        if (fb.getFoodB()>100){
            fb.setFoodB(100); //limites para a fome
        }
        if (wb.getWaterB() >100){
            wb.setWaterB(100); //limites para a sede
        }
    }
    public void apanhaPeixe(){
        Fundo thisFundo = (Fundo)getWorld();
        Actor peixeamarelo = getOneIntersectingObject(PeixeAmarelo.class);
        Actor peixeazul = getOneIntersectingObject(PeixeAzul.class);
        Actor peixevermelho = getOneIntersectingObject(PeixeVermelho.class);
        if(peixeamarelo != null){
            getWorld().removeObject(peixeamarelo);
            Greenfoot.playSound("comer.wav");
            fb.addFoodB(10); //adiciona 10 de Fome ao Rapaz
            hb.addHealthB(5);  //adiciona  5 de vida do Rapaz   
            scr.addScore(10);
        }
        if(peixeazul != null){
            getWorld().removeObject(peixeazul);
            Greenfoot.playSound("comer.wav");
            fb.addFoodB(10); //adiciona 10 de Fome ao Rapaz
            hb.addHealthB(5);  //adiciona  5 de vida do Rapaz  
            scr.addScore(10);
        } 
        if(peixevermelho != null){
            getWorld().removeObject(peixevermelho);
            Greenfoot.playSound("comer.wav");
            fb.addFoodB(10); //adiciona 10 de Fome ao Rapaz
            hb.addHealthB(5);  //adiciona  5 de vida do Rapaz     
            scr.addScore(10);
        }
    }
}
