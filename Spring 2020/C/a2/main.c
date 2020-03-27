#include <stdio.h>
#include "sort.h"
#include <stdlib.h>
#include <time.h>

void RandomNumbers(int array[], int size) {
  int kMinimumValue = 0;
  int kMaximumValue = 5000;
  for (int i = 0; i < size; i++) {
    array[i] = (kMinimumValue + (rand() % (kMaximumValue - kMinimumValue)));
  }
}

void PrintingArrays(int array[], int size) {
  for (int i = 0; i < size; i++) {
    printf("%d ", array[i]);
  }
}

int main() {
  // Creating the arrays.
  int small[8];
  RandomNumbers(small, 8);
  int medium[1024];
  RandomNumbers(medium, 1024);
  int large[32768];
  RandomNumbers(large, 32768);

  printf("-----------------------------------\n");
  // Printing and sorting the small array.
  printf("Unsorted Small Array: \n");
  PrintingArrays(small, 8);
  printf("\n");
  printf("-----------------------------------\n");
  printf("Sorted Small Array: \n");
  clock_t t;
  t = clock();
  int smallcompare = Sort(small, 8);
  t = clock() - t;
  double time = ((double)t)/CLOCKS_PER_SEC;
  PrintingArrays(small, 8);
  printf("\n");
  printf("-----------------------------------\n");
  // Printing and sorting the medium array.
  printf("Unsorted Medium Array: \n");
  PrintingArrays(medium, 1024);
  printf("\n");
  printf("-----------------------------------\n");
  printf("Sorted Medium Array: \n");
  clock_t m;
  m = clock();
  int mediumcompare = Sort(medium, 1024);
  m = clock() - m;
  double time2 = ((double)m)/CLOCKS_PER_SEC;
  PrintingArrays(medium, 1024);
  printf("\n");
  printf("-----------------------------------\n");
  // Printing and sorting the large array.
  printf("Unsorted Large Array: \n");
  PrintingArrays(large, 32768);
  printf("\n");
  printf("-----------------------------------\n");
  printf("Sorted Large Array: \n");
  clock_t n;
  n = clock();
  int largecompare = Sort(large, 32768);
  n = clock() - n;
  double time3 = ((double)n)/CLOCKS_PER_SEC;
  PrintingArrays(large, 32768);
  printf("\n");
  printf("-----------------------------------\n");
  printf("SORTING:\n");
  printf("Small: ");
  printf("%d elements, ", 8);
  printf("%d comparions, %f seconds.\n", smallcompare, time);
  printf("Medium: ");
  printf("%d elements, ", 1024);
  printf("%d comparions, %f seconds.\n", mediumcompare, time2);
  printf("Large: ");
  printf("%d elements, ", 32768);
  printf("%d comparions, %f seconds.\n", largecompare, time3);
}
