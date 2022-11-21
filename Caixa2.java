import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Caixa2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caixa2 extends Caixa
{
    /**
     * Act - do whatever the Caixa2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem;
    public Inventario inventario;
    public MadeiraA madeiraa;
    public Calhau calhau;
    public Coco coco;
    Score scr = new Score();            //cria uma referencia ao Actor Score
    private Text ind=new Text();        //cria uma referencia ao Actor Text
    public void act() {
        //Faz com que o actor seja invisivel.
        imagem = getImage();
        imagem.setTransparency(0);
        Inv();                          //cria texto para mostrar quais as teclas a precionar
    }   
    public Caixa2(){
        inventario = new Inventario();      //cria uma referencia ao Actor Inventario
        madeiraa = new MadeiraA();          //cria uma referencia ao Actor MadeiraA
        calhau = new Calhau();              //cria uma referencia ao Actor Calhau
        coco = new Coco();                  //cria uma referencia ao Actor Coco
    }
    public void Inv(){
        getWorld().addObject(ind, 400, 650);
        Actor text = getOneIntersectingObject(Text.class);
        if(isTouching(Boy.class)){
            ind.setText("[E]: Abrir.  [R]: Fechar.");
            if(Greenfoot.isKeyDown("E")){
                getWorld().addObject(inventario,100,680);
                getWorld().addObject(madeiraa,60,615);
                getWorld().addObject(coco,110,615);
                getWorld().addObject(calhau,100,685);
            }
            if (Greenfoot.isKeyDown("R")){
                getWorld().removeObject(inventario);
                getWorld().removeObject(calhau);
                getWorld().removeObject(madeiraa);
                getWorld().removeObject(coco);
                getWorld().removeObject(ind);
                scr.addScore(5);
                getWorld().removeObject(this);
            }
        }
    }
}
