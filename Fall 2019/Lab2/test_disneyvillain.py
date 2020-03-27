from disneyvillain import user_chara


def test_user_chara():
    assert(user_chara("A", "B", "A") == "You are the Wicked Stepmother")
    assert(user_chara("C", "C", "B") == "You are Mother Gothel")
    assert(user_chara("B", "A", "C") == "You are Ursula")
    assert(user_chara("A", "C", "B") == "You are the Wicked Stepmother")
