import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FoodGirl extends Actor
{
    /**
     * Act - do whatever the Food2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int foodG;
    private GreenfootImage imagem;
    HealthGirl hg = new HealthGirl();           //cria uma referencia para o actor HealthGirl
    private int counter = 0, counter2 = 0;
    public int getFoodG(){
        return foodG;
    }
    public void setFoodG(int fg){
        foodG = fg;
    }
    public void addFoodG(int fg){
        foodG += fg;
    }
    public void removeFoodG(int fg){
        foodG -= fg;
    }
    public void act(){
        //cria um relogio para perder agua com o tempo. Se chegar a zero começa a perder vida
        if (counter2 == 380){
            removeFoodG(1);
            counter2 = 0;
        }
        else if (counter2 < 380){
            counter2++;
        }
        if(getFoodG() <= 0){
            setFoodG(0);
            counter++;
            if (counter == 700){
                Greenfoot.delay(20);
                hg.removeHealthG(5);
                counter = 0;
            }
        }
        else if(getFoodG() >= 100){
            setFoodG(100);
        }
        //Muda a transparcencia do Actor conforme a variavel da Comida
        imagem = getImage();
        imagem.setTransparency(255*getFoodG()/100);
    }
}
