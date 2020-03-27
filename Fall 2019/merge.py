

# PURPOSE
# Sorts a list using the Merge Sort algorithm.
# SIGNATURE
# merge_sort :: List<?> => None
def merge_sort(lst):
    if len(lst) > 1:
        # Find the mid point
        mid = len(lst) // 2
        # Split
        left_half = lst[:mid]
        right_half = lst[mid:]
        
        # Recursively call merge_sort on each half
        merge_sort(left_half)
        merge_sort(right_half)
        
        # Merge the two halves
        merge(lst, left_half, right_half)


# PURPOSE
# Helper function that performs the merge step of Merge Stort
# SIGNATURE
# merge :: List<?>, List<?>, List<?> => None
def merge(lst, left, right):
    i = 0 # Our position in the left list
    j = 0 # Our position in the right list
    k = 0 # Our position in lst
  
    # As long as there are items in left AND right
    while i < len(left) and j < len(right):
        if left[i] < right[j]:
            lst[k] = left[i]
            i += 1
        else:
            lst[k] = right[j]
            j += 1
        k += 1
    
    # If only the left list has items
    while i < len(left):
        lst[k] = left[i]
        i += 1
        k += 1
    
    # if only the right list has items
    while j < len(right):
        lst[k] = right[j]
        j += 1
        k += 1

def main():
    desserts = ["carrot", "banana", "pecan", "apple", "pumpkin"]
    merge_sort(desserts)
    print("Sorted desserts =", desserts)

main()
