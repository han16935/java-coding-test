package oop.three_six_nine;

import java.util.List;

public class Main {

    public static void main (String [] args) throws InterruptedException {

        Player p1 = new Player("p1", 0);
        Player p2 = new Player("p2", 0.1);
        Player p3 = new Player("p3", 0.1);
        List<Player> seoulPlayers = List.of(p1, p2, p3);
        Game seoulGame = new SeoulGame(1, false, seoulPlayers);
        Thread seoulGameThread = new Thread(seoulGame);

        Player p4 = new Player("p4", 0);
        Player p5 = new Player("p5", 0.3);
        Player p6 = new Player("p6", 0.5);
        List<Player> busanPlayers = List.of(p4, p5, p6);
        Game busanGame = new BusanGame(1, false, busanPlayers);
        Thread busanGameThread = new Thread(busanGame);

        seoulGameThread.start();
//        busanGameThread.start();

        seoulGameThread.join();
//        busanGameThread.join();
    }
}
