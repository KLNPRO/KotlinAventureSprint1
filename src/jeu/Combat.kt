package jeu

import personnage.Personnage

class Combat(
    val jeu :Jeu,
    val monstre: Personnage
) {
    var nombreTours: Int = 1

    // Méthode pour simuler un tour de combat du joueur
    fun tourDeJoueur() {
        println("\u001B[34m ---Tour de ${this.jeu.joueur.nomPersonnage} (pv: ${this.jeu.joueur.pointDeVie}) ---")
       //TODO Mission 1.2
        this.jeu.joueur.boirePotion()
        println("Choisissez une action: 1 => Attaquer, 2 => Passer ")

        var res=readln().toInt()
        if (res==1) {
            this.jeu.joueur.attaque(monstre)

        }
        else {
            println("${this.jeu.joueur.nomPersonnage} passe le tour.")
        }
        println("\u001b[0m")
    }

    // Méthode pour simuler un tour de combat du monstre
    fun tourDeMonstre() {
        println("\u001B[31m---Tour de ${monstre.nomPersonnage} (pv: ${monstre.pointDeVie}) ")
        var generation: Int = (0..100).random()
        if (generation <= 70) {
            this.monstre.attaque(this.jeu.joueur)

        }else if(monstre.pointDeVieMax <= monstre.pointDeVieMax/2  && monstre.avoirPotion() && generation<80  ){


        }
        else
            println("le monstre passe son tour")
        println("\u001b[0m")



    }

    // Méthode pour exécuter le combat complet
    fun executerCombat() {
        println("Début du combat : ${this.jeu.joueur.nomPersonnage} vs ${monstre.nomPersonnage}")
        //La vitesse indique qui commence
        var tourJoueur = this.jeu.joueur.vitesse >= this.monstre.vitesse
        //Tant que le joueur et le monstre sont vivants
        while (this.jeu.joueur.pointDeVie > 0 && monstre.pointDeVie > 0) {
            println("Tours de jeu : ${nombreTours}")
            if (tourJoueur) {
                tourDeJoueur()
            } else {
                tourDeMonstre()
            }
            nombreTours++
            tourJoueur = !tourJoueur // Alternance des tours entre le joueur et le monstre
            println("${this.jeu.joueur.nomPersonnage}: ${this.jeu.joueur.pointDeVie} points de vie | ${monstre.nomPersonnage}: ${monstre.pointDeVie} points de vie")
            println("")
        }

        if (this.jeu.joueur.pointDeVie <= 0) {
            println("Game over ! ${this.jeu.joueur.nomPersonnage} a été vaincu !")
            println("Le combat recommence")

            this.jeu.joueur.pointDeVie = this.jeu.joueur.pointDeVieMax
            this.monstre.pointDeVie = this.monstre.pointDeVieMax
            this.executerCombat()
        } else {
            println("BRAVO ! ${monstre.nomPersonnage} a été vaincu !")
        }
    }
}