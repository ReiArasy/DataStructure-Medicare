package src.manajemen;

import java.util.Scanner; 

public class DokterLinkedList {
    // Kelas internal untuk merepresentasikan data Dokter dalam linked list.
    private static class Dokter {
        String idDokter;
        String nama;
        String Spesialis;
        String status;
        Dokter next;
    
        public Dokter(String idDokter, String nama, String Spesialis, String status) {
            this.idDokter = idDokter;
            this.nama = nama;
            this.Spesialis = Spesialis;
            this.status = status;
            this.next = null;
        }
    }
    
    private Dokter head; // Pointer awal dari linked list (head).

    private final Scanner scanner = new Scanner(System.in); 

    // Metode untuk menambahkan Dokter baru ke linked list.
    public void tambahDokter() {
        System.out.println("\n==== Tambah Data Dokter ====");
        System.out.print("Masukkan ID Dokter: ");
        String idDokter = scanner.nextLine(); 
        System.out.print("Masukkan Nama Dokter: ");
        String nama = scanner.nextLine(); 
        System.out.print("Masukkan Spesialis Dokter: ");
        String Spesialis = scanner.nextLine(); 
        System.out.print("Masukkan Status Dokter: ");
        String status = scanner.nextLine();

        // Membuat node Dokter baru dengan data yang dimasukkan.
        Dokter newDokter = new Dokter(idDokter, nama, Spesialis, status);
        if (head == null) {
            // Jika linked list kosong, Dokter baru menjadi head.
            head = newDokter;
        } else {
            // Jika linked list tidak kosong, tambahkan Dokter di akhir.
            Dokter current = head; // Mulai dari head.
            while (current.next != null) {
                current = current.next; // Iterasi ke node berikutnya.
            }
            current.next = newDokter; // Tambahkan Dokter baru di akhir.
        }
        System.out.println("Dokter berhasil ditambahkan.");
    }

    // Metode untuk mengedit data Dokter berdasarkan ID.
    public void editDokter() {
        System.out.println("\n==== Edit Data Dokter ====");
        System.out.print("Masukkan ID Dokter yang ingin diubah: ");
        int idDokter = scanner.nextInt(); // Membaca ID Dokter yang akan diedit.
        Dokter current = head; // Mulai dari head.

        // Iterasi untuk mencari Dokter dengan ID yang sesuai.
        while (current != null) {
            if (current.idDokter.equals(idDokter)) {
                // Jika ditemukan, perbarui data Dokter.
                System.out.print("Masukkan Nama Baru: ");
                current.nama = scanner.nextLine(); 
                System.out.print("Masukkan Spesialis Baru: ");
                current.Spesialis = scanner.nextLine(); 
                System.out.println("Data Dokter berhasil diperbarui.");
                return; // Keluar setelah data diperbarui.
            }
            current = current.next; // Lanjut ke Dokter berikutnya.
        }
        // Jika Dokter dengan ID tersebut tidak ditemukan.
        System.out.println("Dokter dengan ID " + idDokter + " tidak ditemukan.");
    }

    // Metode untuk membaca dan menampilkan semua data Dokter.
    public void lihatDataDokter() {
        System.out.println("\n==== Data Dokter ====");
        if (head == null) {
            // Jika linked list kosong.
            System.out.println("Tidak ada data Dokter.");
            return;
        }

        Dokter current = head; // Mulai dari head.
        while (current != null) {
            System.out.println("ID Dokter: " + current.idDokter);
            System.out.println("Nama: " + current.nama);
            System.out.println("Spesialis: " + current.Spesialis);
            System.out.println("Status: " + current.status);
            System.out.println("---------------------");
            current = current.next; // Lanjut ke Dokter berikutnya.
        }
    }
}
