import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pessoa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pessoa extends Actor {
    private int velocidadeHorizontal = 5;  // Velocidade de movimento horizontal
    private int velocidadeVertical = 0;    // Velocidade de movimento vertical (inicialmente zero)
    private int gravidade = 1;              // Força da gravidade
    private int forcaPulo = -15;            // Força do pulo (negativo para mover para cima)
    private int posicaoChao;                // Posição do "chão"
    private boolean noChao;                 // Verifica se o ator está no chão

    public Pessoa(int posicaoChao) {
        this.posicaoChao = posicaoChao;  // Inicializa a posição do chão
        this.noChao = true;  // Inicia no chão
    }

    public void act() {
        moverComTeclas();  // Movimento horizontal e pulo
        aplicarGravidade();  // Aplicação da gravidade
        manterNoChao();  // Mantém o ator no chão se ele estiver lá
    }

    private void moverComTeclas() {
        if (Greenfoot.isKeyDown("a")) {
            this.setLocation(getX() - this.velocidadeHorizontal, this.getY());  // Move para a esquerda
        }
        if (Greenfoot.isKeyDown("d")) {
            this.setLocation(getX() + this.velocidadeHorizontal, this.getY());  // Move para a direita
        }

        if (Greenfoot.isKeyDown("space") && noChao) {
            pular();  // Faz o ator pular se estiver no chão
        }
        if (Greenfoot.isKeyDown("w") && noChao) {
            pular();  // Faz o ator pular se estiver no chão
        }
        
        //Setinhas
    }

    private void pular() {
        this.velocidadeVertical = forcaPulo;  // Aplica a força do pulo
        this.noChao = false;  // O ator não está mais no chão
    }

    private void aplicarGravidade() {
        if (!noChao) {
            this.velocidadeVertical += this.gravidade;  // Aumenta a velocidade vertical pela gravidade
            this.setLocation(getX(), getY() + this.velocidadeVertical);  // Atualiza a posição do ator
        }

        // Verifica se o ator atingiu o chão
        if (getY() >= posicaoChao) {
            this.setLocation(this.getX(), this.posicaoChao);  // Mantém o ator no chão
            this.velocidadeVertical = 0;  // Reseta a velocidade vertical
            this.noChao = true;  // Indica que o ator está no chão
        }
    }

    private void manterNoChao() {
        if (getY() > posicaoChao) {
            this.setLocation(this.getX(), this.posicaoChao);  // Mantém o ator na posição do chão
            this.velocidadeVertical = 0;  // Reseta a velocidade vertical
            this.noChao = true;  // Indica que o ator está no chão
        }
    }

    private void realizarAcaoComEspaco() {
        // Exemplo: tocar um som ao pressionar Espaço
        // Greenfoot.playSound("sound.wav");  // Substitua "sound.wav" pelo nome correto do seu arquivo de som
    }
}

