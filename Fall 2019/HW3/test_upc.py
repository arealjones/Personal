from upc import upc_calc, valid


def test_upc_calc():
    assert(upc_calc("12345") == 27)
    assert(upc_calc("") == 0)
    assert(upc_calc("1") == 1)
    assert(upc_calc("070847811169") == 90)
    assert(upc_calc("010700021526") == 30)
    assert(upc_calc("072273391642") == 80)
    assert(upc_calc("red") == 0)


def test_valid():
    assert(valid("12345") == "Invalid")
    assert(valid("") == "Invalid")
    assert(valid("1") == "Invalid")
    assert(valid("070847811169") == "Valid")
    assert(valid("010700021526") == "Valid")
    assert(valid("072273391642") == "Valid")
    assert(valid("red") == "Invalid")
