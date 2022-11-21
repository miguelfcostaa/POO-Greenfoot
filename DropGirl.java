import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Drop2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DropGirl extends Actor
{
    /**
     * Act - do whatever the Drop2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int waterG;
    private GreenfootImage imagem;
    HealthGirl hg = new HealthGirl();        //cria uma referencia para o HealthGirl   
    private int counter = 0, counter2 = 0;    
    public int getWaterG(){
        return waterG;
    }
    public void setWaterG(int wg){
        waterG = wg;
    }
    public void addWaterG(int wg){
        waterG += wg;
    }
    public void removeWaterG(int wg){
        waterG -= wg;
    }
    public DropGirl(){
        
    }
    public void act(){
        //cria um relogio para perder agua com o tempo. Se chegar a zero começa a perder vida
        if (counter2 == 400){
            removeWaterG(1);
            counter2 = 0;
        }
        else if (counter2 < 400){
            counter2++;
        }
        if(getWaterG() <= 0){
            setWaterG(0);
            counter++;
            if (counter == 700){
                Greenfoot.delay(20);
                hg.removeHealthG(5);
                counter = 0;
            }
        }
        else if(getWaterG() >= 100){
            setWaterG(100);
        }
        //Muda a transparcencia do Actor conforme a variavel da agua
        imagem = getImage();
        imagem.setTransparency(255*getWaterG()/100);
    }
}
