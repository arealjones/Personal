def valid_path(file_path):
    try:
        file = open(file_path, "r")
        file.close()
    except FileNotFoundError:
        print("File not found!")
        return False

def valid_contents(file_path):
    list_of_contents = []
    file = open(file_path, "r")
    for line in file:
            if ("\t") in line:
                parts = line.split("\t")
                parts[0] = parts[0].strip()
                parts[1] = parts[1].strip()
                list_of_contents += [parts]
            else:
                print("Error processing the file. ")
                return False
    file.close()
    return list_of_contents


def create_collections(file, list_of_contents, num):
    with open(file, "w") as file:
        for i in list_of_contents:
            if i[1] == num:
                file.write(i[0] + "\n")
    file.close()  

def separate_list(list_of_contents, num):
    new_list = []
    for i in list_of_contents:
        if i[1] == num:
            new_list += [i[0]]
    return new_list

def separate_choice(choice):
    if choice == "q":
        return choice
    if " " in choice:
        choice = choice.split(" ")
        if choice[-1].isdigit():
            choice[-1] = (int(choice[-1]))
            if len(choice) == 2:
                if (choice[0] == "p") or (choice[0] == "q") or (choice[0] == "n"):
                    if choice[-1] >= 0:
                        return choice
                    print("Please enter a positive number.")
                    return False
                print("Please choose p, n, or q.")
                return False
            print("Please only enter a letter and a positive number. ")
            return False
        print("Please only enter a letter and a positive number. ")
        return False
    print("Please include a space. ")
    return False
        
    
def display_review(new_choice, positive_list, negative_list):
    if new_choice[0] == "q":
            return True
    if new_choice[0] == "p":
        try:
            print(positive_list[int(new_choice[1])])
        except IndexError:
            print("Review number must be between 0-499")
        except ValueError:
            print("Review number must be a valid integer.")
    if new_choice[0] == "n":
        try:
            print(negative_list[int(new_choice[1])])
        except IndexError:
            print("Review number must be between 0-499")
        except ValueError:
            print("Review number must be a valid integer.")


def main():
    path = input("Enter the path to the IMDB dataset: ")
    while valid_path(path) == False:
        path = input("Enter the path to the IMDB dataset: ")
    while valid_contents(path) == False:
        path = input("Enter the path to the IMDB dataset: ")

    list_of_contents = (valid_contents(path))
    neg_file = "negative.txt"
    pos_file = "positive.txt"

    create_collections(neg_file, list_of_contents, "0")
    create_collections(pos_file, list_of_contents, "1")
    negative_list = separate_list(list_of_contents, "0")
    positive_list = separate_list(list_of_contents, "1")
    
    print("Please enter one of the following letters and the index number (as an integer) to see the review. Press Q to exit.")
    print("p index number: To see a positive review on a specific line.")
    print("n index number: To see a negative review on a specific line.")
    print("q: Quit")
    choice = input("Please make a choice: ")

    new_choice = separate_choice(choice)

    while new_choice == False:
        new_choice = input("Please make a choice: ")
        new_choice = separate_choice(new_choice)

    while display_review(new_choice, positive_list, negative_list) != True:
        new_choice = input("Please make a choice: ")
        new_choice = separate_choice(new_choice)

main()
