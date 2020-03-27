class Actor:
    def __init__(self, first, last):
        self.first = first
        self.last = last
        self.shows = []


    def appears_in(self, show):
        return show in self.shows


    def __str__(self):
        return "{} {}".format(self.first, self.last)


    def __eq__(self, other):
        if type(self) == type(other):
            return self.first == other.first and self.last == other.last
        return False

