package oop.numberatomic;

public class Main {
    public static void main(String[] args) throws Exception {

        NumberPointer np1 = new NumberPointer(20000);
        NumberPointer np2 = new NumberPointer(20000);
        NumberPointer np3 = new NumberPointer(20000);
        NumberPointer np4 = new NumberPointer(20000);
        NumberPointer np5 = new NumberPointer(20000);

        Thread t1 = new Thread(np1);
        Thread t2 = new Thread(np2);
        Thread t3 = new Thread(np3);
        Thread t4 = new Thread(np4);
        Thread t5 = new Thread(np5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println(NumberPointer.getAtomic());
    }
}
