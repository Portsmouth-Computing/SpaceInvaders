import graphics as gfx
from sprite import * 

class GameObject:
    '''the player of the game'''
    def __init__(self, win, x, y, w, h):
        self.sprite = Sprite(gfx.Point(x, y), gfx.Point(w, h), win)
        self.is_alive = True

    def is_colliding(self, obj):
        return False