import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Eleve {

    private String nom;
    private String prenom;
    private int age;
    private List<Competence> competences;
    private int moyenne;

    public Eleve(String nom, String prenom, int age, int moyenne) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.moyenne = moyenne;
        this.competences = new ArrayList<>();
    }

    public void learnCompetence(Competence competence) {
        competences.add(competence);
    }

    @Override
    public String toString() {
        String string = "";
        string = MessageFormat.format("{0} {1} ({2}/20) \n \t Compétences :", prenom, nom, moyenne);
        if (competences.isEmpty()) {
            string += "aucune";
        } else {
            for (Competence competence : competences) {
                string += competence.getNom() + " - ";
            }
        }
        return string;
    }
}
