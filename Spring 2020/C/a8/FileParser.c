/*
  ////////////////////////////
  /////Areal·Jones////////////
  /////March·21,·2020/////////
  ////////////////////////////

 *  Adrienne Slaughter
 *  5007 Spr 2020
 *
 *  This is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  It is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  See <http://www.gnu.org/licenses/>.
 */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>
#include <ctype.h>
#include <string.h>

#include "FileParser.h"
#include "Movie.h"
#include "MovieIndex.h"

#define NUM_FIELDS 6
#define MAX_ROW_LENGTH 1000
#define MAX_NUM_ACTORS 10

char* CheckAndAllocateString(char* token) {
  if (strcmp("-", token) == 0) {
    return NULL;
  } else {
    char *out = (char *) malloc((strlen(token) + 1) * sizeof(char));
    snprintf(out, strlen(token) + 1, "%s", token);
    return out;
  }
}

int CheckInt(char* token) {
  if (strcmp("-", token) == 0) {
    return -1;
  } else {
    return atoi(token);
  }
}

double CheckDouble(char* token) {
  if (strcmp("-", token) == 0) {
    return -1;
  } else {
    return atof(token);
  }
}

Movie* CreateMovieFromRow(char *data_row) {
  Movie* mov = CreateMovie();
  if (mov == NULL) {
    printf("Couldn't create a Movie.\n");
    return NULL;
  }

  // STEP 2(Student): Parse the row to create and populate a Movie.
  // Use the strtok

  char *data_row_copy = data_row;
  char* tokens[NUM_FIELDS];
  for (int i = 0; i < NUM_FIELDS; i++) {
    tokens[i] = strtok_r(data_row_copy, "|", &data_row_copy);
    if (tokens[i] == NULL) {
      return NULL;
    }
  }

  mov->star_rating = CheckDouble(tokens[0]);
  mov->title = CheckAndAllocateString(tokens[1]);
  mov->content_rating = CheckAndAllocateString(tokens[2]);
  mov->genre = CheckAndAllocateString(tokens[3]);
  mov->duration = CheckInt(tokens[4]);

  char* actors_in_data = tokens[5];
  char* actors[MAX_NUM_ACTORS];

  int i = 0;
  char* temp = strtok_r(actors_in_data, ",", &actors_in_data);
  for (; temp != NULL; temp = strtok_r(NULL, ",", &actors_in_data)) {
    actors[i] = temp;
    i++;
  }
  mov->num_actors = i;
  mov->actor_list = (char**)malloc(mov->num_actors*(sizeof(char*)));
  for (int i = 0; i < mov->num_actors; i++) {
    mov->actor_list[i] = CheckAndAllocateString(actors[i]);
  }

  return mov;
}

// Returns a LinkedList of Movie structs from the specified file
LinkedList ReadFile(char* filename) {
  FILE *cfPtr;

  LinkedList movie_list = CreateLinkedList();

  if ((cfPtr = fopen(filename, "r")) == NULL) {
    printf("File could not be opened\n");
    DestroyLinkedList(movie_list, NULL);
    return NULL;
  } else {
    char* row = NULL;
    ssize_t read;
    size_t len = 0;

    while ((read = getline(&row, &len, cfPtr)) != -1) {
      // Got the line; create a movie from it
      MoviePtr movie = CreateMovieFromRow(row);
      if (movie != NULL) {
        InsertLinkedList(movie_list, movie);
      }
    }
    free(row);
    fclose(cfPtr);
  }
  return movie_list;
}
