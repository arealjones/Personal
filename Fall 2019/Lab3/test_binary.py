from binary import binary_change


def test_binary_change():
    assert(binary_change("11011")== 27)
    assert(binary_change("100110101")== 309)
    assert(binary_change("101101001101101")== 23149)
    assert(binary_change("110000110101010011111")== 1600159)
