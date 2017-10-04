from player import *

class World:
    def __init__(self, win):
        self.player = Player(win)
        
    def update(self, win, dt):
        self.player.update(win, dt)