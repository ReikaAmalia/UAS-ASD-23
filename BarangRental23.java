public class BarangRental23 {
    String noTNKB;
    String namaKendaraan;
    String jenisKendaraan;
    int tahun;
    int biayaSewaPerJam;

    // Constructor for initializing BarangRental objects
    public BarangRental23(String noTNKB, String namaKendaraan, String jenisKendaraan, int tahun, int biayaSewaPerJam) {
        this.noTNKB = noTNKB;
        this.namaKendaraan = namaKendaraan;
        this.jenisKendaraan = jenisKendaraan;
        this.tahun = tahun;
        this.biayaSewaPerJam = biayaSewaPerJam;
    }

    // Method to print rental item information
    public void cetakInfo() {
        System.out.println("No TNKB: " + noTNKB);
        System.out.println("Nama Kendaraan: " + namaKendaraan);
        System.out.println("Jenis Kendaraan: " + jenisKendaraan);
        System.out.println("Tahun: " + tahun);
        System.out.println("Biaya Sewa per Jam: Rp " + biayaSewaPerJam);
    }
}