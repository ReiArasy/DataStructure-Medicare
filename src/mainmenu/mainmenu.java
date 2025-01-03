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
    private static KunjunganLinkedList kl = new KunjunganLinkedList(dl);
    private static PembelianObatLinkedList po = new PembelianObatLinkedList(ol);

    public static void showMainMenu(String loggedInRole) {
        boolean isLoggedOut = false;

        while (!isLoggedOut) {

            System.out.println("\n==== Main Menu (" + loggedInRole + ") ====");
            if ("admin".equalsIgnoreCase(loggedInRole)) {
                System.out.println("1. Kelola Data Dokter");
                System.out.println("2. Kelola Data Obat");
                System.out.println("3. Lihat Data Kunjungan");
                System.out.println("4. Lihat Data Transaksi Pembelian Obat");
                System.out.println("5. Log-out");
            } else if ("dokter".equalsIgnoreCase(loggedInRole)) {
                System.out.println("1. Tambah kunjungan Pasien");
                System.out.println("2. Transaksi pembelian obat");
                System.out.println("3. Log-Out");
            }
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if ("admin".equalsIgnoreCase(loggedInRole)) {
                switch (choice) {
                    case 1 -> {
                        System.out.println("\n=== Kelola Data Dokter ===");
                        System.out.println("1. Tambah Data Dokter");
                        System.out.println("2. Edit Data Dokter");
                        System.out.println("3. Lihat Data Dokter");
                        System.out.println("4. Kembali");
                        System.out.print("Pilih Menu: ");
                        int submenu = scanner.nextInt();
                        switch (submenu) {
                            case 1 -> dl.tambahDokter();
                            case 2 -> dl.editDokter();
                            case 3 -> dl.lihatDataDokter();
                            case 4 -> {}
                        }
                    }
                    case 2 -> {
                        System.out.println("\n=== Kelola Data Obat ===");
                        System.out.println("1. Tambah Data Obat");
                        System.out.println("2. Edit Data Obat");
                        System.out.println("3. Lihat Data Obat");
                        System.out.println("4. Kembali");
                        System.out.print("Pilih Menu: ");
                        int submenu = scanner.nextInt();
                        switch (submenu) {
                            case 1 -> ol.tambahObat();
                            case 2 -> ol.editObat();
                            case 3 -> ol.lihatDataObat();
                            case 4 -> {}
                        }
                    }
                    case 3 -> kl.viewDataKunjungan();
                    case 4 -> po.viewDataObat();
                    case 5 -> {
                        System.out.println("Logout berhasil.");
                        isLoggedOut = true;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } else if ("dokter".equalsIgnoreCase(loggedInRole)) {
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
                            case 3 -> {}
                            default -> System.out.println("Pilihan tidak valid.");
                        }
                    }
                    case 2 -> {
                        System.out.println("\n=== Transaksi Pembelian Obat ===");
                        System.out.println("1. Tambah Transaksi");
                        System.out.println("2. List Obat");
                        System.out.println("3. Kembali");
                        System.out.print("Pilih Menu: ");
                        int submenu = scanner.nextInt();
                        switch (submenu) {
                            case 1 -> po.tambahPembelian();
                            case 2 -> po.viewDataObat();
                            case 3 -> {}
                        }
                    }
                    case 3 -> {
                        System.out.println("Logout berhasil.");
                        isLoggedOut = true;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            }
        }
    }
}
