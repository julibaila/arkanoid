package clases;

import java.util.ArrayList;
import java.util.List;

public class Nivel2 {
    private List<Bloques> bloques;

    public Nivel2() {
        bloques = new ArrayList<>();
        
        int numRows = 4; 
        int blockWidth = 80;
        int blockHeight = 30;
        int startX = 300; 
        int startY = 0; 
        int paddingX = 20;
        int paddingY = 20;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col <= row; col++) {
                int x = startX + col * (blockWidth + paddingX);
                int y = startY + row * (blockHeight + paddingY);
                bloques.add(new Bloques(x, y, blockWidth, blockHeight));
            }
        }
    }

    public List<Bloques> getBloques() {
        return bloques;
    }
}




