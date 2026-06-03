import java.util.Scanner;

public class DoublelinklistMain23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Doublelinkedlist23 list = new Doublelinkedlist23();
        int pilihan;

        do {
            System.out.println("\n=== MENU DOUBLE LINKED LIST ===");
            System.out.println("1. Tambah data di awal");
            System.out.println("2. Tambah data di akhir");
            System.out.println("3. Sisipkan data tengah (Setelah NIM)");
            System.out.println("4. Hapus data di awal");
            System.out.println("5. Hapus data di akhir");
            System.out.println("6. Tampilkan data");
            System.out.println("0. Keluar");
            System.out.print("Pilih Menu : ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    Mahasiswa23 mhsAwal = inputMahasiswa(sc);
                    list.addFirst(mhsAwal);
                    System.out.println("Data berhasil ditambahkan di awal.");
                    break;
                case 2:
                    Mahasiswa23 mhsAkhir = inputMahasiswa(sc);
                    list.addLast(mhsAkhir);
                    System.out.println("Data berhasil ditambahkan di akhir.");
                    break;
                case 3:
                    System.out.print("Masukkan NIM yang dicari : ");
                    String keyNim = sc.nextLine();
                    System.out.println("Masukkan data baru :");
                    Mahasiswa23 databaru = inputMahasiswa(sc);
                    list.insertAfter(keyNim, databaru);
                    break;
                case 4:
                    list.removefirst();
                    break;
                case 5:
                    list.removeLast();
                    break;
                case 6:
                    list.print();
                    break;
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (pilihan != 0);
        sc.close();
    }

    private static Mahasiswa23 inputMahasiswa(Scanner sc) {
        System.out.print("Masukkan NIM : ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Nama : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan Kelas : ");
        String kelas = sc.nextLine();
        System.out.print("Masukkan IPK : ");
        double ipk = sc.nextDouble();
        sc.nextLine(); 
        return new Mahasiswa23(nim, nama, kelas, ipk);
    }
}
