public class mahasiswa23 {
    String nim;
    String nama;
    String kelas;
    double ipk;

    public mahasiswa23(String nim, String nama, String kelas, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.kelas = kelas;
        this.ipk = ipk;
    }

    void tampilInformasi() {
        System.out.printf("%-8s %-11s %-5s %.1f\n", nama, nim, kelas, ipk);
    }
}