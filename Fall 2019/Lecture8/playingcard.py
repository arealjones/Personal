class PlayingCard:
    face = None

    def __init__(self, val, suit):
        self.value = val
        self.suit = suit
        self.auto_set_face(val)

    # PURPOSE
    # Automatically set the face for the relevant cards
    # SIGNATURE
    # auto_set_face :: (Object, Int) => Void
    def auto_set_face(self, a):
        if a == 1:
            self.face = "Ace"
        elif a == 11:
            self.face = "Jack"
        elif a == 12:
            self.face = "Queen"
        elif a == 13:
            self.face = "King"
        
    # PURPOSE
    # Return a string representation of the playing card
    # e.g. "10 of diamonds", "Jack of hearts"
    # SIGNATURE
    # __str__ :: Object => String
    def __str__(self):
        if self.face == None:
            return str(self.value) + " of " + self.suit
        else:
            return self.face + " of " + self.suit

    # PURPOSE
    # Implements comparison using ==. Returns True if the current object's value
    # is equal to the value of the comparison object and the suits are equal
    # SIGNATURE
    # __eq__ :: (Object, Object) => Boolean
    def __eq__(self, other):
        return self.value == other.value and self.suit == other.suit

