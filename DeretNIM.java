import java.util.Scanner;

public class DeretNIM {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();

        int n = Integer.parseInt(nim.substring(nim.length() - 2));

        
        if (n < 10) {
            n += 10;
        }

        System.out.println("n = " + n);
        System.out.println("Output:");

        int i = 1; 

        while (i <= n) {

            if (i == 10 || i == 15) {
                i++;
                continue;
            }

            if (i % 3 == 0) {
                System.out.print("# ");
            }
            else if (i % 2 == 0) {
                System.out.print(i + " ");
            }
            else {
                System.out.print("* ");
            }

            i++; 
        }

        sc.close();
    }
}
