package item

import jeu.TirageDes
import personnage.Personnage

class Arme(   nom:String ="",
              description:String = "",
              var typeArmes: TypeArmes,
              var qualite:Qualite):Item(description,nom) {

    fun calculerDegat():Int {
        var degat = TirageDes(this.typeArmes.nombreDes, this.typeArmes.valeurDeMax).lance()
        val tirageDeCritique = TirageDes(1, 20)
        val resultatCritique = tirageDeCritique.lance()
        if (resultatCritique >= this.typeArmes.activationCritique) {
            println("COUP CRITIQUE")
            degat *= typeArmes.multiplicateurCritique
        } else {
            degat += qualite.bonusQualite

        }
        return degat
    }


    override fun utiliser(cible: Personnage) {
cible.equipe(this)
    }
}