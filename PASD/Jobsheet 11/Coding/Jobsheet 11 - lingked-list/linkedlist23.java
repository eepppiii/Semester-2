public class linkedlist23 {

    private static final int MAX_NODE = 10;

    private tgsnode23 head;
    private tgsnode23 tail;
    private int  size;
    private int  nomorUrut;

    public linkedlist23() {
        this.head      = null;
        this.tail      = null;
        this.size      = 0;
        this.nomorUrut = 0;
    }

    public int getSize()      { return size;      }
    public int getNomorUrut() { return nomorUrut; }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return size >= MAX_NODE;
    }

    public void clear() {
        tgsnode23 current = head;
        while (current != null) {
            tgsnode23 next    = current.next;
            current.next = null;
            current      = next;
        }
        head      = null;
        tail      = null;
        size      = 0;
        nomorUrut = 0;
        System.out.println("\n  [INFO] Linked list berhasil dikosongkan.");
    }

    public void addLast(tgsmahasiswa23 mhs) {
        if (isFull()) {
            System.out.println("\n  [GAGAL] Antrian penuh! Maks. " + MAX_NODE + " orang.");
            return;
        }

        nomorUrut++;
        tgsnode23 newNode = new tgsnode23(mhs);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail      = newNode;
        }

        size++;
        System.out.println("\n  [OK] Mahasiswa berhasil ditambahkan ke antrian.");
        System.out.println("       Nomor antrian Anda : " + mhs.getNomorAntrian());
    }

    public tgsmahasiswa23 removeFirst() {
        if (isEmpty()) {
            System.out.println("\n  [INFO] Antrian kosong. Tidak ada yang dipanggil.");
            return null;
        }

        tgsmahasiswa23 mhs = head.data;
        head          = head.next;
        if (head == null) tail = null;
        size--;

        System.out.println("\n  ╔══════════════════════════════════════╗");
        System.out.println("  ║    *** MEMANGGIL MAHASISWA ***       ║");
        System.out.println("  ╠══════════════════════════════════════╣");
        System.out.printf ("  ║  No. Antrian : %-22d║%n", mhs.getNomorAntrian());
        System.out.printf ("  ║  NIM         : %-22s║%n", mhs.getNim());
        System.out.printf ("  ║  Nama        : %-22s║%n", mhs.getNama());
        System.out.printf ("  ║  Prodi       : %-22s║%n", mhs.getProdi());
        System.out.printf ("  ║  Keperluan   : %-22s║%n", mhs.getKeperluan());
        System.out.println("  ╚══════════════════════════════════════╝");
        System.out.println("  Sisa antrian : " + size + " mahasiswa");

        return mhs;
    }

    public void getHead() {
        if (isEmpty()) {
            System.out.println("\n  [INFO] Linked list kosong.");
            return;
        }
        tgsmahasiswa23 m = head.data;
        System.out.println("\n  ┌─ ANTRIAN TERDEPAN (HEAD) ──────────────┐");
        System.out.printf ("  │  No. Antrian : %-26d│%n", m.getNomorAntrian());
        System.out.printf ("  │  NIM         : %-26s│%n", m.getNim());
        System.out.printf ("  │  Nama        : %-26s│%n", m.getNama());
        System.out.printf ("  │  Prodi       : %-26s│%n", m.getProdi());
        System.out.printf ("  │  Keperluan   : %-26s│%n", m.getKeperluan());
        System.out.println("  └────────────────────────────────────────┘");
    }

    public void getTail() {
        if (isEmpty()) {
            System.out.println("\n  [INFO] Linked list kosong.");
            return;
        }
        tgsmahasiswa23 m = tail.data;
        System.out.println("\n  ┌─ ANTRIAN PALING AKHIR (TAIL) ──────────┐");
        System.out.printf ("  │  No. Antrian : %-26d│%n", m.getNomorAntrian());
        System.out.printf ("  │  NIM         : %-26s│%n", m.getNim());
        System.out.printf ("  │  Nama        : %-26s│%n", m.getNama());
        System.out.printf ("  │  Prodi       : %-26s│%n", m.getProdi());
        System.out.printf ("  │  Keperluan   : %-26s│%n", m.getKeperluan());
        System.out.println("  └────────────────────────────────────────┘");
    }

    public void displayAll() {
        if (isEmpty()) {
            System.out.println("\n  [INFO] Linked list kosong.");
            return;
        }

        System.out.println("\n  ┌─────────────────────────────────────────────────────────┐");
        System.out.println("  │         DAFTAR ANTRIAN UNIT KEMAHASISWAAN               │");
        System.out.println("  ├───────┬──────────────┬────────────────────┬─────────────┤");
        System.out.println("  │  No.  │     NIM      │       Nama         │  Keperluan  │");
        System.out.println("  ├───────┼──────────────┼────────────────────┼─────────────┤");

        tgsnode23 current = head;
        while (current != null) {
            tgsmahasiswa23 m = current.data;
            String posisi = (current == head && current == tail) ? "[H/T]"
                          : (current == head)                    ? "[H]  "
                          : (current == tail)                    ? "[T]  "
                          : "     ";
            System.out.printf("  │ %-5d │ %-12s │ %-18s │ %-11s │  %s%n",
                m.getNomorAntrian(), m.getNim(), m.getNama(),
                m.getKeperluan(), posisi);
            current = current.next;
        }

        System.out.println("  └───────┴──────────────┴────────────────────┴─────────────┘");
        System.out.println("  Keterangan : [H] = Head (depan)  [T] = Tail (akhir)");
        System.out.println("  Total mahasiswa dalam antrian : " + size);
    }

    public void displayStatus() {
        System.out.println("\n  Status Linked List :");
        System.out.println("    Kosong  : " + (isEmpty() ? "YA" : "TIDAK"));
        System.out.println("    Penuh   : " + (isFull()  ? "YA" : "TIDAK"));
        System.out.println("    Terisi  : " + size + " / " + MAX_NODE + " node");
        System.out.println("    Head    : " + (isEmpty() ? "null" : "No. " + head.data.getNomorAntrian()));
        System.out.println("    Tail    : " + (isEmpty() ? "null" : "No. " + tail.data.getNomorAntrian()));
    }
}