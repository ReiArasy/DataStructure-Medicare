package src.manajemen;

import java.util.Scanner;

public class PasienLinkedList {

    private static class Kunjungan {
        String tanggal;
        String keluhan;
        Kunjungan next;

        public Kunjungan(String tanggal, String keluhan) {
            this.tanggal = tanggal;
            this.keluhan = keluhan;
            this.next = null;
        }
    }

    // Kelas internal untuk merepresentasikan data pasien dalam linked list.
    private static class Pasien {
        String idPasien;
        String nama;
        int umur;
        String alamat;
        String status;
        Kunjungan kunjunganHead;
        Pasien next;

        // Konstruktor untuk menginisialisasi data pasien.
        public Pasien(String idPasien, String nama, int umur, String alamat, String status) {
            this.idPasien = idPasien;
            this.nama = nama;
            this.umur = umur;
            this.alamat = alamat;
            this.status = status;
            this.kunjunganHead = null;
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

    public void tambahKunjungan() {
        System.out.println("\n==== Tambah Kunjungan ====");
        System.out.print("Masukkan ID Pasien: ");
        String idPasien = scanner.nextLine();
        Pasien current = head;
        while (current != null) {
            if (current.idPasien.equals(idPasien)) {
                System.out.print("Masukkan Tanggal Kunjungan (YYYY-MM-DD): ");
                String tanggal = scanner.nextLine();
                System.out.print("Masukkan Keluhan: ");
                String keluhan = scanner.nextLine();

                Kunjungan newKunjungan = new Kunjungan(tanggal, keluhan);
                if (current.kunjunganHead == null) {
                    current.kunjunganHead = newKunjungan;
                } else {
                    Kunjungan kCurrent = current.kunjunganHead;
                    while (kCurrent.next != null) {
                        kCurrent = kCurrent.next;
                    }
                    kCurrent.next = newKunjungan;
                }
                System.out.println("Kunjungan berhasil ditambahkan.");
                return;
            }
            current = current.next;
        }
        System.out.println("Pasien dengan ID " + idPasien + " tidak ditemukan.");
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

    private Pasien cariPasien(String idPasien) {
        Pasien current = head;
        while (current != null) {
            if (current.idPasien.equals(idPasien)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void laporanKunjungan() {
        System.out.println("\n==== Laporan Kunjungan ====");
        Pasien current = head;
        if (current == null) {
            System.out.println("Tidak ada data pasien.");
            return;
        }

        while (current != null) {
            System.out.println("ID Pasien: " + current.idPasien);
            System.out.println("Nama: " + current.nama);
            Kunjungan kCurrent = current.kunjunganHead;
            if (kCurrent == null) {
                System.out.println("  Tidak ada data kunjungan.");
            } else {
                System.out.println("  Riwayat Kunjungan:");
                while (kCurrent != null) {
                    System.out.println("    Tanggal: " + kCurrent.tanggal + ", Keluhan: " + kCurrent.keluhan);
                    kCurrent = kCurrent.next;
                }
            }
            System.out.println("---------------------");
            current = current.next;
        }
    }

    public void editKunjungan(String idPasien, String tanggalKunjungan) {
        Pasien currentPasien = cariPasien(idPasien);
        if (currentPasien != null) {
            Kunjungan currentKunjungan = currentPasien.kunjunganHead;
            while (currentKunjungan != null) {
                if (currentKunjungan.tanggal.equals(tanggalKunjungan)) {
                    System.out.print("Masukkan keluhan baru: ");
                    currentKunjungan.keluhan = scanner.nextLine();
                    System.out.println("Data kunjungan berhasil diperbarui.");
                    return;
                }
                currentKunjungan = currentKunjungan.next;
            }
            System.out.println("Kunjungan pada tanggal tersebut tidak ditemukan.");
        } else {
            System.out.println("Pasien dengan ID " + idPasien + " tidak ditemukan.");
        }
    }

    public void hapusKunjungan(String idPasien, String tanggalKunjungan) {
        Pasien currentPasien = cariPasien(idPasien);
        if (currentPasien != null) {
            Kunjungan prev = null;
            Kunjungan current = currentPasien.kunjunganHead;

            while (current != null) {
                if (current.tanggal.equals(tanggalKunjungan)) {
                    if (prev == null) { // Jika kunjungan pertama
                        currentPasien.kunjunganHead = current.next;
                    } else {
                        prev.next = current.next;
                    }
                    System.out.println("Data kunjungan berhasil dihapus.");
                    return;
                }
                prev = current;
                current = current.next;
            }
            System.out.println("Kunjungan pada tanggal tersebut tidak ditemukan.");
        } else {
            System.out.println("Pasien dengan ID " + idPasien + " tidak ditemukan.");
        }
    }
}