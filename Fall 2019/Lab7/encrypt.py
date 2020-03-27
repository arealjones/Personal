LOW_ASCII = 97
HIGH_ASCII = 122

def lower(word):
    for i in range(len(word)):
        if word[i].isupper():
            return word.lower()
    return word
        

def encrypt(lowercase, n):
    new_str = ""
    for i in lowercase:
        num = ord(i)
        if LOW_ASCII <= num < (HIGH_ASCII - n):
            new_str += chr(num + n)
        elif (HIGH_ASCII - n) <= num <= HIGH_ASCII:
            dif = HIGH_ASCII - num
            new_n = n - dif - 1
            new_str += chr(LOW_ASCII + new_n)
        elif num == HIGH_ASCII:
            new_str += chr(LOW_ASCII + n-1)
        else:
            new_str += i
    return new_str


def slide_up(word, t):
    new_str = ""
    for i in range(len(word)):
        #last index
        if i == (len(word)-1):
            new_str += word[0+t-1]
        elif i >= int(len(word)-t):
            new_str += word[-1]
        else:
            new_str += word[i + t]
    return new_str

word = "abc"
t = 2

print(slide_up(word, t))

def slide_down(word, t):
    new_str = ""
    for i in range(len(word)):
        if i == 0:
            new_str += word[1]
        elif i == (len(word)-1):
            new_str += word[0]
        else:
            new_str += word[1 + t]
    return new_str


def decrypt(crypt, n):
    new_str = ""
    for i in crypt:
        num = ord(i)
        if (LOW_ASCII + n) <= num <= HIGH_ASCII:
            new_str += chr(num - n)
        elif LOW_ASCII <= num <= (LOW_ASCII + n):
            dif = (LOW_ASCII + n) - num
            new_str += chr(HIGH_ASCII - dif+1)
        elif num == LOW_ASCII:
            new_str += chr(HIGH_ASCII - n)
        else:
            new_str += i
    return new_str


# def main():
#     word = input("Please enter an english statement. ")
#     n = int(input("Please enter the amount you would like to shift. "))
#     t = int(input("Please enter the amount you would like to slide. "))
#     lowercase = lower(word)
#     right = slide_up(lowercase, t)
#     crypt = encrypt(right, n)
#     print("Your encrypted word is:", crypt)
#     not_crypt = decrypt(right, n)
#     print("Your decrypted word is:", not_crypt)
    
# main()
