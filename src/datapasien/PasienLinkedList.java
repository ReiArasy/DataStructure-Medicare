package src.datapasien;

import java.util.Scanner; 

public class PasienLinkedList {

    // Kelas internal untuk merepresentasikan data pasien dalam linked list.
    private static class Pasien {
        String idPasien;
        String nama; 
        int umur; 
        String alamat; 
        String status; 
        Pasien next; 

        // Konstruktor untuk menginisialisasi data pasien.
        public Pasien(String idPasien, String nama, int umur, String alamat, String status) {
            this.idPasien = idPasien;
            this.nama = nama;
            this.umur = umur;
            this.alamat = alamat;
            this.status = status;
            this.next = null; // Awalnya, pasien tidak menunjuk ke pasien lain.
        }
    }

    private Pasien head; // Pointer awal dari linked list (head).

    private final Scanner scanner = new Scanner(System.in); 

    // Metode untuk menambahkan pasien baru ke linked list.
    public void tambahPasien() {
        System.out.println("\n==== Tambah Data Pasien ====");
        System.out.print("Masukkan ID Pasien: ");
        String idPasien = scanner.nextLine(); 
        System.out.print("Masukkan Nama Pasien: ");
        String nama = scanner.nextLine(); 
        System.out.print("Masukkan Umur Pasien: ");
        int umur = scanner.nextInt(); 
        scanner.nextLine(); 
        System.out.print("Masukkan Alamat Pasien: ");
        String alamat = scanner.nextLine(); 
        System.out.print("Masukkan Status Pasien: ");
        String status = scanner.nextLine();

        // Membuat node pasien baru dengan data yang dimasukkan.
        Pasien newPasien = new Pasien(idPasien, nama, umur, alamat, status);
        if (head == null) {
            // Jika linked list kosong, pasien baru menjadi head.
            head = newPasien;
        } else {
            // Jika linked list tidak kosong, tambahkan pasien di akhir.
            Pasien current = head; // Mulai dari head.
            while (current.next != null) {
                current = current.next; // Iterasi ke node berikutnya.
            }
            current.next = newPasien; // Tambahkan pasien baru di akhir.
        }
        System.out.println("Pasien berhasil ditambahkan.");
    }

    // Metode untuk mengedit data pasien berdasarkan ID.
    public void editPasien() {
        System.out.println("\n==== Edit Data Pasien ====");
        System.out.print("Masukkan ID Pasien yang ingin diubah: ");
        String idPasien = scanner.nextLine(); // Membaca ID pasien yang akan diedit.
        Pasien current = head; // Mulai dari head.

        // Iterasi untuk mencari pasien dengan ID yang sesuai.
        while (current != null) {
            if (current.idPasien.equals(idPasien)) {
                // Jika ditemukan, perbarui data pasien.
                System.out.print("Masukkan Nama Baru: ");
                current.nama = scanner.nextLine(); 
                System.out.print("Masukkan Umur Baru: ");
                current.umur = scanner.nextInt(); 
                scanner.nextLine(); 
                System.out.print("Masukkan Alamat Baru: ");
                current.alamat = scanner.nextLine(); 
                System.out.print("Masukkan Status Baru: ");
                current.status = scanner.nextLine(); 
                System.out.println("Data pasien berhasil diperbarui.");
                return; // Keluar setelah data diperbarui.
            }
            current = current.next; // Lanjut ke pasien berikutnya.
        }
        // Jika pasien dengan ID tersebut tidak ditemukan.
        System.out.println("Pasien dengan ID " + idPasien + " tidak ditemukan.");
    }

    // Metode untuk membaca dan menampilkan semua data pasien.
    public void lihatDataPasien() {
        System.out.println("\n==== Data Pasien ====");
        if (head == null) {
            // Jika linked list kosong.
            System.out.println("Tidak ada data pasien.");
            return;
        }

        Pasien current = head; // Mulai dari head.
        while (current != null) {
            System.out.println("ID Pasien: " + current.idPasien);
            System.out.println("Nama: " + current.nama);
            System.out.println("Umur: " + current.umur);
            System.out.println("Alamat: " + current.alamat);
            System.out.println("Status: " + current.status);
            System.out.println("---------------------");
            current = current.next; // Lanjut ke pasien berikutnya.
        }
    }
}
