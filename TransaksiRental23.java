class TransaksiRental23 {
    int kodeTransaksi;
    String namaPeminjam;
    int lamaPinjamJam;
    double totalBiaya;
    BarangRental23 barangRental;
    boolean isMember;

    public TransaksiRental23(int kodeTransaksi, String namaPeminjam, int lamaPinjamJam, BarangRental23 barangRental, boolean isMember) {
        this.kodeTransaksi = kodeTransaksi;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjamJam = lamaPinjamJam;
        this.barangRental = barangRental;
        this.isMember = isMember;
        hitungTotalBiaya();
    }

    // Method to calculate total transaction cost based on rental duration and hourly rental cost
    private void hitungTotalBiaya() {
        double biayaAwal = lamaPinjamJam * barangRental.biayaSewaPerJam;
        double potongan = 0;

        // Discount based on rental duration
        if (lamaPinjamJam >= 48 && lamaPinjamJam <= 78) {
            potongan = 0.1 * biayaAwal;
        } else if (lamaPinjamJam > 78) {
            potongan = 0.2 * biayaAwal;
        }

        // Additional discount for members
        if (isMember) {
            potongan += 25000;
        }

        this.totalBiaya = biayaAwal - potongan;
    }

    // Method to print transaction information
    public void cetakInfo() {
        System.out.println("Kode Transaksi: " + kodeTransaksi);
        System.out.println("Nama Peminjam: " + namaPeminjam);
        System.out.println("Lama Pinjam (jam): " + lamaPinjamJam);
        System.out.println("Total Biaya: Rp " + totalBiaya);
        System.out.println("Barang yang Dipinjam:");
        barangRental.cetakInfo();
    }
}