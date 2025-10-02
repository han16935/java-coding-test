package oop.three_six_nine;

import java.util.List;
import java.util.Random;

public class BusanGame implements Game {

    private int count;
    private boolean isErrorHappen;
    private List<Player> players;

    public BusanGame (int count, boolean isErrorHappen, List<Player> players) {
        this.count = count;
        this.isErrorHappen = isErrorHappen;
        this.players = players;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (!isErrorHappen) {
            for (int i=0;i<players.size();i = i % players.size() + 1) {
                isErrorHappen = random.nextDouble() < players.get(i).getErrorRate();
                if (!isErrorHappen) {
                    if (isClapCase(count)) {
                        for(int clapCount=0;clapCount<getClapTime(count);clapCount++) {
                            System.out.print("CLAP ");
                        }
                        System.out.println();
                    }

                    else System.out.println("Busan " + count);
                    count++;
                }
            }
        }

        System.out.println("Busan Game Stop!");
    }

    @Override
    public boolean isClapCase (int num) {
        if (num % 3 > 0) return false;
        while (num > 0) {
            if (num % 10 % 3 == 0) return true;
            num /= 10;
        }
        return false;
    }

    @Override
    public int getClapTime (int num) {
        int answer = 0;
        while (num > 0) {
            if (num % 10 % 3 == 0) answer++;
            num /= 10;
        }
        return answer;
    }
}
