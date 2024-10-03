package item

import personnage.Personnage

class Armure (nom:String, description:String,var qualite: Qualite, val typeArmure:TypeArmure):Item(nom,description) {
    fun calculProtection(): Int {
        return this.typeArmure.bonus + this.qualite.bonusQualite

}
    override fun utiliser(cible: Personnage) {

        println("${nom} est utilisé sur ${cible.nomPersonnage}")
    }
}