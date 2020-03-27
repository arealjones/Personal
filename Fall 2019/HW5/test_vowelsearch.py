from vowelsearch import contains_vowel, string_search


def test_string_search():
    assert(string_search("garage") is True)
    assert(string_search("ffff") is False)
    assert(string_search("DAANNNGG") is True)
    assert(string_search("DDDD") is False)
    assert(string_search("KNoCKK kNocK") is True)
    assert(string_search("monster") is True)
    assert(string_search("monster mash") is True)
    assert(string_search("crypt") is False)
    assert(string_search("zzz") is False)
    assert(string_search("") is False)
    assert(string_search(" ") is False)
    assert(string_search("1") is False)
    assert(string_search("!") is False)


def test_contains_vowel():
    assert(contains_vowel(["KNoCKK kNocK", "Whose", "there"]) is True)
    assert(contains_vowel(["scary", "monster"]) is True)
    assert(contains_vowel([" "]) is False)
    assert(contains_vowel([""]) is False)
    assert(contains_vowel([]) is False)
    assert(contains_vowel(["monster mash", "crypt"]) is False)
    assert(contains_vowel(["monster"]) is True)
    assert(contains_vowel(["DDDD", "Yes"]) is False)
    assert(contains_vowel(["garage", "this", "man"]) is True)
    assert(contains_vowel(["fff", "this", "man"]) is False)
    assert(contains_vowel(["", "candy"]) is False)
    assert(contains_vowel(["1", "scary"]) is False)
    assert(contains_vowel(["this", "!"]) is False)
