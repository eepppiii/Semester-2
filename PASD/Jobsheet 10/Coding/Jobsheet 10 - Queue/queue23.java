public class queue23 {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    public queue23(int n) {
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void peek() {
        if (!isEmpty()) {
            System.out.println("Elemen terdepan : " + data[front]);
        } else {
            System.out.println("QUEUE UNDERFLOW! Queue masih kosong.");
            System.out.println("Program dihentikan.");
            System.exit(1); // ← TAMBAHAN
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(data[i] + " ");
                i = (i + 1) % max;
            }
            System.out.print(data[i] + " ");
            System.out.println("\nJumlah elemen = " + size);
        }
    }

    public void clear() {
        if (!isEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue sudah kosong");
        }
    }

    public void enqueue(int dt) {
        if (isFull()) {
            System.out.println("QUEUE OVERFLOW! Queue sudah penuh.");
            System.out.println("Program dihentikan.");
            System.exit(1); // ← TAMBAHAN: hentikan program dengan kode error
        } else {
            if (isEmpty()) {
                front = rear = 0;
            } else {
                rear = (rear + 1) % max;
            }
            data[rear] = dt;
            size++;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("QUEUE UNDERFLOW! Queue sudah kosong.");
            System.out.println("Program dihentikan.");
            System.exit(1); // ← TAMBAHAN: hentikan program dengan kode error
            return -1; // tidak akan pernah tercapai, tapi wajib ada
        } else {
            int dt = data[front];
            size--;
            if (isEmpty()) {
                front = rear = -1;
            } else {
                front = (front + 1) % max;
            }
            return dt;
        }
    }

}