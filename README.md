# polyfit

Description du Projet : Application web de Suivi d'Entraînement "PolyFit"
Idée :
PolyFit ambitionne de devenir une application web complète dédiée à l'univers du fitness. Elle permettra aux utilisateurs de planifier, suivre, enregistrer leurs séances d'entraînement, et d'échanger des programmes avec d'autres utilisateurs. L'interface conviviale rendra la planification accessible à tous les niveaux de compétence.

Motivations :
PolyFit vise à simplifier le suivi des progrès physiques tout en encourageant la cohérence dans la routine d'entraînement. La technologie jouera un rôle crucial dans la motivation et la persévérance des utilisateurs.

Objectifs :
Création de Programmes d'Entraînement : Les utilisateurs pourront créer des programmes adaptés à leurs objectifs de musculation, cardio, flexibilité, etc.

Suivi des Performances : Enregistrement des séances, progrès, poids, distances, etc., pour une évaluation et une amélioration continues.

Génération de Rapports : Des analyses détaillées fourniront des insights sur les performances et les domaines d'amélioration.

Valeur ajoutée :
La personnalisation des programmes et des conseils adaptés maximiseront la pertinence et l'efficacité des séances, favorisant la motivation et la constance dans la recherche de la forme physique.

Fonctionnalités étendues :
Formulaire d'Inscription : Les données personnelles fournies permettront des suggestions de programmes selon le niveau de l'utilisateur.

Défis Journaliers : Des défis quotidiens motiveront les utilisateurs à rester actifs et engagés.

Filtres de Recherche : Recherche de programmes par niveau de pratique, muscles visés, nombre de séances, etc.

Version Payante : Une version payante offrira l'accès à des coachs professionnels pour un suivi plus personnalisé.

Alertes et Badges : Des rappels de séances et des badges récompenseront les utilisateurs pour leur engagement.

Système de Votes : Les utilisateurs pourront évaluer les programmes, favorisant une communauté active et collaborative.


## Architecture du projet 
- `src/main/java/backend/`: Répertoire principal pour les classes Java de votre application.
  - `controller/`: Contiendrait les contrôleurs REST qui reçoivent les requêtes HTTP et renvoient les réponses appropriées.
  - `model/`: Contiendrait les classes Java représentant les objets métier (utilisateur, séance d'entraînement, etc.).
  - `repository/`: Contiendrait les interfaces de repository pour interagir avec la base de données.
  - `service/`: Contiendrait les services métier qui implémentent la logique de votre application.
  - `Main.java`: Classe principale de l'application Spring Boot.
  - `config/`: Contiendrait les classes de configuration Spring (par exemple, configuration de base de données).
  - `exception/`: Contiendrait les classes de gestion des exceptions.
- `src/main/resources/`: Répertoire pour les ressources de votre application.
  - `static/`: Contiendrait les fichiers statiques tels que les feuilles de style CSS, les scripts JavaScript, les images, etc.
  - `templates/`: Contiendrait les templates HTML si vous utilisez un moteur de template comme Thymeleaf.

- 

## Versions : 
- Java : 17
- Mysql :  8.0.36

## To Install : 
- Xampp (or another solution) 
- Extensions Pack For Java (Extension VSCODE)
- Sprint boot extension Pack (Extension VSCODE)
- Maven for Java (Extension VSCODE)

## Other : 
- We run the PolyFitApplication.java class
- add mysql to env variable if not done
