import turtle


# PURPOSE
# Draw a line of a given length
# SIGNATURE
# draw_line :: Turtle, Integer => None
def draw_line(a_turtle, length):
    a_turtle.pendown()
    a_turtle.forward(length)
    a_turtle.penup()

# PURPOSE
# Draw a line of a given size
# SIGNATURE
# draw_square :: Turtle, Integer => None
def draw_square(a_turtle, size):
    RIGHT_ANGLE = 90
    a_turtle.pendown()
    for i in range(4):
        a_turtle.forward(size)
        a_turtle.left(RIGHT_ANGLE)
    a_turtle.penup()


# PURPOSE
# Draw an equilateral triangle of a given size
# SIGNATURE
# draw_triangle :: Turtle, Integer => None
def draw_triangle(a_turtle, size):
    SIDE_TRIANGLE = 120
    a_turtle.pendown()
    for i in range(3):
        a_turtle.forward(size)
        a_turtle.left(SIDE_TRIANGLE)
    a_turtle.penup()


# PURPOSE
# Draw a circle of a given size
# SIGNATURE
# draw_circle :: Turtle, Integer => None
# def draw_circle(a_turtle, radius):
#     a_turtle.pendown()
#     a_turtle.circle(radius)
#     a_turtle.penup()


def main():
    turtle.setup(420, 420) # open a window
    turtle.screensize(400, 400) # set the drawing canvas size
    turtle.bgcolor("white")

    pen = turtle.Turtle()
    pen.speed(0)
    draw_line(pen, 100)
    pen.setposition(-100, 0)
    #draw_square(pen, 30)
    draw_triangle(pen, 80)
    #draw_circle(pen, 60)

    turtle.done() # Important! Stops the window from closing immediately


main()
