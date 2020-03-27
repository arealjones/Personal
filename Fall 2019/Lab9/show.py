class Show:
    def __init__(self, title, members):
        self.title = title
        self.members = members

    def cast_contains(self, actor):
        if actor in self.members:
            return True
        return False

    def __str__(self):
        return self.title
