//test github

package src.transaksi;

import java.util.Scanner;
import src.manajemen.ObatLinkedList;

public class PembelianObatLinkedList {

    // Kelas internal untuk merepresentasikan data pembelian obat dalam linked list.
    private static class PembelianObat {
        String idTransaksi;
        String idObat; // ID Obat untuk mencocokkan dengan data obat
        int jumlah;
        double totalHarga;

        PembelianObat next; // Referensi ke node berikutnya.

        // Konstruktor untuk menginisialisasi data pembelian obat.
        public PembelianObat(String idTransaksi, String idObat, int jumlah, double totalHarga) {
            this.idTransaksi = idTransaksi;
            this.idObat = idObat;
            this.jumlah = jumlah;
            this.totalHarga = totalHarga;
            this.next = null; // Awalnya, tidak ada node berikutnya.
        }
    }

    private PembelianObat head; // Pointer awal dari linked list (head).
    private final Scanner scanner = new Scanner(System.in);

    // Referensi ke ObatLinkedList untuk mendapatkan data obat.
    private final ObatLinkedList obatLinkedList;

    // Konstruktor dengan referensi ke ObatLinkedList
    public PembelianObatLinkedList(ObatLinkedList obatLinkedList) {
        this.obatLinkedList = obatLinkedList;
    }

    // Metode untuk menambahkan transaksi pembelian obat berdasarkan ID obat.
    public void tambahPembelian() {
        System.out.println("\n==== Tambah Data Pembelian Obat ====");
        System.out.print("Masukkan ID Transaksi: ");
        String idTransaksi = scanner.nextLine();
        System.out.print("Masukkan ID Obat: ");
        String idObat = scanner.nextLine();

        // Validasi apakah ID Obat ada dalam daftar obat.
        if (!obatLinkedList.cekObatById(idObat)) {
            System.out.println("ID Obat tidak ditemukan. Tambahkan obat terlebih dahulu.");
            return;
        }

        System.out.print("Masukkan Jumlah: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline setelah angka

        // Ambil harga obat dari ObatLinkedList
        double hargaObat = obatLinkedList.getHargaObatById(idObat);
        double totalHarga = jumlah * hargaObat;

        // Membuat node PembelianObat baru dengan data yang dimasukkan.
        PembelianObat newPembelian = new PembelianObat(idTransaksi, idObat, jumlah, totalHarga);
        if (head == null) {
            // Jika linked list kosong, pembelian baru menjadi head.
            head = newPembelian;
        } else {
            // Jika linked list tidak kosong, tambahkan pembelian di akhir.
            PembelianObat current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPembelian;
        }
        System.out.println("Data pembelian obat berhasil ditambahkan.");
    }

    // Metode untuk melihat semua data transaksi pembelian obat.
    public void viewDataTransaksiPembelianObat() {
        System.out.println("\n==== Data Transaksi Pembelian Obat ====");
        if (head == null) {
            // Jika linked list kosong.
            System.out.println("Tidak ada data transaksi pembelian obat.");
            return;
        }

        PembelianObat current = head; // Mulai dari head.
        while (current != null) {
            System.out.println("ID Transaksi: " + current.idTransaksi);
            System.out.println("ID Obat: " + current.idObat);
            System.out.println("Nama Obat: " + obatLinkedList.getNamaObatById(current.idObat));
            System.out.println("Jumlah: " + current.jumlah);
            System.out.println("Total Harga: Rp" + current.totalHarga);
            System.out.println("---------------------");
            current = current.next; // Lanjut ke node berikutnya.
        }
    }
}
