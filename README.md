## Movie Ticket Booking App (Java CLI)
### Kelompok 4 UAS Pemrograman Berorientasi Objek

A simple terminal-based Java program that simulates a movie ticket booking system. Built collaboratively by Kelompok 4 for the PBO course.

### Features

- View available movies
- Book tickets
- Choose payment method (Cash / E-Wallet with 5% discount)
- Save and view order history via `orders.txt`
- Full OOP implementation

### Technologies

- Java
- CLI (Command Line Interface)
- Git & GitHub

### Folder Structure

```
src/
├── app/Main.java
├── model/
│   ├── Movie.java (abstract)
│   ├── Movie2D/3D/IMAX.java
│   ├── BookingService.java
│   ├── Order.java
│   └── payment/
│       ├── PaymentMethod.java (interface)
│       ├── CashPayment.java
│       └── EWalletPayment.java
├── util/OrderSaver.java
orders.txt
run.bat
```

### How to Run

1. Buka terminal di root folder (`uas-pbo/`)
2. Jalankan:
   ```bash
   run.bat
   ```

Atau manual:

```bash
javac -d out src/**/*.java
java -cp out app.Main
```
