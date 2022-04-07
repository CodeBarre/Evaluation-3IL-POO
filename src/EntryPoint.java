import java.text.MessageFormat;
import java.util.Scanner;

/**
 * @author Adrien HAUTOT (adrien.hautot@erudo.fr)
 */
public class EntryPoint {

    public static void main(String[] args) {

        Ecole ecole = Ecole.getInstance();

        Enseignant enseignant1 = new Enseignant("Hochgnug", "Julien", "Emakina.FR");
        Enseignant enseignant2 = new Enseignant("Ruchaud", "William", "3iL");
        Enseignant enseignant3 = new Enseignant("Hautot", "Adrien", "Erudo");

        Promotion promotion1 = new Promotion("B3");
        for (int i = 0; i < 3; i++) {
            Eleve eleve1 = EleveFactory.create(LevelEleve.FORT);
            promotion1.addEleve(eleve1);
            Eleve eleve2 = EleveFactory.create(LevelEleve.MOYEN);
            promotion1.addEleve(eleve2);
            Eleve eleve3 = EleveFactory.create(LevelEleve.FAIBLE);
            promotion1.addEleve(eleve3);
        }
        Promotion promotion2 = new Promotion("MS2D");
        for (int i = 0; i < 3; i++) {
            Eleve eleve1 = EleveFactory.create(LevelEleve.FORT);
            promotion2.addEleve(eleve1);
            Eleve eleve2 = EleveFactory.create(LevelEleve.MOYEN);
            promotion2.addEleve(eleve2);
            Eleve eleve3 = EleveFactory.create(LevelEleve.FAIBLE);
            promotion2.addEleve(eleve3);
        }

        enseignant1.addPromotion(promotion1);
        enseignant1.addPromotion(promotion2);
        enseignant2.addPromotion(promotion1);
        enseignant3.addPromotion(promotion2);

        System.out.println("/_\\ Bienvenue sur 3IL manager!");

        // la Console permet de faciliter la récupération d'une saisie de l'utilisateur dans la console
        Console console = new Console();
        int functionToRun = -1;
        do {
            System.out.println("Qu'est-ce que tu veux faire?");
            System.out.println("1 - Lister les élèves");
            System.out.println("2 - Lister les enseignants");
            System.out.println("3 - Donner un cours");
            System.out.println("4 - J'ai fini");

            functionToRun = console.captureInt(1, 4);
                // contrôle de la saisie
                switch(functionToRun) {
                    case 1:
                        System.out.println("Voici la liste des élèves");
                        listEleves();
                        break;
                    case 2:
                        System.out.println("Voici la liste des enseignants");
                        listEnseignants();
                        break;
                    case 3:
                        System.out.println("C'est parti pour un cours!");
                        donnerCours();
                        break;
                    case 4:
                        System.out.println("A la prochaine!");
                    default:
                        System.err.println("Saisie invalide... tu dois choisir entre 1 et 4");
                }
            System.out.println("###################################################");

        } while(functionToRun != 4);

    }

    private static void listEnseignants() {
        Ecole ecole = Ecole.getInstance();

        System.out.println("Liste des enseignants:");

        for (Enseignant enseignant: ecole.getEnseignants()) {
            System.out.println(enseignant);
        }
    }

    private static void listEleves() {
        Ecole ecole = Ecole.getInstance();

        System.out.println("Liste des élèves:");

        for (Promotion promotion: ecole.getPromotions()) {
            System.out.println("\n #Promotion " + promotion.getNom() + ":");
            for (Eleve eleve: promotion.getEleves()) {
                System.out.println(" - \t " + eleve);
            }
        }
    }

    private static void donnerCours() {
        Ecole ecole = Ecole.getInstance();
        Console console = new Console();
        System.out.println("Quel enseignant donne un cours?");
        int i = 0;
        for (Enseignant enseignant: ecole.getEnseignants()){
            System.out.println(MessageFormat.format("{0} - {1} {2}", i, enseignant.getPrenom(), enseignant.getNom()));
            i++;
        }
        Enseignant enseignant = ecole.getEnseignants().get(console.captureInt(0, ecole.getEnseignants().size()));

        System.out.println("À quelle promotion?");
        i = 0;
        for (Promotion promotion: enseignant.getPromotions()){
            System.out.println(MessageFormat.format("{0} - {1}", i, promotion.getNom()));
            i++;
        }
        Promotion promotion = enseignant.getPromotions().get(console.captureInt(0, enseignant.getPromotions().size()));

        System.out.println("Quel est l’intitulé du cours?");
        Competence competence = new Competence(console.captureString());
        for (Eleve eleve: promotion.getEleves()) {
            eleve.learnCompetence(competence);
        }
        System.out.println("GG, les élèves deviennent meilleurs chaque jour et ont appris “" + competence.getNom() + "”!\n");
    }
}
