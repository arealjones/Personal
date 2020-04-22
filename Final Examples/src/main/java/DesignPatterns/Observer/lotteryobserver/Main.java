package DesignPatterns.Observer.lotteryobserver;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int numToDraw = 3;
        int maxNum = 5;

        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(1);
        set1.add(4);

        Set<Integer> set2 = new HashSet<>();
        set2.add(0);
        set2.add(3);
        set2.add(4);

        LotteryTicket ticket1 = new LotteryTicket("Player 1", set1);
        LotteryTicket ticket2 = new LotteryTicket("Player 2", set2);

        LotteryDraw draw = new LotteryDraw(numToDraw, maxNum);
        draw.addObserver(ticket1);
        draw.addObserver(ticket2);
        draw.pickNumbers();
    }
}
