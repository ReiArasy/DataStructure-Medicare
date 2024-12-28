package src.manajemen;

import java.util.Scanner;

public class DokterLinkedList {

    private static class Dokter {
        String idDokter;
        String nama;
        String spesialis;
        String status;
        Dokter next;

        public Dokter(String idDokter, String nama, String spesialis, String status) {
            this.idDokter = idDokter;
            this.nama = nama;
            this.spesialis = spesialis;
            this.status = status;
            this.next = null;
        }
    }

    private Dokter head;
    private final Scanner scanner = new Scanner(System.in);

    public void tambahDokter() {
        System.out.println("\n==== Tambah Data Dokter ====");
        System.out.print("Masukkan ID Dokter: ");
        String idDokter = scanner.nextLine();
        System.out.print("Masukkan Nama Dokter: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Spesialisasi Dokter: ");
        String spesialis = scanner.nextLine();
        System.out.print("Masukkan Status Dokter (aktif/tidak aktif): ");
        String status = scanner.nextLine();

        Dokter newDokter = new Dokter(idDokter, nama, spesialis, status);
        if (head == null) {
            head = newDokter;
        } else {
            Dokter current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newDokter;
        }
        System.out.println("Dokter berhasil ditambahkan.");
    }

    public void editDokter() {
        System.out.println("\n==== Edit Data Dokter ====");
        System.out.print("Masukkan ID Dokter yang ingin diubah: ");
        String idDokter = scanner.nextLine();
        Dokter current = head;

        while (current != null) {
            if (current.idDokter.equals(idDokter)) {
                System.out.print("Masukkan Nama Baru: ");
                current.nama = scanner.nextLine();
                System.out.print("Masukkan Spesialisasi Baru: ");
                current.spesialis = scanner.nextLine();
                System.out.print("Masukkan Status Baru (aktif/tidak aktif): ");
                current.status = scanner.nextLine();
                System.out.println("Data dokter berhasil diperbarui.");
                return;
            }
            current = current.next;
        }
        System.out.println("Dokter dengan ID " + idDokter + " tidak ditemukan.");
    }

    public void lihatDataDokter() {
        System.out.println("\n==== Data Dokter ====");
        if (head == null) {
            System.out.println("Tidak ada data dokter.");
            return;
        }

        Dokter current = head;
        while (current != null) {
            System.out.println("ID Dokter: " + current.idDokter);
            System.out.println("Nama: " + current.nama);
            System.out.println("Spesialisasi: " + current.spesialis);
            System.out.println("Status: " + current.status);
            System.out.println("---------------------");
            current = current.next;
        }
    }
}
