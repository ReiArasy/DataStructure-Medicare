
// untuk mengelola proses 
package src.Login;

import java.util.Scanner;
import src.mainmenu.mainmenu;

// Class untuk menyimpan data pengguna (user)
class User {
    String username; // Menyimpan username pengguna
    String password; // Menyimpan password pengguna
    User next; // Menyimpan referensi ke pengguna berikutnya dalam linked list

    // Konstruktor untuk membuat objek User baru
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.next = null; // Set next ke null, artinya tidak ada pengguna lain setelahnya
    }
}

// Class untuk mengelola daftar pengguna
class UserManager {
    private User head; // Head node dari linked list pengguna

    // Konstruktor untuk menginisialisasi linked list pengguna dan menambahkan
    // pengguna default
    public UserManager() {
        this.head = null; // Inisialisasi linked list kosong (head = null)

        // Menambahkan pengguna default (admin dan petugas)
        addUser("admin", "admin123");
        addUser("dokter", "dokter123");
    }

    // Mencari pengguna berdasarkan username
    private User findUser(String username) {
        User current = head; // Mulai pencarian dari head node
        while (current != null) { // Selama ada node berikutnya
            if (current.username.equals(username)) { // Jika username ditemukan
                return current; // Kembalikan user tersebut
            }
            current = current.next; // Lanjutkan pencarian ke node berikutnya
        }
        return null; // Kembalikan null jika tidak ditemukan
    }

    // Menambahkan pengguna baru (admin atau petugas) ke linked list
    private void addUser(String username, String password) {
        User newUser = new User(username, password); // Buat user baru
        if (head == null) { // Jika linked list kosong (head = null)
            head = newUser; // Set head ke user baru
        } else {
            User current = head;
            while (current.next != null) { // Mencari akhir dari linked list
                current = current.next; // Pindah ke node berikutnya
            }
            current.next = newUser; // Tambahkan user baru di akhir linked list
        }
    }

    // Login pengguna dengan memverifikasi username dan password
    public boolean login(String username, String password) {
        User user = findUser(username); // Cari user berdasarkan username
        if (user != null && user.password.equals(password)) { // Jika user ditemukan dan password sesuai
            System.out.println("Login berhasil. Selamat datang, " + username + "!");
            mainmenu.showMainMenu(user.username);
            return true; // Login berhasil
        } else {
            System.out.println("Username atau password salah.");
            return false; // Login gagal
        }
    }
}

// untuk mengelola proses login
public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membaca input dari pengguna
        UserManager userManager = new UserManager(); // Membuat objek UserManager

        // Loop untuk menu utama aplikasi
        while (true) {
            System.out.println("\n - Aplikasi Medicare - ");
            System.out.println("\n=== Hi!, Silahkan Login ===");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("\nPilih menu: ");
            int choice = scanner.nextInt(); // Membaca pilihan menu
            scanner.nextLine(); // Mengkonsumsi newline setelah pilihan menu

            switch (choice) {
                case 1 -> {
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan password: ");
                    String password = scanner.nextLine();
                    userManager.login(username, password);
                }
                case 2 -> {
                    System.out.println("\nAnda Telah Keluar!, Terima Kasih Telah Menggunakan Medicare-App!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}

