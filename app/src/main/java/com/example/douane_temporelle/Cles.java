package com.example.douane_temporelle;

public class Cles {
    // ekher 4 chiffres
    public static final String MATRICULE = "2005";

    // ekher 4 chiffres zidhom esm l voyageur
    public static String cle(String matricule, String nom) {
        return matricule + "_" + nom;
    }
    // méthodes statiques mta3 l cles
    public static String nomVoyageur()  { return cle(MATRICULE, "NOM_VOYAGEUR"); }
    public static String anneeNaiss()   { return cle(MATRICULE, "ANNEE_NAISSANCE"); }
    public static String anneeDest()    { return cle(MATRICULE, "ANNEE_DESTINATION"); }
    public static String motif()        { return cle(MATRICULE, "MOTIF"); }
    public static String verdict()      { return cle(MATRICULE, "VERDICT"); }
}
