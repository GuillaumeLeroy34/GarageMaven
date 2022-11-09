package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

    private final String immatriculation;
    private final List<Stationnement> myStationnements = new LinkedList<>();

    public Voiture(String i) {
        if (null == i) {
            throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
        }

        immatriculation = i;

    }

    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Fait rentrer la voiture au garage Précondition : la voiture ne doit pas
     * être déjà dans un garage
     *
     * @param g le garage où la voiture va stationner
     * @throws java.lang.Exception Si déjà dans un garage
     */
    public void entreAuGarage(Garage g) throws Exception {
        // Et si la voiture est déjà dans un garage ?

        Stationnement s = new Stationnement(this, g);
        for (Stationnement sta : myStationnements) {
            if (sta.estEnCours()) {
                throw new Exception("la voiture est déjà dans un garage et ne peut pas entrer dans un autre");

            }

        }

        myStationnements.add(s);

    }

    /**
     * Fait sortir la voiture du garage Précondition : la voiture doit être dans
     * un garage
     *
     * @throws java.lang.Exception si la voiture n'est pas dans un garage
     */
    public void sortDuGarage() throws Exception {

        if (this.estDansUnGarage()) {
            for (Stationnement s : myStationnements) {
                if (s.estEnCours()) {
                    s.terminer();
                }
            }

        } else {
            throw new Exception("la voiture est déjà dehors");
        }
    }

    // TODO: Implémenter cette méthode
    // Trouver le dernier stationnement de la voiture
    // Terminer ce stationnement
    /**
     * @return l'ensemble des garages visités par cette voiture
     */
    public Set<Garage> garagesVisites() {
        Set<Garage> retour = new HashSet();
        myStationnements.forEach(e -> {
            retour.add(e.getGarage());
        });

        return (retour);
    }

    /**
     * @return vrai si la voiture est dans un garage, faux sinon
     */
    public boolean estDansUnGarage() {
        boolean ret = false;

        for (Stationnement s : myStationnements) {

            if (s.estEnCours()) {
                ret = true;
            }
        }
        return ret;

    }

    /**
     * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste
     * des dates d'entrée / sortie dans ce garage
     * <br>
     * Exemple :
     *
     * <pre>
     * Garage Castres:
     *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
     *		Stationnement{ entree=28/01/2019, en cours }
     *  Garage Albi:
     *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
     * </pre>
     *
     * @param out l'endroit où imprimer (ex: System.out)
     */
    public void imprimeStationnements(PrintStream out) {

        for (Garage g : this.garagesVisites()) {
            out.println(g.toString());
        
        for (Stationnement t : myStationnements) {
            if(t.getGarage().equals(g))
            out.println(t.toString());
        }}
    }

}
