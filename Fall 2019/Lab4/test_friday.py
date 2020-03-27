from friday import days_until_fri, index_day, valid


def test_days_until_fri():
    assert(days_until_fri(0) == 6)
    assert(days_until_fri(2) == 4)
    assert(days_until_fri(5) == 1)
    assert(days_until_fri(6) == 0)


def test_index_day():
    assert(index_day("Su") == 1)
    assert(index_day("W") == 4)
    assert(index_day("Tu") == 3)
    assert(index_day("Sa") == 0)


def test_valid():
    assert(valid("Th") == True)
    assert(valid("Monday") == False)
    assert(valid("F") == True)
    assert(valid("Sat") == False)
