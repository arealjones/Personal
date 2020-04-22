package DesignPatterns.Observer.lotteryobserver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryDraw {
    private int numbersToDraw;
    private int maxNum;
    private Set<Integer> winningNumbers;
    private List<LotteryTicket> purchasedTickets;

    public LotteryDraw(int numbersToDraw, int maxNum) {
        this.numbersToDraw = numbersToDraw;
        this.maxNum = maxNum;
        this.winningNumbers = new HashSet<>();
        this.purchasedTickets = new ArrayList<>();
    }

    public void addObserver(LotteryTicket observer) {
        this.purchasedTickets.add(observer);
    }

    public void pickNumbers() {
        while (winningNumbers.size() < this.numbersToDraw) {
            int draw = (int)Math.round(Math.random() * maxNum);
            System.out.println(System.lineSeparator() + "DRAW: " + draw);
            winningNumbers.add(draw);
            for (LotteryTicket ticket: this.purchasedTickets)
                ticket.notifyNumberDraw(draw);
        }
        this.drawComplete();
    }

    private void drawComplete() {
        for (LotteryTicket ticket: this.purchasedTickets)
            ticket.notifyDrawComplete();
    }



}
