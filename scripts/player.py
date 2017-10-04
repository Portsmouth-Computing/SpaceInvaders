import graphics as gfx
from sprite import * 
from game_object import *

class Player(GameObject):
    '''the player of the game'''
    def __init__(self, win):
        GameObject.__init__(self,   win,
                            win.width / 2, win.height - 50, 
                            25, 30)
        self.velocity = 0.0

    def update(self, win, dt):
        key = win.checkKey()

        if (key == "a"):
            self.velocity -= 5.0
        elif (key == "d"):
            self.velocity += 5.0

        self.sprite.move(self.velocity * dt, 0)

        self.velocity *= 0.95