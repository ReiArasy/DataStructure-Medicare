import java.util.Scanner;

// Node classes for multi linked lists
class UserNode {
    String username;
    String password;
    String role;
    UserNode next;

    public UserNode(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.next = null;
    }
}

class PatientNode {
    String id;
    String name;
    String address;
    TransactionNode transactionHead;
    MedicalRecordNode recordHead;
    PatientNode next;

    public PatientNode(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.transactionHead = null;
        this.recordHead = null;
        this.next = null;
    }
}

class TransactionNode {
    String id;
    String date;
    double amount;
    String description;
    TransactionNode next;

    public TransactionNode(String id, String date, double amount, String description) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.next = null;
    }
}

class MedicalRecordNode {
    String id;
    String date;
    String diagnosis;
    String treatment;
    MedicalRecordNode next;

    public MedicalRecordNode(String id, String date, String diagnosis, String treatment) {
        this.id = id;
        this.date = date;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.next = null;
    }
}

// Main class for clinic management
public class MediCare {
    private UserNode userHead;
    private PatientNode patientHead;
    private static Scanner scanner = new Scanner(System.in);
    private static String currentUser = null;
    private static String currentRole = null;

    public MediCare() {
        initializeUsers();
    }

    private void initializeUsers() {
        addUser("admin", "admin123", "ADMIN");
        addUser("petugas", "petugas123", "STAFF");
    }

