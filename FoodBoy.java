import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FoodBoy extends Actor
{
    /**
     * Act - do whatever the Food wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int foodB;
    private GreenfootImage imagem;
    HealthBoy hb = new HealthBoy();             //cria uma referencia para o actor HealthBoy
    private int counter = 0, counter2 = 0;
    public int getFoodB(){
        return foodB;
    }
    public void setFoodB(int fb){
        foodB = fb;
    }
    public void addFoodB(int fb){
        foodB += fb;
    }
    public void removeFoodB(int fb){
        foodB -= fb;
    }
    public FoodBoy(){
        
    }
    public void act(){
        //cria um relogio para perder agua com o tempo. Se chegar a zero começa a perder vida
        if (counter == 395){
            removeFoodB(1);
            counter = 0;
        }
        else if (counter < 395){
            counter++;
        }
        if(getFoodB() <= 0){
            setFoodB(0);
            counter2++;
            if (counter2 == 500){
                Greenfoot.delay(20);
                hb.removeHealthB(5);
                counter2 = 0;
            }
        }
        else if(getFoodB() >= 100){
            setFoodB(100);
        }
        //Muda a transparcencia do Actor conforme a variavel da Comida
        imagem = getImage();
        imagem.setTransparency(255*getFoodB()/100);
    }
}
