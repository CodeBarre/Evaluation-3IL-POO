public class EleveFactory {

    public static Eleve create(LevelEleve level) {
        NamesGenerator.Names names = NamesGenerator.generateNames();
        switch (level) {
            case FAIBLE:
                return new Eleve(names.getLastName(), names.getFirstName(), 21, 5);
            case MOYEN:
                return new Eleve(names.getLastName(), names.getFirstName(), 21, 11);
            case FORT:
                return new Eleve(names.getLastName(), names.getFirstName(), 21, 17);
            default:
                return null;
        }
    }
}
