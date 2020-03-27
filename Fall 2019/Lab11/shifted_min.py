def find_min(lst):
    first_ind = lst[0]
    last_ind = lst[-1]
    if first_ind <= last_ind:
        return first_ind
    else:
        mid = (len(lst) // 2)
        if lst[mid] < last_ind:
            return find_min(lst[:mid+1])
        else:
            return find_min(lst[mid:])



def main():
    lst = [18, 25, 38, 1, 12, 13]

    print(find_min(lst))

main()
