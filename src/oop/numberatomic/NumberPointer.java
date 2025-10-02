package oop.numberatomic;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberPointer implements Runnable {

    private static int num = 0;  // AtomicInteger 대신 int 사용
    private final int count;

    public NumberPointer(int count) {
        this.count = count;
    }

    // main 에서는 서로 다른 NumberPointer 인스턴스를 만들었으므로 synchronized가 통하지 않음
    // 각 thread마다 서로 다른 synchronized (synchronized는 인스턴스 단위로 걸림)
    @Override
    public synchronized void run() {
        for (int i = 0; i < count; i++) {
            num++;  // 동기화 없이 단순 증가
        }
    }

    public static int getAtomic() {
        return num;  // 동기화 없이 바로 반환
    }
}

