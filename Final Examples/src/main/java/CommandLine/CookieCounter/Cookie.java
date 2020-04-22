package CommandLine.CookieCounter;

import java.util.Objects;

/**
 * Concrete class representing the nutritional information of a type of cookie.
 */
public class Cookie {
    private String name;
    private int cookiesPerServing;
    private int caloriesPerServing;
    private int sugarPerServing;

    /**
     * Constructor for the Cookie class.
     * @param name The name of the cookie (found on the box).
     * @param cookiesPerServing The number of cookies per serving.
     * @param caloriesPerServing The number of calories per serving.
     * @param sugarPerServing The amount of sugar in grams per serving.
     */
    public Cookie(String name, int cookiesPerServing, int caloriesPerServing, int sugarPerServing) {
        this.name = name;
        this.cookiesPerServing = cookiesPerServing;
        this.caloriesPerServing = caloriesPerServing;
        this.sugarPerServing = sugarPerServing;
    }

    /**
     * Gets the name of the cookie.
     * @return The name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the number of cookies per serving.
     * @return The number of cookies in a serving.
     */
    public int getCookiesPerServing() {
        return cookiesPerServing;
    }

    /**
     * Gets the number of calories per serving.
     * @return The number of calories per serving.
     */
    public int getCaloriesPerServing() {
        return caloriesPerServing;
    }

    /**
     * Gets the amount of sugar in a serving.
     * @return The amount of sugar in grams.
     */
    public int getSugarPerServing() {
        return sugarPerServing;
    }

    /**
     * Helper method to calculate calories/sugar in a given number of cookies.
     * @param numCookies The number of cookies
     * @param unit The amount of either calories or sugar in a serving.
     * @return The amount of either calories or sugar in the given number of cookies.
     */
    private int totalOfUnit(int numCookies, int unit) {
        int unitPerCookie = Math.round(unit / this.cookiesPerServing);
        return unitPerCookie * numCookies;
    }

    /**
     * Calculates and returns the amount of calories in the given number of cookies.
     * @param numCookies The number of cookies.
     * @return The number of calories.
     */
    public int totalCalories(int numCookies) {
        return this.totalOfUnit(numCookies, this.caloriesPerServing);
    }

    /**
     * Calculates and returns that amount of sugar in the given number of cookies.
     * @param numCookies The number of cookies.
     * @return The amount of sugar.
     */
    public int totalSugar(int numCookies) {
        return this.totalOfUnit(numCookies, this.sugarPerServing);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cookie cookie = (Cookie) o;
        return getCookiesPerServing() == cookie.getCookiesPerServing() &&
                getCaloriesPerServing() == cookie.getCaloriesPerServing() &&
                getSugarPerServing() == cookie.getSugarPerServing() &&
                Objects.equals(getName(), cookie.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCookiesPerServing(), getCaloriesPerServing(), getSugarPerServing());
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "name='" + name + '\'' +
                ", cookiesPerServing=" + cookiesPerServing +
                ", caloriesPerServing=" + caloriesPerServing +
                ", sugarPerServing=" + sugarPerServing +
                '}';
    }
}
