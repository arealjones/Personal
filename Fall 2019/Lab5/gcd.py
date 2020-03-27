# PURPOSE
# Finds the greatest common divisor between two integers.
# SIGNATURE
# gcd :: Integer, Integer => Integer
# EXAMPlES
# gcd(12, 8) => 4
# gcd(15, 30) => 15
# gcd(10, 3) => 1


def gcd(x, y):
    if x > y:
        max_var = x
        if (max_var % y) == 0:
            return y
        else:
            return gcd(y, max_var % y)
    elif y > x:
        max_var = y
        if (max_var % x) == 0:
            return x
        else:
            return gcd(x, max_var % x)


# PURPOSE
# Finds the greatest common divisor between all integers in a list.
# SIGNATURE
# gcd_num :: list<Integer> => Integer
# EXAMPlES
# gcd_num([3, 9, 27]) => 3
# gcd_num([25, 30, 65, 90, 55]) => 5
# gcd_num([13, 7, 9, 8, 5]) => 1


def gcd_num(lst_num):
    if len(lst_num) == 0:
        return 0
    elif len(lst_num) == 1:
        return lst_num[0]
    elif len(lst_num) == 2:
        return gcd(lst_num[0], lst_num[1])
    else:
        return gcd(lst_num[0], gcd_num(lst_num[1:]))


