package src.manajemen;

import java.util.Scanner;

public class DokterLinkedList {
    private static class Dokter {
        String idDokter;
        String nama;
        String Spesialis;
        String status;
        Dokter next;
    
        public Dokter(String idDokter, String nama, String Spesialis, String status) {
            this.idDokter = idDokter;
            this.nama = nama;
            this.Spesialis = Spesialis;
            this.status = status;
            this.next = null;
        }
    }
    
    private Dokter head;
    private final Scanner scanner = new Scanner(System.in); 

    public void tambahDokter() {
        System.out.print("Masukkan ID Dokter: ");
        String idDokter = scanner.nextLine(); 
        System.out.print("Masukkan Nama Dokter: ");
        String nama = scanner.nextLine(); 
        System.out.print("Masukkan Spesialis Dokter: ");
        String Spesialis = scanner.nextLine(); 
        System.out.print("Masukkan Status Dokter: ");
        String status = scanner.nextLine();

        Dokter newDokter = new Dokter(idDokter, nama, Spesialis, status);
        if (head == null) {
            head = newDokter;
        } else {
            Dokter current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newDokter;
        }
        System.out.println("Dokter berhasil ditambahkan.");
    }

    public void editDokter() {
        System.out.print("Masukkan ID Dokter yang ingin diubah: ");
        String idDokter = scanner.nextLine(); 
        Dokter current = head; 

        while (current != null) {
            if (current.idDokter.equals(idDokter)) {
                System.out.print("Masukkan Nama Baru: ");
                current.nama = scanner.nextLine(); 
                System.out.print("Masukkan Spesialis Baru: ");
                current.Spesialis = scanner.nextLine(); 
                System.out.println("Data Dokter berhasil diperbarui.");
                return;
            }
            current = current.next; 
        }
        System.out.println("Dokter dengan ID " + idDokter + " tidak ditemukan.");
    }

    public void lihatDataDokter() {
        if (head == null) {
            System.out.println("Tidak ada data Dokter.");
            return;
        }

        Dokter current = head;
        while (current != null) {
            System.out.println("ID Dokter: " + current.idDokter);
            System.out.println("Nama: " + current.nama);
            System.out.println("Spesialis: " + current.Spesialis);
            System.out.println("Status: " + current.status);
            System.out.println("---------------------");
            current = current.next;
        }
    }

    public boolean cekDokterById(String idDokter) {
        Dokter current = head;
        while (current != null) {
            if (current.idDokter.equals(idDokter)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
