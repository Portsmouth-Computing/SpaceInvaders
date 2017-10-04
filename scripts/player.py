import graphics as gfx
from sprite import * 

class Player:
    '''the player of the game'''
    def __init__(self, win):
        self.sprite = Sprite(gfx.Point(win.width / 2, win.height - 50), gfx.Point(24, 36), win)

        self.velocity = 0.0

    def update(self, win, dt):
        key = win.checkKey()

        if (key == "a"):
            self.velocity -= 5.0
        elif (key == "d"):
            self.velocity += 5.0

        self.sprite.move(self.velocity * dt, 0)

        self.velocity *= 0.95