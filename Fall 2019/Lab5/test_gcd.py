from gcd import gcd, gcd_num

def test_gcd():
    assert(gcd(12, 8) == 4)
    assert(gcd(15, 30) == 15)
    assert(gcd(10, 3) == 1)
    assert(gcd(21, 14) == 7)


def test_gcd_num():
    assert(gcd_num([3, 9, 27]) == 3)
    assert(gcd_num([33, 22, 11, 44]) == 11)
    assert(gcd_num([25, 30, 65, 90, 55]) == 5)
    assert(gcd_num([13, 7, 9, 8, 5]) == 1)
    assert(gcd_num([12]) == 12)
    assert(gcd_num([]) == 0)

