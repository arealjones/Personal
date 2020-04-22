package DesignPatterns.Observer.lotteryobserver;

import java.util.Set;

public class LotteryTicket {
    private String ownerName;
    private Set<Integer> numbers;
    private int matchingNumbers;

    public LotteryTicket(String ownerName, Set<Integer> numbers) {
        this.ownerName = ownerName;
        this.numbers = numbers;
        this.matchingNumbers = 0;
    }

    public void notifyNumberDraw(int number) {
        if (this.numbers.contains(number)) {
            System.out.println(ownerName + " has " + number);
            matchingNumbers++;
        } else {
            System.out.println(ownerName + " does not have " + number);
        }
    }

    public void notifyDrawComplete() {
        if (this.matchingNumbers == this.numbers.size())
            System.out.println(ownerName + " wins!");
        else System.out.println(ownerName + " did not win.");
    }
}
