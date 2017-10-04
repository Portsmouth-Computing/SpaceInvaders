import graphics as gfx
from timeit import default_timer as timer

from clock import *

class Game:
    def __init__(self):
        self.win = gfx.GraphWin("Space Invaders", 800, 600, autoflush = False)
        self.win.setBackground("black")
        print ("Created game")

    def runGame(self):
        time = timer()
        end = 0

        clock = Clock()

        while True:
            delta = clock.getElapsed()
            clock.restart()

            print(delta)


            time_now = timer()
            delta = time_now - time
            time = time_now




            print(self.win.checkKey())
            gfx.update(30)

            end 
            


def main():
    g = Game()
    g.runGame()
    

main()