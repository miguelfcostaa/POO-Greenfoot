import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vagao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vagao extends Actor {
    private int DELTA = 5;
    HealthGirl hg = new HealthGirl();   //cria uma referencia ao Actor HealthGirl
    HealthBoy hb = new HealthBoy();     //cria uma referencia ao Actor HealthBoy  
    FoodBoy fb = new FoodBoy();     //cria uma referencia ao Actor FoodBoy 
    FoodGirl fg = new FoodGirl();   //cria uma referencia ao Actor FoodGirl  
    DropBoy wb = new DropBoy();     //cria uma referencia ao Actor DropBoy  
    DropGirl wg = new DropGirl();   //cria uma referencia ao Actor DropGirlthGirl 
    Calhau c = new Calhau();        //cria uma referencia ao Actor Calhau
    Score scr = new Score();        //cria uma referencia ao Actor Score
    public void act() {
        checkKeyPress();            //Codigo para fazer a personagens andar quando precionado as teclas.
        apanhouPedra();             //Quando tocar no actor Calhau esse actor desaparece e aumenta 1 na contagem da pedra.
        dano();                     //Os personagens perdem vida quando tocam nos actors referidos
        comida();                   //Os personagens ganham comida, agua e vida. quando tocam nos actors. 
    }  
    public void checkKeyPress(){
        if (Greenfoot.isKeyDown("E")){
            setLocation(getX()-DELTA, getY());   // move-se para a esquerda
        }
        if (Greenfoot.isKeyDown("I")){
            setLocation(getX()+DELTA, getY());   // move-se para a direita      
        }
    }
    public void comida(){
        Actor apple = getOneIntersectingObject(Apple.class);
        if(apple != null){
            Greenfoot.playSound("comer.wav");
            getWorld().removeObject(apple);
            hg.addHealthG(10); //adiciona 20 de vida da Rapariga
            hb.addHealthB(10); //adiciona 20 de vida do Rapaz
            wb.addWaterB(15); //adiciona 15 de Sede ao Rapaz
            wg.addWaterG(15); //adiciona 15 de Sede a Rapariga
            fb.addFoodB(20); //adiciona 10 de Fome ao Rapaz
            fg.addFoodG(20); //adiciona 10 de Fome a Rapariga
            scr.addScore(25);   //adiciona 25 ao Score
        }
    }
    public void dano(){
        Actor bigorna = getOneIntersectingObject(Bigorna.class);
        if(bigorna != null){
            Greenfoot.delay(20);
            Greenfoot.playSound("au.wav");
            getWorld().removeObject(bigorna);
            hg.removeHealthG(40); //retira 40 de vida da Rapariga
            hb.removeHealthB(40); //retira 40 de vida do Rapaz
            scr.addScore(5);   //adiciona 5 ao Score
        }
    }
    public void apanhouPedra(){
        Actor pedra = getOneIntersectingObject(Calhau.class);
        if (pedra != null){
            getWorld().removeObject(pedra);
            c.addPedra(1);     //incrementa o numero da pedra em 1
        }
    }
}
