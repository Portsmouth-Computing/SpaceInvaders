import graphics as gfx
from timeit import default_timer as timer

from clock import *

class Game:
    '''The class that controls the game'''
    def __init__(self):
        self.win = gfx.GraphWin("Space Invaders", 800, 600, autoflush = False)
        self.win.setBackground("black")
        print ("Created game")

    def runGame(self):
        '''runs the game'''
        clock = Clock()
        while True:
            delta = clock.getElapsed()  
            clock.restart()
            gfx.update(30)

def main():
    g = Game()
    g.runGame()
    

main()