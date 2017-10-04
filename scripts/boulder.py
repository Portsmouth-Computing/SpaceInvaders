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
        self.health -= 1
        print(self.health)
        self.sprite.set_size(self._w, self.health * 2)
        if (self.health == 0):
            self.alive = False
            sprite.un_draw()
            sprite.rect.draw(win)
