import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends World{
    
    /**
     * Constructor for objects of class Start.
     * 
     */
    private String[] a = {"16.png","17.png","18.png","19.png","20.png","21.png","22.png","23.png","24.png","25.png","26.png","27.png","1.png","2.png","3.png","4.png","5.png","6.png","7.png","8.png","9.png","10.png","11.png","12.png","13.png","14.png","15.png"};
    private int currentImage = 0;
    public void act(){
        addObject(new Play(),400,550); //adiciona o botao play
        imagens();
    }
    public Start(){    
        super(800, 600, 1); //cria um mundo 800x600
        setPaintOrder(Play.class); //define que a class Play subrepoe as outras classes
    }
    public void imagens(){
       if (currentImage>=26){ //define um limite de 26 imagens e reseta
           currentImage=0;
       }
       Greenfoot.delay(15);
       currentImage++; //incrementa a variavel
       GreenfootImage background = new GreenfootImage(a[currentImage]); //cria uma imagem com array
       setBackground(background); //define a imagem criada como background
    }
}
