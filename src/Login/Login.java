package src.Login;

import java.util.Scanner;
import src.mainmenu.mainmenu;

class User {
    String username;
    String password;
    User next;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.next = null;
    }
}

class UserManager {
    private User head;

    public UserManager() {
        this.head = null;
        addUser("admin", "admin123");
        addUser("dokter", "dokter123");
    }

    private User findUser(String username) {
        User current = head;
        while (current != null) {
            if (current.username.equals(username)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private void addUser(String username, String password) {
        User newUser = new User(username, password);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    public boolean login(String username, String password) {
        User user = findUser(username);
        if (user != null && user.password.equals(password)) {
            System.out.println("Login berhasil. Selamat datang, " + username + "!");
            mainmenu.showMainMenu(user.username);
            return true;
        } else {
            System.out.println("Username atau password salah.");
            return false;
        }
    }
}

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

        while (true) {
            System.out.println("\n - Aplikasi Medicare - ");
            System.out.println("\n=== Hi!, Silahkan Login ===");
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("\nPilih menu: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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