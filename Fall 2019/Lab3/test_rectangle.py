from rectangle import rect_top_bottom, rect_middle


def test_rect_top_bottom():
    assert(rect_top_bottom(4, 6, "*") == "****")
    assert(rect_top_bottom(10, 3, "!") == "!!!!!!!!!!")
    assert(rect_top_bottom(7, 5, "$") == "$$$$$$$")
    assert(rect_top_bottom(2, 8, ".") == "..")


def test_rect_middle():
    assert(rect_middle(4, "*") == "*  *")
    assert(rect_middle(10, "!") == "!        !")
    assert(rect_middle(7, "$") == "$     $")
    assert(rect_middle(2, ".") == "..")
