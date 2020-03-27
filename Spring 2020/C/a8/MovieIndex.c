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
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "MovieIndex.h"
#include "htll/LinkedList.h"
#include "htll/Hashtable.h"
#include "Movie.h"
#include "MovieSet.h"
#define RATINGSIZE 10

void DestroyMovieSetWrapper(void *movie_set) {
  DestroyMovieSet((MovieSet)movie_set);
}

void toLower(char *str, int len) {
  for (int i = 0; i < len; i++) {
    str[i] = tolower(str[i]);
  }
}

Index BuildMovieIndex(LinkedList movies, enum IndexField field_to_index) {
  Index movie_index = CreateIndex();

  // STEP 4(Student): Check that there is at least one movie
  // What happens if there is not at least one movie?
  LLIter iter = CreateLLIter(movies);
  Movie* cur_movie;
  LLIterGetPayload(iter, (void**)&cur_movie);
  if (movies == NULL) {
    return NULL;
  }

  AddMovieToIndex(movie_index, cur_movie, field_to_index);

  while (LLIterHasNext(iter)) {
    LLIterNext(iter);
    LLIterGetPayload(iter, (void**)&cur_movie);
    AddMovieToIndex(movie_index, cur_movie, field_to_index);
  }
  DestroyLLIter(iter);
  return movie_index;
}


int AddMovieActorsToIndex(Index index, Movie *movie) {
  HTKeyValue kvp;
  HTKeyValue old_kvp;

  // STEP 6(Student): Add movies to the index via actors.
  //  Similar to STEP 5.

  int i = 0;

  uint64_t key = FNVHash64((unsigned char*)movie->actor_list[i],
                           strlen(movie->actor_list[i]));
  int result = LookupInHashtable(index, key, &kvp);

  if (result < 0) {
    kvp.value = CreateMovieSet(movie->actor_list[i]);
    kvp.key = key;
    PutInHashtable(index, kvp, &old_kvp);
  }

  AddMovieToSet((MovieSet)kvp.value, movie);
  return 0;
}

int AddMovieToIndex(Index index, Movie *movie, enum IndexField field) {
  if (field == Actor) {
    return AddMovieActorsToIndex(index, movie);
  }

  HTKeyValue kvp;
  // I'm adding the following line.
  HTKeyValue old_kvp;
  kvp.key = ComputeKey(movie, field, 0);

  // STEP 5(Student): How do we add movies to the index?
  // The general idea:
  // Check hashtable to see if relevant MovieSet already exists
  // If it does, grab access to it from the hashtable
  // If it doesn't, create the new MovieSet and get the pointer to it
  // Put the new MovieSet into the Hashtable.

  int result = LookupInHashtable(index, kvp.key, &kvp);

  if (result < 0) {
    char* type_set_name;
    char rating[RATINGSIZE];
    switch (field) {
      case Genre:
        type_set_name = movie->genre;
        break;
      case StarRating:
        snprintf(rating, RATINGSIZE, "%f", movie->star_rating);
        type_set_name = rating;
        break;
      case ContentRating:
        type_set_name = movie->content_rating;
        break;
      default:
        type_set_name = "Default";
        break;
    }
    kvp.value = CreateMovieSet(type_set_name);
    PutInHashtable(index, kvp, &old_kvp);
  }

  // After we either created or retrieved the MovieSet from the Hashtable:
  AddMovieToSet((MovieSet)kvp.value, movie);

  return 0;
}

uint64_t ComputeKey(Movie* movie, enum IndexField which_field,
                    int which_actor) {
  char rating_str[RATINGSIZE];
  switch (which_field) {
    case Genre:
      return FNVHash64((unsigned char*)movie->genre, strlen(movie->genre));
    case StarRating:
      snprintf(rating_str, RATINGSIZE, "%f", movie->star_rating);
      return FNVHash64((unsigned char*)rating_str, strlen(rating_str));
    case ContentRating:
      return FNVHash64((unsigned char*)movie->content_rating,
                       strlen(movie->content_rating));
    case Actor:
      if (which_actor < movie->num_actors) {
        return FNVHash64((unsigned char*)movie->actor_list[which_actor],
                         strlen(movie->actor_list[which_actor]));
      }
      break;
  }
  return -1u;
}

// Removed for simplicity
// MovieSet GetMovieSet(Index index, const char *term){}

int DestroyIndex(Index index) {
  DestroyHashtable(index, &DestroyMovieSetWrapper);
  return 0;
}

Index CreateIndex() {
  return CreateHashtable(128);
}
