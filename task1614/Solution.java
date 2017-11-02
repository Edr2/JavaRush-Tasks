package com.javarush.task.task16.task1614;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static volatile List<String> list = new ArrayList<String>(5);
    private static int count = 10;

    static {
        for (int i = 0; i < count; i++) {
            list.add("Time: " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Countdown(count), "Countdown");
        t.start();
    }

    public static class Countdown implements Runnable {
        private int countFrom;

        public Countdown(int countFrom) {
            this.countFrom = countFrom;
        }

        public void run() {
            try {
                while (countFrom > 0) {
                    printCountdown();
                }
            } catch (InterruptedException e) {
            }
        }

        public void printCountdown() throws InterruptedException {
            if( countFrom < 0 ) return;
            Thread.sleep(500);
            System.out.println(list.get(--countFrom));
        }
    }
}
