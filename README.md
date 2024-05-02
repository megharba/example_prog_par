
# Java CSV Processing

Ce projet contient deux versions de traitement de fichiers CSV en Java : une version séquentielle et une version parallèle.

## Prérequis
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

## Installation
1. Clonez le dépôt :
   ```bash
   git clone <URL_DU_DÉPÔT>
   ```
2. Ouvrez le projet dans IntelliJ IDEA.
3. Assurez-vous que le JDK est configuré.

## Exécution des tests
Assurez-vous que le chemin du fichier CSV est configuré correctement dans les fichiers Java (`SequentialCSVProcessing` et `ParallelCSVProcessing`).

### Exécution de la version séquentielle
1. Ouvrez le fichier `SequentialCSVProcessing.java`.
2. Mettez à jour le chemin du fichier CSV (`generated_data.csv`).
3. Cliquez sur `Run` ou utilisez le raccourci `Shift + F10`.

### Exécution de la version parallèle
1. Ouvrez le fichier `ParallelCSVProcessing.java`.
2. Mettez à jour le chemin du fichier CSV (`generated_data.csv`).
3. Cliquez sur `Run` ou utilisez le raccourci `Shift + F10`.

## Détails des versions

### Version Séquentielle
Cette version lit et traite chaque ligne du fichier CSV de manière séquentielle.

**Fichier** : `SequentialCSVProcessing.java`

**Approche** :
- Chaque ligne est lue et traitée dans une seule boucle.
- Convient pour les petites tâches de traitement ou les fichiers de petite taille.

**Résultats** :
- Indiquez les résultats des tests ici.

### Version Parallèle
Cette version lit le fichier et divise les lignes en plusieurs threads pour un traitement parallèle.

**Fichier** : `ParallelCSVProcessing.java`

**Approche** :
- Le fichier est lu en entier, puis divisé en portions pour le traitement en parallèle.
- Convient pour les tâches de traitement lourdes ou les fichiers de grande taille.

**Résultats** :
- Indiquez les résultats des tests ici.

## Conclusion
La parallélisation peut améliorer les performances de traitement de fichiers CSV, mais l'efficacité dépend du type de traitement effectué et de la taille du fichier.
