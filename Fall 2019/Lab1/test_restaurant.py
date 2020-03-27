from restaurant import calc_contribute


def test_calc_contribute():
    assert(calc_contribute(30, 20, 3) == 12.0)
    assert(calc_contribute(50, 15, 5) == 11.5)
    assert(calc_contribute(75, 10, 4) == 20.625)
    assert(calc_contribute(28, 20, 2) == 16.8)
    assert(calc_contribute(41, 15, 2) == 23.575)


