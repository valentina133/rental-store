# 🎥 Progetto Rental Store

Benvenuto nel progetto **Rental Store**! Questo sistema basato su Java è stato progettato per gestire le operazioni di
un negozio di noleggio film. Il progetto utilizza **Maven** per la gestione delle dipendenze ed è destinato a essere
sviluppato utilizzando **IntelliJ IDEA**.

---

## 📌 Iniziare

Per iniziare con questo progetto:

### 1️⃣ Fai il fork di questo repository su GitHub

- Clicca sul pulsante **Fork** nell'angolo in alto a destra della pagina del repository per creare la tua copia.

### 2️⃣ Clona il tuo repository biforcato

Apri un terminale ed esegui:

```bash
git clone https://github.com/tuo-username/rental-store.git
cd rental-store
```

## 🛠️ Configurazione del Progetto

### Requisiti

- **Java 21**
- **Maven 3.8+**
- **PostgreSQL**
- **IntelliJ IDEA** (consigliato)

### Importa Progetto

1. Apri **IntelliJ IDEA**.
2. Clicca su **Open** e seleziona la cartella `rental-store`.
3. IntelliJ dovrebbe riconoscerlo automaticamente come un progetto Maven. Se richiesto, seleziona **Enable Auto-Import
   for Maven**.

## 📖 Primo Compito di Implementazione

### Panoramica del Compito

Il tuo primo compito è implementare la struttura del database **Customer Data** basata sul diagramma seguente con alcuni
endpoint.

### 📌 Diagramma del Database

C'è un file PDF nella cartella del database che contiene il modello completo del database, incluse le tabelle per *
*Customer Data**. Puoi anche utilizzare MySQL Workbench per visualizzare tutti i dettagli aprendo il file
rental-store.mwb.

### Passaggi:

1. **Crea un nuovo database** in PostgreSQL chiamato `rental_store` e modifica la configurazione nel file
   `application.yml` all'interno della cartella `customer/resources`.
2. Mappa le entità JPA per:
    - `country` (già mappato)
    - `city`
    - `address`
    - `customer`
3. Assicurati che:
    - I rapporti di chiave esterna siano implementati correttamente.
    - I tipi di dati corrispondano a quelli nel diagramma.
    - Le chiavi primarie siano impostate correttamente.
4. Quando l'applicazione viene eseguita, Spring dovrebbe creare tutte le tabelle nel database.
5. Crea tutta la logica necessaria per implementare i seguenti endpoint per ciascuna entità:
    - Trova Tutti
    - Trova Uno
    - Inserisci
    - Aggiorna
    - Elimina
6. Crea un endpoint per filtrare i dati dall'entità `customer` dove:
    - I risultati devono essere paginati, visualizzando 10 elementi per pagina.
    - Deve filtrare per `first_name` o `last_name` in base all'input fornito.
    - L'input deve essere di almeno due caratteri di lunghezza.
7. **Esegui il commit delle modifiche** e spingile nel tuo repository biforcato.

## 📦 Comandi Maven

### Compila il progetto:

```bash
mvn clean install
```