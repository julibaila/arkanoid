package clases;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Balon {
    private final int Ancho = 15;
    private final int Alto = 15;
    private double dx = 5;
    private double dy = 5;
    private int direccionX;
    private int direccionY;
    Paleta p1 = new Paleta(350,415);
    private int x;
    private int y;
    private double velocidadX;
    private double velocidadY;
    private final double velocidadInicial;
    private final double diametro;

    public Balon(int x, int y, double velocidadInicial) {
        this.x = x;
        this.y = y;
        this.velocidadInicial = velocidadInicial;
        this.velocidadX = velocidadInicial;
        this.velocidadY = velocidadInicial;
        this.diametro = 80.0; 
    }
public Rectangle2D getBalon() {
    return new Rectangle2D.Double(x, y, Ancho, Alto);
}


public void mover(Rectangle limites, boolean colisionp1) {
    x += dx;
    y += dy;
    
    if(colisionp1)
    {
    	dy=-dy;
    	y=400;
    }
    if (x > limites.getMaxX()) {
        dx = -dx;
    }
    if (y > limites.getMaxY()) {
        dy = -dy;
    }
    if (x < 0) {
        dx = -dx;
    }
    if (y < 0) {
        dy = -dy;
    }
}
public void aumentarVelocidad() {
    dx = 1.1;
    dy = 1.1;
}
public void dibujar(Graphics2D g) 
{
    g.fillOval(x, y, Ancho, Alto);
}
public void invertirDireccionY() {
    dy = -dy;
}
public void setVelocidad(double nuevaVelocidad) {
    velocidadX = nuevaVelocidad;
    velocidadY = nuevaVelocidad;
}
/*
public void ajustarDireccionX(int seccion) {
    double centroSeccion = p1.getSecciones()[seccion].getCenterX();
    double centroPelota = x + Ancho / 2;
    double offset = centroPelota - centroSeccion;
    dx = offset / 10;
}
public void ajustarDireccionRebote(double angulo) {
    double velocidad = Math.sqrt(dx * dx + dy * dy);
    dx = -velocidad * Math.sin(angulo);
    dy = velocidad * Math.cos(angulo);
}
*/
}
