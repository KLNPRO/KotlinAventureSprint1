package jeu

import personnage.Personnage



class Jeu(monstres: List<Personnage>) {
    //Le personage du joueur

    lateinit var joueur: Personnage
    //La liste des monstre a combatre
     var combats: MutableList<Combat> = mutableListOf()
    //Le score
    var score: Int = 0

    // Corps du constructeur
    init {
        // Lancement de la création du personage du joueur
        this.creerPersonnage()
        // Pour chaque monstre dans la liste de monstres
        for (unMonstre in monstres){
            // On créer un combat
            val unCombat= Combat(this,unMonstre)
            combats.add(unCombat)
        }
    }

    fun lancerCombat() {
        for (unCombat in this.combats) {
            unCombat.executerCombat()
            // Mettre à jour le score en fonction du nombre de tours
            val tours = unCombat.nombreTours
            score += calculerScore(tours)
        }
        println("Score final du joueur: $score")
    }

    private fun calculerScore(tours: Int): Int {
        // Par exemple, vous pouvez attribuer plus de points pour moins de tours
        return 500 - tours * 10
    }

    /**
     *  Méthode pour créer le personnage du joueur en demandant les informations à l'utilisateur
     *
     */
    fun creerPersonnage(): Personnage {
        var nom : String=""
        var attaque : Int=0
        var defense : Int=0
        var endurance : Int=0
        var vitesse : Int=0
        var pointDeVieMax : Int=0
        var total=40
        var premierPassage=true
        println("Saisir le nom du personnage")
        nom = readln()
        while (premierPassage || total == 0)  {
            premierPassage=false
            total=40
            println("Saisir le score d'attaque : ")
            attaque = readln().toInt()
            total= total-attaque
            println("Saisir le score defense : ")
            defense = readln().toInt()
            total= total-defense
            println("Saisir le score d'endurance : ")
            endurance = readln().toInt()
            total= total-endurance
            println("Saisir le score de la vitesse : ")
            vitesse = readln().toInt()
            total= total-vitesse

            pointDeVieMax = 50 + (10 * endurance)
            if (total > 40)
                println("Vous avez distribué $total points, qui est superieur a 40 VEUILLEZ RECOMMANCER")
            else if (total < 40)
                println("Vous avez  pad tout attribiuer vos points $total, veullier mieux repartager")
            else
                println("attribution Complete")
        }
        println("Création votre personnage:")

        // TODO Mission 1.1
        val hero = Personnage(nom, pointDeVieMax, pointDeVieMax, attaque, endurance, defense, vitesse)
        this.joueur= hero
        return hero
    }
    

}