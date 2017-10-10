from game_object import *
import graphics as gfx

class Boulder(GameObject):
    '''One of the boulders/ sheilds in the game to protect the player'''
    def __init__(self, win, x):
        self._w = 60
        self._h = 20

        GameObject.__init__(self, win, 
                            x - self._w / 2,  win.height - 125, # Position
                            self._w,          self._h)             # Size
        self.health = 20
        self.health_display = gfx.Text(gfx.Point(x,  win.height - 125 + self._h / 2), str(self.health))
        self.health_display.draw(win)

    def hit(self, win):
        '''Called when the boulder is hit by a projectile'''
        self.health -= 1
        self.health_display.setText(str(self.health))
        if (self.health <= 1):
            print ("ded")
            self.is_alive = False
            self.health_display.undraw()
