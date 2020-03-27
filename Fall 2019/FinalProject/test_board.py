from board import Board


def test_count_tiles():
    b = Board(8)
    assert(b.count_tiles(2) == 2)
    assert(b.count_tiles(1) == 2)


def test_check_directions():
    b = Board(8)
    assert(b.check_directions(3, 3, 1, 2) == [0, 0, 0, 0, 0, 0, 0, 0])
    assert(b.check_directions(3, 4, 2, 1) == [0, 0, 0, 0, 0, 0, 0, 0])
    assert(b.check_directions(4, 3, 1, 2) == [0, 0, 0, 0, 0, 0, 0, 0])
    assert(b.check_directions(4, 4, 2, 1) == [0, 0, 0, 0, 0, 0, 0, 0])


def test_check_ai_directions():
    b = Board(8)
    assert(b.check_ai_directions(3, 3, 2, 1) == [[3, 5], [5, 3]])
    assert(b.check_ai_directions(4, 4, 2, 1) == [[4, 2], [2, 4]])


def test_check_tiles():
    b = Board(8)
    assert(b.check_tiles(3, 4) == 1)
    assert(b.check_tiles(4, 4) == 2)
    assert(b.check_tiles(0, 0) == 0)
    assert(b.check_tiles(7, 7) == 0)


def test_in_bounds():
    b = Board(8)
    assert(b.in_bounds(2, 1) is True)
    assert(b.in_bounds(8, 1) is False)
    assert(b.in_bounds(4, 5) is True)
    assert(b.in_bounds(0, 8) is False)


def test_ai_turn():
    b = Board(8)
    assert(b.ai_turn(2, 1) == [2, 4])


def test_empty_tiles():
    b = Board(8)
    assert(b.empty_tiles(1, 2) == [[3, 2], [5, 4], [4, 5], [2, 3]])
    assert(b.empty_tiles(2, 1) == [[3, 5], [5, 3], [4, 2], [2, 4]])


def test_getcenter():
    b = Board(8)
    assert(b.get_center(2, 6) == (-50.0, -125.0))
    assert(b.get_center(1, 4) == (-100.0, -25.0))
    assert(b.get_center(7, 7) == (200.0, -175.0))
    assert(b.get_center(3, 5) == (0.0, -75.0))


def test_conv_coord():
    b = Board(8)
    assert(b.conv_coord(-155, 103) == (0, 1))
    assert(b.conv_coord(195, -35) == (7, 4))
    assert(b.conv_coord(23, 67) == (4, 2))
    assert(b.conv_coord(115, -145) == (6, 6))


def test_valid_move():
    b = Board(8)
    assert(b.valid_move(2, 3, 1, 2) is True)
    assert(b.valid_move(2, 4, 2, 1) is True)
    assert(b.valid_move(6, 5, 1, 2) is False)
    assert(b.valid_move(1, 3, 2, 1) is False)


def test_check_left():
    b = Board(8)
    assert(b.check_left(4, 3, 1, 2) == 0)
    assert(b.check_left(3, 3, 1, 2) == 0)


def test_check_right():
    b = Board(8)
    assert(b.check_right(4, 3, 1, 2) == 0)
    assert(b.check_right(3, 3, 1, 2) == 0)


def test_check_up():
    b = Board(8)
    assert(b.check_up(4, 3, 1, 2) == 0)
    assert(b.check_up(3, 3, 1, 2) == 0)


def test_check_down():
    b = Board(8)
    assert(b.check_down(4, 3, 1, 2) == 0)
    assert(b.check_down(3, 3, 1, 2) == 0)


def test_check_diag_upright():
    b = Board(8)
    assert(b.check_diag_upright(4, 3, 1, 2) == 0)
    assert(b.check_diag_upright(3, 3, 1, 2) == 0)


def test_check_diag_upleft():
    b = Board(8)
    assert(b.check_diag_upleft(4, 3, 1, 2) == 0)
    assert(b.check_diag_upleft(3, 3, 1, 2) == 0)


def test_check_diag_downleft():
    b = Board(8)
    assert(b.check_diag_downleft(4, 3, 1, 2) == 0)
    assert(b.check_diag_downleft(3, 3, 1, 2) == 0)


def test_check_diag_downright():
    b = Board(8)
    assert(b.check_diag_downright(4, 3, 1, 2) == 0)
    assert(b.check_diag_downright(3, 3, 1, 2) == 0)


def test_check_ai_left():
    b = Board(8)
    assert(b.check_ai_left(4, 4, 2, 1) == [4, 2])
    assert(b.check_ai_left(3, 3, 2, 1) is None)


def test_check_ai_right():
    b = Board(8)
    assert(b.check_ai_right(4, 4, 2, 1) is None)
    assert(b.check_ai_right(3, 3, 2, 1) == [3, 5])


def test_check_ai_up():
    b = Board(8)
    assert(b.check_ai_up(4, 4, 2, 1) == [2, 4])
    assert(b.check_ai_up(3, 3, 2, 1) is None)


def test_check_ai_down():
    b = Board(8)
    assert(b.check_ai_down(4, 4, 2, 1) is None)
    assert(b.check_ai_down(3, 3, 2, 1) == [5, 3])


def test_check_ai_diag_upright():
    b = Board(8)
    assert(b.check_ai_diag_upright(4, 4, 2, 1) is None)
    assert(b.check_ai_diag_upright(3, 3, 2, 1) is None)


def test_check_ai_diag_upleft():
    b = Board(8)
    assert(b.check_ai_diag_upleft(4, 4, 2, 1) is None)
    assert(b.check_ai_diag_upleft(3, 3, 2, 1) is None)


def test_check_ai_diag_downleft():
    b = Board(8)
    assert(b.check_ai_diag_downleft(4, 4, 2, 1) is None)
    assert(b.check_ai_diag_downleft(3, 3, 2, 1) is None)


def test_check_ai_diag_downright():
    b = Board(8)
    assert(b.check_ai_diag_downright(4, 4, 2, 1) is None)
    assert(b.check_ai_diag_downright(3, 3, 2, 1) is None)
