# PURPOSE
# Determines whether a given string meets all password requirements:
# 1) At least one lowercase letter
# 2) At least one uppercase letter
# 3) At least one number (0-9),
# 4) At least 1 special character: one of $, #, or @
# 5) Is 6 - 12 characters long (inclusive)
# SIGNATURE
# secure_password(secret) :: String => Boolean
# EXAMPLES
# secure_password(“password”) => False
# secure_password(“pA$$worD1”) => True
# secure_password("WaaaaayyyyT@@L@ng20") => False


def secure_password(secret):
    low = False
    up = False
    num = False
    special = False
    length = False
    MIN_LENGTH = 6
    MAX_LENGTH = 12
    special_chara = ["@", "#", "$"]
    if (MIN_LENGTH <= len(secret) <= MAX_LENGTH):
        length = True
    for chara in secret:
        if chara.islower():
            low = True
        elif chara.isupper():
            up = True
        elif chara.isnumeric():
            num = True
        elif chara in special_chara:
            special = True
    if (low is True and up is True and num is True
            and special is True and length is True):
        return True
    return False


def main():
    secret = input("Please enter your password: ")

    print(secure_password(secret))


main()
