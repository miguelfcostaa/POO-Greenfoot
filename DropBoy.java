import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Drop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DropBoy extends Actor
{
    /**
     * Act - do whatever the Drop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int waterB;
    private int counter = 0, counter2 = 0;
    private GreenfootImage imagem;
    HealthBoy hb = new HealthBoy();         //cria uma referencia para o HealthBoy
    public int getWaterB(){
        return waterB;
    }
    public void setWaterB(int wb){
        waterB = wb;
    }
    public void addWaterB(int wb){
        waterB += wb;
    }
    public void removeWaterB(int wb){
        waterB -= wb;
    }
    public DropBoy(){
        
    }
    public void act(){
        //cria um relogio para perder agua com o tempo. Se chegar a zero começa a perder vida
        if (counter2 == 415){
            removeWaterB(1);
            counter2 = 0;
        }
        else if (counter2 < 415){
            counter2++;
        }
        if(getWaterB() <= 0){
            setWaterB(0);
            counter++;
            if (counter == 700){
                Greenfoot.delay(20);
                hb.removeHealthB(5);
                counter = 0;
            }
        }
        else if(getWaterB() >= 100){
            setWaterB(100);
        }
        //Muda a transparcencia do Actor conforme a variavel da agua
        imagem = getImage();
        imagem.setTransparency(255*getWaterB()/100);
    }
}

