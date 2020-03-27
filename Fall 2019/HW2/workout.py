# PURPOSE
# Takes the users input and returns a workout and how long to do it.
# SIGNATURE
# i_workout(day_valid, temp_valid, day, holi_bool, rain_bool, duration) ::
# Bool/Str, Bool/Str, Str, Bool, Bool, Bool => Str
# EXAMPLES
# i_workout(True, True, "M", True, False, True)
# => "Go for a hike for 45 minutes."
# i_workout(True, True, "Tu", False, True, False) => "Rest today."
# i_workout(False, True, "Sa", True, True, False)
# => "Go swimming for 35 minutes."


def i_workout(day_valid, temp_valid, day, holi_bool, rain_bool, duration):
    rest = ["Tu", "Th", "Su"]
    workout = ["M", "W", "F", "Sa"]
    run = ["M", "W", "F"]
    if not day_valid or not temp_valid or holi_bool == "NA" \
            or rain_bool == "NA" or duration == "NA":
        return "Go swim for 35 minutes."
    elif (day in rest and not holi_bool):
        return "Rest today."
    elif (not rain_bool and (holi_bool or day == "Sa")):
        return "Go for a hike for 45 minutes."
    elif (rain_bool and ((day in workout) or holi_bool)):
        return "Go swimming for 45 minutes."
    elif ((day in run) and duration):
        return "Go for a run for 30 minutes."
    elif ((day in run) and not duration):
        return "Go for a run for 45 minutes."
    else:
        return "Go swim for 35 minutes."


# PURPOSE
# Checks if the users input of day is valid.
# SIGNATURE
# day_true(day) :: Str => Bool
# EXAMPLES
# day_true("F") => True
# day_true("Sa") => True
# day_true("Tuesday") => False


def day_true(day):
    all_days = ["M", "Tu", "W", "Th", "F", "Sa", "Su"]
    for i in range(len(all_days)):
        if (all_days[i] == day):
            return True
    return False


# PURPOSE
# Checks if the users input of temp is a valid number.
# SIGNATURE
# temp_is_int(temp) :: Str => Bool
# EXAMPLES
# temp_is_int("13") => True
# temp_is_int("76") => True
# temp_is_int("twenty") => False


def temp_is_int(temp):
    return temp.isdigit()


# PURPOSE
# Converts the users input of temp into a true or false.
# SIGNATURE
# time(temp, temp_valid) :: Str, Bool => Bool or Str
# EXAMPLES
# time("89", True) => True
# time("56", True) => False
# time("eleven", False) => "NA"


def time(temp, temp_valid):
    if temp_valid:
        if int(temp) < 35 or int(temp) > 75:
            return True
        elif 35 < int(temp) < 75:
            return False
    else:
        return "NA"


# PURPOSE
# Converts the users input of holi or rain into a true, False, or "NA".
# SIGNATURE
# is_holi_or_rain(user) :: Str => Bool or Str
# EXAMPLES
# is_holi_or_rain("yes") => True
# is_holi_or_rain("n") => False
# is_holi_or_rain("I dont know") => "NA"


def is_holi_or_rain(user):
    if user == "Yes" or user == "yes" or user == "y" or user == "Y":
        return True
    elif user == "No" or user == "no" or user == "n" or user == "N":
        return False
    else:
        return "NA"


def main():
    print("Please enter your answer in the format provided in the question.")
    print("If you do not, you will not receive an accurate activity to do.")
    day = str(input("What day of the week is it (M, Tu, W, Th, F, Sa, Su)? "))
    holi = str(input("Is it a holiday (Yes/No)? "))
    rain = str(input("Is it raining (Yes/No)? "))
    temp = (input("What is the temperature (numbers only)? "))

    temp_valid = temp_is_int(temp)
    holi_bool = is_holi_or_rain(holi)
    rain_bool = is_holi_or_rain(rain)
    duration = time(temp, temp_valid)
    day_valid = day_true(day)

    print(i_workout(day_valid, temp_valid, day, holi_bool, rain_bool, duration))


main()
