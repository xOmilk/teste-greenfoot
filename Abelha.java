import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Abelha extends Actor {
    private int velocidade = 2;  // Velocidade de movimento da abelha
    private int distancia = 50;  // Distância a ser mantida atrás do ator
    private double suavizacao = 0.06;  // Fator de suavização para o movimento da abelha
    
    public void act() {
        seguirAtor();  // Faz a abelha seguir o ator com movimento suave
    }

    private void seguirAtor() {
        // Encontra o ator (Pessoa) no mundo
        Pessoa pessoa = (Pessoa) getWorld().getObjects(Pessoa.class).get(0);

        // Obtém a posição do ator
        int atorX = pessoa.getX();
        int atorY = pessoa.getY();
        
        // Calcula a direção do ator
        int direcaoX = (int) (distancia * Math.cos(Math.toRadians(pessoa.getRotation())));
        int direcaoY = (int) (distancia * Math.sin(Math.toRadians(pessoa.getRotation())));
        
        // Calcula a nova posição desejada para a abelha
        int novoX = atorX - direcaoX;
        int novoY = atorY - direcaoY;
        
        // Move a abelha suavemente em direção à nova posição
        int x = getX();
        int y = getY();
        int dx = novoX - x;
        int dy = novoY - y;
        
        // Atualiza a posição da abelha
        setLocation(x + (int)(dx * suavizacao), y + (int)(dy * suavizacao));
    }
}


