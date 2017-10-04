import graphics as gfx

class Sprite:
    def __init__(self, position, size, win):
        self.position = position
        self.size     = size
        self.rect = gfx.Rectangle(position, gfx.Point(position.x + size.x, position.y + size.y))
        self.rect.setFill("white")
        self.rect.setOutline("white")
        self.rect.draw(win)

    def move(self, x, y):
        self.rect.move(x, y)

    def stop_draw(self):
        self.rect.undraw()
    