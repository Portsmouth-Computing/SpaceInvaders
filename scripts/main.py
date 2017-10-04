import graphics as gfx

class Game:
    def __init__(self):
        self.win = gfx.GraphWin("Space Invaders", 800, 600)
        self.win.setBackground("black")
        print ("Created game")

    def runGame(self):
        self.win.getMouse()


def main():
    g = Game()
    g.runGame()
    

main()