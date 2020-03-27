**Assignment 2 Report**

**Experiment Summary:**
This experiment was to test the merge sort with different sizes of arrays and see how many comparisons it does and how quickly it runs through it. The result was that Merge Sort iterates much faster than a different type of sort such as Bubblesort. 

How many items I sorted:
* Small Array: 8 elements.
* Medium Array: 1024 elements.
* Large Array: 32768 elements.

**Experiment Result:**

How many comparisons it took to sort each array of items:
* Small: 19 comparisons.
* Medium: 24063 comparisons.
* Large: 1753087 comparisons.

How long each sort took:
* Small: 0.000001 seconds.
* Medium: 000409 seconds.
* Large: 0.014745 seconds.

**Details of Experiment:**

**What should the difference be between the arrays?**
In my opinion, I think there should be a big enough gap to show the difference in comparisons but not too big where it takes a decent amount of seconds to run.

**What size for the small array is the smallest that makes sense?**
I thought the smallest that made sense was eight elements so you can see the number of comparisons it does a bit better. You could drop it down to four elements but I thought that might be too small to really see the difference between the small, medium and large arrays.

**What size for the large array makes sense?**
I thought 2^15 would be a good size for the large array. It is big enough to show the difference in comparisons and seconds but doesn’t overload the screen too much or take too much time to run.


**Recommendations:**

After running the experiment, I believe using the Merge Sort is much better than using the Bubble Sort due to the speed of completion and fewer comparisons it takes to sort the array.

**What's a bound on the number of comparisons Bubblesort will do on a list of the same size?**
A bound on the number of comparisons Bubble Sort will do is n^2. 

**How does this algorithm compare to Bubble Sort?**
This merge sort algorithm should have a bound of n log n. It sorts faster than the Bubble Sort because it isn’t iterating through every time with the first number. Merge Sort continues to break the array in half and switching any necessary integers. 