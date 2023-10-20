package clases;

import java.util.ArrayList;
import java.util.List;

public class Nivel4 {
    private List<Bloques> bloques;

    public Nivel4() {
        bloques = new ArrayList<>();
        
        int numFilas = 8;  
        int blockWidth = 50;  
        int blockHeight = 20;  
        int startX = 50;  
        int startY = 50;  
        int paddingX = 10;  
        int paddingY = 10;  
        
        for (int fila = 0; fila < numFilas; fila++) {
            for (int col = 0; col < 16; col++) { 
                int x = startX + col * (blockWidth + paddingX);
                int y = startY + fila * (blockHeight + paddingY);
                bloques.add(new Bloques(x, y, blockWidth, blockHeight));
            }
        }
    }

    public List<Bloques> getBloques() {
        return bloques;
    }
}
