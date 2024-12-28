package src.manajemen;

import java.util.Scanner; 

public class ObatLinkedList {

    // Kelas internal untuk merepresentasikan data Obat dalam linked list.
    private static class Obat {
        String idObat;
        String nama; 
        int stok;
        String status; 

        Obat next; 

        // Konstruktor untuk menginisialisasi data Obat.
        public Obat(String idObat, String nama, int stok, String status) {
            this.idObat = idObat;
            this.nama = nama;
            this.stok = stok;
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
        System.out.print("Masukkan Status Obat: ");
        String status = scanner.nextLine();

        // Membuat node Obat baru dengan data yang dimasukkan.
        Obat newObat = new Obat(idObat, nama, stok, status);
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
        int idObat = scanner.nextInt(); // Membaca ID Obat yang akan diedit.
        Obat current = head; // Mulai dari head.

        // Iterasi untuk mencari Obat dengan ID yang sesuai.
        while (current != null) {
            if (current.idObat.equals(idObat)) {
                // Jika ditemukan, perbarui data Obat.
                System.out.print("Masukkan Nama Baru: ");
                current.nama = scanner.nextLine(); 
                System.out.print("Masukkan Stok Baru: ");
                current.stok = scanner.nextInt(); 
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
            System.out.println("Status: " + current.status);
            System.out.println("---------------------");
            current = current.next; // Lanjut ke Obat berikutnya.
        }
    }
}
