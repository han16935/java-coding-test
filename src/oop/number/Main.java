package oop.number;

public class Main {

    public static void main(String[] args) throws Exception{
        NumberPrinter p1 = new NumberPrinter();
        Thread p1Thread = new Thread(p1);

        NumberPrinter p2 = new NumberPrinter();
        Thread p2Thread = new Thread(p2);

        p1Thread.start();
        p2Thread.start();

//        p1Thread.join();
//        p2Thread.join();
    }
}
