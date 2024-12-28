package src.manajemen;

import java.util.HashMap;
import java.util.Scanner;

public class ObatLinkedList {

    private static class Obat {
        String idObat;
        String nama;
        int stok;
        String status;
        Obat next;

        public Obat(String idObat, String nama, int stok, String status) {
            this.idObat = idObat;
            this.nama = nama;
            this.stok = stok;
            this.status = status;
            this.next = null;
        }
    }

    private Obat head;
    private final Scanner scanner = new Scanner(System.in);
    private final HashMap<String, Integer> laporanPembelian = new HashMap<>();

    public void tambahObat() {
        System.out.println("\n==== Tambah Data Obat ====");
        System.out.print("Masukkan ID Obat: ");
        String idObat = scanner.nextLine();
        System.out.print("Masukkan Nama Obat: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Stok Obat: ");
        int stok = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan Status Obat (tersedia/tidak tersedia): ");
        String status = scanner.nextLine();

        Obat newObat = new Obat(idObat, nama, stok, status);
        if (head == null) {
            head = newObat;
        } else {
            Obat current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newObat;
        }
        System.out.println("Obat berhasil ditambahkan.");
    }

    public void editObat() {
        System.out.println("\n==== Edit Data Obat ====");
        System.out.print("Masukkan ID Obat yang ingin diubah: ");
        String idObat = scanner.nextLine();
        Obat current = head;

        while (current != null) {
            if (current.idObat.equals(idObat)) {
                System.out.print("Masukkan Nama Baru: ");
                current.nama = scanner.nextLine();
                System.out.print("Masukkan Stok Baru: ");
                current.stok = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan Status Baru (tersedia/tidak tersedia): ");
                current.status = scanner.nextLine();
                System.out.println("Data obat berhasil diperbarui.");
                return;
            }
            current = current.next;
        }
        System.out.println("Obat dengan ID " + idObat + " tidak ditemukan.");
    }

    public void lihatDataObat() {
        System.out.println("\n==== Data Obat ====");
        if (head == null) {
            System.out.println("Tidak ada data obat.");
            return;
        }

        Obat current = head;
        while (current != null) {
            System.out.println("ID Obat: " + current.idObat);
            System.out.println("Nama: " + current.nama);
            System.out.println("Stok: " + current.stok);
            System.out.println("Status: " + current.status);
            System.out.println("---------------------");
            current = current.next;
        }
    }

    public void pembelianObat() {
        System.out.println("\n==== Pembelian Obat ====");
        System.out.print("Masukkan Nama Obat yang Dibeli: ");
        String namaObat = scanner.nextLine();
        System.out.print("Masukkan Jumlah Pembelian: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        Obat current = head;
        while (current != null) {
            if (current.nama.equalsIgnoreCase(namaObat)) {
                if (current.stok >= jumlah) {
                    current.stok -= jumlah;
                    laporanPembelian.put(namaObat, laporanPembelian.getOrDefault(namaObat, 0) + jumlah);
                    System.out.println("Pembelian berhasil. Stok tersisa: " + current.stok);
                } else {
                    System.out.println("Stok tidak mencukupi. Stok tersedia: " + current.stok);
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Obat dengan nama " + namaObat + " tidak ditemukan.");
    }

    public void laporanpembelianobat() {
        System.out.println("\n==== Laporan Pembelian Obat ====");
        if (laporanPembelian.isEmpty()) {
            System.out.println("Belum ada pembelian obat.");
            return;
        }
        for (String namaObat : laporanPembelian.keySet()) {
            System.out.println("Nama Obat: " + namaObat + ", Total Pembelian: " + laporanPembelian.get(namaObat));
        }
    }
}
