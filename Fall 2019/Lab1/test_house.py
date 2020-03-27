from house import calc_downpay, calc_savings, calc_months, calc_years, downpay_line, savings_line, time_line


def test_calc_downpay():
    assert(calc_downpay(55000, .25) == 13750)
    assert(calc_downpay(129000, .20) == 25800)
    assert(calc_downpay(515000, .10) == 51500)
    assert(calc_downpay(96000, .20) == 19200)


def test_calc_savings():
    assert(calc_savings(120000, 20) == 2000)
    assert(calc_savings(88000, 15) == 1100)
    assert(calc_savings(45000, 25) == 937.5)
    assert(calc_savings(90000, 10) == 750)


def test_calc_months():
    assert(calc_months(120000, 80000, 20) == 10.5)
    assert(calc_months(500000, 100000, 15) == 4.0)
    assert(calc_months(80000, 160000, 10) == 3.0)
    assert(calc_months(50000, 30000, 25) == 8.0)


def test_calc_years():
    assert(calc_years(120000, 80000, 20) == 1.0)
    assert(calc_years(500000, 100000, 15) == 8.0)
    assert(calc_years(80000, 160000, 10) == 1.0)
    assert(calc_years(50000, 30000, 25) == 1.0)


def test_downpay_line():
    assert(downpay_line(15000) == "The downpayment amount is: $15000.00.")
    assert(downpay_line(33000) == "The downpayment amount is: $33000.00.")
    assert(downpay_line(21000) == "The downpayment amount is: $21000.00.")
    assert(downpay_line(46000) == "The downpayment amount is: $46000.00.")


def test_savings_line():
    assert(savings_line(2250) == "The amount you save each month is: $2250.00.")
    assert(savings_line(1110) == "The amount you save each month is: $1110.00.")
    assert(savings_line(3125) == "The amount you save each month is: $3125.00.")
    assert(savings_line(5467) == "The amount you save each month is: $5467.00.")

#Ask tomorrow about this error.
# def test_time_line():
#     assert(time_line(500, 2, 6) == "If you save $500.00 per month, it will take 2.0 year(s) and 6.0 months to save enough for the down payment!")
#     assert(time_line(1110, 3, 8) == "If you save $1110.00 per month, it will take 3.0 year(s) and 8.0 months to save enough for the down payment!")
#     assert(time_line(900, 4, 1) == "If you save $900.00 per month, it will take 4.0 year(s) and 1.0 months to save enough for the down payment!")
#     assert(time_line(3000, 5, 7) == "If you save $3000.00 per month, it will take 5.0 year(s) and 7.0 months to save enough for the down payment!")





