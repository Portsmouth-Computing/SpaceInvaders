import graphics as gfx
from timeit import default_timer as timer

from clock import *
from sprite import *

class Game:
    '''The class that controls the game'''
    def __init__(self):
        self.win = gfx.GraphWin("Space Invaders", 800, 600, autoflush = False)
        self.win.setBackground("black")
        print ("Created game")

    def runGame(self):
        '''runs the game'''

        s = Sprite(gfx.Point(50, 50), gfx.Point(50, 100), self.win)

        clock = Clock()
        while not self.win.closed:
            delta = clock.getElapsed()  
            clock.restart()
            gfx.update(30)

def main():
    g = Game()
    g.runGame()
    

main()