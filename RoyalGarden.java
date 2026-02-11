public class RoyalGarden {

    public static int hitungPendapatan(int[] stok, int[] harga) {
        int total = 0;
        for (int i = 0; i < stok.length; i++) {
            total += stok[i] * harga[i];
        }
        return total;
    }

    public static String tampilkanStatus(int pendapatan) {
        if (pendapatan > 1500000) {
            return "Sangat Baik";
        } else {
            return "Perlu Evaluasi";
        }
    }

    public static void main(String[] args) {

        // Data stok bunga (baris = cabang, kolom = jenis bunga)
        int[][] stokBunga = {
            {10, 5, 15, 7},   // RoyalGarden 1
            {6, 11, 9, 12},   // RoyalGarden 2
            {2, 10, 10, 5},   // RoyalGarden 3
            {5, 7, 12, 9}     // RoyalGarden 4
        };

        // Harga bunga
        int[] harga = {75000, 50000, 60000, 10000};

        String[] cabang = {
            "RoyalGarden 1",
            "RoyalGarden 2",
            "RoyalGarden 3",
            "RoyalGarden 4"
        };

        System.out.println("=== Laporan Pendapatan RoyalGarden ===");

        // Perulangan untuk tiap cabang
        for (int i = 0; i < stokBunga.length; i++) {

            int pendapatan = hitungPendapatan(stokBunga[i], harga);

            System.out.println(cabang[i]);
            System.out.println("Pendapatan : Rp" + pendapatan);
            System.out.println("Status     : " + tampilkanStatus(pendapatan));
            System.out.println("-----------------------------------");
        }
    }
}
