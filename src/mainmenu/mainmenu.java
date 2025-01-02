package src.mainmenu;

import java.util.Scanner;
import src.manajemen.DokterLinkedList;
import src.manajemen.ObatLinkedList;
import src.transaksi.KunjunganLinkedList;
import src.transaksi.PembelianObatLinkedList;

public class mainmenu {
    private static Scanner scanner = new Scanner(System.in);
    private static DokterLinkedList dl = new DokterLinkedList();
    private static ObatLinkedList ol = new ObatLinkedList();
    private static KunjunganLinkedList kl = new KunjunganLinkedList();
    private static PembelianObatLinkedList po = new PembelianObatLinkedList(ol);

    // Metode untuk menampilkan menu utama berdasarkan peran (admin atau dokter)
    public static void showMainMenu(String loggedInRole) {
        boolean isLoggedOut = false; // Flag untuk memastikan pengguna keluar dari menu setelah logout

        // Perulangan menu utama, akan berhenti jika isLoggedOut == true
        while (!isLoggedOut) {

            System.out.println("\n==== Main Menu (" + loggedInRole + ") ====");
            if ("admin".equalsIgnoreCase(loggedInRole)) { // Jika pengguna adalah admin
                System.out.println("1. Kelola Data Dokter");
                System.out.println("2. Kelola Data Obat");
                System.out.println("3. Lihat Data Kunjungan");
                System.out.println("4. Lihat Data Transaksi Pembelian Obat");
                System.out.println("5. Log-out");
            } else if ("dokter".equalsIgnoreCase(loggedInRole)) { // Jika pengguna adalah dokter
                System.out.println("1. Tambah kunjungan Pasien");
                System.out.println("2. Transaksi pembelian obat");
                System.out.println("3. Log-Out");
            }
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            // Jika pengguna adalah admin
            if ("admin".equalsIgnoreCase(loggedInRole)) {
                boolean kembaliKeMenuUtama = false; // Flag untuk kembali ke menu utama
                switch (choice) {
                    case 1 -> { // Kelola Data Dokter
                        System.out.println("\n=== Kelola Data Dokter ===");
                        System.out.println("1. Tambah Data Dokter");
                        System.out.println("2. Edit Data Dokter");
                        System.out.println("3. Lihat Data Dokter");
                        System.out.println("4. Kembali");
                        System.out.print("Pilih Menu: ");
                        int submenu = scanner.nextInt(); // Pilihan submenu untuk kelola dokter
                        switch (submenu) {
                            case 1 -> dl.tambahDokter();
                            case 2 -> dl.editDokter();
                            case 3 -> dl.lihatDataDokter();
                            case 4 -> kembaliKeMenuUtama = true;
                        }
                    }
                    case 2 -> { // Kelola Data Obat
                        System.out.println("\n=== Kelola Data Obat ===");
                        System.out.println("1. Tambah Data Obat");
                        System.out.println("2. Edit Data Obat");
                        System.out.println("3. Lihat Data Obat");
                        System.out.println("4. Kembali");
                        System.out.print("Pilih Menu: ");
                        int submenu = scanner.nextInt(); // Pilihan submenu untuk kelola obat
                        switch (submenu) {
                            case 1 -> ol.tambahObat();
                            case 2 -> ol.editObat();
                            case 3 -> ol.lihatDataObat();
                            case 4 -> kembaliKeMenuUtama = true;
                        }
                    }
                    case 3 -> kl.viewDataKunjungan();
                    case 4 -> po.viewDataTransaksiPembelianObat();
                    case 5 -> { // Log-out
                        System.out.println("Logout berhasil.");
                        isLoggedOut = true; // Set flag isLoggedOut menjadi true untuk keluar dari loop
                        loggedInRole = null; // Reset loggedInRole untuk memastikan pengguna keluar dari menu
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            }

            else if ("dokter".equalsIgnoreCase(loggedInRole)) {
                boolean kembaliKeMenuUtama = false;
                switch (choice) {
                    case 1 -> {
                        System.out.println("\n=== Tambah Kunjungan Pasien ===");
                        System.out.println("1. Lihat List Dokter");
                        System.out.println("2. Tambah Kunjungan");
                        System.out.println("3. Kembali");
                        System.out.print("Pilih Menu: ");
                        int submenu = scanner.nextInt();
                        switch (submenu) {
                            case 1 -> dl.lihatDataDokter();
                            case 2 -> kl.tambahKunjungan();
                            case 3 -> kembaliKeMenuUtama = true;
                            default -> System.out.println("Pilihan tidak valid.");
                        }
                    }
                    case 2 -> { // Transaksi Pembelian Obat
                        System.out.println("\n=== Transaksi Pembelian Obat ===");
                        System.out.println("1. Tambah Transaksi");
                        System.out.println("2. View Transaksi");
                        System.out.println("3. Kembali");
                        System.out.print("Pilih Menu: ");
                        int submenu = scanner.nextInt(); // Pilihan submenu untuk transaksi pembelian obat
                        switch (submenu) {
                            case 1 -> po.tambahPembelian();
                            case 2 -> po.viewDataTransaksiPembelianObat();
                            case 3 -> kembaliKeMenuUtama = true;
                        }
                    }
                    case 3 -> { // Log-out
                        System.out.println("Logout berhasil.");
                        isLoggedOut = true;
                        loggedInRole = null;
                    }
                    default -> System.out.println("Pilihan tidak valid."); // Jika pilihan tidak valid
                }
            }
        }
    }
}
