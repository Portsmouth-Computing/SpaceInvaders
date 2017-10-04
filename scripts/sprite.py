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

    def set_size(self, x, y):
        self.rect.width = x
        self.rect.height = y

    def get_width(self):
        return self.rect.width

    def get_height(self):
        return self.rect.height

    def get_pos_x(self):
        return self.rect.p1.x

    def get_pos_y(self):
        return self.rect.p1.y

    def stop_draw(self):
        self.rect.undraw()
    