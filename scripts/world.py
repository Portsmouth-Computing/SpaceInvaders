from player import *
from boulder import *

class World:
    def __init__(self, win):
        self.player = Player(win)
        self.boulders = [] 
        
        for i in range(3):
            x = win.width / 4 * (i + 1)
            self.boulders.append(Boulder(win, x))
        
    def update(self, win, dt):
        #print(len(self.boulders))
        self.player.update(win, dt)