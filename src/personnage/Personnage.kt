package personnage

import item.*

class Personnage(
    val nomPersonnage: String,
    var pointDeVie: Int,
    val pointDeVieMax: Int,
    var attaque: Int,
    var defense: Int,
    var endurance: Int,
    var vitesse: Int,
    var armureEquiper: Armure?=null,
    var armePrincipal:Arme?=null
) {
    var inventaire: MutableList<Item> = mutableListOf()

    fun calculeDefense(): Int {
        //TODO Mission 4.2
        if (armureEquiper != null) {
            return this.defense / 2 + this.armureEquiper!!.calculProtection()
        } else {
            return this.defense / 2;

        }

    }


    override fun toString(): String {
        return "$nomPersonnage (PV: $pointDeVie/$pointDeVieMax, Attaque: $attaque, Défense: $defense, Endurance: $endurance, Vitesse: $vitesse)"
    }

    // Méthode pour attaquer un adversaire
    fun attaque(adversaire: Personnage) {
        var degats = attaque / 2

        if (this.armePrincipal != null) {
            degats += this.armePrincipal!!.calculerDegat()
        }

        val degatsInfliges = maxOf(degats - adversaire.calculeDefense(), 1)

        adversaire.pointDeVie -= degatsInfliges

        val nomArmeUtilisee = armePrincipal?.nom ?: "attaque de base"
        println("${nomPersonnage} attaque ${adversaire.nomPersonnage} avec ${nomArmeUtilisee} et inflige ${degatsInfliges} points de dégâts.")
    }

    fun equipeArme(arme: Arme) {
        if (inventaire.contains(arme)) {
            armePrincipal = arme
            println("$nomPersonnage equipe ${arme.nom}")
        }
    }

    fun equipeArmure(armure: Armure) {
        if (inventaire.contains(armure)) {
            armureEquiper = armure
            println("$nomPersonnage equipe ${armure.nom}")
        }
    }


    fun afficheinventaire() {
        println("inventaires $nomPersonnage ")
        for (item in this.inventaire.withIndex()) {
            println("${item.index} => ${item.value.nom}")
        }
    }

    fun loot(cible:Personnage){
        if(cible.pointDeVie <=0){
            cible.armePrincipal = null
            cible.armePrincipal = null
            this.inventaire.addAll(cible.inventaire)
            cible.inventaire.clear()
            println("vos avez volez l'inventaire de l'adversaire")
        }
        else {
            println("la cible est encore vivant et ne peut pas etre loot")
        }
    }

    fun avoirPotion(): Boolean {
        for (item in inventaire) {
            if (item is Potion) {
                return true
            }
        }
        return false
    }

    fun avoirBombe(): Boolean {
        for (item in inventaire) {
            if (item is Potion) {
                return true
            }
        }
        return false
    }


    fun boirePotion() {

        for (i in inventaire) {
            if (i is Potion) {
                val hpT0=this.pointDeVie
                this.pointDeVie+=i.soin
                if ( this.pointDeVieMax < pointDeVie){
                    pointDeVie = pointDeVieMax
                }
                this.inventaire.remove(i)

               var newpv =pointDeVie - hpT0
           return
                println("${this.nomPersonnage}a récupéré ${this.pointDeVie} en buvant ${i.nom}")
            }



        }
    }


}



