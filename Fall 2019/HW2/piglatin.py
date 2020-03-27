# PURPOSE
# Translates a word to pig latin. The word must contain only letters. If the
# word starts with a vowel, the suffix "ay" will be added to the end.
# Otherwise, the consonant cluster at the start of the word is moved to the end
# then the suffix "ay" is added.
# SIGNATURE
# pig_latin_translator :: String => String
# EXAMPLES
# pig_latin_translator("pig") => "igpay"
# pig_latin_translator("123") => "Invalid word!"
# pig_latin_translator("apple") => "appleay"


def pig_latin_translator(word):
    alpha = word.isalpha()
    vowels = ["a", "e", "i", "o", "u", "A", "E", "I", "O", "U"]
    if not alpha:
        return "Invalid word!"
    for letter in word:
        for vowel in vowels:
            if vowel == letter:
                ind = word.index(vowel)
                return word[ind:] + word[:ind] + "ay"
    return word + "ay"


def main():
    word = str(input("Please enter a word. "))

    print(pig_latin_translator(word))


main()
