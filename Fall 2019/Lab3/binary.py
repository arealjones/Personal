def binary_change(user):
    if len(user) == 0:
        return 0
    else:
        num = user[0]
        rest = user[1:]
        return int(num) * 2**(len(user) -1) + binary_change(rest)


# def main():
#     user = str(input("Please enter a binary string. "))


#     print(binary_change(user))



# main()
