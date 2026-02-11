import java.util.Scanner;

public class IPSemester{
    
    public static double konversiNilai(double nilai) {
        if (nilai > 80 && nilai <= 100) return 4.0;
        else if (nilai > 73 && nilai <= 80) return 3.5;
        else if (nilai > 65 && nilai <= 73) return 3.0;
        else if (nilai > 60 && nilai <= 65) return 2.5;
        else if (nilai > 50 && nilai <= 60) return 2.0;
        else if (nilai > 39 && nilai <= 50) return 1.0;
        else return 0.0;
    }
    
    public static String nilaiHuruf(double nilai) {
        if (nilai > 80 && nilai <= 100) return "A";
        else if (nilai > 73 && nilai <= 80) return "B+";
        else if (nilai > 65 && nilai <= 73) return "B";
        else if (nilai > 60 && nilai <= 65) return "C+";
        else if (nilai > 50 && nilai <= 60) return "C";
        else if (nilai > 39 && nilai <= 50) return "D";
        else return "E";
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("Program Menghitung IP Semester");
        System.out.println("====================================");
        System.out.print("Masukkan jumlah mata kuliah: ");
        int jumlahMK = input.nextInt();
        input.nextLine();
        
        String[] namaMK = new String[jumlahMK];
        int[] sks = new int[jumlahMK];
        double[] nilaiAngka = new double[jumlahMK];
        String[] nilaiHuruf = new String[jumlahMK];
        double[] bobot = new double[jumlahMK];
        double totalNilai = 0;
        int totalSKS = 0;
        
        for (int i = 0; i < jumlahMK; i++) {
            System.out.println("\nMata Kuliah ke-" + (i + 1));
            System.out.print("Nama Mata Kuliah      : ");
            namaMK[i] = input.nextLine();
            System.out.print("Jumlah SKS   : ");
            sks[i] = input.nextInt();
            System.out.print("Nilai Angka  : ");
            nilaiAngka[i] = input.nextDouble();
            input.nextLine();

            nilaiHuruf[i] = nilaiHuruf(nilaiAngka[i]);
            bobot[i] = konversiNilai(nilaiAngka[i]);

            totalNilai += bobot[i] * sks[i];
            totalSKS += sks[i];
        }

        double ip = totalNilai / totalSKS;

        
        System.out.println("\n------------------------------------------------------------------");
        System.out.printf("Mata Kuliah ", "Nilai", "Huruf", "Bobot", "SKS");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < jumlahMK; i++) {
            System.out.printf("%-25s %-10.2f %-10s %-10.2f %-5d\n",
                    namaMK[i], nilaiAngka[i], nilaiHuruf[i], bobot[i], sks[i]);
        }
        System.out.println("------------------------------------------------------------------");
        System.out.printf("IP Semester = %.2f\n", ip);
        System.out.println("------------------------------------------------------------------");

        input.close();
    }
}