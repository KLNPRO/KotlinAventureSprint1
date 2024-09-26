package item

import jeu.TirageDes
import personnage.Personnage

class Arme(   nom:String ="",
              description:String = "",
              var typeArmes: TypeArmes,
              var qualite:Qualite):Item(description,nom) {

    override fun utiliser(cible: Personnage) {
        fun calculerDegat() {
            var degat = TirageDes(this.typeArmes.nombreDes, this.typeArmes.valeurDeMax).lance()
            val tirageDeCritique = TirageDes(1, 20)
            val resultatCritique = tirageDeCritique.lance()
            if (resultatCritique >= this.typeArmes.activationCritique) {
                println("COUP CRITIQUE")
                degat *= typeArmes.multiplicateurCritique
            } else {
                degat += qualite.bonusQualite
                return calculerDegat()
            }
        }

        fun utiliser(cible: Personnage) {

        }
    }
}