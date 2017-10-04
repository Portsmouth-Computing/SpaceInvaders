from player import *
from boulder import *
from projectile import * 
from clock import *

class World:
    '''The world'''
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

    def try_input(self, key, win):
        if (self.inputClock.getElapsed() > 0.5):
            if (key == "w"):
                self.add_projectile(win)
                self.inputClock.restart()

    def update(self, win, dt, key):
        self.try_input(key, win)


        self.player.update(win, dt, key)

        for projectile in self.projectiles:
            projectile.update()
        self.projectiles = [p for p in self.projectiles if not p.alive]


        for p in self.projectiles:
            for b in self.boulders:
                if (p.is_colliding(b)):
                    print ("wrk")
                    p.alive = False
                    p.sprite.stop_draw()
