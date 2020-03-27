# PURPOSE
# Checks if there is a vowel in the string.
# SIGNATURE
# string_search(string) :: String => Bool
# EXAMPLES
# string_search("garage") => True
# string_search("ffff") => False
# string_search(" ") => False


def string_search(string):
    vowels = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
    if len(string) == 0:
        return False
    elif len(string) == 1:
        return (string[0] in vowels)
    else:
        return ((string[0] in vowels) or string_search(string[1:]))


# PURPOSE
# Checks if every string in the list has a vowel.
# SIGNATURE
# contains_vowel(list) :: List<String> => Bool
# EXAMPLES
# contains_vowel(["KNoCKK kNocK", "Whose", "there"]) => True
# contains_vowel(["monster mash", "crypt"]) => False
# contains_vowel([]) => False


def contains_vowel(lst):
    if len(lst) == 0 or len(lst) == 1 and string_search(lst[0]) is False:
        return False
    elif len(lst) == 1 and string_search(lst[0]) is True:
        return True
    else:
        return (string_search(lst[0])) and contains_vowel(lst[1:])
