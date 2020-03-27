# PURPOSE
# Checks if the user entered a number then calculates
# the total number from the upc code.
# SIGNATURE
# upc_calc(code) :: String => Integer
# EXAMPLES
# Monster Energy Drink
# upc_calc("070847811169") => 90
# Candy: Milk Duds
# upc_calc("010700021526") => 30
# Garbanzo Beans
# upc_calc("072273391642") => 80
# upc_calc("red") => 0


def upc_calc(code):
    total = 0
    if code.isnumeric():
        reverse = (code[::-1])
        for i in range(len(reverse)):
            if (i % 2 == 0):
                total += (int(reverse[i]))
            else:
                total += ((int(reverse[i])) * 3)
        return total
    else:
        return total


# PURPOSE
# Determines if the user input is valid/invalid.
# SIGNATURE
# valid(code) :: String => String
# EXAMPLES
# Monster Energy Drink
# valid("070847811169") => "Valid"
# valid("") => "Invalid"
# valid("12345") => "Invalid"
# Garbanzo Beans
# valid("072273391642") => "Valid"
# valid("24") => "Valid"


def valid(code):
    total = upc_calc(code)
    MULT_OF_TEN = 10
    if (total % MULT_OF_TEN == 0) and (total > 0):
        return "Valid"
    else:
        return "Invalid"


def main():
    code = input("Please enter a upc code. ")

    print(valid(code))


main()
