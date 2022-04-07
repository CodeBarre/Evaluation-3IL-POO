import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Enseignant {

    private String nom;
    private String prenom;
    private String entreprise;
    private List<Promotion> promotions;

    public Enseignant(String nom, String prenom, String entreprise) {
        this.nom = nom;
        this.prenom = prenom;
        this.entreprise = entreprise;
        this.promotions = new ArrayList<>();
        Ecole.getInstance().addEnseignant(this);
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    @Override
    public String toString() {
        String string = "";
        string = MessageFormat.format("\n #{0} {1} ({2}) \n", prenom, nom, entreprise);
            for (Promotion promotion : promotions) {
                string += "\t - \t" + promotion.getNom() + "\n";
            }
        return string;
    }
}
