import java.util.ArrayList;
import java.util.List;

public class Promotion {
    private String nom;
    private List<Eleve> eleves;

    public Promotion(String nom) {
        this.nom = nom;
        this.eleves = new ArrayList<>();
        Ecole.getInstance().addPromotion(this);
    }

    public void addEleve(Eleve eleve) {
        eleves.add(eleve);
    }

    public String getNom() {
        return nom;
    }

    public List<Eleve> getEleves() {
        return eleves;
    }
}
