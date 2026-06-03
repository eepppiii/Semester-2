public class AntrianKRS23 {
    private Mahasiswa[] queue;
    private int front;
    private int rear;
    private int size;
    private int max;
    private int handledCount;
    private final int MAX_HANDLED = 30;

    public AntrianKRS23(int kapasitas) {
        this.max = kapasitas;
        queue = new Mahasiswa[max];
        front = 0;
        rear = -1;
        size = 0;
        handledCount = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        if (!isEmpty()) {
            front = 0;
            rear = -1;
            size = 0;
            System.out.println("Antrian berhasil dikosongkan.");
        } else {
            System.out.println("Antrian sudah kosong.");
        }
    }

    public void tambahAntrian(Mahasiswa m) {
        if (isFull()) {
            System.out.println("Antrian penuh! Tidak bisa menambah mahasiswa.");
        } else if (handledCount >= MAX_HANDLED) {
            System.out.println("DPA sudah menangani 30 mahasiswa. Tidak bisa menambah antrian baru.");
        } else {
            rear = (rear + 1) % max;
            queue[rear] = m;
            size++;
            System.out.println(m.getNama() + " berhasil masuk antrian.");
        }
    }

    public void prosesKRS() {
        if (handledCount >= MAX_HANDLED) {
            System.out.println("DPA sudah menangani 30 mahasiswa. Tidak bisa memproses lagi.");
            return;
        }
        int proses = 0;
        while (proses < 2 && !isEmpty() && handledCount < MAX_HANDLED) {
            Mahasiswa m = queue[front];
            front = (front + 1) % max;
            size--;
            System.out.println("Memproses KRS mahasiswa:");
            m.tampilkanData();
            handledCount++;
            proses++;
        }
        if (proses == 0) {
            System.out.println("Tidak ada mahasiswa dalam antrian.");
        } else {
            System.out.println("Jumlah mahasiswa yang diproses kali ini: " + proses);
        }
        if (handledCount >= MAX_HANDLED) {
            System.out.println("DPA telah mencapai batas penanganan 30 mahasiswa.");
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=== Daftar Antrian KRS ===");
        int i = front;
        int count = 0;
        while (count < size) {
            queue[i].tampilkanData();
            i = (i + 1) % max;
            count++;
        }
        System.out.println("Jumlah antrian: " + size);
    }

    public void tampilkanDuaTerdepan() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=== Dua Mahasiswa Terdepan ===");
        int i = front;
        int count = 0;
        while (count < size && count < 2) {
            queue[i].tampilkanData();
            i = (i + 1) % max;
            count++;
        }
        if (size < 2) {
            System.out.println("(Hanya tersisa " + size + " mahasiswa dalam antrian)");
        }
    }

    public void tampilkanPalingBelakang() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("=== Mahasiswa Paling Belakang ===");
        queue[rear].tampilkanData();
    }

    public int getJumlahAntrian() {
        return size;
    }

    public int getJumlahSudahProses() {
        return handledCount;
    }

    public int getJumlahBelumProses() {
        return size;
    }
}