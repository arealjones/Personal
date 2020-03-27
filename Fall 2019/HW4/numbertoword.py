MIN_NUM = 0
MAX_NUM = 1000000


# PURPOSE
# Takes a positive integer and converts it to list of
# its individual digits, in order.
# SIGNATURE
# num_to_digits(num) :: Integer => List<Integer>
# EXAMPlES
# num_to_digits(101) => [1, 0, 1]
# num_to_digits(25) => [2, 5]


def num_to_digits(num):
    if num < MIN_NUM or num > MAX_NUM:
        return False
    num_string = str(num)
    digit_list = list(num_string)
    for i, digit in enumerate(digit_list):
        digit_list[i] = int(digit)
    return digit_list


# PURPOSE
# Takes a list of integers and concatenates the digit
# to make a single, valid
# integer. This is the reverse of num_to_digits.
# SIGNATURE
# list_to_num(list) :: List<Integer> => Integer
# EXAMPLES
# list_to_num([1, 0, 3]) => 103
# list_to_num([0, 1, 4, 0]) => 140


def list_to_num(num_list):
    for i, num in enumerate(num_list):
        num_list[i] = str(num)
    return int("".join(num_list))


# PURPOSE
# Checks if a list of integers contains only zeros.
# SIGNATURE
# all_zeros(list) :: List<Integer> => Boolean
# EXAMPLES
# all_zeros([0,0,0]) => True
# all_zeros([1,2,0]) => False


def all_zeros(num_list):
    for num in num_list:
        if num != 0:
            return False
    return True


# PURPOSE
# Converts an integer between 0 and 100000 to words.
# Returns "Invalid input!" if the input is invalid.
# SIGNATURE
# integer_to_english(num) :: Integer => String
# EXAMPLES
# integer_to_english(101) => "one hundred and one"
# integer_to_english(598104) => "five hundred and ninety
# eight thousand one hundred and four"
# integer_to_english(-1) => "Invalid input!"


def integer_to_english(num):
    BASE = ["zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eigteen", "nineteen"]
    TENS = ["", "ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"]
    MAX_BASE = 20
    digits = num_to_digits(num)
    if not digits:
        return "Invalid input!"
    length = len(digits)
    if num < MAX_BASE:
        return BASE[num]
    elif num == MAX_NUM:
        return "one million"
    else:
        if length == 2:
            if digits[-1] == 0:
                return TENS[digits[0]]
            else:
                return TENS[digits[0]] + " " + BASE[digits[-1]]
        elif length == 3:
            if all_zeros(digits[1:]):
                return BASE[digits[0]] + " hundred"
            else:
                return BASE[digits[0]] + " hundred and " \
                    + integer_to_english(list_to_num(digits[1:]))
        elif length == 4:
            if all_zeros(digits[1:]):
                return BASE[digits[0]] + " thousand"
            else:
                return BASE[digits[0]] + " thousand " + \
                    integer_to_english(list_to_num(digits[1:]))
        elif length == 5:
            if all_zeros(digits[1:]):
                return integer_to_english(list_to_num(digits[:2])) + \
                    " thousand"
            else:
                return integer_to_english(list_to_num(digits[:2])) + \
                    " thousand " + integer_to_english(list_to_num(digits[2:]))
        else:
            if all_zeros(digits[1:]):
                return integer_to_english(list_to_num(digits[:3])) + \
                    " thousand"
            elif all_zeros(digits[3:4]):
                return integer_to_english(list_to_num(digits[:3])) + \
                    " thousand and " + \
                    integer_to_english(list_to_num(digits[3:]))
            else:
                return integer_to_english(list_to_num(digits[:3])) + \
                    " thousand " + integer_to_english(list_to_num(digits[3:]))
