from convertcase_recursive import convertcase


def test_convertcase():
    assert(convertcase("BaNaNa Bread") == "bAnAnA bREAD")
    assert(convertcase("COSTUME") == "costume")
    assert(convertcase("ChRIStmas") == "cHrisTMAS")
    assert(convertcase("wInE") == "WiNe")
    assert(convertcase("KNoCKK kNocK") == "knOckk KnOCk")
    assert(convertcase("scary") == "SCARY")
    assert(convertcase("") == "")
    assert(convertcase(" ") == " ")
    assert(convertcase("1") == "1")
    assert(convertcase("!") == "!")
