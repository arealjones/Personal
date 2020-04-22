package CommandLine.CookieCounter;

/**
 * Calculates facts about the cookies eaten. Currently only returns basic nutritional information but could be extended
 * to perform other cookie calculations.
 */
public class Calculator {
    public static Cookie samoas;
    public static Cookie dosidos;
    public static Cookie thinMints;

    private int samoasEaten;
    private int dosidosEaten;
    private int thinMintsEaten;

    /**
     * Constructor for the Calculator class.
     * @param samoasEaten
     * @param dosidosEaten
     * @param thinMintsEaten
     */
    public Calculator(int samoasEaten, int dosidosEaten, int thinMintsEaten) {
        // populate cookies - values should really be constants...
        samoas = new Cookie("Samoas",2, 150, 11);
        dosidos = new Cookie("Do-si-dos", 3, 160, 11);
        thinMints = new Cookie("Thin Mints", 4, 160, 10);
        this.samoasEaten = samoasEaten;
        this.dosidosEaten = dosidosEaten;
        this.thinMintsEaten = thinMintsEaten;
    }

    /**
     * Returns a String describing the total amount of calories and sugar in the provided number of cookies.
     * @return A String describing the total amount of calories and sugar in the provided number of cookies.
     */
    public String getTotalMessage() {
        int totalCalories = samoas.totalCalories(samoasEaten) + dosidos.totalCalories(dosidosEaten)
                + thinMints.totalCalories(thinMintsEaten);
        int totalSugar = samoas.totalSugar(samoasEaten) + dosidos.totalSugar(dosidosEaten)
                + thinMints.totalSugar(thinMintsEaten);
        StringBuilder msg = new StringBuilder();
        msg.append("You ate ").append(totalCalories).append(" calories, ").append(totalSugar).append("g of sugar");
        return msg.toString();
    }
}
