from numbertoword import integer_to_english

def test_invalid():
    assert(integer_to_english(-1) == "Invalid input!")
    assert(integer_to_english(1000001) == "Invalid input!")
    
def test_single_digit():
    assert(integer_to_english(0) == "zero")
    assert(integer_to_english(1) == "one")
    assert(integer_to_english(9) == "nine")

def test_two_digits():
    assert(integer_to_english(12) == "twelve")
    assert(integer_to_english(20) == "twenty")
    assert(integer_to_english(50) == "fifty")
    assert(integer_to_english(75) == "seventy five")
    assert(integer_to_english(99) == "ninety nine")

def test_three_digits():
    assert(integer_to_english(100) == "one hundred")
    assert(integer_to_english(101) == "one hundred and one")
    assert(integer_to_english(110) == "one hundred and ten")
    assert(integer_to_english(120) == "one hundred and twenty")
    assert(integer_to_english(333) == "three hundred and thirty three")
    assert(integer_to_english(999) == "nine hundred and ninety nine")

def test_four_digits():
    assert(integer_to_english(1000) == "one thousand")
    assert(integer_to_english(1100) == "one thousand one hundred")
    assert(integer_to_english(2104) == "two thousand one hundred and four")
    assert(integer_to_english(2114) == "two thousand one hundred and fourteen")
    assert(integer_to_english(3330) == "three thousand three hundred and thirty")
    assert(integer_to_english(9999) == "nine thousand nine hundred and ninety nine")

def test_five_digits():
    assert(integer_to_english(10000) == "ten thousand")
    assert(integer_to_english(10100) == "ten thousand one hundred")
    assert(integer_to_english(20104) == "twenty thousand one hundred and four")
    assert(integer_to_english(42114) == "forty two thousand one hundred and fourteen")
    assert(integer_to_english(60000) == "sixty thousand")
    assert(integer_to_english(33330) == "thirty three thousand three hundred and thirty")
    assert(integer_to_english(99999) == "ninety nine thousand nine hundred and ninety nine")

def test_six_digits():
    assert(integer_to_english(100000) == "one hundred thousand")
    assert(integer_to_english(100100) == "one hundred thousand one hundred")
    assert(integer_to_english(210104) == "two hundred and ten thousand one hundred and four")
    assert(integer_to_english(421014) == "four hundred and twenty one thousand and fourteen")
    assert(integer_to_english(600000) == "six hundred thousand")
    assert(integer_to_english(333300) == "three hundred and thirty three thousand three hundred")
    assert(integer_to_english(999999) == "nine hundred and ninety nine thousand nine hundred and ninety nine")

def test_million():
    assert(integer_to_english(1000000) == "one million")
