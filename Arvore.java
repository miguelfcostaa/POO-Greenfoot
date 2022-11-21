import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arvore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arvore extends Actor
{
    /**
     * Act - do whatever the Arvore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage imagem1,imagem2,imagem3,imagem4,imagem5;
    private int counter=0;
    private Text ind=new Text();        //cria uma referencia para o texto.
    public void act() 
    {
        Corta();        //Anima o actor e coloca o actor MadeiraA.
    }   
    public Arvore(){
        imagem1 = new GreenfootImage("actor-arvore1.png");
        imagem2 = new GreenfootImage("actor-arvore2.png");
        imagem3 = new GreenfootImage("actor-arvore3.png");
        imagem4 = new GreenfootImage("actor-arvore4.png");
        imagem5 = new GreenfootImage("actor-arvore_5final.png");
    }
    //Texto para mostrar quais teclas precionar.
    public void ind(){
        getWorld().addObject(ind, 400, 650);
        Actor text = getOneIntersectingObject(Text.class);
        if(isTouching(Boy.class) || isTouching(Girl.class)){
            ind.setText("[E] e [I] : Cortar arvore");
        }
        if(!isTouching(Boy.class) || isTouching(Girl.class)){
            ind.setText("");
        }
    }
    public void Corta(){
        if (Greenfoot.isKeyDown("E") && Greenfoot.isKeyDown("I")){
            if (isTouching(Boy.class) || isTouching(Girl.class)){
               counter ++;
               if (counter==100){
                   setImage(imagem2);
               }
               if (counter==200){
                   setImage(imagem3);
               }
               if (counter==300){
                   setImage(imagem4);
               }
               if (counter==400){
                   setImage(imagem5);
               }
               if (counter== 405){
                   getWorld().addObject(new MadeiraA(), 100, 570);
                   getWorld().addObject(new MadeiraA(), 600, 570);
               }
            }
        } 
    }
}
