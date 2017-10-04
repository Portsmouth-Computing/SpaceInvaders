from player import *
from boulder import *
from projectile import * 
from clock import *

class World:
    def __init__(self, win):
        self.player = Player(win)
        self.boulders = [] 
        self.projectiles = []
        self.inputClock = Clock()
        
        for i in range(3):
            x = win.width / 4 * (i + 1)
            self.boulders.append(Boulder(win, x))

    def add_projectile(self, win):
        x = self.player.sprite.get_pos_x() + self.player.sprite.get_width() / 2
        y = self.player.sprite.get_pos_y()
        self.projectiles.append(Projectile(win, x, y))

        
    def update(self, win, dt, key):
        #print(len(self.boulders))

        self.player.update(win, dt, key)

        if (self.inputClock.getElapsed() > 0.5):
            print(key)
            if (key == "w"):
                self.add_projectile(win)
                self.inputClock.restart()

        for projectile in self.projectiles:
            projectile.update()
        self.projectiles = [p for p in self.projectiles if not p.alive]

