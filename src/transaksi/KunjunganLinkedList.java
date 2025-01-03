package src.transaksi;

import java.util.Scanner;
import src.manajemen.DokterLinkedList;

public class KunjunganLinkedList {
    private static class Kunjungan {
        String idDokter;
        String namaPasien;
        int umur;
        String jenisKelamin;
        String keluhan;
        Kunjungan next;

        public Kunjungan(String idDokter, String namaPasien, int umur, String jenisKelamin, String keluhan) {
            this.idDokter = idDokter;
            this.namaPasien = namaPasien;
            this.umur = umur;
            this.jenisKelamin = jenisKelamin;
            this.keluhan = keluhan;
            this.next = null;
        }
    }

    private Kunjungan head;
    private final Scanner scanner;
    private final DokterLinkedList dokterLinkedList;

    public KunjunganLinkedList(DokterLinkedList dokterLinkedList) {
        this.head = null;
        this.scanner = new Scanner(System.in);
        this.dokterLinkedList = dokterLinkedList;
    }

    public void menuTambahKunjungan() {
        while (true) {
            System.out.println("\nMenu Tambah Kunjungan Pasien:");
            System.out.println("1. Lihat List Dokter");
            System.out.println("2. Tambah Kunjungan");
            System.out.println("0. Kembali ke Menu Utama");
            System.out.print("Pilih opsi: ");

            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    lihatDataDokter();
                    break;
                case "2":
                    tambahKunjungan();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }

    public void lihatDataDokter() {
        System.out.println("\n==== Daftar Dokter ====");
        dokterLinkedList.lihatDataDokter();
    }

    public void tambahKunjungan() {
        System.out.print("Masukkan ID Dokter: ");
        String idDokter = scanner.nextLine();

        if (!dokterLinkedList.cekDokterById(idDokter)) {
            System.out.println("ID Dokter tidak ditemukan. Tambahkan dokter terlebih dahulu.");
            return;
        }

        System.out.print("Masukkan Nama Pasien: ");
        String namaPasien = scanner.nextLine();

        int umur;
        while (true) {
            try {
                System.out.print("Masukkan Umur: ");
                umur = Integer.parseInt(scanner.nextLine());
                if (umur > 0) break;
                System.out.println("Umur harus lebih dari 0. Coba lagi.");
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
            }
        }

        System.out.print("Masukkan Jenis Kelamin: ");
        String jenisKelamin = scanner.nextLine();
        System.out.print("Masukkan Keluhan: ");
        String keluhan = scanner.nextLine();

        Kunjungan kunjunganBaru = new Kunjungan(idDokter, namaPasien, umur, jenisKelamin, keluhan);

        if (head == null) {
            head = kunjunganBaru;
        } else {
            Kunjungan temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = kunjunganBaru;
        }

        System.out.println("Data kunjungan berhasil ditambahkan!\n");
    }

    public void viewDataKunjungan() {
        if (head == null) {
            System.out.println("Tidak ada data kunjungan.\n");
            return;
        }

        System.out.println("Data Kunjungan:");
        Kunjungan temp = head;
        while (temp != null) {
            System.out.println("ID Dokter: " + temp.idDokter);
            System.out.println("Nama Pasien: " + temp.namaPasien);
            System.out.println("Umur: " + temp.umur);
            System.out.println("Jenis Kelamin: " + temp.jenisKelamin);
            System.out.println("Keluhan: " + temp.keluhan);
            System.out.println("---------------------");
            temp = temp.next;
        }
    }
}
