package src.transaksi;

import java.util.Scanner;
import src.manajemen.ObatLinkedList;

public class PembelianObatLinkedList {

    private static class PembelianObat {
        String idTransaksi;
        String idObat;
        int jumlah;
        double totalHarga;

        PembelianObat next;

        public PembelianObat(String idTransaksi, String idObat, int jumlah, double totalHarga) {
            this.idTransaksi = idTransaksi;
            this.idObat = idObat;
            this.jumlah = jumlah;
            this.totalHarga = totalHarga;
            this.next = null;
        }
    }

    private PembelianObat head;
    private final Scanner scanner = new Scanner(System.in);
    private final ObatLinkedList obatLinkedList;

    public PembelianObatLinkedList(ObatLinkedList obatLinkedList) {
        this.obatLinkedList = obatLinkedList;
    }

    public void tambahPembelian() {
        System.out.println("\n==== Tambah Data Pembelian Obat ====");
        System.out.print("Masukkan ID Transaksi: ");
        String idTransaksi = scanner.nextLine();
        System.out.print("Masukkan ID Obat: ");
        String idObat = scanner.nextLine();

        if (!obatLinkedList.cekObatById(idObat)) {
            System.out.println("ID Obat tidak ditemukan. Tambahkan obat terlebih dahulu.");
            return;
        }

        System.out.print("Masukkan Jumlah: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        int stokTersedia = obatLinkedList.getStokObatById(idObat);
        if (jumlah > stokTersedia) {
            System.out.println("Stok tidak mencukupi. Stok tersedia: " + stokTersedia);
            return;
        }

        double hargaObat = obatLinkedList.getHargaObatById(idObat);
        double totalHarga = jumlah * hargaObat;

        PembelianObat newPembelian = new PembelianObat(idTransaksi, idObat, jumlah, totalHarga);
        if (head == null) {
            head = newPembelian;
        } else {
            PembelianObat current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPembelian;
        }

        obatLinkedList.kurangiStokObat(idObat, jumlah);
        System.out.println("Data pembelian obat berhasil ditambahkan.");
    }

    public void viewDataTransaksiPembelianObat() {
        System.out.println("\n==== Data Transaksi Pembelian Obat ====");
        if (head == null) {
            System.out.println("Tidak ada data transaksi pembelian obat.");
            return;
        }

        PembelianObat current = head;
        while (current != null) {
            System.out.println("ID Transaksi: " + current.idTransaksi);
            System.out.println("ID Obat: " + current.idObat);
            System.out.println("Nama Obat: " + obatLinkedList.getNamaObatById(current.idObat));
            System.out.println("Jumlah: " + current.jumlah);
            System.out.println("Total Harga: Rp" + current.totalHarga);
            System.out.println("---------------------");
            current = current.next;
        }
    }
}
