package DesignPatterns.Factory.cookiefactory;

import java.util.Objects;

/**
 * Concrete class representing the nutritional information of a type of cookie.
 */
public class Cookie extends AbstractFoodItem {
    private String name;

    /**
     * Constructor for the Cookie class.
     * @param name The name of the cookie (found on the box).
     * @param cookiesPerServing The number of cookies per serving.
     * @param caloriesPerServing The number of calories per serving.
     * @param sugarPerServing The amount of sugar in grams per serving.
     */
    public Cookie(String name, int cookiesPerServing, int caloriesPerServing, int sugarPerServing) {
        super(cookiesPerServing, caloriesPerServing, sugarPerServing);
        this.name = name;
    }

    /**
     * Gets the name of the cookie.
     * @return The name.
     */
    public String getName() {
        return this.name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cookie cookie = (Cookie) o;
        return getQuantityPerServing() == cookie.getQuantityPerServing() &&
                getCaloriesPerServing() == cookie.getCaloriesPerServing() &&
                getSugarPerServing() == cookie.getSugarPerServing() &&
                Objects.equals(getName(), cookie.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getQuantityPerServing(), getCaloriesPerServing(), getSugarPerServing());
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "name='" + name + '\'' +
                ", cookiesPerServing=" + getQuantityPerServing() +
                ", caloriesPerServing=" + getCaloriesPerServing() +
                ", sugarPerServing=" + getSugarPerServing() +
                '}';
    }
}
