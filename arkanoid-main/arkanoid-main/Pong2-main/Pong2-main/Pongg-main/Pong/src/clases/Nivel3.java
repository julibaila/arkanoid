package clases;

import java.util.ArrayList;
import java.util.List;

public class Nivel3 {
    private List<Bloques> bloques;

    public Nivel3() {
        bloques = new ArrayList<>();
        
        int numFilas = 5; 
        int numColumnas = 10; 
        int anchoBloque = 60; 
        int altoBloque = 20; 
        int espacioHorizontal = 15;
        int espacioVertical = 10;
        
        for (int fila = 0; fila < numFilas; fila++) {
            for (int columna = 0; columna < numColumnas; columna++) {
                int x = columna * (anchoBloque + espacioHorizontal) + 50;
                int y = fila * (altoBloque + espacioVertical) + 50;
                bloques.add(new Bloques(x, y, anchoBloque, altoBloque));
            }
        }
    }

    public List<Bloques> getBloques() {
        return bloques;
    }
}



