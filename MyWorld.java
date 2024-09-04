import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private void prepare(){
        int posicaoChao= 500;
        Pessoa jogadorPrincipal = new Pessoa(posicaoChao);
        addObject(jogadorPrincipal, 120, posicaoChao);

        //Adicionando a abelha para seguir a pessoa
        Abelha abelha= new Abelha();
        addObject(abelha,100,100);

        abelha.setLocation(49,402);
    }
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(750, 600, 1);
        prepare();
        
        
    }
}
