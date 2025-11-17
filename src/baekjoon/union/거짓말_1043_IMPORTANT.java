package baekjoon.union;

import java.util.*;
import java.io.*;

public class 거짓말_1043_IMPORTANT {

    static int n, m; // 사람 수, 파티 수
    static int answer = 0;
    static int knowTruthCount;
    static Set<Integer> knowTruthPeople = new HashSet<>();
    static List<Node> arr = new ArrayList<>();
    static int [] set;

    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        set = new int[n + 1];
        for (int i=1;i<=n;i++) {
            set[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        knowTruthCount = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            int knowTruthPerson = Integer.parseInt(st.nextToken());
            knowTruthPeople.add(knowTruthPerson);
            set[knowTruthPerson] = 0;
        }

        for (int party=0;party<m;party++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            List<Integer> people = new ArrayList<>();
            int firstPerson = Integer.parseInt(st.nextToken());
            people.add(firstPerson);

            if (count > 1) {
                for (int person=1;person<count;person++) {
                    int otherPerson = Integer.parseInt(st.nextToken());
                    union(firstPerson, otherPerson);
                    people.add(otherPerson);
                }
            }

            arr.add(new Node(count, people));
        }

        for (Node n : arr) {
            boolean isTruthExist = false;
            List<Integer> people = n.people;
            for (int person : people) {
                if (find(person) == 0) {
                    isTruthExist = true;
                    break;
                }
            }
            if (!isTruthExist) answer++;
        }

        System.out.println(answer);
    }


    static class Node {
        int count;
        List<Integer> people;

        public Node (int count, List<Integer> people) {
            this.count = count;
            this.people = people;
        }
    }

    static int find (int person) {
        if (set[person] == 0) return 0;
        if (set[person] == person) return person;
        else return set[person] = find(set[person]);
    }

    static void union (int first, int second) {
        int firstSetParent = find(first);
        int secondSetParent = find(second);
        if (firstSetParent != secondSetParent) {
            if (firstSetParent < secondSetParent) set[secondSetParent] = firstSetParent;
            else set[firstSetParent] = secondSetParent;
        }
    }
}
