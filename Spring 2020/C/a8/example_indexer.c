/*
  ////////////////////////////
  /////Areal Jones////////////
  /////March 21, 2020/////////
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
#include <assert.h>
#include <string.h>

#include <ctype.h>
#include <unistd.h>


#include "htll/LinkedList.h"
#include "MovieIndex.h"
#include "Movie.h"
#include "MovieReport.h"
#include "./FileParser.h"

void DestroyNothing(void* thing) {
  // Helper method to destroy the LinkedList.
}

int main(int argc, char* argv[]) {
  // STEP 8(Student): Check args, do the right thing.
  int option;
  enum IndexField whichField;

  while ((option = getopt(argc, argv, "scag")) != -1) {
    switch (option) {
      case 's':
        whichField = StarRating;
        break;
      case 'c':
        whichField = ContentRating;
        break;
      case 'a':
        whichField = Actor;
        break;
      case 'g':
        whichField = Genre;
        break;
      default:
        abort();
    }
  }

  char* filename = argv[optind];
  LinkedList movie_list  = ReadFile(filename);
  Index index = BuildMovieIndex(movie_list, whichField);
  // STEP 9(Student): Create the index properly.

  PrintReport(index);
  DestroyLinkedList(movie_list, &DestroyNothing);
  DestroyIndex(index);

  return 0;
}
