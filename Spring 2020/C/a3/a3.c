///////////////////
// Areal Jones
// Jan 31, 2020
///////////////////

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include "a3.h"


// YOUR CODE GOES HERE

// Print the string <first> <middle> <last>
//  e.g. if first = "Ben", middle = "Ivan",
//  and last = "Bitdiddle, then print:
//  "Ben Ivan Bitdiddle".
//
//  If the middle name is NULL, then print:
//  "Ben Bitdiddle"
//
//  name: a pointer to a Name
void Big(Name *name) {
  if (name->middle) {
    printf("%s %s %s\n", name->first, name->middle, name->last);
  } else {
    printf("%s %s\n", name->first, name->last);
  }
}

// Print the string <last>, <first>
//  e.g. if first = "Ben", middle = "Ivan",
//  and last = "Bitdiddle, then print:
//  "Bitdiddle, Ben".
//
// name: a pointer to a Name
void Last(Name *name) {
  printf("%s, %s\n", name->last, name->first);
}

// Print the string <first> <last>
//  e.g. if first = "Ben", middle = "Ivan",
//  and last = "Bitdiddle, then print:
//  "Ben Bitdiddle".
//
// name: a pointer to a Name
void Reg(Name *name) {
  printf("%s %s\n", name->first, name->last);
}

// Print the string <first> <middle-initial>. <last>
//  e.g. if first = "Ben", middle = "Ivan",
//  and last = "Bitdiddle, then print:
//  "Ben I. Bitdiddle".
//
// If middle name is NULL, print:
// "Ben Bitdiddle"
//
// name: a pointer to a Name
void Mid(Name *name) {
  if (name->middle) {
    printf("%s %c %s\n", name->first, name->middle[0], name->last);
  } else {
    printf("%s %s\n", name->first, name->last);
  }
}

// Print the first name only.
//  e.g. if first = "Ben", middle = "Ivan",
//  and last = "Bitdiddle, then print:
//  "Ben".
//
// name: a pointer to a Name
void Small(Name *name) {
  printf("%s\n", name->first);
}
// Given a format char, print the given
// name in the format specified by char.
// The mapping is shown below:
// B -> 'big' format
// L -> 'last' format
// R -> 'reg' format
// M -> 'mid' format
// S -> 'small' format
//
// name: a pointer to a Name
// format: a char indicating the format to use (case doesn't matter)
void FormatName(Name *name, char format) {
  if ((format >= 97) && (format <= 122)) {
    format -= 32;
  }
  switch (format) {
  case 'B':
    printf("Big Name Format: ");
    Big(name);
    printf("\n");
    break;
  case 'L':
    printf("Last Name Format: ");
    Last(name);
    printf("\n");
    break;
  case 'R':
    printf("Reg Name Format: ");
    Reg(name);
    printf("\n");
    break;
  case 'M':
    printf("Mid Name Format: ");
    Mid(name);
    printf("\n");
    break;
  case 'S':
    printf("Small Name Format: ");
    Small(name);
    printf("\n");
    break;
  default:
    printf("Illegal input of format, please try again.\n");
    break;
  }
}

// Given a name, a format and a destination array,
// put the properly formatted name in the destination
// array, not printing anything on the screen.
//
// The mapping is shown below:
// B -> 'big' format
// L -> 'last' format
// R -> 'reg' format
// M -> 'mid' format
// S -> 'small' format
//
// name: a pointer to a Name
// format: a char indicating the format to use (case doesn't matter)
// dest: a pointer to an array that is guaranteed to be big enough
// to hold the formatted name
void FillName(Name *name, char format, char *dest) {
  int middleLen = 0;
  if (name->middle) {
    middleLen = strlen(name->middle);
  }
  int firstLen = strlen(name->first);
  int lastLen = strlen(name->last);
  int middleSpaces = 3;
  int noMiddleSpaces = 2;
  int noSpaces = 1;
  int spaceAndComma = 3;
  if ((format >= 97) && (format <= 122)) {
    format -= 32;
  }
  switch (format) {
  case 'B':
    if (name->middle) {
      printf("Big Name Format: ");
      snprintf(dest, (firstLen + middleLen + lastLen + middleSpaces), \
               "%s %s %s\n", name->first, name->middle, name->last);
    } else {
      printf("Big Name Format: ");
      snprintf(dest, (firstLen + lastLen + noMiddleSpaces), \
               "%s %s\n", name->first, name->last);
    }
    break;
  case 'L':
    printf("Last Name Format: ");
    snprintf(dest, (firstLen + lastLen + spaceAndComma), \
             "%s, %s\n", name->last, name->first);
    break;
  case 'R':
    printf("Reg Name Format: ");
    snprintf(dest, (firstLen + lastLen + noMiddleSpaces), \
             "%s %s\n", name->first, name->last);
    break;
  case 'M':
    if (name->middle) {
      printf("Mid Name Format: ");
      snprintf(dest, (firstLen + middleLen + lastLen + middleSpaces), \
               "%s %c %s\n", name->first, name->middle[0], name->last);
    } else {
      printf("Mid Name Format: ");
      snprintf(dest, (firstLen + lastLen + noMiddleSpaces), \
               "%s %s\n", name->first, name->last);
    }
    break;
  case 'S':
    printf("Small Name Format: ");
    snprintf(dest, (firstLen + noSpaces), "%s\n", name->first);
    break;
  default:
    printf("Illegal input of format, please try again.\n");
    break;
  }
}
