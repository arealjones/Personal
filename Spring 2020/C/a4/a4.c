////////////////////
// Areal Jones
// February 14, 2020
////////////////////

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

#include "a4.h"

#define kPrintDebug 1

Hand* CreateHand() {
  Hand* h = (Hand*)malloc(sizeof(Hand));
  h->first_card = NULL;
  h->num_cards_in_hand = 0;
  return h;
}

void AddCardToHand(Card *card, Hand *hand) {
  if (hand->num_cards_in_hand == 5) {
    return;
  }
  CardNode* card_node = (CardNode*)malloc(sizeof(CardNode));
  card_node->this_card = card;
  card_node->next_card = NULL;
  card_node->prev_card = NULL;
  if (hand->first_card == NULL) {
    hand->first_card = card_node;
  } else {
    card_node->next_card = hand->first_card;
    hand->first_card->prev_card = card_node;
    hand->first_card = card_node;
  }
  hand->num_cards_in_hand += 1;
}

Card* RemoveCardFromHand(Card *card, Hand *hand) {
  if (hand->num_cards_in_hand == 0) {
    return NULL;
  }
  CardNode* temp;
  temp = hand->first_card;
  while ((temp != NULL) && (temp->this_card != card)) {
    temp = temp->next_card;
  }
  if (temp == NULL) {
    return NULL;
  } else if (temp->prev_card == NULL) {
    hand->first_card = temp->next_card;
    hand->num_cards_in_hand -= 1;
    if (hand->num_cards_in_hand >= 1) {
      hand->first_card->prev_card = NULL;
    }
  } else if (temp->next_card != NULL) {
    temp->prev_card->next_card = temp->next_card;
    temp->next_card->prev_card = temp->prev_card;
    hand->num_cards_in_hand -= 1;
  } else if (temp->next_card == NULL) {
    temp->prev_card->next_card = NULL;
    hand->num_cards_in_hand -= 1;
    if (hand->num_cards_in_hand == 0) {
      hand->first_card = NULL;
    }
  }
  free(temp);
  return card;
}

int IsHandEmpty(Hand* hand) {
  if (hand->num_cards_in_hand == 0) {
    return 1;
  }
  return 0;
}

void DestroyHand(Hand* hand) {
  while (hand->first_card != NULL) {
    free(RemoveCardFromHand(hand->first_card->this_card, hand));
  }
  free(hand);
}

int IsLegalMove(Hand *hand, Card *lead_card, Card *played_card) {
  if (played_card->suit == lead_card->suit) {
    return 1;
  } else {
    CardNode* temp;
    temp = hand->first_card;
    while (temp->next_card) {
      if (temp->this_card->suit == lead_card->suit) {
        return 0;
      } else {
        temp = temp->next_card;
      }
    }
    return 1;
  }
}

int WhoWon(Card *lead_card, Card *followed_card, Suit trump) {
  if (lead_card->suit == followed_card->suit) {
    if (lead_card->name > followed_card->name) {
      return 1;
    } else {
      return 0;
    }
  } else {
    if (trump == followed_card->suit) {
      return 0;
    } else {
      return 1;
    }
  }
}

void ReturnHandToDeck(Hand *hand, Deck *deck) {
  CardNode* card = hand->first_card;
  while (card != NULL) {
    CardNode* next_card = card->next_card;
    PushCardToDeck(RemoveCardFromHand(card->this_card, hand), deck);
    card = next_card;
  }
}
