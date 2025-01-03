package src.manajemen;

import java.util.Scanner;

public class ObatLinkedList {

    private static class Obat {
        String idObat;
        String nama;
        int stok;
        double harga;
        String status;

        Obat next;

        public Obat(String idObat, String nama, int stok, double harga, String status) {
            this.idObat = idObat;
            this.nama = nama;
            this.stok = stok;
            this.harga = harga;
            this.status = status;
            this.next = null;
        }
    }

    private Obat head;

    private final Scanner scanner = new Scanner(System.in);

    public void tambahObat() {
        System.out.print("Masukkan ID Obat: ");
        String idObat = scanner.nextLine();
        System.out.print("Masukkan Nama Obat: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Stok Obat: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan Harga Obat: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan Status Obat: ");
        String status = scanner.nextLine();

        Obat newObat = new Obat(idObat, nama, stok, harga, status);
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
        System.out.print("Masukkan ID Obat yang ingin diubah: ");
        String idObat = scanner.nextLine();
        Obat current = head;

        while (current != null) {
            if (current.idObat.equals(idObat)) {
                System.out.print("Masukkan Nama Baru: ");
                current.nama = scanner.nextLine();
                System.out.print("Masukkan Stok Baru: ");
                current.stok = scanner.nextInt();
                System.out.print("Masukkan Harga Baru: ");
                current.harga = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Masukkan Status Baru: ");
                current.status = scanner.nextLine();
                System.out.println("Data Obat berhasil diperbarui.");
                return;
            }
            current = current.next;
        }
        System.out.println("Obat dengan ID " + idObat + " tidak ditemukan.");
    }

    public void lihatDataObat() {
        if (head == null) {
            System.out.println("Tidak ada data Obat.");
            return;
        }

        Obat current = head;
        while (current != null) {
            System.out.println("---------------------");
            System.out.println("ID Obat: " + current.idObat);
            System.out.println("Nama: " + current.nama);
            System.out.println("Stok: " + current.stok);
            System.out.println("Harga: Rp" + current.harga);
            System.out.println("Status: " + current.status);
            System.out.println("---------------------");
            current = current.next;
        }
    }

    public void hapusObat() {
        System.out.print("Masukkan ID Obat yang ingin dihapus: ");
        String idObat = scanner.nextLine();

        if (head == null) {
            System.out.println("Tidak ada data obat untuk dihapus.");
            return;
        }

        if (head.idObat.equals(idObat)) {
            head = head.next;
            System.out.println("Data obat berhasil dihapus.");
            return;
        }

        Obat current = head;
        Obat previous = null;
        while (current != null && !current.idObat.equals(idObat)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Obat dengan ID " + idObat + " tidak ditemukan.");
            return;
        }

        previous.next = current.next;
        System.out.println("Data obat berhasil dihapus.");
    }

    public boolean cekObatById(String idObat) {
        Obat current = head;
        while (current != null) {
            if (current.idObat.equals(idObat)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public String getNamaObatById(String idObat) {
        Obat current = head;
        while (current != null) {
            if (current.idObat.equals(idObat)) {
                return current.nama;
            }
            current = current.next;
        }
        return "Tidak ditemukan";
    }

    public double getHargaObatById(String idObat) {
        Obat current = head;
        while (current != null) {
            if (current.idObat.equals(idObat)) {
                return current.harga;
            }
            current = current.next;
        }
        return 0.0;
    }

    public int getStokObatById(String idObat) {
        Obat current = head;
        while (current != null) {
            if (current.idObat.equals(idObat)) {
                return current.stok;
            }
            current = current.next;
        }
        return 0; // Jika obat tidak ditemukan
    }

    public void kurangiStokObat(String idObat, int jumlah) {
        Obat current = head;
        while (current != null) {
            if (current.idObat.equals(idObat)) {
                current.stok -= jumlah;
                return;
            }
            current = current.next;
        }
    }
}
