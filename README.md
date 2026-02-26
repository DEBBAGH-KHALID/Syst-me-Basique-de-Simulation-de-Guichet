# Systeme-Basique-de-Simulation-de-Guichet

1. Présentation du Projet :

L'objectif est de développer une application console en Java (Approche Procédurale) simulant les fonctionnalités critiques d'un Distributeur Automatique de Billets.  L'utilisateur doit pouvoir interagir avec son compte de manière sécurisée et fluide.
3. Spécifications Fonctionnelles :
   
 Le système doit répondre aux exigences suivantes :
 SF1 : Sécurité et AccèsAuthentification : Le programme doit exiger un code PIN (ex: 1234) avant d'autoriser l'accès au menu.Tentatives : Bloquer l'accès après 3 échecs consécutifs.
 SF2 : Gestion du 
 Solde : Le solde initial est fixé par défaut (ex: 0.00DH).
 Dépôt : L'utilisateur saisit un montant. Le système valide que le montant est strictement positif avant de l'ajouter au solde.
 Retrait : Le système vérifie que le solde est suffisant (solde $\ge$ montant) avant de débiter. Aucun découvert n'est autorisé.
 SF3 : Traçabilité (Historique)Chaque transaction (Dépôt ou Retrait) doit être enregistrée textuellement.L'historique doit stocker les 100 dernières opérations dans un tableau de chaînes de caractères (String[]).
 
 3. Architecture Technique (Contraintes):

Pour respecter le paradigme procédural, le projet doit suivre cette structure :
A. Stockage des Données (Variables Statiques)

Toutes les variables d'état doivent être déclarées au sommet de la classe avec le mot-clé static :
double solde : État financier du compte.
String[] historiques : Tableau de stockage des messages.
int nbhistoriques : Compteur pour l'index du tableau.


4. Algorithme de Contrôle:
  
Le flux logique du programme suit cet ordonnancement :
1-Phase d'entrée : Appel de la fonction de sécurité.
Boucle de service : Tant que l'utilisateur n'a pas choisi "Quitter" :
Affichage du menu.
Lecture du choix via Scanner.
2-Exécution de la fonction correspondante via un bloc switch.
3-Phase de sortie : Message de remerciement et fermeture du Scanner.
