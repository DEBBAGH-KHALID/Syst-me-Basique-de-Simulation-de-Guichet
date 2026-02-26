import java.util.Scanner;

public class Gestion {
    static double solde ;
    static String[] historiques = new String[100] ;
    static int nbhistorique = 0;
    static boolean estConnecte ;
    static int choix ;
    static Scanner sc = new Scanner(System.in);
    static void main(String[] args) {
    estConnecte = verifiePIN();
    if(estConnecte){
        do {
            afficheMenu();
            choix = saisirChoix();
            switch (choix){
                case 1 :
                    consulterSolde();
                    break;
                case 2 :
                    effectuerDepot();
                    break ;
                case 3 :
                    effectuerRetraite();
                    break ;
                case 4 :
                    afficheHistorique(historiques);
                    break;
                default:
                    System.out.println("Le choix que vous avez entrer n'est pas valid !!");
            }
        }while(estConnecte  && choix !=5);
    }
    }
    public static void afficheMenu(){
        System.out.println("--------------Menu------------");
        System.out.println("1---Solde");
        System.out.println("2---Depot");
        System.out.println("3---Retrait");
        System.out.println("4---Historique");
        System.out.println("5---Quitter");
    }
    public static int saisirChoix(){
        System.out.print("Entrer votre choix :");
        int choix = sc.nextInt();
        return choix ;
    }
    public static void consulterSolde(){
        System.out.println("Votre solde est : "+solde+" DH");
    }
    public static void effectuerDepot(){
        System.out.print("Entrer le montant a disposer dans votre compte :");
        double montant = sc.nextDouble();
        if(montant >=0){
            historiques[nbhistorique] = "Depot de : + "+montant+" DH";
            nbhistorique++;
            solde += montant;

        }else{
            System.out.println(" Attention!! Le montant que vous avez entrer invalid");
        }
    }
    public static void effectuerRetraite(){
        System.out.print("Entrer le montant a retiré :");
        double montant = sc.nextDouble();
        if (montant <= solde){
            historiques[nbhistorique] = "Retraite de : - "+montant+" DH";
            nbhistorique++;
            solde -= montant;
        }else{
            System.out.println("Le montant que vous avez saisi n'existe pas dans votre compte !!!!");
        }
    }
    public static void afficheHistorique(String[] historiques) {
        System.out.println("Voici votre historiques :");
        for (int i=0 ; i<nbhistorique;i++) {
            if (historiques[i] != null) {
                System.out.println(historiques[i]);
            } else {
                System.out.println("Pas de historiques");
            }
        }
    }
    public static boolean verifiePIN(){
        int i=0;
        while(estConnecte == false){
            System.out.print("Entrer votre code PIN (4 chiffres):");
            int PIN = sc.nextInt();
            if(PIN == 1234){
                estConnecte = true;
            }else{
                i++;
            }
            if (i==3){
                System.out.println("Vous avez depasser 3 essaie !!!");
                return false;
            }
        }
        return true;
    }
}
