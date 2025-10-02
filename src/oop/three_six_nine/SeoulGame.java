package oop.three_six_nine;

import java.util.List;
import java.util.Random;

public class SeoulGame implements Game {

    private int count;
    private boolean isErrorHappen;
    private List<Player> players;

    public SeoulGame(int count, boolean isErrorHappen, List<Player> players) {
        this.count = count;
        this.isErrorHappen = isErrorHappen;
        this.players = players;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!isErrorHappen) {
            for (int i = 0; i < players.size(); i = i % players.size() + 1) {
                isErrorHappen = random.nextDouble() < players.get(i).getErrorRate();

                if (!isErrorHappen) {
                    if (isClapCase(count)) System.out.println("Seoul CLAP");
                    else System.out.println("Seoul " + count);
                    count++;
                }
            }
        }
        System.out.println("Seoul Game Stop!");
    }

    @Override
    public boolean isClapCase(int num) {
        if (num % 3 > 0) return false;
        while (num > 0) {
            int tmp = num % 10 % 3;
            System.out.println(tmp);
            if (tmp == 0) return true;
            num /= 10;
        }
        return false;
    }

    @Override
    public int getClapTime(int num) {
        return 1;
    }
}
