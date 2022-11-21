import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caixa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caixa extends Actor
{
    /**
     * Act - do whatever the Caixa wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem;
    private Inventario inventario;
    private Key key;
    Score scr = new Score();                //cria uma referencia ao Actor Score
    private Text ind=new Text();            //cria uma referencia ao Actor Text
    public void act() {
        //Faz com que o actor seja invisivel.
        imagem = getImage();
        imagem.setTransparency(0);
        Inv();                          //cria texto para mostrar quais as teclas a precionar
    }   
    public Caixa(){
        inventario = new Inventario();      //cria uma referencia ao Actor Inventario
        key = new Key();                    //cria uma referencia ao Actor Key
    }
    public void Inv(){
        getWorld().addObject(ind, 400, 650);
        Actor text = getOneIntersectingObject(Text.class);
        if(isTouching(Girl.class)){
            if(Greenfoot.isKeyDown("I")){
                getWorld().addObject(inventario,100,680);
                getWorld().addObject(key,50,615);
            }
            ind.setText("[I] : Abrir.  [U] : Fechar.");
            if (Greenfoot.isKeyDown("U")){
                getWorld().removeObject(inventario);
                getWorld().removeObject(key);
                getWorld().removeObject(ind);
                scr.addScore(5);
                getWorld().removeObject(this);
            }
        }
    }
}
