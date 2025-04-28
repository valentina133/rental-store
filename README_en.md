# 🎥 Rental Store Project

Welcome to the **Rental Store** project! This Java-based system is designed to manage a movie rental store's operations.
The project uses **Maven** for dependency management and is intended to be developed using **IntelliJ IDEA**.

---

## 📌 Getting Started

To get started with this project:

### 1️⃣ Fork this repository on GitHub

- Click the **Fork** button at the top-right corner of the repository page to create your own copy.

### 2️⃣ Clone your forked repository

Open a terminal and run:

```bash
git clone https://github.com/your-username/rental-store.git
cd rental-store
```

## 🛠️ Project Setup

### Requirements

- **Java 21**
- **Maven 3.8+**
- **PostgreSQL**
- **IntelliJ IDEA** (recommended)

### Import Project

1. Open **IntelliJ IDEA**.
2. Click **Open** and select the `rental-store` folder.
3. IntelliJ should automatically recognize it as a Maven project. If prompted, select **Enable Auto-Import for Maven**.

## 📖 First Implementation Task

### Task Overview

Your first task is to implement the **Customer Data** database structure based on the diagram below with some endpoints.

### 📌 Database Diagram

There is a PDF file in the database folder containing the complete database model, including the tables for **Customer
Data*8. You can also use MySQL Workbench to view all the details by opening the rental-store.mwb file.

### Steps:

1. **Create a new database** in PotsgreSQL named `rental_store` and change the configuration in the `application.yml`
   file inside the folder `customer/resources`.
2. Map the JPA entities for:
    - `country` (already mapped)
    - `city`
    - `address`
    - `customer`
3. Ensure that:
    - Foreign key relationships are correctly implemented.
    - Data types match those in the diagram.
    - Primary keys are set properly.
4. When the application is run, Spring should create all tables in the database.
5. Create all the necessary logic to implement the following endpoints for each entity:
    - Find All
    - Find One
    - Insert
    - Update
    - Delete
6. Create an endpoint to filter data from the `customer` entity where::
    - The results must be paginated, displaying 10 elements per page.
    - It should filter by `first_name` or `last_name` based on the given input.
    - The input must be at least two characters long.
7. **Commit your changes** and push them to your forked repository.

## 📦 Maven Commands

### Build the project:

```bash
mvn clean install
