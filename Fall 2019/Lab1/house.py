# TEST 1
# cost = 120,000, salary = 80,000, savings percent = 20% =>
# If they save 1,333.33, it will take 1 year and 10.5 months.
# TEST CASE #2
# cost = 60,000 salary = 40,000, savings percent = 15% =>
# If they save 500, it will take 2 years and 6 months.
# TEST CASE #3
# cost = 500,000, salary = 90,000, savings percent = 30% =>
# If they save 2,250, it will take 4 years and 7 months.

# PURPOSE
# Returns the cost of the downpayment.
# SIGNATURE
# calc_downpay(num_cost, percent) :: Int, Int => Int
# EXAMPLES
# calc_downpay(500000, 30) => 125000
# calc_downpay(60000, 15) => 15000


def calc_downpay(num_cost, percent):
    return num_cost * percent


# PURPOSE
# Returns the amount that can be saved each month.
# SIGNATURE
# calc_savings(num_salary, num_savings) ::
# Int, Float => Float
# EXAMPLES
# calc_savings(90000, 30) => 2250.00
# calc_savings(80000, 20) => 1333.33


def calc_savings(num_salary, num_savings):
    percent_saving = num_savings / 100
    monthly_income = num_salary / 12
    savings_month = percent_saving * monthly_income
    return savings_month


# PURPOSE
# Returns the number of additional months it will take.
# SIGNATURE
# calc_months(num_cost, num_salary, num_savings) ::
# Int, Int, Float => Float
# EXAMPLES
# calc_months(120000, 80000, 20) => 10.5
# calc_months(60000, 40000, 15) => 6.0


def calc_months(num_cost, num_salary, num_savings):
    down_pay = num_cost * .25
    percent_saving = num_savings / 100
    savings_year = percent_saving * num_salary
    monthly_income = savings_year / 12
    months = down_pay / monthly_income
    rem_months = months - ((months // 12) * 12)
    return rem_months


# PURPOSE
# Returns the number of years it will take to save.
# SIGNATURE
# calc_years_months(num_cost, num_salary, num_savings) ::
# Int, Int, Float => Int
# EXAMPLES
# calc_years_months(500000, 90000, 30) => 4
# calc_years_months(60000, 40000, 15) => 2


def calc_years(num_cost, num_salary, num_savings):
    down_pay = num_cost * .25
    percent_saving = num_savings / 100
    savings_year = percent_saving * num_salary
    monthly_income = savings_year / 12
    months = down_pay / monthly_income
    years = months // 12
    return years


# PURPOSE
# To clean up the line of the downpayment that is shown to the user.
# SIGNATURE
# downpay_line(downpay_cost) :: Float => Str
# EXAMPLES
# downpay_line(15000) => "The downpayment amount is: $15000.00"
# downpay_line(125000) => "The downpayment amount is: $125000.00"


def downpay_line(downpay_cost):
    return "The downpayment amount is: ${:.2f}.".format(downpay_cost)


# PURPOSE
# To clean up the line of the monthly savings that is shown to the user.
# SIGNATURE
# savings_line(savings_amount) :: Float => Str
# EXAMPLES
# savings_line(2250) => "The amount you save each month is: $2250.00"
# savings_line(500) => "The amount you save each month is: $500.00"


def savings_line(savings_amount):
    return "The amount you save each month is: ${:.2f}.".format(savings_amount)


# PURPOSE
# For the last line of the savings, years, and months that is shown to the user.
# SIGNATURE
# time_line(savings_amount, years, months) :: Float, Float, Float => Str
# EXAMPLES
# time_line(500, 2, 6) => "If you save $500.00 per month, it will take 2.0(s)
# and 6.0 months to save enough for the down payment!
# time_line(2250, 4, 7.6) => "If you save $2250.00 per month, it will take
# 4.0(s) and 7.6 months to save enough for the down payment!


def time_line(savings_amount, years, months):
    return "If you save ${:.2f} per month, it will take {} year(s) and\
        {:.1f} months to save enough for the down\
            payment!".format(savings_amount, years, months)


def main():
    cost = int(input("How much does the house cost? "))
    salary = int(input("How much is your annual salary? "))
    savings = float(input(
        "What percent of your monthly salary can you save each month? "))

    downpay_cost = calc_downpay(cost, .25)
    savings_amount = calc_savings(salary, savings)
    years = calc_years(cost, salary, savings)
    months = calc_months(cost, salary, savings)

    print(downpay_line(downpay_cost))
    print(savings_line(savings_amount))
    print(time_line(savings_amount, years, months))


main()
