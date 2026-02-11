import java.util.Scanner;

public class IPSemeter {
    public static void main(String[] args) {

        char[] KODE = {'A','B','D','E','F','G','H','L','N','T'};

        String[] KOTA = {
            "BANTEN",
            "JAKARTA",
            "BANDUNG",
            "CIREBON",
            "BOGOR",
            "PEKALONGAN",
            "SEMARANG",
            "SURABAYA",
            "MALANG",
            "TEGAL"
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kode plat nomor: ");
        char input = sc.next().charAt(0);

        boolean ditemukan = false;

        for (int i = 0; i < KODE.length; i++) {
            if (input == KODE[i]) {
                System.out.println("Kota: " + KOTA[i]);
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Kode tidak ditemukan.");
        }

        sc.close();
    }
}