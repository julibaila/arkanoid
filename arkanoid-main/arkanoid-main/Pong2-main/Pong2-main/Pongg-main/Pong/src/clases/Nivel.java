package clases;

import java.util.ArrayList;
import java.util.List;

public class Nivel {
    private List<Bloques> bloques;

    public Nivel() {
        bloques = new ArrayList<>();
            bloques.add(new Bloques(400, 100, 80, 30));
            bloques.add(new Bloques(500, 100, 80, 30));
            bloques.add(new Bloques(300, 100, 80, 30));
        
    }


    public List<Bloques> getBloques() {
        return bloques;
    }
}
