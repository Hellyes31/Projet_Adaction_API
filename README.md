# Adaction - API Backend

## Description

Ce projet constitue la partie **API backend** du projet **Adaction**.  
Il a été développé avec **Java Spring Boot**, et permet la gestion des données via une base **PostgreSQL hébergée sur Neon**.  
Ce projet a besoin de la partie Front fait par mon collaborateur : https://github.com/DwoDwoS/Project_Adaction_Front

L’objectif de ce backend est de mettre en place un système complet de **CRUD**, avec une base de données relationnelle, la gestion sécurisée des utilisateurs (hashage des mots de passe), et une configuration respectant les bonnes pratiques (variables d’environnement, migration Flyway, etc.).

---

## Compétences abordées

- ✅ Développer un back-end avec **Java Spring Boot**
- ✅ Mettre en place un **CRUD** (Create, Read, Update, Delete)
- ✅ Concevoir et implémenter une **base de données relationnelle**
- ✅ Écrire des **requêtes SQL** et comprendre leur logique
- ✅ Utiliser un **SGBDR** (PostgreSQL via **Neon**)
- ✅ Gérer les **migrations de schéma** avec **Flyway**
- ✅ **Chiffrer les mots de passe** (BCrypt)
- ✅ Comprendre la **configuration d’une application Spring Boot**
- ✅ Gérer les **variables d’environnement** (`.env`, `application.properties`)
- ✅ Comprendre l’utilité du fichier **package.json** (si un frontend est lié au projet)

---

## Technologies utilisées

| Outil / Techno | Rôle |
|----------------|------|
| **Java 17+** | Langage principal |
| **Spring Boot** | Framework backend |
| **Flyway** | Gestion des migrations de base de données |
| **PostgreSQL (Neon)** | Base de données relationnelle |
| **Spring Data JPA** | Communication ORM avec la base |
| **BCrypt** | Hashage des mots de passe |
| **dotenv / application.properties** | Gestion de la configuration et des variables d’environnement |
| **Maven** | Gestionnaire de dépendances |
| **Git / GitHub** | Versioning et hébergement du code |

---

## Installation du projet

### 1. Cloner le dépôt

```bash
git clone https://github.com/<ton-utilisateur>/<nom-du-repo>.git
cd <nom-du-repo>
```

### 2. Configurer les variables d'environnement

Créer un fichier .env (ou compléter le application.properties) à la racine du projet :

```properties
# Configuration base de données
SPRING_DATASOURCE_URL=jdbc:postgresql://<votre-url-neon>/<nom-de-bdd>
SPRING_DATASOURCE_USERNAME=<votre-username>
SPRING_DATASOURCE_PASSWORD=<votre-password>

# Configuration Flyway
SPRING_FLYWAY_ENABLED=true

# Port du serveur
SERVER_PORT=8080
```
Astuce : ne jamais pousser votre fichier .env sur GitHub.
Ajoutez-le à votre .gitignore pour éviter toute fuite d’informations sensibles.

### 3. Lancer les migrations de base de données

Les migrations sont gérées automatiquement par Flyway au démarrage de l’application.
Les fichiers SQL se trouvent dans le dossier :

```css
src/main/resources/db/migration/
```
Chaque fichier suit la convention :

```pgsql
V1__nom_de_la_migration.sql

```

### 4. Lancer le projet
Via Maven :

```bash
./mvnw spring-boot:run

```
Ou via votre IDE (IntelliJ / Eclipse) :

- Ouvrir le projet

- Lancer la classe principale (souvent AdactionApplication.java)

---

## Endpoints de l’API (exemples)

| Méthode  | Endpoint          | Description                        |
| -------- | ----------------- | ---------------------------------- |
| `GET`    | `/api/volunteers`      | Récupère tous les bénévoles     |
| `POST`   | `/api/volunteers`      | Crée un nouveau bénévole         |
| `GET`    | `/api/volunteers/{id}` | Récupère un bénévole spécifique |
| `PUT`    | `/api/volunteers/{id}` | Met à jour un bénévole          |
| `DELETE` | `/api/volunteers/{id}` | Supprime un bénévole            |

---

## Sécurité

- Les mots de passe sont chiffrés avec BCrypt avant d’être enregistrés.

- Les variables sensibles sont stockées dans des fichiers d’environnement.

- La connexion à la base de données Neon est sécurisée (SSL).

---

## Structure du projet
```
src/
 └── main/
     ├── java/com/adaction/
     │    ├── controllers/    # Gestion des routes API
     │    ├── models/         # Entités JPA
     │    ├── repositories/    # Interfaces JPA Repository
     │    ├── services/       # Logique métier
     │    └── ProjetAdactionApiApplication.java
     └── resources/
          ├── application.properties
          ├── migrations/  # Fichiers SQL Flyway
          └── static/        # (Optionnel)
```
---

## Tests

Les tests unitaires peuvent être exécutés avec :

```bash
./mvnw test
```
---

## Licence

Ce projet a été réalisé dans le cadre de la formation **Ada Tech School – Nantes**.  
Le code source du projet **Adaction** est fourni à des fins **pédagogiques et d’apprentissage**.  
Toute réutilisation partielle ou totale doit mentionner la source et respecter le cadre éducatif d’origine.  
Aucune utilisation commerciale n’est autorisée sans l’accord préalable de **Ada Tech School**.

---

## Auteur

Etudiants AdaTechSchool
- **Eliès** - [GitHub](https://github.com/Hellyes31)
- **Elouan** - [GitHub](https://github.com/DwoDwoS)
