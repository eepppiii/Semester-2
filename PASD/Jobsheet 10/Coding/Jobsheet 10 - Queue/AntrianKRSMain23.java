    import java.util.Scanner;

public class AntrianKRSMain23 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Masukkan kapasitas maksimal antrian (max 10): ");
        int kapasitas = sc.nextInt();
        if (kapasitas > 10) kapasitas = 10;
        AntrianKRS23 antrian = new AntrianKRS23(kapasitas);

        int pilihan;
        do {
            System.out.println("\n=== MENU ANTRIAN KRS ===");
            System.out.println("1. Tambah Antrian (Mahasiswa)");
            System.out.println("2. Proses KRS (Panggil 2 mahasiswa)");
            System.out.println("3. Cek Antrian Kosong");
            System.out.println("4. Cek Antrian Penuh");
            System.out.println("5. Kosongkan Antrian");
            System.out.println("6. Tampilkan Semua Antrian");
            System.out.println("7. Tampilkan 2 Antrian Terdepan");
            System.out.println("8. Tampilkan Antrian Paling Akhir");
            System.out.println("9. Cetak Jumlah Antrian");
            System.out.println("10. Cetak Jumlah Sudah Proses KRS");
            System.out.println("11. Cetak Jumlah Belum Proses KRS");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahMahasiswa(antrian);
                    break;
                case 2:
                    antrian.prosesKRS();
                    break;
                case 3:
                    System.out.println("Antrian kosong? " + (antrian.isEmpty() ? "Ya" : "Tidak"));
                    break;
                case 4:
                    System.out.println("Antrian penuh? " + (antrian.isFull() ? "Ya" : "Tidak"));
                    break;
                case 5:
                    antrian.clear();
                    break;
                case 6:
                    antrian.tampilkanSemua();
                    break;
                case 7:
                    antrian.tampilkanDuaTerdepan();
                    break;
                case 8:
                    antrian.tampilkanPalingBelakang();
                    break;
                case 9:
                    System.out.println("Jumlah antrian saat ini: " + antrian.getJumlahAntrian());
                    break;
                case 10:
                    System.out.println("Jumlah mahasiswa yang sudah diproses KRS: " + antrian.getJumlahSudahProses());
                    break;
                case 11:
                    System.out.println("Jumlah mahasiswa yang belum diproses (dalam antrian): " + antrian.getJumlahBelumProses());
                    break;
                case 0:
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
        sc.close();
    }

    private static void tambahMahasiswa(AntrianKRS23 antrian) {
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Program Studi: ");
        String prodi = sc.nextLine();
        System.out.print("Masukkan Kelas: ");
        String kelas = sc.nextLine();

        Mahasiswa mhs = new Mahasiswa(nim, nama, prodi, kelas);
        antrian.tambahAntrian(mhs);
    }
}