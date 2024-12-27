package src.mainmenu;

import src.Login.Login;
import src.datapasien.PasienLinkedList;

import java.util.Scanner;

public class mainmenu {
    private static Scanner scanner = new Scanner(System.in);
    private static PasienLinkedList mp = new PasienLinkedList();

    public static void showMainMenu(String loggedInRole) {
        while (true) {
            System.out.println("\n==== Main Menu (" + loggedInRole + ") ====");
            if ("admin".equalsIgnoreCase(loggedInRole)) {
                System.out.println("1. Kelola Data Pasien");
                System.out.println("2. Kelola Data Dokter");
                System.out.println("3. Kelola Data Obat");
                System.out.println("4. Lihat Data Transaksi");  //view data transaksi kunjungan dan pembelian obat
                System.out.println("5. Logout");
            } else if ("petugas".equalsIgnoreCase(loggedInRole)) {
                System.out.println("1. Tambah Data Pasien");
                System.out.println("2. Tambah Transaksi"); //add kunjungan atau pembelian obat
                System.out.println("3. Lihat Data Transaksi"); // view data transaksi kunjungan dan pembelian obat
                System.out.println("4. Logout");
            }
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if ("admin".equalsIgnoreCase(loggedInRole)) {
                switch (choice) {
                    case 1 -> keloladatapasien("admin");
                    case 2 -> keloladatadokter();
                    case 3 -> keloladataobat();
                    case 4 -> laporan();
                    case 5 -> {
                        System.out.println("Logout berhasil.");
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } else if ("petugas".equalsIgnoreCase(loggedInRole)) {
                switch (choice) {
                    case 1 -> keloladatapasien("petugas");
                    case 2 -> transaksi();
                    case 3 -> laporan();
                    case 4 -> {
                        System.out.println("Logout berhasil.");
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            }
        }
    }

    public static void keloladatapasien(String loggedInRole) {
        while (true) {
            System.out.println("\n==== Kelola Data Pasien ====");
            if ("admin".equalsIgnoreCase(loggedInRole)) {
                System.out.println("1. Tambah Pasien");
                System.out.println("2. Edit Pasien");
                System.out.println("3. Lihat Data Pasien");
                System.out.println("4. Kembali ke Main Menu");
            } else if ("petugas".equalsIgnoreCase(loggedInRole)) {
                System.out.println("1. Tambah Pasien");
                System.out.println("2. Lihat Data Pasien");
                System.out.println("3. Kembali ke Main Menu");
            }
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if ("admin".equalsIgnoreCase(loggedInRole)) {
                switch (choice) {
                    case 1 -> mp.tambahPasien();
                    case 2 -> mp.editPasien();
                    case 3 -> mp.lihatDataPasien();
                    case 4 -> {
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } else if ("petugas".equalsIgnoreCase(loggedInRole)) {
                switch (choice) {
                    case 1 -> mp.tambahPasien();
                    case 3 -> mp.lihatDataPasien();
                    case 2 -> {
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            }
        }
    }

    public static void keloladatadokter() {
        while (true) {
            System.out.println("\n==== Kelola Data Dokter ====");
            System.out.println("1. Tambah Dokter");
            System.out.println("2. Edit Dokter"); // (sama seperti manage pasien)ga ku kasih delete karena siapa tau datanya diperlukan suatu hari nanti, jadi nanti tambahkan status yang bisa di edit (status pasien: keluar/ masih dirumah sakit)
            System.out.println("3. Read Data Dokter");
            System.out.println("4. Kembali ke Main Menu");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> tambahDokter();
                case 2 -> editDokter();
                case 3 -> lihatDataDokter();
                case 4 -> {
                    return; // Kembali ke menu utama
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void keloladataobat() {
        while (true) {
            System.out.println("\n==== Kelola Data Obat ====");
            System.out.println("1. Tambah Obat");
            System.out.println("2. Edit Obat"); // (manage obat, disini akan ada status obat tersedia atau tidak nya obat/ obat masih di produksi atau tidak)
            System.out.println("3. Read Data Obat");
            System.out.println("4. Kembali ke Main Menu");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> tambahObat();
                case 2 -> editObat();
                case 3 -> lihatDataObat();
                case 4 -> {
                    return; // Kembali ke menu utama
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void laporan() {
        while (true) {
            System.out.println("\n==== Laporan ====");
            System.out.println("1. Lihat Laporan Kunjungan");
            System.out.println("2. Lihat Laporan Transaksi pembelian obat"); // total pembelian per jenis/nama obat yang diinputkan nanti= total pembelian obat A ada 10 
            System.out.println("3. Kembali ke Main Menu");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1 -> mp.laporanKunjungan();
                case 2 -> laporanpembelianobat();
                case 3 -> {
                    return; // Kembali ke menu utama
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void transaksi() {
        while (true) {
            System.out.println("\n==== Tambah ====");
            System.out.println("1. Tambah Kunjungan pasien");
            System.out.println("2. Pembelian obat"); 
            System.out.println("3. Kembali ke Main Menu");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1 -> mp.tambahKunjungan();
                case 2 -> pembelianObat();
                case 3 -> {
                    return; // Kembali ke menu utama
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}

