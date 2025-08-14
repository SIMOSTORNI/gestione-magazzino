# Gestione Magazzino

## Descrizione
Web App per la gestione di un magazzino, con tracciamento di ordini, fornitori e prodotti.
Progettata con architettura MVC e sviluppata con Spring Boot (Java) su IntelliJ IDEA.

## Tecnologie
- Backend: Spring Boot, Spring MVC, Hibernate, JPA
- Database: MariaDB (gestito con HeidiSQL)
- Frontend: HTML, Thymeleaf, Bootstrap
- Container: Tomcat embedded
- Sicurezza: Password hashing con MessageDigest (SHA-256)

## Architettura
- Data Tier: Entità JPA e Repository (Spring Data JPA)
- Business Logic Tier: Service con logica di business
- Presentation Tier: Controller Spring MVC e View Thymeleaf

## Funzionalità
- Gestione fornitori (aggiunta, modifica, eliminazione, visualizzazione prodotti)
- Gestione prodotti (aggiunta, modifica, eliminazione, associazione a fornitori)
- Gestione ordini (creazione, modifica, eliminazione, stato evaso/non evaso)
- Visualizzazione dashboard prodotti, ordini e fornitori
- Validazione dati con trigger su Partita IVA e email

## Sicurezza
Le password degli utenti vengono salvate in formato crittografato tramite hashing SHA-256:
1. Conversione della password in byte (password.getBytes())
2. Calcolo digest con MessageDigest.getInstance("SHA-256")
3. Conversione in stringa esadecimale (String.format("%02x", b))

## Esecuzione
1. Creare il database 'prova' su MariaDB
2. Configurare application.properties con credenziali:
   spring.datasource.url=jdbc:mariadb://localhost:3306/prova
   spring.datasource.username=root
   spring.datasource.password=admin
3. Avviare l'applicazione con Maven:
   mvn spring-boot:run
