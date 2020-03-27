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
# Draw a star of a given size
# SIGNATURE
# draw_star :: Turtle, Integer => None
def draw_star(a_turtle, size):
    SIDE_STAR = 144
    colors = ["green", "yellow", "blue", "red", "orange"]
    a_turtle.pendown()
    for i in range(5):
        a_turtle.pencolor(colors[i])
        a_turtle.forward(size)
        a_turtle.right(SIDE_STAR)
    SIDE_STAR += SIDE_STAR * 2
    a_turtle.penup()   


def main():
    turtle.setup(420, 420) # open a window
    turtle.screensize(400, 400) # set the drawing canvas size
    turtle.bgcolor("white")

    pen = turtle.Turtle()
    pen.speed(5)
    pen.setposition(-100, 0)
    draw_star(pen, 100)
    draw_star(pen, 120)
    draw_star(pen, 140)
    draw_star(pen, 160)

    turtle.done() # Important! Stops the window from closing immediately


main()
