public class Doublelinkedlist23 {
    Node23 head;
    Node23 tail;

    public Doublelinkedlist23() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa23 data) {
        Node23 newNode23 = new Node23(data);
        if (isEmpty()) {
            head = tail = newNode23;
        } else {
            newNode23.next = head;
            head.prev = newNode23;
            head = newNode23;
        }
    }

    public void addLast(Mahasiswa23 data) {
        Node23 newNode23 = new Node23(data);
        if (isEmpty()) {
            head = tail = newNode23;
        } else {
            tail.next = newNode23;
            newNode23.prev = tail;
            tail = newNode23;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa23 data) {
        Node23 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Data dengan NIM " + keyNim + "tidak ditemukan.");
            return;
        }
        Node23 newNode23 = new Node23(data);

        if (current == tail) {
            newNode23.prev = current;
            current.next = newNode23;
            tail = newNode23;
        } else {
            newNode23.prev = current;
            newNode23.next = current;
            current.next.prev = newNode23;
            current.next = newNode23;
        }
        System.out.println("Data berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
            return;
        }
        Node23 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    public void removefirst() {
        if (!isEmpty()) {
            System.out.println("Lingked list kosong");
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void removeLast() {
        if (!isEmpty()) {
            System.out.println("Linked list kosong ");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
            return;
        }
        Node23 current = tail;
        while (current != null) {
            current.data.tampil();
            current = current.prev;
        }
    }

}
