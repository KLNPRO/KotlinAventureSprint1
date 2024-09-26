import item.Armure
import item.Bombe
import item.Potion
import item.Qualite
import jeu.Jeu
import personnage.Personnage

//Créattion des qualités des objets
val qualiteCommun = Qualite("commun", 0, "\u001B[32m")
val qualiteRare = Qualite("rare", 1, couleur = "\u001B[34m")
val qualiteEpic = Qualite("epic", 2, "\u001B[35m")
val qualiteLegendaire = Qualite("legendaire", 3, "\u001B[33m")

//TODO Sprint 1 Mission 2A et 2B Création des types d'armes/armures

//TODO Sprint 2 : Création de sorts

fun main(args: Array<String>) {
    // TODO Intemission 4 : Création des items ( armes, armures potions, bombes )
    val armure1= Armure("Cotte de mailles en adamantine","cotte de mailles plus lourde mais aussi plus solide")
    val armure2= Armure("Le manteau de la Nuit", "Une armure en cuir obscure comme la nuit")
    val potion1= Potion(20,"Potion de soin", "Une potion qui contient un liquide rouge.")
    val potion2= Potion(30,"Grande potion de soins","Une grande potion qui contient un liquide rouge.")
    val bombe1 = Bombe(4,6,"feu Gregois","Une flasque qui contient un liquide inflammable.")
    val bombe2 = Bombe(2,8,"Flasque d'acide","Une flasque qui contient une puissante substance corrosive")
    val bombe3 = Bombe(5,6,"Grenade","Une contraption qui explose une fois lancée")

    //Création des monstresSS
    val gobelin = Personnage(
        "Gob le gobelin",
        pointDeVie = 20,
        pointDeVieMax = 20,
        attaque = 5,
        defense = 4,
        vitesse = 11,
        endurance = 6)
gobelin.inventaire.add((potion1))
    // TODO Intermission 1 : Ajouter d'autres monstres
        val Monstre1 = Personnage("Ettin",85,88,16,12,14,8)
        val Monstre2= Personnage("Gnoll",22,25,11,8,11,14)
        val Monstre3= Personnage("Cyclope",114,114,18,14,14,9)
    //TODO On ajoute les monstres a la liste de monstres du jeu
    val jeu = Jeu(listOf( gobelin,Monstre1,Monstre2,Monstre3))
    //Lancement du jeu
    jeu.lancerCombat()
}