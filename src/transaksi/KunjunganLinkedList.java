package src.transaksi;

import java.util.Scanner;

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

    public KunjunganLinkedList() {
        this.head = null;
        this.scanner = new Scanner(System.in);
    }

    public void tambahKunjungan() {
        System.out.print("Masukkan ID Dokter: ");
        String idDokter = scanner.nextLine();
        System.out.print("Masukkan Nama Pasien: ");
        String namaPasien = scanner.nextLine();
        int umur;
        while (true) {
            try {
                System.out.print("Masukkan Umur: ");
                umur = Integer.parseInt(scanner.nextLine());
                if (umur > 0)
                    break;
                else
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
            head = kunjunganBaru; // Jika list kosong, set node baru sebagai head
        } else {
            Kunjungan temp = head;
            while (temp.next != null) {
                temp = temp.next; // Telusuri hingga ke akhir list
            }
            temp.next = kunjunganBaru; // Tambahkan node baru di akhir
        }

        System.out.println("Data kunjungan berhasil ditambahkan!\n");
    }

    public void lihatDataKunjungan() {
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