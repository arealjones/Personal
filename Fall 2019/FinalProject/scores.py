

class Scores:

    # PURPOSE
    # Constructor for the Scores class.
    # SIGNATURE
    # __init__ :: Scores, Users Name, Score => Score

    def __init__(self, name, score):
        self.name = name
        self.score = score
    # PURPOSE
    # Checks to see if the file has already been created, aka if its the first
    # or second turn.
    # SIGNATURE
    # valid_path :: Scores, File Path => Boolean

    def valid_path(self, file_path):
        try:
            file = open(file_path, "r")
            file.close()
            return True
        except FileNotFoundError:
            return False
    # PURPOSE
    # This will read the file if it has already been created by someone elses
    # turn. It will convert the contents into a nested list.
    # SIGNATURE
    # read_file :: Scores, File Path => List

    def read_file(self, file_path):
        lst_users = []
        file = open(file_path, "r")
        for line in file:
            if (" ") in line:
                parts = line.split(" ")
                score = [0, 0]
                if len(parts) > 2:
                    score[1] = int(parts[-1].strip())
                    parts.pop()
                    new_str = ""
                    for i in range(len(parts)):
                        new_str += parts[i]
                        new_str += " "
                    new_str = new_str.strip()
                    score[0] = new_str
                    lst_users += [score]
                else:
                    parts = line.split(" ")
                    score[0] = parts[0].strip()
                    score[1] = int(parts[1].strip())
                    lst_users += [score]
        file.close()
        return lst_users
    # PURPOSE
    # Organizes the list that was returned from reading the file from highest
    # score to lowest.
    # SIGNATURE
    # org_list :: Scores, File Path => List

    def org_list(self, file_path):
        list_plays = self.read_file(file_path)
        leng = len(list_plays)
        for i in range(0, leng):
            for j in range(0, leng - i - 1):
                if (list_plays[j][1] < list_plays[j + 1][1]):
                    temp = list_plays[j]
                    list_plays[j] = list_plays[j + 1]
                    list_plays[j + 1] = temp
        return list_plays
    # PURPOSE
    # Adds the users name and score to the end of the list and then
    # reorganizes it from highest score to lowest.
    # SIGNATURE
    # add_to_list:: Scores, File Path, Score => List

    def add_to_list(self, file_path, score):
        org_file = self.org_list(file_path)
        org_file.append([str(score.name), score.score])
        leng = len(org_file)
        for i in range(0, leng):
            for j in range(0, leng - i - 1):
                if (org_file[j][1] < org_file[j + 1][1]):
                    temp = org_file[j]
                    org_file[j] = org_file[j + 1]
                    org_file[j + 1] = temp
        return org_file
    # PURPOSE
    # Appends the file with all of the users names and scores from highest
    # to lowest.
    # SIGNATURE
    # append_file :: Scores, File Path, Score => None

    def append_file(self, file_path, score):
        org_file = self.add_to_list(file_path, score)
        file = open(file_path, "w")
        for person in org_file:
            file.write(person[0] + " " + str(person[1]) + "\n")
        file.close()
    # PURPOSE
    # Creates the file if the path wasnt found and adds the users name and
    # score.
    # SIGNATURE
    # create_file :: Scores, File Path, score => None

    def create_file(self, file_path, score):
        file = open(file_path, "w")
        file.write(score.name + " " + str(score.score) + "\n")
        file.close()
