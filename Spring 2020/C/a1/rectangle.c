// This function will print a rectangle based on the height and width provided.
#include<stdio.h>

void PrintRectangle(int width, int height) {
  if ((width<=0)||(height<=0)) {
    return;
  } else {
      for (int i=0; i<height; i++) {
        for (int j=0; j<width; j++) {
          if ((i==0)||(i==height-1)) {
            printf("-");
          } else {
            if ((j==0)||(j==width-1)) {
              printf("-");
            } else {
              printf(" ");
            }
          }
        }
        printf("\n");
      }
  }
}

// This function will print a fancy rectangle. 
void PrintFancyRectangle(int width, int height, char symbol, int fill) {
  if ((width<=0)||(height<=0)||(fill<0)||(fill>1)) {
    return;
  } else {
      for (int i=0; i<height; i++) {
        for (int j=0; j<width; j++) {
          if ((i==0)||(i==height-1)) {
            printf("%c", symbol);
          } else {
            if ((j==0)||(j==width-1)||(fill==1)) {
              printf("%c", symbol);
            } else {
              printf(" ");
            }
          }
        }
        printf("\n");
      }
  }
}

int main(){
  PrintRectangle(-4, 8);
  PrintRectangle(7, -3);
  PrintRectangle(8, 8);
  PrintRectangle(6, 7);
  PrintRectangle(0, 0);
  PrintRectangle(0, 5);
  
  PrintFancyRectangle(8, 6, '*', 1);
  PrintFancyRectangle(-1, 3, '#', 0);
  PrintFancyRectangle(-4, 5, '^', 1);
  PrintFancyRectangle(4, 5, 'a', 1);
  PrintFancyRectangle(10, 11, '1', 1);
  PrintFancyRectangle(3, 8, 'H', 1);
  PrintFancyRectangle(4, 2, '~', 1);
}
