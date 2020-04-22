package DesignPatterns.Factory.cookiefactory;

import java.util.Objects;

/**
 * An abstract class representing a food item. For simplicity's sake, a lot of nutritional info is left out e.g.
 * protein, iron, etc.
 */
public abstract class AbstractFoodItem {
    private double quantityPerServing;
    private int caloriesPerServing;
    private int sugarPerServing;

    public AbstractFoodItem(double quantityPerServing, int caloriesPerServing, int sugarPerServing) {
        this.quantityPerServing = quantityPerServing;
        this.caloriesPerServing = caloriesPerServing;
        this.sugarPerServing = sugarPerServing;
    }

    /**
     * Gets the quantity of the item that makes up a serving.
     * @return The quantity of the item that makes up a serving.
     */
    public double getQuantityPerServing() {
        return this.quantityPerServing;
    }

    /**
     * Gets the calories in a serving.
     * @return The number of calories in a serving.
     */
    public int getCaloriesPerServing() {
        return this.caloriesPerServing;
    }

    /**
     * The amount of sugar in a serving, in grams.
     * @return  The amount of sugar in a serving.
     */
    public int getSugarPerServing() {
        return this.sugarPerServing;
    }

    /**
     * Helper method to calculate calories/sugar in a given number of the item.
     * @param numItem The number of the item
     * @param unit The amount of either calories or sugar in a serving.
     * @return The amount of either calories or sugar in the given number of the item.
     */
    private double totalOfUnit(double numItem, double unit) {
        double unitPerCookie = unit / this.getQuantityPerServing();
        return unitPerCookie * numItem;
    }

    /**
     * Calculates and returns the amount of calories in the given number of cookies.
     * @param numItem The number of the item.
     * @return The number of calories.
     */
    public double totalCalories(double numItem) {
        return this.totalOfUnit(numItem, this.getCaloriesPerServing());
    }

    /**
     * Calculates and returns that amount of sugar in the given number of cookies.
     * @param numItem The number of the item.
     * @return The amount of sugar.
     */
    public double totalSugar(double numItem) {
        return this.totalOfUnit(numItem, this.getSugarPerServing());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFoodItem that = (AbstractFoodItem) o;
        return Double.compare(that.getQuantityPerServing(), getQuantityPerServing()) == 0 &&
                getCaloriesPerServing() == that.getCaloriesPerServing() &&
                getSugarPerServing() == that.getSugarPerServing();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getQuantityPerServing(), getCaloriesPerServing(), getSugarPerServing());
    }
}
