public class SLLmain23 {
    public static void main(String[] args) {
        singlelinkedlist23 sll = new singlelinkedlist23();

        mahasiswa23 mhsA = new mahasiswa23("11111111", "Andi", "2A", 3.2);
        mahasiswa23 mhsCintia = new mahasiswa23("22212202", "Cintia", "3C", 3.5);
        mahasiswa23 mhsBimon = new mahasiswa23("23212201", "Bimon", "2B", 3.8);
        mahasiswa23 mhsDewi = new mahasiswa23("33333333", "Dewi", "4A", 3.9);

        sll.addLast(mhsA);
        sll.addLast(mhsCintia);
        sll.addLast(mhsBimon);
        sll.addLast(mhsDewi);

        System.out.println("data index 1 : ");
        sll.getData(1);

        System.out.println("data mahasiswa an Bimon berada pada index : " + sll.indexOf("bimon"));
        System.out.println();

        sll.removeFirst();  
        sll.removeLast();   
        sll.print();        

        sll.removeAt(0);
        sll.print();
    }
}