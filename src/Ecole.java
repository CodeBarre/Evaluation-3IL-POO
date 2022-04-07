import java.util.ArrayList;
import java.util.List;

public class Ecole {
    private static Ecole ecole;

    private List<Enseignant> enseignants;
    private List<Promotion> promotions;

    public static Ecole getInstance() {
        if (ecole == null) {
            ecole = new Ecole();
        }
        return ecole;
    }

    private Ecole() {
        enseignants = new ArrayList<>();
        promotions = new ArrayList<>();
    }

    public void addEnseignant(Enseignant enseignant) {
        this.enseignants.add(enseignant);
    }

    public void addPromotion(Promotion promotion) {
        this.promotions.add(promotion);
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }
}
