package champollion;

public class Enseignant extends Personne {
    
    private int hCM;
    private int hTD;
    private int hTP;
    private int H;
    private int D;
    private UE U;

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        H= hCM +hTD +hTP;
        return H;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        if (U==ue) {
         return hCM+hTD+hTP; 
        }
        return H;
    }
    
    public int heuresPlanifiées () {
        return D;
    }
    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
       ServicePrevu sp = new ServicePrevu(volumeCM,volumeTD,volumeTP);
       U = ue;
       hCM+= Math.round(sp.getvolumeCM()*1.5);
       hTD+= sp.getvolumeTD();
       hTP+= Math.round(sp.getvolumeTP()*0.75);
    }
    public void ajouteIntervention (Intervention e) {
        Intervention inter = e;
        D+=inter.getDuree();
    }
    public boolean sousService() {
        if(H<192) {
            return true;
        }
        return false;
    }
}
