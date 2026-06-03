    import java.util.Scanner;

    public class queueMain23 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Masukkan kapasitas queue: ");
            int n = sc.nextInt();
            queue23 Q = new queue23(n);

            int pilih;
            do {
                System.out.println("\n=== MENU QUEUE ===");
                System.out.println("1. Enqueue (Tambah data)");
                System.out.println("2. Dequeue (Hapus data)");
                System.out.println("3. Print (Cetak queue)");
                System.out.println("4. Peek (Lihat depan)");
                System.out.println("5. Clear (Kosongkan queue)");
                System.out.println("0. Keluar");
                System.out.print("Pilih operasi: ");
                pilih = sc.nextInt();

                switch (pilih) {
                    case 1:
                        System.out.print("Masukkan data baru: ");
                        int dataMasuk = sc.nextInt();
                        Q.enqueue(dataMasuk);
                        break;
                    case 2:
                        int dataKeluar = Q.dequeue();
                        if (dataKeluar != -1) {
                            System.out.println("Data yang dikeluarkan: " + dataKeluar);
                        }
                        break;
                    case 3:
                        Q.print();
                        break;
                    case 4:
                        Q.peek();
                        break;
                    case 5:
                        Q.clear();
                        break;
                    case 0:
                        System.out.println("Program selesai.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } while (pilih != 0);

            sc.close();
        }
    }