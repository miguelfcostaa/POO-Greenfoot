import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LimiteBack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LimiteBack extends Actor
{
    /**
     * Act - do whatever the LimiteBack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem;
    HealthGirl hg = new HealthGirl();   //cria uma referencia ao Actor HealthGirl
    HealthBoy hb = new HealthBoy();     //cria uma referencia ao Actor HealthBoy  
    FoodBoy fb = new FoodBoy();     //cria uma referencia ao Actor FoodBoy 
    FoodGirl fg = new FoodGirl();   //cria uma referencia ao Actor FoodGirl  
    DropBoy wb = new DropBoy();     //cria uma referencia ao Actor DropBoy  
    DropGirl wg = new DropGirl();   //cria uma referencia ao Actor DropGirlthGirl  
    MadeiraA m = new MadeiraA();    //cria uma referencia ao Actor MadeiraA 
    Calhau c = new Calhau();        //cria uma referencia ao Actor Calhau
    Score scr = new Score();        //cria uma referencia ao Actor Score
    public void act() {
        //Faz o actor LimiteBack ser invisivel
        imagem = getImage();
        imagem.setTransparency(0);
        back();                         //Faz os personagens voltarem para a ilha
    }
    public void back(){
        if (isTouching(Girl.class) || isTouching(Boy.class)){
            if (getWorld() instanceof CortaArvore){
                Greenfoot.setWorld(new Ilha(hb.getHealthB(),hg.getHealthG(),fb.getFoodB(),fg.getFoodG(),wb.getWaterB(),wg.getWaterG(),m.getMadeira(),c.getPedra(),scr.getScore()));
            }
            if (getWorld() instanceof PartePedra){
                Greenfoot.setWorld(new Ilha(hb.getHealthB(),hg.getHealthG(),fb.getFoodB(),fg.getFoodG(),wb.getWaterB(),wg.getWaterG(),m.getMadeira(),c.getPedra(),scr.getScore()));
            }
            if (getWorld() instanceof SosMundo){
                Greenfoot.setWorld(new Ilha(hb.getHealthB(),hg.getHealthG(),fb.getFoodB(),fg.getFoodG(),wb.getWaterB(),wg.getWaterG(),m.getMadeira(),c.getPedra(),scr.getScore()));
            }
        }
    }
}
