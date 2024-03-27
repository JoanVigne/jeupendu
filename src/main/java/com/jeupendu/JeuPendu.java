package com.jeupendu;

public class JeuPendu {
    private String motADeviner;
    private StringBuilder motPartiel;
    private int tentativesRestantes;

    public JeuPendu(String motADeviner, int tentativesMax) {
        this.motADeviner = motADeviner.toUpperCase();
        this.motPartiel = new StringBuilder("_".repeat(motADeviner.length()));
        this.tentativesRestantes = tentativesMax;
    }

    public boolean proposerLettre(char lettre) {
        lettre = Character.toUpperCase(lettre);
        boolean lettreTrouvee = false;

        for (int i = 0; i < motADeviner.length(); i++) {
            if (motADeviner.charAt(i) == lettre) {
                motPartiel.setCharAt(i, lettre);
                lettreTrouvee = true;
            }
        }

        if (!lettreTrouvee) {
            tentativesRestantes--;
        }

        return lettreTrouvee;
    }

    public boolean estMotDevine() {
        return motPartiel.indexOf("_") == -1;
    }

    public String getMotPartiel() {
        return motPartiel.toString();
    }

    public int getTentativesRestantes() {
        return tentativesRestantes;
    }

    public String getMotADeviner() {
        return motADeviner;
    }
}
