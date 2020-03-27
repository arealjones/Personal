'''
Task 1: implement the missing methods in deckofcards.py (signatures provided)
Task 2: implement the following "magic" trick in main(). You will need to import
the DeckOfCards class.
- Create a deck of cards and shuffle it.
- Prompt the user to press any key to draw a card from the deck. You will need 
to save their choice.
- Print their card.
- Return the card to the deck and shuffle it.
- Repeat the following steps until the original card is found: prompt the user 
to press any key to draw a card. Provide feedback e.g. You drew... There are
N cards remaining.

'''
from deckofcards import DeckOfCards


def main():
    deck = DeckOfCards()
    deck.shuffle()
    input("Press a key to draw a card. ")
    last = deck.draw_card()
    print("Your choose card is: {}".format(last))
    print("Returning the card to the deck...")
    deck.add_card(last)
    deck.shuffle()

    card_found = False
    while not card_found and deck.num_cards_in_deck() > 0:
        input("Press a key to draw a card. ")
        new_card = deck.draw_card()
        print("Your choose card is: {}".format(new_card))
        #if card == new_card:

main()
