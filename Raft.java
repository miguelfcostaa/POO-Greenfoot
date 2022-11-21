
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class raft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Raft extends Actor{    
    private final int DELTA=3;
    private GreenfootImage imagem1,imagem2, imagem3, imagem4, imagem5;
    HealthGirl hg = new HealthGirl();   //cria uma referencia ao Actor HealthGirl
    HealthBoy hb = new HealthBoy();     //cria uma referencia ao Actor HealthBoy  
    FoodBoy fb = new FoodBoy();     //cria uma referencia ao Actor FoodBoy 
    FoodGirl fg = new FoodGirl();   //cria uma referencia ao Actor FoodGirl  
    DropBoy wb = new DropBoy();     //cria uma referencia ao Actor DropBoy  
    DropGirl wg = new DropGirl();   //cria uma referencia ao Actor DropGirlthGirl  
    MadeiraA m = new MadeiraA();    //cria uma referencia ao Actor MadeiraA 
    Score scr = new Score();        //cria uma referencia ao Actor Score
    public void act(){
        checkKeyPress();            //Codigo para fazer a personagens andar quando precionado as teclas.
        apanhouMadeira();           //Quando tocar no actor MadeiraA esse actor desaparece e aumenta 1 na contagem da madeira.
        dano();                     //Os personagens perdem vida quando tocam nos actors referidos
        comida();                   //Os personagens ganham comida, agua e vida. quando tocam nos actors. 
        vida();                     //Muda a imagem do actor raft conforme a vida vai mudando
    }    
    public Raft(){
        imagem1 = new GreenfootImage("bote.png");
        imagem2 = new GreenfootImage("actor-boteDano1.png");
        imagem3 = new GreenfootImage("actor-boteDano2.png");
        imagem4 = new GreenfootImage("actor-boteDano3.png");
        imagem5 = new GreenfootImage("actor-bote_final.png"); 
    }
    public void checkKeyPress(){
        if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-DELTA, getY());   // move-se para a esquerda
        }
        if (Greenfoot.isKeyDown("right")){
            setLocation(getX()+DELTA, getY());   // move-se para a direita
        }
        if (Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+DELTA);   // move-se para baixo
        } 
        if (Greenfoot.isKeyDown("W")){
            setLocation(getX(), getY()-DELTA);   // move-se para cima
        }
    }
    public void apanhouMadeira(){
        Actor madeira = getOneIntersectingObject(Madeira.class);
        if (madeira != null){
            getWorld().removeObject(madeira);
            m.addMadeira(1);     //incrementa o numero da madeira em 1
            scr.addScore(10);
        }
    }
    public void dano(){
        Actor petroleo = getOneIntersectingObject(Petroleo.class);
        Actor shark = getOneIntersectingObject(Shark.class);
        Actor boia = getOneIntersectingObject(Boia.class);
        if(petroleo != null){
            Greenfoot.delay(20);
            Greenfoot.playSound("au.wav");
            getWorld().removeObject(petroleo);
            hb.removeHealthB(25); //retira 25 de vida do Rapaz   
            hg.removeHealthG(25); //retira 25 de vida da Rapariga
        }
        if(shark != null){
            Greenfoot.delay(20); 
            Greenfoot.playSound("au.wav");
            getWorld().removeObject(shark);
            hb.removeHealthB(100); //retira 100 de vida do Rapaz  
            hg.removeHealthG(100); //retira 100 de vida da Rapariga
            hb.setHealthB(0);
            hg.setHealthG(0);
        }
        if(boia != null){
            Greenfoot.delay(20);
            Greenfoot.playSound("au.wav");
            getWorld().removeObject(boia);
            hb.removeHealthB(35); //retira 25 de vida do Rapaz
            hg.removeHealthG(35); //retira 25 de vida da Rapariga
        }
    }
    public void comida(){
        Oceano thisGame = (Oceano)getWorld();
        Actor banana = getOneIntersectingObject(Banana.class);
        Actor coco = getOneIntersectingObject(Coco.class);
        if(coco != null){
            getWorld().removeObject(coco);
            Greenfoot.playSound("beber.wav");
            wb.addWaterB(15); //adiciona 15 de Sede ao Rapaz
            wg.addWaterG(15); //adiciona 15 de Sede a Rapariga
            fb.addFoodB(10); //adiciona 10 de Fome ao Rapaz
            fg.addFoodG(10); //adiciona 10 de Fome a Rapariga
            hb.addHealthB(5);  //adiciona  5 de vida do Rapaz
            hg.addHealthG(5);  //adiciona 5 de vida da Rapariga
            scr.addScore(15);
        }
        if(banana != null){
            getWorld().removeObject(banana);
            Greenfoot.playSound("comer.wav");
            fb.addFoodB(10); //adiciona 10 de Fome ao Rapaz
            fg.addFoodG(10); //adiciona 10 de Fome a Rapariga
            hb.addHealthB(5); //adiciona  5 de vida do Rapaz
            hg.addHealthG(5); //adiciona 5 de vida da Rapariga
            scr.addScore(10);
        }  
    }
    public void vida(){
        if (hb.getHealthB() <= 0 || hg.getHealthG() <= 0){        
            hb.setHealthB(0);
            hg.setHealthG(0);
            setImage(imagem5); //imagem do raft destruido
            Greenfoot.playSound("morrer.wav");
            Greenfoot.delay(100);
            Greenfoot.stop(); //jogo acaba
        }
        if (hb.getHealthB() > 100 || hg.getHealthG()>100){
            hb.setHealthB(100); //limites para a vida
            hg.setHealthG(100);
        }
        if (fb.getFoodB() > 100 || fg.getFoodG() >100){
            fb.setFoodB(100); //limites para a fome
            fg.setFoodG(100);
        }
        if (wb.getWaterB() > 100 || wg.getWaterG()>100){
            wb.setWaterB(100); //limites para a sede
            wg.setWaterG(100);
        }
        if (hb.getHealthB() >= 75 && hb.getHealthB() <= 100){
            setImage(imagem1); // imagem do raft reparado
        }
        if (hb.getHealthB() >= 50 && hb.getHealthB() <= 75){
            setImage(imagem2); //imagem do raft ligeiramente danificado
        }
        if (hb.getHealthB() >= 25 && hb.getHealthB() <= 50){
            setImage(imagem3); //imagem do raft danificado
        }
        if (hb.getHealthB() > 0 && hb.getHealthB() <= 25){
            setImage(imagem4); //imagem do raft roto
        }   
    }      
}
