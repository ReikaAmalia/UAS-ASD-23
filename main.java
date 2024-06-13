import java.util.Scanner;

public class main {

    static final int MAX_BARANG = 10;
    static final int MAX_TRANSAKSI = 100;
    static BarangRental23[] daftarBarang = new BarangRental23[MAX_BARANG];
    static TransaksiRental23[] daftarTransaksi = new TransaksiRental23[MAX_TRANSAKSI];
    static int indexBarang = 0;
    static int indexTransaksi = 0;
    static int kodeTransaksiCounter = 1;

    public static void main(String[] args) {
        inisialisasiBarang();

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanMenu();
            System.out.print("Pilih (1-5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (pilihan) {
                case 1:
                    tampilkanDaftarBarang();
                    break;
                case 2:
                    tambahkanTransaksi(scanner);
                    break;
                case 3:
                    tampilkanDaftarTransaksi();
                    break;
                case 4:
                    urutkanTransaksi();
                    tampilkanDaftarTransaksi();
                    break;
                case 5:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }

        } while (pilihan != 5);

        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\nMenu Rental Kendaraan");
        System.out.println("1. Daftar Kendaraan");
        System.out.println("2. Peminjaman Kendaraan");
        System.out.println("3. Tampilkan Transaksi");
        System.out.println("4. Urutkan Transaksi");
        System.out.println("5. Keluar");
    }

    private static void inisialisasiBarang() {
        daftarBarang[indexBarang++] = new BarangRental23("B1234XYZ", "Toyota Avanza", "Mobil", 2019, 50000);
        daftarBarang[indexBarang++] = new BarangRental23("B5678XYZ", "Honda Beat", "Motor", 2020, 20000);
        // Tambahkan lebih banyak barang jika diperlukan
    }

    private static void tampilkanDaftarBarang() {
        System.out.println("\nDaftar Kendaraan yang Tersedia:");
        for (int i = 0; i < indexBarang; i++) {
            System.out.println("[" + (i + 1) + "]");
            daftarBarang[i].cetakInfo();
            System.out.println();
        }
    }

    private static void tambahkanTransaksi(Scanner scanner) {
        System.out.print("Nama Peminjam: ");
        String namaPeminjam = scanner.nextLine();

        System.out.print("Lama Pinjam (jam): ");
        int lamaPinjamJam = scanner.nextInt();

        System.out.print("Apakah member (true/false): ");
        boolean isMember = scanner.nextBoolean();

        tampilkanDaftarBarang();
        System.out.print("Pilih kendaraan (1-" + indexBarang + "): ");
        int pilihanKendaraan = scanner.nextInt();
        BarangRental23 barangDipilih = daftarBarang[pilihanKendaraan - 1];

        TransaksiRental23 transaksiBaru = new TransaksiRental23(kodeTransaksiCounter++, namaPeminjam, lamaPinjamJam, barangDipilih, isMember);
        daftarTransaksi[indexTransaksi++] = transaksiBaru;

        System.out.println("Transaksi berhasil ditambahkan.");
    }

    private static void tampilkanDaftarTransaksi() {
        System.out.println("\nDaftar Transaksi:");
        for (int i = 0; i < indexTransaksi; i++) {
            daftarTransaksi[i].cetakInfo();
            System.out.println();
        }
    }

    private static void urutkanTransaksi() {
        // Sorting transactions based on total cost in ascending order using Bubble Sort
        for (int i = 0; i < indexTransaksi - 1; i++) {
            for (int j = 0; j < indexTransaksi - i - 1; j++) {
                if (daftarTransaksi[j].totalBiaya > daftarTransaksi[j + 1].totalBiaya) {
                    TransaksiRental23 temp = daftarTransaksi[j];
                    daftarTransaksi[j] = daftarTransaksi[j + 1];
                    daftarTransaksi[j + 1] = temp;
                }
            }
        }
        System.out.println("Transaksi berhasil diurutkan berdasarkan total biaya.");
    }
}