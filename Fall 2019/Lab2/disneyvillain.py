#Villain options: Ursula, Wicked Stepmother, or Mother Gothel
# Users Character Options:
# A x x: Wicked Stepmother
# A A B: Wicked Stepmother
# A A C: Wicked Stepmother
# A B x: Wicked Stepmother
# A C x: Wicked Stepmother
# B x x: Ursula 
# C A A: Mother Gothel
# C A B: Mother Gothel
# C A C: Mother Gothel
# C B x: Mother Gothel
# C C x: Mother Gothel
def user_chara(despise, animal, angry):
    if (despise == "A") and (animal == "A" or "B" or "C") and (angry == "A" or "B" or "C"):
        return "You are the Wicked Stepmother"
    elif (despise == "B") and (animal == "A" or "B" or "C") and (angry == "A" or "B" or "C"):
        return "You are Ursula"
    else:
        return "You are Mother Gothel"


def main():
    print("If You Were A Female Disney Villain, Which One Would You Be?")
    print("Which princess do you despise? ")
    despise = str(input("A. Ariel B. Rapunzel C. Cinderella ")).upper()
    
    print("If you were an animal, what would you be? ")
    animal = str(input("A. Lizard B. Cat C. Eel ")).upper()
        
    print("Why are you so angry? ")
    angry = str(input("A. My family annoys me B. I'm jealous of someone C. Pretty girls think they're better than me. ")).upper()

    print(user_chara(despise, animal, angry))

main()
