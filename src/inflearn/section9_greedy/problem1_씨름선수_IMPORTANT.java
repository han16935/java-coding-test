package inflearn.section9_greedy;

import java.util.*;
import java.io.*;

/**
 * 특정 선수보다 키, 몸무게 전부 보다 큰 사람이 없는 사람의 수 구하기
 * 기존 풀이는 O(N^2) 로 풀었지만, 신규 풀이에서는 O(N) 으로 해결 가능!
 *     - 키 기준으로 내림차순 정렬
 *     - 이 때, maxWeight 통해 순회하면서 업데이트
 *         - 만약 업데이트되었을 경우, 이전 선수 (그 선수보다 키가 큰 선수) 보다 무거운 선수는 없으므로 선출!
 *         - 만약 업데이트되지 않았을 경우, 이전 선수 (그 선수보다 키가 큰 선수) 중 그 선수보다 무거운 선수가 있다는 의미이므로, 선출되지 않음
 */
public class problem1_씨름선수_IMPORTANT {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 1; // 제일 키가 큰 선수
        Person[] persons = new Person[n];

        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            persons[i] = new Person(height, weight);
        }

        Arrays.sort(persons, Collections.reverseOrder());

        int maxWeight = persons[0].weight;
        for(int i=1;i<n;i++) {
            Person chosenPerson = persons[i];
            if (chosenPerson.weight > maxWeight) {
                answer++;
                maxWeight = chosenPerson.weight;
            }
        }

        System.out.println(answer);
    }

    static class Person implements Comparable<Person> {
        int height;
        int weight;

        @Override
        public int compareTo(Person person) {
            return this.height - person.height;
        }

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}
