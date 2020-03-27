// Write a C program called array2.c that has an array of 400 integers in the function of main that is dynamically allocated.
#include <stdio.h>
#include <stdlib.h>

#define FOURHUNDRED 400

int main() {
  int *array = (int*)malloc(FOURHUNDRED*sizeof(int));
  array[66] = 712;
  array[70] = 536;
  printf("%d\n", array[66]);
  printf("%d\n", array[70]);
  free(array);
  return 0;
}
