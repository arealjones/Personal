from password import secure_password


def test_secure_password():
    assert(secure_password("password") is False)
    assert(secure_password("pA$$worD1") is True)
    assert(secure_password("Sch@@l") is False)
    assert(secure_password("HE$$$OO") is False)
    assert(secure_password("Correct!2019") is False)
    assert(secure_password("WaaaaayyyyT@@L@ng20") is False)
    assert(secure_password("W@nTG3uss") is True)
    assert(secure_password("Vaca#2020") is True)
    assert(secure_password("Vaca&2020") is False)
    assert(secure_password("1allDAc@de1") is True)
