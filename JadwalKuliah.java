import java.util.Scanner;

public class JadwalKuliah {

    static Scanner sc = new Scanner(System.in);

    public static void inputJadwal(String[][] jadwal, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Jadwal ke-" + (i + 1));

            System.out.print("Nama Mata Kuliah : ");
            jadwal[i][0] = sc.nextLine();

            System.out.print("Ruang            : ");
            jadwal[i][1] = sc.nextLine();

            System.out.print("Hari Kuliah      : ");
            jadwal[i][2] = sc.nextLine();

            System.out.print("Jam Kuliah       : ");
            jadwal[i][3] = sc.nextLine();

            System.out.println("---------------------------");
        }
    }

    public static void tampilSemua(String[][] jadwal, int n) {
        System.out.println("\n===== DAFTAR JADWAL KULIAH =====");
        System.out.printf("%-25s %-20s %-15s %-15s\n",
                "Mata Kuliah", "Ruang", "Hari", "Jam");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-25s %-20s %-15s %-15s\n",
                    jadwal[i][0],
                    jadwal[i][1],
                    jadwal[i][2],
                    jadwal[i][3]);
        }
    }

    public static void cariBerdasarkanHari(String[][] jadwal, int n) {
        System.out.print("\nMasukkan Hari yang dicari: ");
        String hariCari = sc.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < n; i++) {
            if (jadwal[i][2].equalsIgnoreCase(hariCari)) {
                System.out.println(jadwal[i][0] + " | " +
                                   jadwal[i][1] + " | " +
                                   jadwal[i][2] + " | " +
                                   jadwal[i][3]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada jadwal pada hari tersebut.");
        }
    }

    public static void cariBerdasarkanMK(String[][] jadwal, int n) {
        System.out.print("\nMasukkan Nama Mata Kuliah yang dicari: ");
        String mkCari = sc.nextLine();

        boolean ditemukan = false;

        for (int i = 0; i < n; i++) {
            if (jadwal[i][0].equalsIgnoreCase(mkCari)) {
                System.out.println(jadwal[i][0] + " | " +
                                   jadwal[i][1] + " | " +
                                   jadwal[i][2] + " | " +
                                   jadwal[i][3]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Mata kuliah tidak ditemukan.");
        }
    }

    public static void main(String[] args) {

        System.out.print("Masukkan jumlah jadwal kuliah: ");
        int n = Integer.parseInt(sc.nextLine());

        String[][] jadwal = new String[n][4];

        inputJadwal(jadwal, n);
        tampilSemua(jadwal, n);
        cariBerdasarkanHari(jadwal, n);
        cariBerdasarkanMK(jadwal, n);

        sc.close();
    }
}