    private void addUser(String username, String password, String role) {
        UserNode newNode = new UserNode(username, password, role);
        if (userHead == null) {
            userHead = newNode;
        } else {
            UserNode current = userHead;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    private boolean login(String username, String password) {
        UserNode current = userHead;
        while (current != null) {
            if (current.username.equals(username) && current.password.equals(password)) {
                currentUser = username;
                currentRole = current.role;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void addPatient(String id, String name, String address) {
        if (findPatient(id) != null) {
            System.out.println("Error: Pasien dengan ID " + id + " sudah ada!");
            return;
        }

        PatientNode newNode = new PatientNode(id, name, address);
        if (patientHead == null) {
            patientHead = newNode;
        } else {
            PatientNode current = patientHead;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    private void listPatients() {
        if (patientHead == null) {
            System.out.println("Belum ada data pasien.");
            return;
        }

        System.out.println("\n=== DAFTAR PASIEN ===");
        PatientNode current = patientHead;
        while (current != null) {
            System.out.printf("ID: %s, Nama: %s, Alamat: %s\n",
                    current.id, current.name, current.address);
            current = current.next;
        }
    }

    private void addTransaction(String patientId, String transactionId, String date,
            double amount, String description) {
        PatientNode patient = findPatient(patientId);
        if (patient == null) {
            System.out.println("Error: Pasien tidak ditemukan!");
            return;
        }

        TransactionNode newTransaction = new TransactionNode(transactionId, date, amount, description);
        if (patient.transactionHead == null) {
            patient.transactionHead = newTransaction;
        } else {
            TransactionNode current = patient.transactionHead;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTransaction;
        }
    }

    private void addMedicalRecord(String patientId, String recordId, String date,
            String diagnosis, String treatment) {
        PatientNode patient = findPatient(patientId);
        if (patient == null) {
            System.out.println("Error: Pasien tidak ditemukan!");
            return;
        }

        MedicalRecordNode newRecord = new MedicalRecordNode(recordId, date, diagnosis, treatment);
        if (patient.recordHead == null) {
            patient.recordHead = newRecord;
        } else {
            MedicalRecordNode current = patient.recordHead;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newRecord;
        }
    }

    private void viewPatientRecords(String patientId) {
        PatientNode patient = findPatient(patientId);
        if (patient == null) {
            System.out.println("Error: Pasien tidak ditemukan!");
            return;
        }

        System.out.println("\n=== REKAM MEDIS PASIEN ===");
        System.out.println("Pasien: " + patient.name + " (ID: " + patient.id + ")");

        MedicalRecordNode record = patient.recordHead;
        if (record == null) {
            System.out.println("Belum ada rekam medis untuk pasien ini.");
            return;
        }

        while (record != null) {
            System.out.printf("\nID Rekam Medis: %s\nTanggal: %s\nDiagnosis: %s\nTreatment: %s\n",
                    record.id, record.date, record.diagnosis, record.treatment);
            record = record.next;
        }
    }

    private PatientNode findPatient(String id) {
        PatientNode current = patientHead;
        while (current != null) {
            if (current.id.equals(id)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private void generateTransactionReport() {
        if (patientHead == null) {
            System.out.println("Belum ada data transaksi.");
            return;
        }

        System.out.println("\n=== LAPORAN TRANSAKSI ===");
        PatientNode currentPatient = patientHead;
        double totalAmount = 0;
        int totalTransactions = 0;

        while (currentPatient != null) {
            TransactionNode currentTransaction = currentPatient.transactionHead;

            if (currentTransaction != null) {
                System.out.println("\nPasien: " + currentPatient.name + " (ID: " + currentPatient.id + ")");

                while (currentTransaction != null) {
                    System.out.printf("Transaksi ID: %s, Tanggal: %s, Jumlah: Rp%.2f, Keterangan: %s\n",
                            currentTransaction.id,
                            currentTransaction.date,
                            currentTransaction.amount,
                            currentTransaction.description);
                    totalAmount += currentTransaction.amount;
                    totalTransactions++;
                    currentTransaction = currentTransaction.next;
                }
            }
            currentPatient = currentPatient.next;
        }

        System.out.println("\n=== RINGKASAN TRANSAKSI ===");
        System.out.println("Total Transaksi: " + totalTransactions);
        System.out.printf("Total Pendapatan: Rp%.2f\n", totalAmount);
        if (totalTransactions > 0) {
            System.out.printf("Rata-rata Transaksi: Rp%.2f\n", totalAmount / totalTransactions);
        }
    }

    private void showMenu() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Tambah Pasien");
        System.out.println("2. Lihat Daftar Pasien");
        System.out.println("3. Tambah Transaksi");
        System.out.println("4. Tambah Rekam Medis");
        System.out.println("5. Lihat Rekam Medis Pasien");
        System.out.println("6. Lihat Laporan Transaksi");
        System.out.println("7. Logout");
        System.out.println("8. Keluar");
        System.out.print("Pilih menu (1-8): ");
    }

    public void run() {
        while (true) {
            if (currentUser == null) {
                System.out.println("\n=== LOGIN MediCare  KLINIK ===");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                if (login(username, password)) {
                    System.out.println("Login berhasil sebagai " + currentRole + "!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                    continue;
                }
            }

            showMenu();

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("ID Pasien: ");
                        String id = scanner.nextLine();
                        System.out.print("Nama: ");
                        String name = scanner.nextLine();
                        System.out.print("Alamat: ");
                        String address = scanner.nextLine();
                        addPatient(id, name, address);
                        System.out.println("Pasien berhasil ditambahkan!");
                        break;

                    case 2:
                        listPatients();
                        break;

                    case 3:
                        System.out.print("ID Pasien: ");
                        String patientId = scanner.nextLine();
                        System.out.print("ID Transaksi: ");
                        String transId = scanner.nextLine();
                        System.out.print("Tanggal (DD/MM/YYYY): ");
                        String date = scanner.nextLine();
                        System.out.print("(Rp) Jumlah: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Keterangan: ");
                        String desc = scanner.nextLine();
                        addTransaction(patientId, transId, date, amount, desc);
                        System.out.println("Transaksi berhasil ditambahkan!");
                        break;

                    case 4:
                        System.out.print("ID Pasien: ");
                        String pid = scanner.nextLine();
                        System.out.print("ID Rekam Medis: ");
                        String recordId = scanner.nextLine();
                        System.out.print("Tanggal (DD/MM/YYYY): ");
                        String recordDate = scanner.nextLine();
                        System.out.print("Diagnosis: ");
                        String diagnosis = scanner.nextLine();
                        System.out.print("Treatment: ");
                        String treatment = scanner.nextLine();
                        addMedicalRecord(pid, recordId, recordDate, diagnosis, treatment);
                        System.out.println("Rekam medis berhasil ditambahkan!");
                        break;

                    case 5:
                        System.out.print("ID Pasien: ");
                        String viewPid = scanner.nextLine();
                        viewPatientRecords(viewPid);
                        break;

                    case 6:
                        generateTransactionReport();
                        break;

                    case 7:
                        currentUser = null;
                        currentRole = null;
                        System.out.println("Logout berhasil!");
                        break;

                    case 8:
                        System.out.println("Terima kasih telah menggunakan sistem!");
                        System.exit(0);

                    default:
                        System.out.println("Menu tidak valid!");
                }
            } catch (Exception e) {
                System.out.println("Error: Input tidak valid!");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        MediCare system = new MediCare();
        system.run();
    }
}