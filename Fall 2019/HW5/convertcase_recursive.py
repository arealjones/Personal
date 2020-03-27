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
    if len(string) == 0:
        return string
    elif len(string) == 1 and string.isupper():
        return string.lower()
    elif len(string) == 1 and string.islower():
        return string.upper()
    else:
        if string[0].isupper():
            return string[0].lower() + convertcase(string[1:])
        else:
            return string[0].upper() + convertcase(string[1:])
