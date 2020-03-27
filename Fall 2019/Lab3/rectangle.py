def rect_top_bottom(width, height, chara):
    box = ""
    for i in range(0, height):
        if (i == 0) or (i == height-1):
            return box + (width * chara)


def rect_middle(width, chara):
    blank = " " * (width - 2)
    mid = (chara + blank + chara)
    return mid

def main():
    width = int(input("Please enter the width you would like it to be? "))
    height = int(input("Please enter the height you would like it to be? "))
    chara = input("Please enter the type of character you would like it to be? ")
    
    top_bottom = rect_top_bottom(width, height, chara)
    middle = rect_middle(width, chara)
    
    print(top_bottom)
    for i in range(1, height - 1):
        print(middle)
    print(top_bottom)


main()
