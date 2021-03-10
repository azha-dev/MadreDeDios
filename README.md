# MadreDeDios

Prérequis : 
- Maven 3.6.3
- Java 11


Pour lancer le projet :

Le cloner puis se placer a la racine du projet.

- Lancer la commande de compilation :  
```mvn compile```

- Lancer la commande d'execution avec vos arguments :  
entryPath : Chemin du fichier d'entrée 
outputPath : Chemin du fichier de sortie  
```mvn exec:java -Dexec.mainClass=Main -Dexec.args="entryPath outputPath"```


Pour lancer les tests :  
```mvn test```
