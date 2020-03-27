import turtle
import time
from scores import Scores

SQUARE = 50


class Board:
    colors = ("black", "white")
    tiles_on_board = [
        [0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 2, 1, 0, 0, 0],
        [0, 0, 0, 1, 2, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0],
        [0, 0, 0, 0, 0, 0, 0, 0],
    ]

    # PURPOSE
    # Constructor for the Board class. size should be an even integer.
    # SIGNATURE
    # __init__ :: Board, Integer => Board

    def __init__(self, size):
        self.size = size
        self.high_bound = SQUARE * size / 2
        self.low_bound = 0 - self.high_bound
        self.remaining_tiles = 60
        self.black_tile = 2
        self.white_tile = 2
        self.username = None
    # PURPOSE
    # Draws the board.
    # SIGNATURE
    # draw_board :: Board => None

    def draw_board(self):
        NUM_SIDES = 4
        RIGHT_ANGLE = 90
        turtle.setup(self.size * SQUARE + 50, self.size * SQUARE + 150)
        turtle.screensize(self.size * SQUARE, self.size * SQUARE)
        turtle.bgcolor("white")
        # turtle.penup()
        # turtle.hideturtle()
        # turtle.setposition(-190, 250)
        # turtle.write("Black Tile Count: ", font=("Arial", 12, "normal"))
        # turtle.setposition(-190, 230)
        # turtle.write("White Tile Count: ", font=("Arial", 12, "normal"))

        # Create the turtle to draw the board
        self.othello = turtle.Turtle()
        self.othello.penup()
        self.othello.speed(0)
        self.othello.hideturtle()

        # Line color is black, fill color is green
        self.othello.color("black", "blue")

        # Move the turtle to the upper left corner
        corner = -self.size * SQUARE / 2
        self.othello.setposition(corner, corner)

        # Draw the green background
        self.othello.begin_fill()
        for i in range(NUM_SIDES):
            self.othello.pendown()
            self.othello.forward(SQUARE * self.size)
            self.othello.left(RIGHT_ANGLE)
        self.othello.end_fill()

        # Draw the horizontal lines
        for i in range(self.size + 1):
            self.othello.setposition(corner, SQUARE * i + corner)
            self.draw_lines(self.othello, self.size)

        # Draw the vertical lines
        self.othello.left(RIGHT_ANGLE)
        for i in range(self.size + 1):
            self.othello.setposition(SQUARE * i + corner, corner)
            self.draw_lines(self.othello, self.size)

        # Sets the first turn for black.
        self.turn = "black"
        # Nested list of the empty and filled positions on the board.
        # 0 is empty, 1 is black, 2 is white.
        self.tiles_on_board = [
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 2, 1, 0, 0, 0],
            [0, 0, 0, 1, 2, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
            [0, 0, 0, 0, 0, 0, 0, 0],
        ]
        self.file_path = "scores.txt"

        # Draw the 4 start pieces
        self.start_pieces()

        # Get the reference to the screen
        screen = turtle.Screen()

        # This is the tile of the screen to welcome the player.
        screen.title("Welcome to Othello!")

        # Listens for click events and alternates between the players.
        screen.onclick(self.whose_turn)

        # Stops the window from closing
        turtle.done()
    # PURPOSE
    # Helper function to update the black and white tile counts after each
    # turn.
    # SIGNATURE
    # count_tiles :: Board, Integer => Integer

    def count_tiles(self, integer):
        count = 0
        for entry in self.tiles_on_board:
            for i in entry:
                if i == integer:
                    count += 1
        return count


    def tile_count(self, integer, x_loc, y_loc):
        #turtle.penup()
        turtle.setposition(x_loc, y_loc)
        turtle.write(integer, font=("Arial", 12, "normal"))
        #turtle.penup()
        turtle.setposition(x_loc, y_loc)
        turtle.pendown()
        turtle.begin_fill()
        turtle.color("white", "black")
        turtle.shape("square")
        turtle.end_fill()
        # turtle.penup()
        # turtle.setposition(x_loc, y_loc)
        # turtle.write(integer, font=("Arial", 12, "normal"))

    # PURPOSE
    # Helper function to draw the lines on the board
    # SIGNATURE
    # draw_lines :: Board, Turtle, Integer => None

    def draw_lines(self, turt, n):
        turt.pendown()
        turt.forward(SQUARE * n)
        turt.penup()
    # PURPOSE
    # Converts the users clicks into the proper col and row number.
    # SIGNATURE
    # conv_coord :: Board, Integer, Integer => (Integer, Integer)

    def conv_coord(self, x, y):
        QUARDRANTS = 4
        col = int(((SQUARE * QUARDRANTS + x) // SQUARE))
        row = int(((SQUARE * QUARDRANTS - y) // SQUARE))
        return(col, row)
    # PURPOSE
    # Helper function to check each direction for another tile of both the
    # user and computer. Its searching for itself.
    # SIGNATURE
    # check_directions :: Board, Int, Int, Int, Int  => List

    def check_directions(self, col, row, num1, num2):
        valid_spaces = []
        valid_spaces.append(self.check_left(col, row, num1, num2))
        valid_spaces.append(self.check_right(col, row, num1, num2))
        valid_spaces.append(self.check_up(col, row, num1, num2))
        valid_spaces.append(self.check_down(col, row, num1, num2))
        valid_spaces.append(self.check_diag_downleft(col, row, num1, num2))
        valid_spaces.append(self.check_diag_downright(col, row, num1, num2))
        valid_spaces.append(self.check_diag_upleft(col, row, num1, num2))
        valid_spaces.append(self.check_diag_upright(col, row, num1, num2))
        return valid_spaces
    # PURPOSE
    # Helper function to flip the correct tiles in each direction based on the
    # location of where the user/computer chooses to place a tile.
    # SIGNATURE
    # flip_directions :: Board, Int, Int, Int, Int, Str  => None

    def flip_directions(self, col, row, num1, num2, color):
        self.flip_left(col, row, num1, num2, color)
        self.flip_right(col, row, num1, num2, color)
        self.flip_up(col, row, num1, num2, color)
        self.flip_down(col, row, num1, num2, color)
        self.flip_diag_upright(col, row, num1, num2, color)
        self.flip_diag_upleft(col, row, num1, num2, color)
        self.flip_diag_downleft(col, row, num1, num2, color)
        self.flip_diag_downright(col, row, num1, num2, color)
    # PURPOSE
    # Helper function to check each direction for an empty tile for the
    # computer to place a piece.
    # SIGNATURE
    # check_ai_directions :: Board, Int, Int, Int, Int  => List

    def check_ai_directions(self, col, row, n1, n2):
        valid_spaces = []
        if type(self.check_ai_left(col, row, n1, n2)) == list:
            valid_spaces.append(self.check_ai_left(col, row, n1, n2))
        if type(self.check_ai_right(col, row, n1, n2)) == list:
            valid_spaces.append(self.check_ai_right(col, row, n1, n2))
        if type(self.check_ai_up(col, row, n1, n2)) == list:
            valid_spaces.append(self.check_ai_up(col, row, n1, n2))
        if type(self.check_ai_down(col, row, n1, n2)) == list:
            valid_spaces.append(self.check_ai_down(col, row, n1, n2))
        if type(self.check_ai_diag_downleft(col, row, n1, n2)) == list:
            valid_spaces.append(self.check_ai_diag_downleft(col, row, n1, n2))
        if type(self.check_ai_diag_downright(col, row, n1, n2)) == list:
            valid_spaces.append(self.check_ai_diag_downright(col, row, n1, n2))
        if type(self.check_ai_diag_upleft(col, row, n1, n2)) == list:
            valid_spaces.append(self.check_ai_diag_upleft(col, row, n1, n2))
        if type(self.check_ai_diag_upright(col, row, n1, n2)) == list:
            valid_spaces.append(self.check_ai_diag_upright(col, row, n1, n2))
        return valid_spaces
    # PURPOSE
    # Helper function to check the nested list of the board to see what piece
    # is in that specific spot.
    # SIGNATURE
    # check_tiles :: Board, Int, Int  => Int

    def check_tiles(self, col, row):
        BLACK = 1
        WHITE = 2
        EMPTY = 0
        if self.tiles_on_board[row][col] == BLACK:
            return BLACK
        elif self.tiles_on_board[row][col] == WHITE:
            return WHITE
        return EMPTY
    # PURPOSE
    # Helper function to check that where the user/computer place or flip
    # is in the bounds of the board.
    # SIGNATURE
    # in_bounds :: Board, Int, Int  => Boolean

    def in_bounds(self, col, row):
        MIN = 0
        MAX = 7
        if ((MIN <= col <= MAX) and (MIN <= row <= MAX)):
            return True
        return False
    # PURPOSE
    # Helper function to determine if where the user wants to place is valid.
    # SIGNATURE
    # valid_move :: Board, Int, Int, Int, Int => Boolean

    def valid_move(self, col, row, num1, num2):
        if self.in_bounds(col, row):
            if self.check_tiles(col, row) == 0:
                if (max(self.check_directions(col, row, num1, num2)) > 0):
                    return True
        return False
    # PURPOSE
    # Helper function to draw the valid circles once a player chooses.
    # SIGNATURE
    # draw :: Board, Int, Int, Str, Int => None

    def draw(self, col, row, color, player):
        self.draw_piece(col, row, color)
        self.tiles_on_board[row][col] = player
    # PURPOSE
    # Helper function to determine the best move for the computer to make.
    # SIGNATURE
    # ai_turn :: Board, Int, Int => List

    def ai_turn(self, white, black):
        max_flips = [0, 0, 0, 0, 0, 0, 0, 0]
        white_spots = []
        empty_spots = []
        best_spot = [0, 0]
        for i in range(len(self.tiles_on_board)):
            for j in range(len(self.tiles_on_board[i])):
                if self.tiles_on_board[i][j] == white:
                    white_spots.append([i, j])
        for i in white_spots:
            empty_spots += (self.check_ai_directions(i[1], i[0], white, black))
        for empty in empty_spots:
            location = self.check_directions(empty[1], empty[0], white, black)
            if sum(location) >= sum(max_flips):
                max_flips = location
                best_spot = [empty[0], empty[1]]
        return best_spot
    # PURPOSE
    # Helper function to determine if there are any valid empty tiles for the
    # user to click on. This allows me to end the game early even though there
    # may be spots open.
    # SIGNATURE
    # empty_tiles :: Board, Int, Int => List

    def empty_tiles(self, player1, player2):
        player = []
        empty = []
        for i in range(len(self.tiles_on_board)):
            for j in range(len(self.tiles_on_board[i])):
                if self.tiles_on_board[i][j] == player1:
                    player.append([i, j])
        for i in player:
            empty += (self.check_ai_directions(i[1], i[0], player1, player2))
        return empty

    # PURPOSE
    # Alternates between the players, draws the circles in the location
    # they choose and waits until they make a valid click.
    # It also calls the winner function to announce who won at the end.
    # SIGNATURE
    # whose_turn :: Board, Integer, Integer => None
    def whose_turn(self, x, y):
        winner_called = False
        BL = 1
        WH = 2
        EM = 0
        col, row = self.conv_coord(x, y)
        # self.black_counter = self.tile_count(0, -100, 250)
        # #self.black_counter
        # self.white_counter = self.tile_count(0, -100, 230)
        #self.white_counter
        if self.remaining_tiles > 0:
            if self.turn == "black" and (self.remaining_tiles > 0):
                if len(self.empty_tiles(BL, WH)) == 0:
                    print("You have no current valid moves,",
                          "the turn goes to white.")
                    self.turn = "white"
                elif self.valid_move(col, row, BL, WH):
                    self.draw(col, row, "black", BL)
                    self.flip_directions(col, row, BL, WH, "black")
                    self.remaining_tiles = self.count_tiles(EM)
                    self.black_tile = self.count_tiles(BL)
                    self.white_tile = self.count_tiles(WH)
                    # self.tile_count(self.black_tile, -100, 250)
                    # self.tile_count(self.white_tile, -100, 230)
                    self.turn = "white"
                    print("It is the computers turn. ")
            if self.turn == "white" and (self.remaining_tiles > 0):
                if len(self.empty_tiles(WH, BL)) == 0:
                    print("White has no current valid moves,",
                          "the turn goes back to you.")
                    self.turn = "black"
                else:
                    best = self.ai_turn(WH, BL)
                    self.draw(best[1], best[0], "white", WH)
                    self.flip_directions(best[1], best[0], WH, BL, "white")
                    self.remaining_tiles = self.count_tiles(EM)
                    self.black_tile = self.count_tiles(BL)
                    self.white_tile = self.count_tiles(WH)
                    # self.tile_count(self.black_tile, -100, 250)
                    # self.tile_count(self.white_tile, -100, 230)
                    self.turn = "black"
                    print("It is the users turn. ")
        if ((winner_called is False) and
                (self.black_tile == 0)):
            print("Gave Over! You ran out of tiles. ")
            winner_called = True
            self.winner()
        if (winner_called is False) and (self.white_tile == 0):
            print("Gave Over! The Computer ran out of tiles. ")
            winner_called = True
            self.winner()
        if (winner_called is False) and (self.remaining_tiles == 0):
            print("Game Over!")
            winner_called = True
            self.winner()
        if ((winner_called is False) and
            ((len(self.empty_tiles(WH, BL)) == 0) and
                (len(self.empty_tiles(BL, WH)) == 0))):
            print("Game Over! You and the Computer have",
                  "ran out of valid moves. ")
            winner_called = True
            self.winner()
    # PURPOSE
    # Determines who won based on the amount of tiles each has at the end
    # and announces it. It also creates/appends the scores text file.
    # SIGNATURE
    # winner :: Board => None

    def winner(self):
        username = input("Please enter your name: ")
        user_score = Scores(username, self.black_tile)
        if self.black_tile > self.white_tile:
            print("You have won with", self.black_tile, "amount of tiles!")
            if user_score.valid_path(self.file_path) is False:
                user_score.create_file(self.file_path, user_score)
            else:
                user_score.append_file(self.file_path, user_score)
        elif self.white_tile > self.black_tile:
            print("The Computer has won with", self.white_tile,
                  "amount of tiles!")
            if user_score.valid_path(self.file_path) is False:
                user_score.create_file(self.file_path, user_score)
            else:
                user_score.append_file(self.file_path, user_score)
        else:
            print("Its a tie! Player 1 had",
                  self.black_tile, "tiles and the Computer had",
                  self.white_tile, "tiles. Good game!")
            if user_score.valid_path(self.file_path) is False:
                user_score.create_file(self.file_path, user_score)
            else:
                user_score.append_file(self.file_path, user_score)
    # PURPOSE
    # Helper function returning the center coordinates of a square on
    # the board.
    # SIGNATURE
    # get_center :: Board, Integer, Integer => (Float, Float)

    def get_center(self, col, row):
        x = col * SQUARE + SQUARE + self.low_bound
        y = (-(row * SQUARE + SQUARE / 2)) + self.high_bound
        return (x, y)
    # PURPOSE
    # Draw a tile of a given color in a given square on the board.
    # SIGNATURE
    # draw_piece :: Board, Integer, Integer, String => None

    def draw_piece(self, col, row, color):
        center = self.get_center(col, row)
        RADIUS = SQUARE // 2
        self.othello.penup()
        self.othello.setposition(center[0], center[1])
        self.othello.pendown()
        self.othello.begin_fill()
        self.othello.color("black", color)
        self.othello.circle(RADIUS)
        self.othello.end_fill()
    # PURPOSE
    # Helper function that draws the 4 starting pieces.
    # SIGNATURE
    # start_pieces :: Board => None

    def start_pieces(self):
        self.draw_piece(4, 3, "black")
        self.draw_piece(3, 3, "white")
        self.draw_piece(4, 4, "white")
        self.draw_piece(3, 4, "black")
    # PURPOSE
    # Helper function to check how many tiles of the other player they
    # can flip before hitting another one of their own pieces.
    # SIGNATURE
    # check_left :: Board, Int, Int, Int, Int => Int

    def check_left(self, col, row, num1, num2):
        other_player = 0
        col -= 1
        while (self.in_bounds(col, row) and
                (self.check_tiles(col, row) != num1)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col -= 1
            elif self.check_tiles(col, row) == 0:
                return 0
        if not self.in_bounds(col, row):
            return 0
        return other_player
    # PURPOSE
    # Helper function to check how many tiles of the user the computer
    # can flip before hitting an empty piece.
    # SIGNATURE
    # check_ai_left :: Board, Int, Int, Int, Int => Int

    def check_ai_left(self, col, row, num1, num2):
        other_player = 0
        col -= 1
        while ((self.in_bounds(col, row)) and
                (self.check_tiles(col, row) != 0)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col -= 1
            if self.check_tiles(col, row) == num1:
                break
        if not self.in_bounds(col, row):
            return None
        if ((self.check_tiles(col, row) == 0) and (other_player > 0)):
            return [row, col]
    # PURPOSE
    # Helper function to flip the correct amount of tiles in a direction.
    # SIGNATURE
    # flip_left :: Board, Int, Int, Int, Int, Str => None

    def flip_left(self, col, row, num1, num2, color):
        left = self.check_left(col, row, num1, num2)
        col -= 1
        while left > 0:
            self.draw(col, row, color, num1)
            self.tiles_on_board[row][col] == num1
            col -= 1
            left -= 1
    # PURPOSE
    # Helper function to check how many tiles of the other player they
    # can flip before hitting another one of their own pieces.
    # SIGNATURE
    # check_right :: Board, Int, Int, Int, Int => Int

    def check_right(self, col, row, num1, num2):
        other_player = 0
        col += 1
        while (self.in_bounds(col, row) and
                (self.check_tiles(col, row) != num1)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col += 1
            elif self.check_tiles(col, row) == 0:
                return 0
        if not self.in_bounds(col, row):
            return 0
        return other_player
    # PURPOSE
    # Helper function to check how many tiles of the user the computer
    # can flip before hitting an empty piece.
    # SIGNATURE
    # check_ai_right :: Board, Int, Int, Int, Int => Int

    def check_ai_right(self, col, row, num1, num2):
        other_player = 0
        col += 1
        while (self.in_bounds(col, row) and (self.check_tiles(col, row) != 0)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col += 1
            elif self.check_tiles(col, row) == num1:
                break
        if not self.in_bounds(col, row):
            return None
        if ((self.check_tiles(col, row) == 0) and (other_player > 0)):
            return [row, col]
    # PURPOSE
    # Helper function to flip the correct amount of tiles in a direction.
    # SIGNATURE
    # flip_right :: Board, Int, Int, Int, Int, Str => None

    def flip_right(self, col, row, num1, num2, color):
        right = self.check_right(col, row, num1, num2)
        col += 1
        while right > 0:
            self.draw(col, row, color, num1)
            self.tiles_on_board[row][col] == num1
            col += 1
            right -= 1
    # PURPOSE
    # Helper function to check how many tiles of the other player they
    # can flip before hitting another one of their own pieces.
    # SIGNATURE
    # check_up :: Board, Int, Int, Int, Int => Int

    def check_up(self, col, row, num1, num2):
        other_player = 0
        row -= 1
        while (self.in_bounds(col, row) and
                (self.check_tiles(col, row) != num1)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                row -= 1
            elif self.check_tiles(col, row) == 0:
                return 0
        if not self.in_bounds(col, row):
            return 0
        return other_player
    # PURPOSE
    # Helper function to flip the correct amount of tiles in a direction.
    # SIGNATURE
    # flip_up :: Board, Int, Int, Int, Int, Str => None

    def flip_up(self, col, row, num1, num2, color):
        up = self.check_up(col, row, num1, num2)
        row -= 1
        while up > 0:
            self.draw(col, row, color, num1)
            self.tiles_on_board[row][col] == num1
            row -= 1
            up -= 1
    # PURPOSE
    # Helper function to check how many tiles of the user the computer
    # can flip before hitting an empty piece.
    # SIGNATURE
    # check_ai_up :: Board, Int, Int, Int, Int => Int

    def check_ai_up(self, col, row, num1, num2):
        other_player = 0
        row -= 1
        while (self.in_bounds(col, row) and (self.check_tiles(col, row) != 0)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                row -= 1
            elif self.check_tiles(col, row) == num1:
                break
        if not self.in_bounds(col, row):
            return None
        if ((self.check_tiles(col, row) == 0) and (other_player > 0)):
            return [row, col]
    # PURPOSE
    # Helper function to check how many tiles of the other player they
    # can flip before hitting another one of their own pieces.
    # SIGNATURE
    # check_down :: Board, Int, Int, Int, Int => Int

    def check_down(self, col, row, num1, num2):
        other_player = 0
        row += 1
        while (self.in_bounds(col, row) and
                (self.check_tiles(col, row) != num1)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                row += 1
            elif self.check_tiles(col, row) == 0:
                return 0
        if not self.in_bounds(col, row):
            return 0
        return other_player
    # PURPOSE
    # Helper function to check how many tiles of the user the computer
    # can flip before hitting an empty piece.
    # SIGNATURE
    # check_ai_down :: Board, Int, Int, Int, Int => Int

    def check_ai_down(self, col, row, num1, num2):
        other_player = 0
        row += 1
        while (self.in_bounds(col, row) and (self.check_tiles(col, row) != 0)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                row += 1
            elif self.check_tiles(col, row) == num1:
                break
        if not self.in_bounds(col, row):
            return None
        if ((self.check_tiles(col, row) == 0) and (other_player > 0)):
            return [row, col]
    # PURPOSE
    # Helper function to flip the correct amount of tiles in a direction.
    # SIGNATURE
    # flip_down :: Board, Int, Int, Int, Int, Str => None

    def flip_down(self, col, row, num1, num2, color):
        down = self.check_down(col, row, num1, num2)
        row += 1
        while down > 0:
            self.draw(col, row, color, num1)
            self.tiles_on_board[row][col] == num1
            row += 1
            down -= 1
    # PURPOSE
    # Helper function to check how many tiles of the other player they
    # can flip before hitting another one of their own pieces.
    # SIGNATURE
    # check_diag_upright :: Board, Int, Int, Int, Int => Int

    def check_diag_upright(self, col, row, num1, num2):
        other_player = 0
        col += 1
        row -= 1
        while (self.in_bounds(col, row) and
                (self.check_tiles(col, row) != num1)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col += 1
                row -= 1
            elif self.check_tiles(col, row) == 0:
                return 0
        if not self.in_bounds(col, row):
            return 0
        return other_player
    # PURPOSE
    # Helper function to check how many tiles of the user the computer
    # can flip before hitting an empty piece.
    # SIGNATURE
    # check_ai_diag_upright :: Board, Int, Int, Int, Int => Int

    def check_ai_diag_upright(self, col, row, num1, num2):
        other_player = 0
        col += 1
        row -= 1
        while (self.in_bounds(col, row) and (self.check_tiles(col, row) != 0)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col += 1
                row -= 1
            elif self.check_tiles(col, row) == num1:
                break
        if not self.in_bounds(col, row):
            return None
        if ((self.check_tiles(col, row) == 0) and (other_player > 0)):
            return [row, col]
    # PURPOSE
    # Helper function to flip the correct amount of tiles in a direction.
    # SIGNATURE
    # flip_diag_upright :: Board, Int, Int, Int, Int, Str => None

    def flip_diag_upright(self, col, row, num1, num2, color):
        diag_upright = self.check_diag_upright(col, row, num1, num2)
        col += 1
        row -= 1
        while diag_upright > 0:
            self.draw(col, row, color, num1)
            self.tiles_on_board[row][col] == num1
            col += 1
            row -= 1
            diag_upright -= 1
    # PURPOSE
    # Helper function to check how many tiles of the other player they
    # can flip before hitting another one of their own pieces.
    # SIGNATURE
    # check_diag_upleft :: Board, Int, Int, Int, Int => Int

    def check_diag_upleft(self, col, row, num1, num2):
        other_player = 0
        col -= 1
        row -= 1
        while (self.in_bounds(col, row) and
                (self.check_tiles(col, row) != num1)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col -= 1
                row -= 1
            elif self.check_tiles(col, row) == 0:
                return 0
        if not self.in_bounds(col, row):
            return 0
        return other_player
    # PURPOSE
    # Helper function to check how many tiles of the user the computer
    # can flip before hitting an empty piece.
    # SIGNATURE
    # check_ai_diag_upleft :: Board, Int, Int, Int, Int => Int

    def check_ai_diag_upleft(self, col, row, num1, num2):
        other_player = 0
        col -= 1
        row -= 1
        while (self.in_bounds(col, row) and (self.check_tiles(col, row) != 0)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col -= 1
                row -= 1
            elif self.check_tiles(col, row) == num1:
                break
        if not self.in_bounds(col, row):
            return None
        if ((self.check_tiles(col, row) == 0) and (other_player > 0)):
            return [row, col]
    # PURPOSE
    # Helper function to flip the correct amount of tiles in a direction.
    # SIGNATURE
    # flip_diag_upleft :: Board, Int, Int, Int, Int, Str => None

    def flip_diag_upleft(self, col, row, num1, num2, color):
        diag_upleft = self.check_diag_upleft(col, row, num1, num2)
        col -= 1
        row -= 1
        while diag_upleft > 0:
            self.draw(col, row, color, num1)
            self.tiles_on_board[row][col] == num1
            col -= 1
            row -= 1
            diag_upleft -= 1
    # PURPOSE
    # Helper function to check how many tiles of the other player they
    # can flip before hitting another one of their own pieces.
    # SIGNATURE
    # check_diag_downleft :: Board, Int, Int, Int, Int => Int

    def check_diag_downleft(self, col, row, num1, num2):
        other_player = 0
        col -= 1
        row += 1
        while (self.in_bounds(col, row) and
                (self.check_tiles(col, row) != num1)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col -= 1
                row += 1
            elif self.check_tiles(col, row) == 0:
                return 0
        if not self.in_bounds(col, row):
            return 0
        return other_player
    # PURPOSE
    # Helper function to check how many tiles of the user the computer
    # can flip before hitting an empty piece.
    # SIGNATURE
    # check_ai_diag_downleft :: Board, Int, Int, Int, Int => Int

    def check_ai_diag_downleft(self, col, row, num1, num2):
        other_player = 0
        col -= 1
        row += 1
        while (self.in_bounds(col, row) and (self.check_tiles(col, row) != 0)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col -= 1
                row += 1
            elif self.check_tiles(col, row) == num1:
                break
        if not self.in_bounds(col, row):
            return None
        if ((self.check_tiles(col, row) == 0) and (other_player > 0)):
            return [row, col]
    # PURPOSE
    # Helper function to flip the correct amount of tiles in a direction.
    # SIGNATURE
    # flip_diag_downleft :: Board, Int, Int, Int, Int, Str => None

    def flip_diag_downleft(self, col, row, num1, num2, color):
        diag_downleft = self.check_diag_downleft(col, row, num1, num2)
        col -= 1
        row += 1
        while diag_downleft > 0:
            self.draw(col, row, color, num1)
            self.tiles_on_board[row][col] == num1
            col -= 1
            row += 1
            diag_downleft -= 1
    # PURPOSE
    # Helper function to check how many tiles of the other player they
    # can flip before hitting another one of their own pieces.
    # SIGNATURE
    # check_diag_downright :: Board, Int, Int, Int, Int => Int

    def check_diag_downright(self, col, row, num1, num2):
        other_player = 0
        col += 1
        row += 1
        while (self.in_bounds(col, row) and
                (self.check_tiles(col, row) != num1)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col += 1
                row += 1
            elif self.check_tiles(col, row) == 0:
                return 0
        if not self.in_bounds(col, row):
            return 0
        return other_player
    # PURPOSE
    # Helper function to check how many tiles of the user the computer
    # can flip before hitting an empty piece.
    # SIGNATURE
    # check_ai_diag_downright :: Board, Int, Int, Int, Int => Int

    def check_ai_diag_downright(self, col, row, num1, num2):
        other_player = 0
        col += 1
        row += 1
        while (self.in_bounds(col, row) and (self.check_tiles(col, row) != 0)):
            if self.check_tiles(col, row) == num2:
                other_player += 1
                col += 1
                row += 1
            elif self.check_tiles(col, row) == num1:
                break
        if not self.in_bounds(col, row):
            return None
        if ((self.check_tiles(col, row) == 0) and (other_player > 0)):
            return [row, col]
    # PURPOSE
    # Helper function to flip the correct amount of tiles in a direction.
    # SIGNATURE
    # flip_diag_downright :: Board, Int, Int, Int, Int, Str => None

    def flip_diag_downright(self, col, row, num1, num2, color):
        diag_downright = self.check_diag_downright(col, row, num1, num2)
        col += 1
        row += 1
        while diag_downright > 0:
            self.draw(col, row, color, num1)
            self.tiles_on_board[row][col] == num1
            col += 1
            row += 1
            diag_downright -= 1
