import java.util.Scanner;

public class NilaiAkhir {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("===============================");

        System.out.print("Masukkan Nilai Tugas :");
        int tugas = sc.nextInt();
        System.out.print("Masukkan Nilai Kuis :");
        int kuis = sc.nextInt();
        System.out.print("Masukkan Nilai UTS :");
        int uts = sc.nextInt();
        System.out.print("Masukkan Nilai UAS :");
        int uas = sc.nextInt();
        System.out.println("===============================");
        System.out.println("===============================");

        int nilai_akhir;

        nilai_akhir = (tugas * 20 / 100 + kuis * 20 / 100 + uts * 30 / 100 + uas * 30 / 100);

        System.out.println("Nilai Akhir : " + nilai_akhir);
        if (nilai_akhir < 0 || nilai_akhir > 100) {
            System.out.println("Nilai Tidak Valid");
            System.out.println("===============================");
        }

        if (nilai_akhir <= 100 && nilai_akhir >= 80) {
            System.out.println("A");
        } else if (nilai_akhir <= 80 && nilai_akhir > 73) {
            System.out.println("B+");

        } else if (nilai_akhir <= 73 && nilai_akhir > 65) {
            System.out.println("B");

        } else if (nilai_akhir <= 65 && nilai_akhir > 60) {
            System.out.println("C+");

        } else if (nilai_akhir <= 60 && nilai_akhir > 50) {
            System.out.println("C");

        } else if (nilai_akhir <= 50 && nilai_akhir > 39) {
            System.out.println("D");

        } else {
            System.out.println("E");
        }

        System.out.println("===============================");
        System.out.println("===============================");

        if (nilai_akhir >= 50 && nilai_akhir <= 100) {
            System.out.println("Selamat Anda Lulus");
        }else{
            System.out.println("Anda Tidak Lulus");
        }

    }
}