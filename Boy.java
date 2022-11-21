import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boy extends Actor
{
    /**
     * Act - do whatever the Boy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int DELTA = 3;
    private GreenfootImage i1,i2,i3,i4;
    private GreenfootImage imagens = getImage();
    //Criar a animação para cada direção.
    private String[] boyfront = {"boyfrontwalk.png","boyfrontwalk2.png","boyfrontwalk3.png"};
    private String[] boyback = {"boybackwalk.png","boybackwalk2.png","boybackwalk3.png"};
    private String[] boyleft = {"boyleftwalk.png","boyleftwalk2.png","boyleftwalk3.png"};
    private String[] boyright = {"boyrightwalk.png","boyrightwalk2.png","boyrightwalk3.png"};
    private String[] boymachado = {"boy_axe_up.png","boy_axe_dn.png","boy_axe_up.png","boy_axe_dn.png"};
    private int currentImage = 0, currentImage2 = 0;
    Score scr = new Score();    //cria uma referencia ao Actor Score
    public void act(){
        checkKeyPress();        //Codigo para fazer a personagens andar quando precionado as teclas.
        limite();               //Limita o personagem para nao passar o actor limite.
        machado();              //Muda a imagem do personagem.
        apanhouMadeira();       //Quando tocar no actor MadeiraA esse actor desaparece e aumenta 1 na contagem da madeira.
        porta();                //Limita o personagem de passar aquele actor.
    }
    public Boy(){
        i1 = new GreenfootImage("boyfront.png");
        i2 = new GreenfootImage("boyback.png");
        i3 = new GreenfootImage("boyleft.png");
        i4 = new GreenfootImage("boyright.png");
    }
    public void checkKeyPress(){
        if(currentImage >= 2){ //como so tem duas imagens reseta 
                currentImage = 0;
            }
        currentImage++;
        if (Greenfoot.isKeyDown("A")){
            setLocation(getX()-DELTA, getY());   // move-se para a esquerda
            GreenfootImage boyleftmovem = new GreenfootImage(boyleft[currentImage]);
            setImage(boyleftmovem);  
        }
        if (Greenfoot.isKeyDown("D")){
            setLocation(getX()+DELTA, getY());   // move-se para a direita
            GreenfootImage boyrightmovem = new GreenfootImage(boyright[currentImage]);
            setImage(boyrightmovem);       
        }
        if (Greenfoot.isKeyDown("S")){
            setLocation(getX(), getY()+DELTA);   // move-se para baixo
            GreenfootImage boyfrontmovem = new GreenfootImage(boyfront[currentImage]);
            setImage(boyfrontmovem); 
        } 
        if (Greenfoot.isKeyDown("W")){
            setLocation(getX(), getY()-DELTA);   // move-se para cima
            GreenfootImage boybackmovem = new GreenfootImage(boyback[currentImage]);
            setImage(boybackmovem); 
        }
    }
    public void limite(){
        if (isTouching(Limite.class)){
            if (Greenfoot.isKeyDown("S")){
                setLocation(getX(), getY()-DELTA);
                setImage(i1);
            }
            if (Greenfoot.isKeyDown("W")){
                setLocation(getX(), getY()+DELTA);
                setImage(i2);
            }
        }
        if (isTouching(LimiteV.class)){
            if(Greenfoot.isKeyDown("A")){
                setLocation(getX()+DELTA, getY());
                setImage(i3);
            }
            if(Greenfoot.isKeyDown("D")){
                setLocation(getX()-DELTA, getY());
                setImage(i4);
            }
        }
    }
    public void porta(){
        if (isTouching(Porta.class)){
            if (Greenfoot.isKeyDown("S")){
                setLocation(getX(), getY()-DELTA);
            }
            if (Greenfoot.isKeyDown("W")){
                setLocation(getX(), getY()+DELTA);
            }
        }
    }
    public void machado(){
        if(isTouching(Arvore.class)){
            if (Greenfoot.isKeyDown("E")){
                if(currentImage2 >= 3){ //como so tem 3 imagens reseta 
                    currentImage2 = 0;
                }
                currentImage2++;
                GreenfootImage boymachadomovem = new GreenfootImage(boymachado[currentImage2]);
                setImage(boymachadomovem); 
            }
        }
    }
    public void apanhouMadeira(){
        MadeiraA m = new MadeiraA();
        Actor madeira = getOneIntersectingObject(MadeiraA.class);
        if (madeira != null){
            getWorld().removeObject(madeira);
            m.addMadeira(1);     //incrementa o numero da madeira em 1
            scr.addScore(10);
        }
    }
}
