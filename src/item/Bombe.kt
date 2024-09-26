package item

import jeu.TirageDes
import personnage.Personnage

class Bombe(var nbDeDes:Int, var maxDe:Int,  nom:String,  description:String):Item(nom,description) {

    override fun utiliser(cible:Personnage){
        var degat = TirageDes(nbDeDes,maxDe).lance() - cible.calculeDefense()
        if (degat<1) {
            degat = 1
        }
        cible.pointDeVie -= degat
        println("la Bombe a fais ${degat} de degat !")
    }
}