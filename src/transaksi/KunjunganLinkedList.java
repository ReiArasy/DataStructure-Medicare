package src.transaksi;

import java.util.Scanner;

public class KunjunganLinkedList {

    private static class Kunjungan {
        String idDokter;
        String namaPasien;
        int umur;
        String jenisKelamin;
        String keluhan;
        Kunjungan next; // Referensi ke node berikutnya

        public Kunjungan(String idDokter, String namaPasien, int umur, String jenisKelamin, String keluhan) {
            this.idDokter = idDokter;
            this.namaPasien = namaPasien;
            this.umur = umur;
            this.jenisKelamin = jenisKelamin;
            this.keluhan = keluhan;
            this.next = null; // Inisialisasi sebagai node terakhir
        }
    }

    private Kunjungan head; // head dari linked list
    private final Scanner scanner;

    public KunjunganLinkedList() {
        this.head = null; // Inisialisasi list kosong
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
                if (umur > 0) break;
                else System.out.println("Umur harus lebih dari 0. Coba lagi.");
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

    public static void main(String[] args) {
        KunjunganLinkedList list = new KunjunganLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Tambah Data Kunjungan");
            System.out.println("2. Lihat Data Kunjungan");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Pilihan tidak valid. Masukkan angka.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    list.tambahKunjungan();
                    break;
                case 2:
                    list.lihatDataKunjungan();
                    break;
                case 3:
                    System.out.println("Keluar dari program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}