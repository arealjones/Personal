import random
from playingcard import *

class DeckOfCards:
    #This is a tuple below.
    SUITS = ("Hearts", "Diamonds", "Spades", "Clubs")
    MIN_VAL = 1 # lowest value of a card i.e. the Ace
    MAX_VAL = 13 # highest value of a card i.e. the King

    def __init__(self):
        self.create_deck()


    # PURPOSE
    # Helper method to populate the deck of cards.
    # SIGNATURE
    # create_deck :: DeckOfCards => None
    def create_deck(self):
        self.cards = []
        for suit in self.SUITS:
            for i in range(self.MIN_VAL, self.MAX_VAL + 1):
                self.cards.append(PlayingCard(i, suit))

    
    # PURPOSE
    # Shuffles the cards in the deck.
    # SIGNATURE
    # shuffle :: DeckOfCards => None
    def shuffle(self):
        random.shuffle(self.cards)


    # PURPOSE
    # Returns the number of cards in the deck.
    # SIGNATURE 
    # num_cards_in_deck :: DeckOfCards => Integer
    def num_cards_in_deck(self):
        return len(self.cards)


    # PURPOSE
    # Removes and returns the last card in the deck. Hint: you will need a list
    # method for this one.
    # SIGNATURE
    # draw_card :: DeckOfCards => PlayingCard
    def draw_card(self):
        last = self.cards[-1]
        self.cards = self.cards[:-1]
        return last


    # PURPOSE
    # Adds the given card to the deck.
    # SIGNATURE
    # add_card :: DeckOfCards, PlayingCard => None
    # Since it goes to none, you do not want to return anything.
    def add_card(self, card):
        self.cards.append(card)

    # PURPOSE
    # Returns a string representation of the deck.
    # SIGNATURE
    # __str__ :: DeckOfCards => String   
    def __str__(self):
        msg = "Cards in deck: "
        for card in self.cards:
            msg += str(card) + ", "
        return msg
