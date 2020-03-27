
def days_until_fri(index_of_current):
    days = ["Sa", "Su", "M", "Tu", "W", "Th", "F"]
    friday = (len(days) - 1)
    return (friday - index_of_current)


def index_day(current):
    days = ["Sa", "Su", "M", "Tu", "W", "Th", "F"]
    return int(days.index(current))


def valid(current):
    days = ["Sa", "Su", "M", "Tu", "W", "Th", "F"]
    if current in days:
        return True
    return False


def main():
    name = input("What is your name? ")
    print("Hello,", name)
    current = input("What is the current day of the week (Sa, Su, M, Tu, W, Th, F)? ")
    while not valid(current):
        current = input("Invalid input, please enter it in the following format: (Sa, Su, M, Tu, W, Th, F) ")

    index_of_current = index_day(current)

    print("The number of days remaining until Friday are: ", days_until_fri(index_of_current))

main()
