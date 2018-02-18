import graphics as gfx
from clock import *
from world import *

class Game:
    '''The class that controls the game'''
    def __init__(self):
        self.win = gfx.GraphWin("Space Invaders", 800, 600, autoflush = False)
        self.win.setBackground("black")
        self.world = World(self.win)

    def runGame(self):
        '''runs the game'''
        clock = Clock()
        while not self.win.closed:
            key = self.win.checkKey()
            delta = clock.getElapsed()  
            clock.restart()

            self.world.update(self.win, delta, key)

            gfx.update(30)

def main():
    '''entry point'''
    g = Game()
    g.runGame()
    
main()