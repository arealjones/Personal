from convertcase import convertcase


def test_convertcase():
    assert(convertcase("BOOGER") == "booger")
    assert(convertcase("HeLlO") == "hElLo")
    assert(convertcase("HALLOween") == "halloWEEN")
    assert(convertcase("hi") == "HI")
    assert(convertcase("KNoCKK kNocK") == "knOckk KnOCk")
    assert(convertcase("bOO") == "Boo")
