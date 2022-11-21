import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Limite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Limite extends Actor
{
    /**
     * Act - do whatever the Limite wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem;
    //Faz o actor ser invisivel
    //quando no mundo Fundo, a personagem tem de tocar no limite para voltar para a ilha
    public void act() 
    {
        imagem = getImage();
        imagem.setTransparency(0);
        if(isTouching(GirlSea.class) || isTouching(BoySea.class)){
            if (getWorld() instanceof Fundo){
                HealthGirl hg = new HealthGirl();
                HealthBoy hb = new HealthBoy();
                FoodBoy fb = new FoodBoy();
                FoodGirl fg = new FoodGirl();
                DropBoy wb = new DropBoy();
                DropGirl wg = new DropGirl();
                MadeiraA m = new MadeiraA();
                Calhau c = new Calhau(); 
                Score scr = new Score();
                Greenfoot.setWorld(new Ilha(hb.getHealthB(),hg.getHealthG(),fb.getFoodB(),fg.getFoodG(),wb.getWaterB(),wg.getWaterG(),m.getMadeira(),c.getPedra(),scr.getScore()));
            }
        }
    }    
}
