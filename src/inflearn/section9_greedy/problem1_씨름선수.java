package inflearn.section9_greedy;

import java.util.*;
import java.io.*;

public class problem1_씨름선수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = n;
        Person[] persons = new Person[n];

        StringTokenizer st;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());

            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            persons[i] = new Person(height, weight);
        }

        Arrays.sort(persons);

        for(int i=0;i<n-1;i++) {
            Person chosenPerson = persons[i];
            for(int j=i+1;j<n;j++) {
                if (persons[j].weight > chosenPerson.weight) {
                    answer--;
                    break;
                }
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
