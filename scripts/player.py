import graphics as gfx
from sprite import * 

class Player:
    '''the player of the game'''
    def __init__(self, win):
        self.sprite = Sprite(gfx.Point(win.width / 2, win.height - 50), gfx.Point(24, 36), win)