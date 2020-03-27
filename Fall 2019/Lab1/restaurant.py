# TEST 1
# bill = 60, tip percent = 20, people in group = 3 =>
# everyone will contribute an amount of 24.
# TEST CASE #2
# bill = 145, tip percent = 15, people in group = 6 =>
# everyone will contribute an amount of 27.79.
# TEST CASE #3
# bill = 301, tip percent = 20, people in group = 4 =>
# everyone will contribute an amount of 90.3.

# PURPOSE
# Returns the amount each person will contribute.
# SIGNATURE
# calc_contribute(num_bill, num_tip, num_split) ::
# Float, Float, Integer => Float
# EXAMPLES
# calc_contribute(301, 20, 4) => 90.3
# calc_contribute(145, 15, 6) => 27.79


def calc_contribute(num_bill, num_tip, num_split):
    tip_in_decimals = num_tip / 100
    tip_amount = num_bill * tip_in_decimals
    bill_w_tip = tip_amount + num_bill
    amount_per_person = bill_w_tip / num_split
    return amount_per_person


def main():
    bill = float(input("How much was the total bill? "))
    tip = float(input("What percent is everyone willing to tip? "))
    split = int(input("How many people are splitting the bill? "))
    print("The amount each person should contribute is:", round(float(
        calc_contribute(bill, tip, split)), 2), "dollars.")


main()
