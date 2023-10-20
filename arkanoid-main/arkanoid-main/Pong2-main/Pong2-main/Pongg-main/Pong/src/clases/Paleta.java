package clases;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Paleta {
	private int x, y;
	static final int Ancho=108, Alto=20;
	
	private Rectangle2D[] secciones;

	public Paleta(int x, int y) {
	    this.x = x;
	    this.y = y;
	    /*
	    secciones = new Rectangle2D[3];
	    int seccionAncho = Ancho / secciones.length;
	    for (int i = 0; i < secciones.length; i++) {
	        secciones[i] = new Rectangle2D.Double(x + i * seccionAncho, y, seccionAncho, Alto);
	    }
	    */
	}

	public Rectangle2D[] getSecciones() {
	    return secciones;
	}
	public Rectangle2D getPaleta()
	{
		return new Rectangle2D.Double(x,y,Ancho,Alto);
	}
	public void mover_raqueta(Rectangle limites)
	{
	    if (Movimiento.R && x < limites.getMaxX() - Ancho) {
	        x+=15;
	    }
	    if (Movimiento.L && x > limites.getMinX()) {
	        x-=15;
	    }
	}
	/*
	public double calcularAnguloRebote(Rectangle2D colision) {
	    double centroPaleta = x + Ancho / 2;
	    double centroColision = colision.getCenterX();
	    double desplazamiento = centroColision - centroPaleta;
	    
	    double maxAngulo = Math.toRadians(60);
	    double angulo = desplazamiento / (Ancho / 2) * maxAngulo;
	    
	    angulo = Math.min(maxAngulo, angulo);
	    angulo = Math.max(-maxAngulo, angulo);
	    
	    return angulo;
	}
*/
}
