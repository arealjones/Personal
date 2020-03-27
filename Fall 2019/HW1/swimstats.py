# CS 5001
# Fall 2019
# HW1 - Data Types and Arithmetic Operations

# TEST CASE 1
# distance = 3000m, pool size = 35m, time = 45:44 =>
# 85 laps, pace per 100m = 1:31, avg. speed = 3.9 km/hr
# TEST CASE 2
# distance = 800m, pool size = 20, time = 19:30 =>
# 40 laps, pace per 100m = 2:26, avg. speed = 2.5 km/hr
# TEST CASE 3
# distance = 1400m, pool size = 60, time = 31:19 =>
# 23 laps, pace per 100m = 2:14, avg. speed = 2.7 km/hr

# PURPOSE
# Returns the amount of laps swam.
# SIGNATURE
# calc_laps(num_distance, num_size) :: Int, Int => Float
# EXAMPLES
# calc_laps(1400, 60) => 23
# calc_laps(800, 20) => 40


def calc_laps(num_distance, num_size):
    return num_distance // num_size


# PURPOSE
# Returns the pace of the swimmer per 100m in minutes.
# SIGNATURE
# calc_pace(num_distance, num_minutes, num_seconds) ::
# Integer, Integer, Integer => Float
# EXAMPLES
# calc_pace(3000, 45 , 44) => 1.0
# calc_pace(800, 19, 30) => 2.0


def calc_pace(num_distance, num_minutes, num_seconds):
    minutes_in_seconds = num_minutes * 60
    total_seconds = minutes_in_seconds + num_seconds
    num_of_100m_in_distance = num_distance / 100
    pace_in_seconds = total_seconds // num_of_100m_in_distance
    pace_minutes = pace_in_seconds // 60
    return pace_minutes


# PURPOSE
# Returns the pace of the swimmer per 100m in seconds.
# SIGNATURE
# calc_pace_in_sec(num_distance, num_minutes, num_seconds) ::
# Integer, Integer, Integer => Float
# EXAMPLES
# calc_pace_in_sec(1400, 31 , 19) => 14.0
# calc_pace_in_sec(800, 19, 30) => 26.0


def calc_pace_in_sec(num_distance, num_minutes, num_seconds):
    minutes_in_seconds = num_minutes * 60
    total_seconds = minutes_in_seconds + num_seconds
    num_of_100m_in_distance = num_distance / 100
    pace_in_seconds = total_seconds // num_of_100m_in_distance
    pace_minutes = pace_in_seconds // 60
    pace_minutes_convert = pace_minutes * 60
    seconds = pace_in_seconds - pace_minutes_convert
    return seconds


# PURPOSE
# Returns the speed in kilometers per hour.
# SIGNATURE
# calc_speed(num_distance, num_minutes, num_seconds) ::
# Integer, Integer, Integer => Float
# EXAMPLES
# calc_speed(3000, 45 , 44) => 3.9
# calc_speed(800, 19, 30) => 2.5


def calc_speed(num_distance, num_minutes, num_seconds):
    full_min = round((num_seconds / 60), 1)
    min_in_hour = num_minutes + full_min
    rem_min_in_hour = 60 - min_in_hour
    percent_rem_min = rem_min_in_hour / min_in_hour
    km_per_hour = (((percent_rem_min * num_distance) + num_distance) / 1000)
    rounded_km = round(km_per_hour, 1)
    return rounded_km


# PURPOSE
# Formats the pace line that is shown to the user.
# SIGNATURE
# pace_line(pace_min, pace_sec) :: Int, Int => Str
# EXAMPLES
# pace_line(1, 31) => "Your pace per 100m was 1:31."
# pace_line(2, 26) => "Youe pace per 100m was 2:26."


def pace_line(pace_min, pace_sec):
    return "Your pace per 100m was {}:{}.".format(pace_min, pace_sec)


def main():
    distance = int(input("How many meters did you swim? "))
    size = int(input("How big was the pool in meters? "))
    print("How long did it take you, in minutes and seconds?")
    minutes = int(input("Enter the number of minutes first: "))
    seconds = int(input("Now enter the seconds: "))

    laps = calc_laps(distance, size)
    pace_min = int(calc_pace(distance, minutes, seconds))
    pace_sec = int(calc_pace_in_sec(distance, minutes, seconds))
    avg_speed = calc_speed(distance, minutes, seconds)

    print("You swam", laps, "laps.")
    print(pace_line(pace_min, pace_sec))
    print("Your average speed was", avg_speed, "km/hr.")


main()
