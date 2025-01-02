package src.manajemen;

import java.util.Scanner;

public class ObatLinkedList {

    // Kelas internal untuk merepresentasikan data Obat dalam linked list.
    private static class Obat {
        String idObat;
        String nama;
        int stok;
        double harga;
        String status;

        Obat next;

        // Konstruktor untuk menginisialisasi data Obat.
        public Obat(String idObat, String nama, int stok, double harga, String status) {
            this.idObat = idObat;
            this.nama = nama;
            this.stok = stok;
            this.harga = harga;
            this.status = status;
            this.next = null; // Awalnya, Obat tidak menunjuk ke Obat lain.
        }
    }

    private Obat head; // Pointer awal dari linked list (head).

    private final Scanner scanner = new Scanner(System.in);

    // Metode untuk menambahkan Obat baru ke linked list.
    public void tambahObat() {
        System.out.println("\n==== Tambah Data Obat ====");
        System.out.print("Masukkan ID Obat: ");
        String idObat = scanner.nextLine();
        System.out.print("Masukkan Nama Obat: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Stok Obat: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan Harga Obat: ");
        double harga = scanner.nextDouble();
        scanner.nextLine(); // Konsumsi newline setelah angka
        System.out.print("Masukkan Status Obat: ");
        String status = scanner.nextLine();

        // Membuat node Obat baru dengan data yang dimasukkan.
        Obat newObat = new Obat(idObat, nama, stok, harga, status);
        if (head == null) {
            // Jika linked list kosong, Obat baru menjadi head.
            head = newObat;
        } else {
            // Jika linked list tidak kosong, tambahkan Obat di akhir.
            Obat current = head; // Mulai dari head.
            while (current.next != null) {
                current = current.next; // Iterasi ke node berikutnya.
            }
            current.next = newObat; // Tambahkan Obat baru di akhir.
        }
        System.out.println("Obat berhasil ditambahkan.");
    }

    // Metode untuk mengedit data Obat berdasarkan ID.
    public void editObat() {
        System.out.println("\n==== Edit Data Obat ====");
        System.out.print("Masukkan ID Obat yang ingin diubah: ");
        String idObat = scanner.nextLine(); // Membaca ID Obat yang akan diedit.
        Obat current = head; // Mulai dari head.

        // Iterasi untuk mencari Obat dengan ID yang sesuai.
        while (current != null) {
            if (current.idObat.equals(idObat)) {
                // Jika ditemukan, perbarui data Obat.
                System.out.print("Masukkan Nama Baru: ");
                current.nama = scanner.nextLine();
                System.out.print("Masukkan Stok Baru: ");
                current.stok = scanner.nextInt();
                System.out.print("Masukkan Harga Baru: ");
                current.harga = scanner.nextDouble();
                scanner.nextLine(); // Konsumsi newline setelah angka
                System.out.print("Masukkan Status Baru: ");
                current.status = scanner.nextLine();
                System.out.println("Data Obat berhasil diperbarui.");
                return; // Keluar setelah data diperbarui.
            }
            current = current.next; // Lanjut ke Obat berikutnya.
        }
        // Jika Obat dengan ID tersebut tidak ditemukan.
        System.out.println("Obat dengan ID " + idObat + " tidak ditemukan.");
    }

    // Metode untuk membaca dan menampilkan semua data Obat.
    public void lihatDataObat() {
        System.out.println("\n==== Data Obat ====");
        if (head == null) {
            // Jika linked list kosong.
            System.out.println("Tidak ada data Obat.");
            return;
        }

        Obat current = head; // Mulai dari head.
        while (current != null) {
            System.out.println("ID Obat: " + current.idObat);
            System.out.println("Nama: " + current.nama);
            System.out.println("Stok: " + current.stok);
            System.out.println("Harga: Rp" + current.harga);
            System.out.println("Status: " + current.status);
            System.out.println("---------------------");
            current = current.next; // Lanjut ke Obat berikutnya.
        }
    }

    // Metode untuk menghapus data Obat berdasarkan ID.
    public void hapusObat() {
        System.out.println("\n==== Hapus Data Obat ====");
        System.out.print("Masukkan ID Obat yang ingin dihapus: ");
        String idObat = scanner.nextLine();

        if (head == null) {
            System.out.println("Tidak ada data obat untuk dihapus.");
            return;
        }

        // Jika data yang akan dihapus adalah head.
        if (head.idObat.equals(idObat)) {
            head = head.next;
            System.out.println("Data obat berhasil dihapus.");
            return;
        }

        // Mencari data obat di linked list.
        Obat current = head;
        Obat previous = null;
        while (current != null && !current.idObat.equals(idObat)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Obat dengan ID " + idObat + " tidak ditemukan.");
            return;
        }

        // Menghapus data obat.
        previous.next = current.next;
        System.out.println("Data obat berhasil dihapus.");
    }

    // Metode untuk memeriksa apakah obat ada berdasarkan ID.
    public boolean cekObatById(String idObat) {
        Obat current = head;
        while (current != null) {
            if (current.idObat.equals(idObat)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Metode untuk mendapatkan nama obat berdasarkan ID.
    public String getNamaObatById(String idObat) {
        Obat current = head;
        while (current != null) {
            if (current.idObat.equals(idObat)) {
                return current.nama;
            }
            current = current.next;
        }
        return "Tidak ditemukan";
    }

    // Metode untuk mendapatkan harga obat berdasarkan ID.
    public double getHargaObatById(String idObat) {
        Obat current = head;
        while (current != null) {
            if (current.idObat.equals(idObat)) {
                return current.harga;
            }
            current = current.next;
        }
        return 0.0; // Jika obat tidak ditemukan.
    }
}
