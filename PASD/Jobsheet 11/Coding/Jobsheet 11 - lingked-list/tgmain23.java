import java.util.Scanner;

public class tgmain23 {
       private static final Scanner sc = new Scanner(System.in);
 
    private static void tampilMenu() {
        System.out.println("\n  ╔══════════════════════════════════════╗");
        System.out.println("  ║   LAYANAN UNIT KEMAHASISWAAN         ║");
        System.out.println("  ║   Sistem Antrian - Linked List       ║");
        System.out.println("  ╠══════════════════════════════════════╣");
        System.out.println("  ║  1. Ambil Nomor Antrian              ║");
        System.out.println("  ║  2. Panggil Antrian Berikutnya       ║");
        System.out.println("  ║  3. Lihat Antrian Terdepan  (Head)   ║");
        System.out.println("  ║  4. Lihat Antrian Paling Akhir (Tail)║");
        System.out.println("  ║  5. Tampilkan Semua Antrian          ║");
        System.out.println("  ║  6. Jumlah Mahasiswa dalam Antrian   ║");
        System.out.println("  ║  7. Cek Status Linked List           ║");
        System.out.println("  ║  8. Kosongkan Antrian                ║");
        System.out.println("  ║  0. Keluar                           ║");
        System.out.println("  ╚══════════════════════════════════════╝");
        System.out.print("  Pilihan Anda : ");
    }
 
    private static tgsmahasiswa23 inputMahasiswa(int nomor) {
        System.out.println("\n  ── Pendaftaran Antrian No. " + nomor + " ──────────────────");
        System.out.print("  Masukkan NIM       : ");
        String nim = sc.nextLine().trim();
 
        System.out.print("  Masukkan Nama      : ");
        String nama = sc.nextLine().trim();
 
        System.out.print("  Masukkan Prodi     : ");
        String prodi = sc.nextLine().trim();
 
        System.out.println("  Pilih Keperluan    :");
        System.out.println("    1. Beasiswa");
        System.out.println("    2. Surat Keterangan");
        System.out.println("    3. Konsultasi");
        System.out.println("    4. Pengaduan");
        System.out.println("    5. Lainnya");
        System.out.print("  Pilihan (1-5)      : ");
 
        String keperluan;
        int pil = bacaInteger();
        switch (pil) {
            case 1:  keperluan = "Beasiswa";    break;
            case 2:  keperluan = "Surat Ket.";  break;
            case 3:  keperluan = "Konsultasi";  break;
            case 4:  keperluan = "Pengaduan";   break;
            default: keperluan = "Lainnya";     break;
        }
 
        return new tgsmahasiswa23(nomor, nim, nama, prodi, keperluan);
    }
 
    private static int bacaInteger() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("  [!] Masukkan angka yang valid : ");
            }
        }
    }
 
    public static void main(String[] args) {
        linkedlist23 antrian = new linkedlist23();
        int pilihan;
 
        System.out.println("\n  ============================================");
        System.out.println("   SELAMAT DATANG DI UNIT KEMAHASISWAAN");
        System.out.println("  ============================================");
 
        do {
            tampilMenu();
            pilihan = bacaInteger();
 
            switch (pilihan) {
                case 1:
                    if (antrian.isFull()) {
                        System.out.println("\n  [GAGAL] Antrian penuh! Silakan tunggu.");
                    } else {
                        int nomor   = antrian.getNomorUrut() + 1;
                        tgsmahasiswa23 m = inputMahasiswa(nomor);
                        antrian.addLast(m);
                    }
                    break;
                case 2:
                    antrian.removeFirst();
                    break;
                case 3:
                    antrian.getHead();
                    break;
                case 4:
                    antrian.getTail();
                    break;
                case 5:
                    antrian.displayAll();
                    break;
                case 6:
                    System.out.println("\n  Jumlah mahasiswa yang masih antri : "
                        + antrian.getSize() + " orang");
                    break;
                case 7:
                    antrian.displayStatus();
                    break;
                case 8:
                    System.out.print("\n  Yakin mengosongkan semua antrian? (y/n) : ");
                    String konfirmasi = sc.nextLine().trim();
                    if (konfirmasi.equalsIgnoreCase("y")) {
                        antrian.clear();
                    } else {
                        System.out.println("  Dibatalkan.");
                    }
                    break;
                case 0:
                    antrian.clear();
                    System.out.println("\n  Terima kasih. Program selesai.\n");
                    break;
                default:
                    System.out.println("\n  [!] Pilihan tidak valid.");
            }
 
        } while (pilihan != 0);
 
        sc.close();
    }
}
