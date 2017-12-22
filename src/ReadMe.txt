Pour pouvoir recompiler la gammaire il est nécessaire d'installer les packages :
	byacc-j et jflex

pour compiler le projet il est possible de lancer la commande : 
	$make

Si la grammaire à besoin d'être recompiler il faut lancer la commande :
	$make grammaire

Pour nettoyer la grammaire il est possible de lancer la commande : 
	$make clean_grammaire

Pour lancer le programme il faut lancer la commande
	$sh exec.sh

pour générer la doc il existe la commande : 
	$make doc

pour supprimer la doc il faut lancer la commande :
	$make clean_doc

pour lancer les tests il faut lancer la commande :
	$make test
