# CS 5001
# Fall 2019
# HW1 - Data Types and Arithmetic Operations

# TEST CASE #1
# bread = 2, cheese = 56, ham = 44 =>
# 1 sandwiches, leftover bread = 0, leftover cheese = 53, leftover ham = 38
# TEST CASE #2
# bread = 77, cheese = 400, ham = 189 =>
# 31 sandwiches, leftover bread = 15, leftover cheese = 307, leftover ham = 3
# TEST CASE #3
# bread = 5643, cheese = 9876, ham = 7432 =>
# 1238 sandwiches
# leftover bread = 3167, leftover cheese = 6162, leftover ham = 4

# PURPOSE
# Returns the total sandwiches than can be made with the ingredient.
# SIGNATURE
# calc_sand(amount_have, amount_needed) :: Int, Int => Int
# EXAMPLES
# calc_sand(77, 2) => 38
# calc_sand(5643, 2) => 2821


def calc_sand(amount_have, amount_needed):
    return amount_have // amount_needed


# PURPOSE
# Returns the amount of leftover ingredients after making sandwiches.
# SIGNATURE
# calc_rem_item(item, min_sand, amount_needed) :: Int, Int, Int => Int
# EXAMPLES
# calc_rem_item(400, 31, 3) => 307
# calc_rem_item(44, 1, 6) => 38


def calc_rem_item(item, min_sand, amount_needed):
    ingred = min_sand * amount_needed
    rem_item = item - ingred
    return rem_item


# PURPOSE
# Formats the line of sandwiches that can be made for each ingredient.
# SIGNATURE
# can_make_line(sand) :: Integer => String
# EXAMPLES
# can_make_line(2) => "I can make 1 sandwiches(s) with that."
# can_make_line(7432) => "I can make 1238 sandwiches(s) with that."


def can_make_line(sand):
    return "I can make {} sandwiches(s) with that.".format(sand)


def main():
    bread = int(input("How many slices of bread do you have? "))
    bread_sand = calc_sand(bread, 2)
    print(can_make_line(bread_sand))

    cheese = int(input("How many slices of cheese do you have? "))
    cheese_sand = calc_sand(cheese, 3)
    print(can_make_line(cheese_sand))

    ham = int(input("How many slices of ham do you have? "))
    ham_sand = calc_sand(ham, 6)
    print(can_make_line(ham_sand))

    min_sand = int(min(bread_sand, cheese_sand, ham_sand))
    rem_bread = calc_rem_item(bread, min_sand, 2)
    rem_cheese = calc_rem_item(cheese, min_sand, 3)
    rem_ham = calc_rem_item(ham, min_sand, 6)
    leftover = "Leftover ingredients: bread slices = {}, " \
        "cheese slices = {}, " \
        "ham slices = {}.".format(rem_bread, rem_cheese, rem_ham)

    print("You've got", min_sand, "sandwiches(s) coming!")
    print(leftover)


main()
