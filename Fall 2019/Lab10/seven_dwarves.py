def read_file(file_path):
    dwarves = {}
    with open(file_path, "r") as file:
        for line in file:
            dwarf = line.split(" ").split("\n")
            dwarves[dwarf[0]] = set(dwarf[1:])
    return dwarves


def valid_dwarf(name, dwarves):
    return name.title() in dwarves


def print_friends(dwarves, which_dwarf):
    for dwarf in dwarves[which_dwarf]:
        print(dwarf)

def unfriending(path, dwarves, which_dwarf, unfriend):
    if unfriend in dwarves[which_dwarf]:
        dwarves[which_dwarf].remove(unfriend)
        with open(file_path, "w") as file:
            for line in file:
                file.write()


def main():
    path = "dwarves.txt"
    dwarves = read_file(path)

    which_dwarf = input("Which of the 7 is logging in? ")
    while valid_dwarf(which_dwarf, dwarves) == False:
        print("Invalid user. Please try again.")
        which_dwarf = input("Which of the 7 is logging in? ")

    choice = input("Choose from one of the options below \n P: Print friends list \n U: Unfriend someone \n F: Add a new friend \n Q: Quit \n")
    
    if choice is "P":
        print_friends(dwarves, which_dwarf)
    if choice is "U":
        print("Here is your current friend list ")
        print_friends(dwarves, which_dwarf)
        unfriend = input("Who do you want to unfriend? ")


main()
