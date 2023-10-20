package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bloques {
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private boolean golpeado;

    public Bloques(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.golpeado = false;
    }

    public Rectangle getRectangulo() {
        return new Rectangle(x, y, ancho, alto);
    }

    public boolean estaGolpeado() {
        return golpeado;
    }

    public void golpear() {
        golpeado = true;
    }

    public void dibujar(Graphics g) {
        if (!golpeado) {
            g.fillRect(x, y, ancho, alto);
        }
    }
    
}

