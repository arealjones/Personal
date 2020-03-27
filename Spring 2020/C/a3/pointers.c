///////////////////
// Areal Jones
// Jan 31, 2020
///////////////////
#include <stdio.h>

void doubler(int *x){
  *x *= 2;

}

int sumArray(int n, const int *a) {
  int i;
  int sum;
  sum = 0;
  for (int i=0; i<n; i++) {
    sum += a[i];
  }

  return sum;
}

//This is practicing what I've learned from a book I bought on C.
void goSouthEast(int *lat, int *lon) {
  *lat = *lat - 1;
  *lon = *lon + 1;
}

int main(int argc, char **argv) {
  int y;
  y = 1;
  doubler(&y);
  printf("%d\n", y);

  int a[50];
  void *p;

  a[12] = 17;
  p = a;

  printf("%d\n", ((int *) p)[12]);
  
  //Outside practice.
  int latitude = 32;
  int longitude = -64;
  goSouthEast(&latitude, &longitude);
  printf("Avast! Now at: [%i, %i]\n", latitude, longitude);
  
  return 0;
}
