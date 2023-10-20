package clases;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import clases.Nivel;


public class Tablero extends JPanel {
    private List<Bloques> bloques = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	Balon balon = new Balon(400,400,5);
    Paleta p1 = new Paleta(350,415);
    private int puntaje = 0;
    private boolean juegoEnCurso = true,mensajeGanasteMostrado=false, mensajePerdisteMostrado=false;
    private int vidas = 3;
    private Image fondo;
    private Image corazon1;
    private Image corazonVacio;
    private int nivelActual = 0;
    private List<List<Bloques>> todosLosNiveles = new ArrayList<>();
    private int velocidadPelota = 5, totalPuntajeNecesario;
    
    public Tablero() {
        Nivel nivel1 = new Nivel();
        Nivel2 nivel2 = new Nivel2();
        Nivel3 nivel3 = new Nivel3();
        Nivel4 nivel4 = new Nivel4();

        
        todosLosNiveles.add(nivel1.getBloques());
        todosLosNiveles.add(nivel2.getBloques());
        todosLosNiveles.add(nivel3.getBloques());
        todosLosNiveles.add(nivel4.getBloques());


    	 try {
 	        fondo = ImageIO.read(new URL("https://png.pngtree.com/thumb_back/fw800/background/20210427/pngtree-web-video-game-background-image_674113.jpg"));
 	        corazon1 = ImageIO.read(new URL("https://us.123rf.com/450wm/yupiramos/yupiramos1709/yupiramos170929580/86933877-pixelado-coraz%C3%B3n-icono-de-juego-ilustraci%C3%B3n-vectorial-de-dise%C3%B1o.jpg"));
 	        corazonVacio = ImageIO.read(new URL("https://i.pinimg.com/736x/c3/55/a1/c355a11db38530db34f8c76f9084d38c.jpg"));
 	    } catch (IOException e) {
 	        e.printStackTrace();
 	    }   
       }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if (fondo != null) {
            g2.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
        g2.setColor(Color.white);
        dibujar(g2);
        actualizar();
    }
    public void dibujar(Graphics2D g)
    {
        for (Bloques bloque : bloques) {
            if (!bloque.estaGolpeado()) {
                bloque.dibujar(g);
            }
        }
    	balon.dibujar(g);
    	g.fill(p1.getPaleta());
        g.drawString("Puntaje: " + puntaje, 10, 20);
        int corazonWidth = 20;
        int corazonHeight = 20;
        
        for (int i = 0; i < vidas; i++) {
            g.drawImage(corazon1.getScaledInstance(corazonWidth, corazonHeight, Image.SCALE_DEFAULT),
                        700 + i * 30, 10, this);
        }

        for (int i = vidas; i < 3; i++) {
            g.drawImage(corazonVacio.getScaledInstance(corazonWidth, corazonHeight, Image.SCALE_DEFAULT),
                        700 + i * 30, 10, this);
        }
    }
    public void actualizar() {
        balon.setVelocidad(velocidadPelota * (nivelActual + 1));

        balon.mover(getBounds(), colision(p1.getPaleta()));

        for (Bloques bloque : bloques) {
            if (!bloque.estaGolpeado() && balon.getBalon().intersects(bloque.getRectangulo())) {
                balon.invertirDireccionY();
                bloque.golpear();
                puntaje++;
            }
        }

        p1.mover_raqueta(getBounds());

        int contadorBloquesNoGolpeados = 0;
        for (Bloques bloque : bloques) {
            if (!bloque.estaGolpeado()) {
                contadorBloquesNoGolpeados++;
            }
        }

        if (contadorBloquesNoGolpeados == 0) {
            if (nivelActual < todosLosNiveles.size() - 1) {
                nivelActual++;
                bloques = todosLosNiveles.get(nivelActual);
                balon.setVelocidad(velocidadPelota * (nivelActual + 1));

                //System.out.println("Nivel actual: " + nivelActual);
            } else {
                juegoEnCurso = false;
                JOptionPane.showMessageDialog(this, "¡Ganaste!\nPuntaje: " + puntaje, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }

        if (balon.getBalon().getMaxY() >= getHeight()) {
            vidas = vidas - 1;
            if (vidas == 0) {
                juegoEnCurso = false;
                JOptionPane.showMessageDialog(this, "Juego perdido!\nPuntaje: " + puntaje, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                balon = new Balon(400, 200, velocidadPelota * (nivelActual + 1));
            }
        }
    }



    public void iterar() {
        while (juegoEnCurso) {
            try {
                repaint();
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private boolean colision(Rectangle2D r)
    {
    	return balon.getBalon().intersects(r);
    }
    /*
    public boolean colision(Rectangle2D r) {
        Rectangle2D[] secciones = p1.getSecciones();
        
        for (int i = 0; i < secciones.length; i++) {
            if (balon.getBalon().intersects(secciones[i])) {
                double angulo = p1.calcularAnguloRebote(secciones[i]);
                balon.ajustarDireccionRebote(angulo);
                return true;
            }
        }
        return false;
    }
    */

    

}

