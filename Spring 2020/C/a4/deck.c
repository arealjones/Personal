////////////////////
// Areal Jones
// February 14, 2020
////////////////////

#include <stdio.h>
#include <stdlib.h>

#include "a4.h"

#define PRINT_DEBUG 1

Deck* CreateDeck() {
  Deck* d = (Deck*)malloc(sizeof(Deck));
  d->top_card = -1;
  return d;
}

Deck* PushCardToDeck(Card* card, Deck* deck) {
  if (deck->top_card == kNumCardsInDeck - 1) {
    return NULL;
  }
  deck->top_card += 1;
  deck->cards[deck->top_card] = card;
  return deck;
}

Card* CreateCard(Suit suit, Name name) {
  int value_of_card;
  Card* card = (Card*)malloc(sizeof(Card));
  switch (name) {
    case NINE: value_of_card = 9;
    case TEN: value_of_card = 10;
    case JACK: value_of_card = 11;
    case QUEEN: value_of_card = 12;
    case KING: value_of_card = 13;
    case ACE: value_of_card = 14;
  }
  card->name = name;
  card->suit = suit;
  card->value = value_of_card;
  return card;
}

Deck* PopulateDeck() {
  Deck* d = CreateDeck();
  for (int i = NINE; i <= ACE; i++) {
    for (int j = HEARTS; j <= DIAMONDS; j++) {
      PushCardToDeck(CreateCard(j, i)/*card*/, d);
    }
  }
  return d;
}

Card* PeekAtTopCard(Deck* deck) {
  if (deck->top_card == -1) {
    return NULL;
  }
  Card* card = deck->cards[deck->top_card];
  return card;
}

Card* PopCardFromDeck(Deck* deck) {
  if (deck->top_card == -1) {
    return NULL;
  }
  Card* card = deck->cards[deck->top_card];
  deck->cards[deck->top_card] = NULL;
  deck->top_card -= 1;
  return card;
}

int IsDeckEmpty(Deck* deck) {
  if (deck->top_card == -1) {
    return 1;
  }
  return 0;
}

void Shuffle(Deck *deck) {
  int kMinimumValue = 0;
  int kMaximumValue = 23;
  int randomNumber1 = (kMinimumValue +
                       (rand() % (kMaximumValue - kMinimumValue)));
  int randomNumber2 = (kMinimumValue +
                       (rand() % (kMaximumValue - kMinimumValue)));
  Card* cards[kNumCardsInDeck];
  for (int i = 0; i < kNumCardsInDeck; i++) {
    cards[i] = PopCardFromDeck(deck);
  }
  Card* temp = cards[randomNumber1];
  cards[randomNumber1] = cards[randomNumber2];
  cards[randomNumber2] = temp;
  for (int i = 0; i < kNumCardsInDeck; i++) {
    PushCardToDeck(cards[i], deck);
  }
}

void Deal(Deck *aDeck, Hand *p1hand, Hand *p2hand) {
  for (int i = 0; i < 5; i++) {
    AddCardToHand(aDeck->cards[aDeck->top_card], p1hand);
    aDeck->top_card -= 1;
    AddCardToHand(aDeck->cards[aDeck->top_card], p2hand);
    aDeck->top_card -= 1;
  }
}

void DestroyCard(Card* card) {
  free(card);
}

void DestroyDeck(Deck* deck) {
  while (deck->top_card != -1) {
    DestroyCard(PopCardFromDeck(deck));
  }
  free(deck);
}
