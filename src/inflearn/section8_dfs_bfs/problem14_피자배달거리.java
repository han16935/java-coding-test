package inflearn.section8_dfs_bfs;

import java.util.*;
import java.io.*;

/**
 *
 */
public class problem14_피자배달거리 {
    static int n;
    static int m;
    static int answer = Integer.MAX_VALUE;

    static int [][] map;
    static boolean [] isVisited;

    static List<Home> homes = new ArrayList<>();
    static List<Pizza> pizzas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][n + 1];

        for (int y=1;y<=n;y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=1;x<=n;x++) {
                int nextPoint = Integer.parseInt(st.nextToken());
                if (isHome(nextPoint)) homes.add(new Home(y, x));
                if (isPizza(nextPoint)) pizzas.add(new Pizza(y, x));
                map[y][x] = nextPoint;
            }
        }

        isVisited = new boolean[pizzas.size()];

        // 1. m개 pizza 선택
        choosePizzas(0, 0);

        System.out.println(answer);
    }

    private static void choosePizzas(int chosenCount, int index) {

        if (chosenCount == m) {
            int cityPizzaDistance = 0; // 이 케이스로 피자집이 선택되엇을 때의 피자배달거리 총합

            // 2. 1에서 선택된 pizza 집 대해 각 집 대해 피자배달거리 계산
            for (Home home : homes) {
                int homePizzaDistance = Integer.MAX_VALUE;
                for(int i=0;i<pizzas.size();i++) {
                    if (isVisited[i]) {
                        Pizza pizza = pizzas.get(i);
                        homePizzaDistance = Math.min(homePizzaDistance, calculateAbsoluteDistance(home, pizza));
                    }
                }
                cityPizzaDistance += homePizzaDistance;
            }

            // 3. 2의 결과 합계와 answer 비교, answer보다 작으면 update
            answer = Math.min(answer, cityPizzaDistance);
            return;
        }

        if (index == pizzas.size()) return;

        isVisited[index] = true;
        choosePizzas(chosenCount + 1, index + 1);
        isVisited[index] = false;
        choosePizzas(chosenCount, index+1);
    }

    private static int calculateAbsoluteDistance(Home home, Pizza pizza) {
        return Math.abs(home.x - pizza.x) + Math.abs(home.y - pizza.y);
    }

    private static boolean isPizza(int nextPoint) {
        return nextPoint == 2;
    }

    private static boolean isHome(int nextPoint) {
        return nextPoint == 1;
    }

    static class Home {
        int y;
        int x;

        public Home(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static class Pizza {
        int y;
        int x;

        public Pizza(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
