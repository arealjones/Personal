// Write a C program called array.c that has an array of 400 integers in the function of main.
#include <stdio.h>
#include <stdlib.h>

#define FOURHUNDRED 400

int main() {
  int array[FOURHUNDRED];
  array[0]=72;
  array[70]=56;
  printf("%d\n", array[0]);
  printf("%d\n", array[70]);
  return 1;
}
