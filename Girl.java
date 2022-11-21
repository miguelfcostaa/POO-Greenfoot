import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Girl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Girl extends Actor
{
    /**
     * Act - do whatever the Girl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int DELTA = 3;
    private GreenfootImage i1,i2,i3,i4;
    private GreenfootImage imagens = getImage();
    //Criar a animação para cada direção.
    private String[] girlfront = {"girlfrontwalk.png","girlfrontwalk2.png","girlfrontwalk3.png"};
    private String[] girlback = {"girlbackwalk.png","girlbackwalk2.png","girlbackwalk3.png"};
    private String[] girlleft = {"girlleftwalk.png","girlleftwalk2.png","girlleftwalk3.png"};
    private String[] girlright = {"girlrightwalk.png","girlrightwalk2.png","girlrightwalk3.png"};
    private String[] girlmachado = {"girl_axe_up.png","girl_axe_dn.png","girl_axe_up.png","girl_axe_dn.png"};
    private int currentImage = 0, currentImage2 = 0;
    Score scr = new Score();
    public void act(){
        checkKeyPress();        //Codigo para fazer a personagens andar quando precionado as teclas.
        limite();               //Limita o personagem para nao passar o actor limite.
        machado();              //Muda a imagem do personagem.
        apanhouMadeira();       //Quando tocar no actor MadeiraA esse actor desaparece e aumenta 1 na contagem da madeira.
        porta();                //Limita o personagem de passar aquele actor.
        if(getWorld() instanceof MyWorld) dano();       //Quando a personagem perde vida, faz um som e atualiza a variavel HealthGirl
    }
    public Girl(){
        i1 = new GreenfootImage("girlfront.png");
        i2 = new GreenfootImage("girlback.png");
        i3 = new GreenfootImage("girlleft.png");
        i4 = new GreenfootImage("girlright.png");
    }
    public void checkKeyPress(){
        if(currentImage >= 2){ //como so tem duas imagens reseta 
                currentImage = 0;
            }
        currentImage++;
        if (Greenfoot.isKeyDown("left")){
            setLocation(getX()-DELTA, getY());   // move-se para a esquerda
            GreenfootImage girlleftmovem = new GreenfootImage(girlleft[currentImage]);
            setImage(girlleftmovem);  
        }
        if (Greenfoot.isKeyDown("right")){
            setLocation(getX()+DELTA, getY());   // move-se para a direita
            GreenfootImage girlrightmovem = new GreenfootImage(girlright[currentImage]);
            setImage(girlrightmovem);       
        }
        if (Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+DELTA);   // move-se para baixo
            GreenfootImage girlfrontmovem = new GreenfootImage(girlfront[currentImage]);
            setImage(girlfrontmovem); 
        } 
        if (Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-DELTA);   // move-se para cima
            GreenfootImage girlbackmovem = new GreenfootImage(girlback[currentImage]);
            setImage(girlbackmovem); 
        }
    }
    public void limite(){
        if (isTouching(Limite.class)){
            if (Greenfoot.isKeyDown("down")){
                setLocation(getX(), getY()-DELTA);
                setImage(i1);
            }
            if (Greenfoot.isKeyDown("up")){
                setLocation(getX(), getY()+DELTA);
                setImage(i2);
            }
        }
        if (isTouching(LimiteV.class)){
            if(Greenfoot.isKeyDown("left")){
                setLocation(getX()+DELTA, getY());
                setImage(i3);
            }
            if(Greenfoot.isKeyDown("right")){
                setLocation(getX()-DELTA, getY());
                setImage(i4);
            }
        }
    }
    public void porta(){
        if (isTouching(Porta.class)){
            if (Greenfoot.isKeyDown("down")){
                setLocation(getX(), getY()-DELTA);
            }
            if (Greenfoot.isKeyDown("up")){
                setLocation(getX(), getY()+DELTA);
            }
        }
    }
    public void machado(){
        if(isTouching(Arvore.class)){
            if (Greenfoot.isKeyDown("I")){
                if(currentImage2 >= 3){ //como so tem 4 imagens reseta 
                    currentImage2 = 0;
                }
                currentImage2++;
                GreenfootImage girlmachadomovem = new GreenfootImage(girlmachado[currentImage2]);
                setImage(girlmachadomovem); 
            }
        }
    }
    public void dano(){
        Actor faisca = getOneIntersectingObject(Faisca.class);
        HealthGirl hg = new HealthGirl();
        if(faisca != null){
            Greenfoot.playSound("au.wav"); 
            Greenfoot.delay(20);
            hg.removeHealthG(25); //retira 25 de vida da Rapariga
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

