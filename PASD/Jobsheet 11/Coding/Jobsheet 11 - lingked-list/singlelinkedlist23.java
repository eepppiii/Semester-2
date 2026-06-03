public class singlelinkedlist23 {
    node23 head;
    node23 tail;

    boolean isEmpty() {
        return head == null;
    }

    public void print() {
        if (!isEmpty()) {
            node23 tmp = head;
            System.out.println("Isi Linked List:");
            while (tmp != null) {
                tmp.data.tampilInformasi();
                tmp = tmp.next;
            }
        } else {
            System.out.println("Linked list kosong");
        }
    }

    public void addFirst(mahasiswa23 input) {
        node23 ndInput = new node23(input, head);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            ndInput.next = head;
            head = ndInput;
        }
    }

    public void addLast(mahasiswa23 input) {
        node23 ndInput = new node23(input, null);
        if (isEmpty()) {
            head = ndInput;
            tail = ndInput;
        } else {
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    public void insertAfter(String key, mahasiswa23 input) {
        node23 temp = head;
        while (temp != null) {
            if (temp.data.nama.equalsIgnoreCase(key)) {
                node23 ndInput = new node23(input, temp.next);
                temp.next = ndInput;
                if (ndInput.next == null) {
                    tail = ndInput;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Data dengan nama '" + key + "' tidak ditemukan");
    }

    public void insertAt(int index, mahasiswa23 input) {
        if (index < 0) {
            System.out.println("Index tidak boleh negatif");
            return;
        }
        if (index == 0) {
            addFirst(input);
            return;
        }
        node23 temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null) {
                System.out.println("Index melebihi panjang list");
                return;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Index melebihi panjang list");
            return;
        }
        node23 ndInput = new node23(input, temp.next);
        temp.next = ndInput;
        if (ndInput.next == null) {
            tail = ndInput;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong, tidak dapat dihapus!");
        } else if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong");
            return;
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        node23 temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
    }

    public void remove(String nama) {
        if (isEmpty()) {
            System.out.println("List kosong");
            return;
        }
        if (head.data.nama.equalsIgnoreCase(nama)) {
            removeFirst();
            return;
        }
        node23 temp = head;
        while (temp.next != null) {
            if (temp.next.data.nama.equalsIgnoreCase(nama)) {
                if (temp.next == tail) {
                    tail = temp;
                }
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Data dengan nama '" + nama + "' tidak ditemukan");
    }

    public void removeAt(int index) {
        if (isEmpty()) {
            System.out.println("List kosong");
            return;
        }
        if (index < 0) {
            System.out.println("Index tidak boleh negatif");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        node23 temp = head;
        for (int i = 0; i < index - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("Index melebihi panjang list");
                return;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Index melebihi panjang list");
            return;
        }
        if (temp.next == tail) {
            tail = temp;
        }
        temp.next = temp.next.next;
    }

    public void getData(int index) {
        if (isEmpty()) {
            System.out.println("List kosong");
            return;
        }
        node23 tmp = head;
        for (int i = 0; i < index; i++) {
            if (tmp == null) {
                System.out.println("Index melebihi panjang list");
                return;
            }
            tmp = tmp.next;
        }
        if (tmp != null) {
            tmp.data.tampilInformasi();
        } else {
            System.out.println("Index tidak valid");
        }
    }

    public int indexOf(String key) {
        node23 tmp = head;
        int index = 0;
        while (tmp != null && !tmp.data.nama.equalsIgnoreCase(key)) {
            tmp = tmp.next;
            index++;
        }
        return (tmp == null) ? -1 : index;
    }
}