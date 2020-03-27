// Write a C program using the goto command and a label.
#include <stdio.h>


int main() {
   int product = 1;
   for (int i = 2; i <= 50; i++) {
     product = product * i;
     if (i == 15) {
       goto addition;
     }
   }
addition:
   printf("The product is %d.\n", product);


   return 0;
}
