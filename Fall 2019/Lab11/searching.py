def binary_search(lst, num):
    if (len(lst) == 0):
        return False
    else:
        mid = (len(lst) // 2)
        if num == lst[mid]:
            return True
        elif num < lst[mid]:
            return binary_search(lst[:mid], num)
        else:
            return binary_search(lst[mid+1:], num)


def main():
    num = 4
    lst = [10, 45, 34, 17, 6, 28, 4, 66, 23]
    lst.sort()

    print(binary_search(lst, num))



main()
