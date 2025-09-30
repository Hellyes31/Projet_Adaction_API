# Projet_Adaction_API

## Flyway et gestion des migrations

 Flyway pour versionner et appliquer automatiquement les changements de schéma (DDL) sur la base Postgres Neon au démarrage de l'application.

### Dépendances Maven

Les dépendances suivantes assurent la prise en charge de Flyway et de Postgres:

```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
    </dependency>
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-database-postgresql</artifactId>
</dependency>
```

### Configuration Spring

Les propriétés de configuration désactivent la génération de schéma par Hibernate et indiquent à Flyway où trouver les scripts:

```properties
spring.jpa.hibernate.ddl-auto=none
spring.flyway.locations=classpath:migrations
```

Les paramètres de connexion Postgres Neon sont définis dans `src/main/resources/application.properties`. ( mais en gitignore)

### Emplacement et convention de nommage des scripts

- **Dossier**: `src/main/resources/migrations/`
- **Convention**: `V{version}__{description}.sql` (double underscore), par ex. `V2__Create_product_table.sql`

### Migrations présentes

- `V2__Create_product_table.sql` (crée la table `product`)

Contenu de `V2__Create_product_table.sql`:

```sql
CREATE TABLE IF NOT EXISTS product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price NUMERIC(19,2) NOT NULL
);
```

### Exécuter les migrations (au démarrage)

1. S'assurer d'avoir Java 21 installé (par ex. via Homebrew sur macOS).
2. Démarrer l'application:

```bash
./mvnw spring-boot:run 
```
pour cette partie , c'est juste que je n'ai pas votre IDE magique , j'ai du le faire en ligne de commande et installer java ( j'ai installé java rien que pour vous XD )

3. Observer les logs jusqu'à voir des messages du type:
   - `Flyway Community Edition ...`
   - `Successfully applied 1 migration`
   - `Started ProjetAdactionApiApplication ...`

Lorsque ces lignes apparaissent, les migrations ont été appliquées sur Neon et les tables existent.

### Vérifier dans Neon

Depuis la console Neon ou `psql`:

```sql
\d product;
SELECT * FROM product LIMIT 1;
```

### Ajouter une nouvelle migration

1. Créer un nouveau fichier dans `src/main/resources/migrations/` avec la version suivante, par ex. `V3__Add_new_column.sql`.
2. Écrire le SQL désiré (idempotent si possible: `IF NOT EXISTS`, etc.).
3. Redémarrer l'application pour appliquer la migration.

## Notes techniques liées à JPA

- L'entité `Product` utilise `jakarta.persistence` (Spring Boot 3) et non `javax.persistence`.
- La génération automatique de schéma par Hibernate est désactivée (`spring.jpa.hibernate.ddl-auto=none`) pour éviter les conflits avec Flyway.

## Résumé des changements effectués

- Activation de Flyway et ajout des dépendances Postgres.
- Configuration de `spring.flyway.locations=classpath:migrations` et désactivation de `ddl-auto`.
- Ajout de la migration `V2__Create_product_table.sql` pour créer la table `product`.
- Passage de l'entité `Product` à `jakarta.persistence` et retrait de `javax.persistence` du `pom.xml`.
