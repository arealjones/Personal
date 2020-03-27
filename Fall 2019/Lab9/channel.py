class Channel:
    def __init__(self, name, number, shows, schedule):
        self.name = name
        self.number = number
        self.shows = shows
        self.schedule = schedule

    def get_shows_by_actor(self, actor):
        actors_shows = []
        for show in self.shows:
            if show.cast_contains(actor):
                actors_shows.append(show)
        return actors_shows


    def channel_contains(self, show):
        if show in self.shows:
            return True
        return False

    def __str__(self):
        return "{} channel has the following schedule: {}".format(self.name, self.schedule)
