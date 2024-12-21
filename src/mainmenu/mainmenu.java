package src.mainmenu;

import src.Login.Login;

import java.util.Scanner;

public class mainmenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void showMainMenu(String loggedInRole) {
        while (true) {
            System.out.println("\n==== Main Menu (" + loggedInRole + ") ====");
            if ("admin".equalsIgnoreCase(loggedInRole)) {
                System.out.println("1. Kelola Data Pasien");
                System.out.println("2. Kelola Data Dokter");
                System.out.println("3. Kelola Data Obat");
                System.out.println("4. Kelola Transaksi");
                System.out.println("5. Laporan");
                System.out.println("6. Logout");
            } else if ("petugas".equalsIgnoreCase(loggedInRole)) {
                System.out.println("1. Tambah Data Pasien");
                System.out.println("2. Catat Transaksi");
                System.out.println("3. Lihat Data Transaksi");
                System.out.println("4. Logout");
            }
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if ("admin".equalsIgnoreCase(loggedInRole)) {
                switch (choice) {
                    case 1 -> System.out.println("Kelola Data Pasien");
                    case 2 -> System.out.println("Kelola Data Dokter");
                    case 3 -> System.out.println("Kelola Data Obat");
                    case 4 -> System.out.println("Kelola Transaksi");
                    case 5 -> System.out.println("Laporan");
                    case 6 -> {
                        System.out.println("Logout berhasil.");
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } else if ("petugas".equalsIgnoreCase(loggedInRole)) {
                switch (choice) {
                    case 1 -> System.out.println("Tambah Data Pasien");
                    case 2 -> System.out.println("Catat Transaksi");
                    case 3 -> System.out.println("Lihat Data Transaksi");
                    case 4 -> {
                        System.out.println("Logout berhasil.");
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            }
        }
    }
}

