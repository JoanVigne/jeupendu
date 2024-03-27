package com.jeupendu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String motADeviner = "PENDU"; // Mot à deviner
        int tentativesMax = 6; // Nombre maximum de tentatives

        JeuPendu jeu = new JeuPendu(motADeviner, tentativesMax);

        while (!jeu.estMotDevine() && jeu.getTentativesRestantes() > 0) {
            afficherPendu(jeu.getTentativesRestantes());
            System.out.println("Mot à deviner : " + jeu.getMotPartiel());
            System.out.println("Tentatives restantes : " + jeu.getTentativesRestantes());
            System.out.print("Proposez une lettre : ");
            char lettre = scanner.next().charAt(0);
            boolean lettreTrouvee = jeu.proposerLettre(lettre);
            if (!lettreTrouvee) {
                System.out.println("La lettre '" + lettre + "' n'est pas dans le mot.");
            }
        }

        if (jeu.estMotDevine()) {
            System.out.println("Bravo ! Vous avez deviné le mot : " + jeu.getMotPartiel());
        } else {
            afficherPenduAvecBulle(jeu.getTentativesRestantes()); // Afficher le pendu final avec la bulle
            System.out.println("Désolé, vous avez perdu. Le mot était : " + jeu.getMotADeviner());
        }

        scanner.close();
    }

    public static void afficherPendu(int tentativesRestantes) {
        String[] pendu = {
                "  +---+",
                "  |   |",
                "  |   " + (tentativesRestantes < 6 ? "O" : ""),
                "  |  " + (tentativesRestantes < 5 ? "/" : "") + (tentativesRestantes < 4 ? "|" : "")
                        + (tentativesRestantes < 3 ? "\\" : ""),
                "  |  " + (tentativesRestantes < 2 ? "/" : "") + " " + (tentativesRestantes < 1 ? "\\" : ""),
                "  |",
                "===== "
        };

        for (String line : pendu) {
            System.out.println(line);
        }
    }

    public static void afficherPenduAvecBulle(int tentativesRestantes) {
        String[] pendu = {
                "  +---+      ________",
                "  |   |     | Argggh |",
                "  |   O ----|________|",
                "  |  /|\\",
                "  |  / \\",
                "  |",
                "===== "
        };

        for (String line : pendu) {
            System.out.println(line);
        }
    }
}
