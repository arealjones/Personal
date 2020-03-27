from actor import Actor
from show import Show
from channel import Channel


def shows_starring(actor, available_channels):
    shows = []
    for channel in available_channels:
        shows += channel.get_shows_by_actor(actor)
    return shows


def shows_on_days(day, channel):
    for show in channel:
        if day in show.title:
            return channel.shows


def main():
    actor1 = Actor("Actor", "1")
    actor2 = Actor("Actor", "2")
    actor3 = Actor("Actor", "3")
    show1 = Show("Monday Show", [actor1, actor2])
    show2 = Show("Tuesday Show", [actor1, actor2, actor3])
    show3 = Show("Wednesday Show", [actor2, actor3])
    channel1 = Channel("DEF", 42, [show1], "Show 1 plays on Mondays")
    channel2 = Channel("XYZ", 31, [show2, show3], "Show 2 plays on Tuesdays and Show 3 plays on Wednesdays")

    channels = set([channel1, channel2])
    shows = shows_starring(actor1, channels)
    for show in shows:
        print(show)

    print(channel1.channel_contains(show1))

    print(channel1)
    print(channel2)

    print(shows_on_days("Monday", channel1.shows))



main()
