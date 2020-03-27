from integer import logarithm


def test_logarithm():
    assert(logarithm(8) == 3)
    assert(logarithm(16) == 4)
    assert(logarithm(32) == 5)
    assert(logarithm(64) == 6)
