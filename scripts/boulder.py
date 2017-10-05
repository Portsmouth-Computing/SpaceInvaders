from game_object import *

class Boulder(GameObject):
    '''One of the boulders/ sheilds in the game to protect the player'''
    def __init__(self, win, x):
        self._w = 60
        self._h = 20

        GameObject.__init__(self, win, 
                            x - self._w / 2,  win.height - 125, # Position
                            self._w,          self._h)             # Size
        self.health = 10

    def hit(self, win):
        self.b_update()
        self.health -= 1
        self.sprite.set_size(self._w, self.health * 2)
        if (self.health == 0):
            self.is_alive = False
