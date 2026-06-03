public class tgsmahasiswa23 {
    private int nomorAntrian;
    private String nim;
    private String nama;
    private String prodi;
    private String keperluan;

    public tgsmahasiswa23(int nomorAntrian, String nim, String nama,
                     String prodi, String keperluan) {
        this.nomorAntrian = nomorAntrian;
        this.nim          = nim;
        this.nama         = nama;
        this.prodi        = prodi;
        this.keperluan    = keperluan;
    }

    public int getNomorAntrian() {
        return nomorAntrian;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getProdi() {
        return prodi;
    }

    public String getKeperluan() {
        return keperluan;
    }
}
