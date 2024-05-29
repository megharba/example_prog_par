# Java CSV Processing

Ce projet contient deux versions de traitement de fichiers CSV en Java : une version séquentielle et une version parallèle.

## Groupe
- Adrien Garcia
- Clement Deborde
- Bruno Megharba
- Arthur Estrems

## Prérequis
- Java Development Kit (JDK)
- IntelliJ IDEA

## Installation
1. Clonez le dépôt :
    ```bash
    git clone <URL_DU_DÉPÔT>
    ```
2. Ouvrez le projet dans IntelliJ IDEA.
3. Assurez-vous que le JDK est configuré.

## Exécution des tests
Assurez-vous que le chemin du fichier CSV est configuré correctement dans les fichiers Java (`SequentialCSVProcessing` et `ParallelCSVProcessing`).

## Exécution de la version séquentielle
1. Ouvrez le fichier `SequentialCSVProcessing.java`.
2. Mettez à jour le chemin du fichier CSV (`generated_data.csv`).
3. Cliquez sur Run ou utilisez le raccourci `Shift + F10`.

## Exécution de la version parallèle
1. Ouvrez le fichier `ParallelCSVProcessing.java`.
2. Mettez à jour le chemin du fichier CSV (`generated_data.csv`).
3. Cliquez sur Run ou utilisez le raccourci `Shift + F10`.

## Détails des versions

### Version Séquentielle
Cette version lit et traite chaque ligne du fichier CSV de manière séquentielle.

**Fichier** : `SequentialCSVProcessing.java`

**Approche** :
- Chaque ligne est lue et traitée dans une seule boucle.
- Convient pour les petites tâches de traitement ou les fichiers de petite taille.

**Résultats** :
- **Cas 1 - Sequential Error Line Count:** 51.2757 ms
- **Cas 2 - Sequential Read and Parallel Process:** 58.4665 ms
- **Cas 3 - Sequential Read with Transformation:** 22.1599 ms

### Version Parallèle
Cette version lit le fichier et divise les lignes en plusieurs threads pour un traitement parallèle.

**Fichier** : `ParallelCSVProcessing.java`

**Approche** :
- Le fichier est lu en entier, puis divisé en portions pour le traitement en parallèle.
- Convient pour les tâches de traitement lourdes ou les fichiers de grande taille.

**Résultats** :
- **Cas 1 - Parallel Error Line Count:** 131.5331 ms
- **Cas 2 - Parallel Read and Process:** 80.6867 ms
- **Cas 3 - Parallel Read with Transformation:** 88.8821 ms

## Conclusion des tests

### Comparaison des performances
1. **Cas 1: Comptage des lignes en erreur**
   - **Séquentielle:** 51.2757 ms
   - **Parallèle:** 131.5331 ms
   - **Analyse:** La version parallèle a pris plus de temps que la version séquentielle. Cela s'explique par le fait que chaque unité de travail est très petite et que le coût de la parallélisation est plus grand que le coût de la séquentialisation. De plus, la lecture d'un fichier est une opération séquentielle, donc la parallélisation n'apporte pas de gain de performance.

2. **Cas 2: Lecture séquentielle et traitement parallèle**
   - **Séquentielle:** 58.4665 ms
   - **Parallèle:** 80.6867 ms
   - **Analyse:** La différence de temps d'exécution entre la fonction séquentielle et la fonction parallèle est notable. La majorité du temps d'exécution est consacrée à la lecture du fichier, qui est une opération séquentielle. Le traitement parallèle n'a pas apporté une amélioration significative en raison de la faible complexité de chaque tâche de traitement.

3. **Cas 3: Lecture séquentielle avec transformation**
   - **Séquentielle:** 22.1599 ms
   - **Parallèle:** 88.8821 ms
   - **Analyse:** La version parallèle a pris plus de temps que la version séquentielle, malgré une transformation par ligne. Cela montre que pour des transformations simples, le coût de la gestion des threads peut surpasser les bénéfices de la parallélisation.

## Conclusion générale
La parallélisation peut grandement améliorer les performances d'un programme, surtout pour des tâches de traitement lourdes. Cependant, elle peut aussi entraîner une dégradation des performances si elle est mal utilisée, notamment pour des tâches très petites où le coût de gestion des threads dépasse le bénéfice de la parallélisation. Les résultats montrent qu'une compréhension approfondie du problème à résoudre est essentielle pour déterminer si la parallélisation est bénéfique.

---

## Résumé des observations
1. La parallélisation n'a pas apporté de gain de performance pour les petites tâches de traitement.
2. La parallélisation a été moins efficace que la séquentialisation même pour des tâches de traitement modérées.
3. L'analyse des performances montre l'importance de choisir la bonne approche en fonction de la nature des tâches à traiter.
