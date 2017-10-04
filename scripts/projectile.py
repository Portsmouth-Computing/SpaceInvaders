from game_object import *

class Projectile(GameObject):
    def __init__(self, win, x, y):

        GameObject.__init__(self, win, 
                            x,  y,         # Position
                            5, 5)   # Size
        self.health = 10

    def update(self):
        self.sprite.move(0, -10)
        if (self.sprite.get_pos_y() >= 0):
            self.alive = False
