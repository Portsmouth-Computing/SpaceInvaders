import graphics as gfx

class Game:
    def __init__(self):
        self.win = gfx.GraphWin("Space Invaders", 800, 600, autoflush = False)
        self.win.setBackground("black")
        print ("Created game")

    def runGame(self):
        while True:
            print(self.win.checkKey())
            gfx.update(30)


def main():
    g = Game()
    g.runGame()
    

main()