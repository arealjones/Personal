////////////////////////
////Areal Jones/////////
////March 25th, 2020////
////////////////////////

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

sem_t semaphor;

int main(int argc, char **argv) {
  FILE *f;
  int x;
  int sum;

  sem_init(&semaphor, 0, 1);

  if (argc != 5) {
    fprintf(stderr, "Usage: %s filename\n", argv[0]);
    exit(1);
  }

  // 1.The main thread should spawn the worker threads prior to reading the file
  for (int i = 0; i < argc[4]; i++) {
    pthread_t thread[i];
    pthread_create(&thread[i], NULL, /*function to find the number.*/, NULL);
  }

  // 2.The worker threads should not read the input file.
  // Pass a pointer to the array where the data will be when the threads are
  // spawned,then signal the threads when the data has been read into that array
  // 3.Each thread should update the array storing the line numbers where
  // <number to search for> was found

  f = fopen(argv[1], "r");

  if (f == 0) {
    perror(argv[1]);
    exit(2);
  }

  sum = 0;
  while(fscanf(f, "%d", &x) == 1) {
    printf("%d\n", x);
    sum += x;
  }

  printf("The sum is: %d\n", sum);
  fclose(f);
  //·4. The·main·thread·should·join·on·all·of·the·worker·threads.
  for (int i = 0; i < argc[4]; i++) {
    pthread_join(thread[i], NULL);
  }
  // 5. Print·out·the·line·numbers·where·the·<number·to·search·for>·was·found

  return 0;
}
