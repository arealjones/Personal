def logarithm(user):
  if user % 2 != 0:
    return 0
  else:
    return 1 + logarithm(user/2)


def main():
    user = int(input("Enter a positive power of 2. "))

    entered = str(user)
    answer = str(logarithm(user))

    print("lg(" + entered + ") = " + answer)


main()
