# PURPOSE
# Converts the uppercase letters to lowercase and
# vice versa.
# SIGNATURE
# convertcase(string) :: String => String
# EXAMPLES
# convertcase("HALLOween") => "halloWEEN"
# convertcase("HeLlO") => "hElLo"
# convertcase("hi") => "HI"


def convertcase(string):
    word = ""
    for letter in string:
        if letter.isupper():
            word += letter.lower()
        else:
            word += letter.upper()
    return word


def main():
    string = input("Please enter a word to convert. ")
    while (string.isnumeric() or string.isspace() or not string):
        string = input("Invalid. Please try again. ")
    print(convertcase(string))


main()
