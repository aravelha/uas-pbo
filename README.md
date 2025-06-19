## Aplikasi Pemesanan Tiket Bioskop (Java CLI)
### Kelompok 4 UAS Pemrograman Berorientasi Objek

Program Java sederhana berbasis terminal yang mensimulasikan sistem pemesanan tiket bioskop. Dibuat secara kolaboratif oleh Kelompok 4 untuk mata kuliah Pemrograman Berorientasi Objek.

### 📁 Fitur

- Melihat daftar film yang tersedia
- Memesan tiket
- Memilih metode pembayaran (Tunai / E-Wallet dengan diskon 5%)
- Menyimpan dan menampilkan riwayat pemesanan melalui `orders.txt`
- Implementasi penuh konsep OOP (Object-Oriented Programming)

### Cara Menjalankan di Terminal

1. Buka terminal di folder root (`uas-pbo/`)
2. Jalankan:
   ```
   run.bat
   ```

Atau jalankan secara manual
```
javac -d out src/**/*.java
java -cp out app.Main
```

### Struktur Folder
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

### 🧾 Panduan Penggunaan Program
Setelah program dijalankan, ikuti petunjuk pada layar untuk melakukan pemesanan tiket:

1. **Lihat Daftar Film**  
   Saat program dimulai, akan ditampilkan daftar film yang tersedia beserta jenis (2D/3D/IMAX) dan harga tiketnya.

2. **Pilih Film**  
   Masukkan nomor film yang ingin dipesan.

3. **Masukkan Jumlah Tiket**  
   Tentukan berapa tiket yang ingin kamu beli.

4. **Pilih Metode Pembayaran**  
   - **Tunai**: Bayar sesuai harga normal.
   - **E-Wallet**: Dapatkan diskon 5%.

5. **Konfirmasi dan Simpan**  
   Setelah pembayaran dikonfirmasi, data pesanan akan disimpan secara otomatis ke file `orders.txt`.

6. **Lihat Riwayat Pemesanan**  
   Setelah melakukan pemesanan, kamu dapat memilih untuk melihat daftar pesanan yang telah dibuat.

> 💡 Catatan: Jika file `orders.txt` belum ada, program akan membuatnya secara otomatis saat pesanan pertama disimpan.

##Developer
Rahel Veralda Hutahaean, Thara Carissa Kameshwara, Callysta Cendikia Diba Putri, Dimas Adityea, Muhammad Rafi Zaydan.
