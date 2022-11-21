import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caixa1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caixa1 extends Caixa
{
    /**
     * Act - do whatever the Caixa1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem;
    public Inventario inventario;
    public Key key;
    public MadeiraA madeiraa;
    Score scr = new Score();                //cria uma referencia ao Actor Score
    private Text ind=new Text();            //cria uma referencia ao Actor Text
    public void act() {
        //Faz com que o actor seja invisivel.
        imagem = getImage();
        imagem.setTransparency(0);
        inv();                          //cria texto para mostrar quais as teclas a precionar
    }   
    public Caixa1(){
        inventario = new Inventario();      //cria uma referencia ao Actor Inventario
        key = new Key();                    //cria uma referencia ao Actor Key
        madeiraa = new MadeiraA();          //cria uma referencia ao actor MadeiraA
    }
    public void inv(){
        getWorld().addObject(ind, 400, 650);
        Actor text = getOneIntersectingObject(Text.class); 
        if(isTouching(Girl.class)){
            ind.setText("[I]: Abrir.  [U]: Fechar.");
            if(Greenfoot.isKeyDown("I")){
                getWorld().addObject(inventario,100,680);
                getWorld().addObject(key,50,615);
                getWorld().addObject(madeiraa,120, 615);
            }  
            if (Greenfoot.isKeyDown("U")){
                getWorld().removeObject(inventario);
                getWorld().removeObject(key);
                getWorld().removeObject(madeiraa);
                getWorld().removeObject(ind);
                scr.addScore(5);
                getWorld().removeObject(this);
            }
        }
    }
}
