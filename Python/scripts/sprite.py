import graphics as gfx

class Sprite:
    '''2D rectangle sprite'''
    def __init__(self, position, size, win):
        self.size     = size
        self.rect = gfx.Rectangle(position, gfx.Point(position.x + size.x, position.y + size.y))
        self.rect.setFill("white")
        self.rect.setOutline("white")
        self.rect.draw(win)

    def move(self, x, y):
        self.rect.move(x, y)

    '''
    def set_size(self, x, y):
        self.rect.p2.x = self.rect.p2.x - x
        self.rect.p2.y = self.rect.p2.y - y
        self.size.x = x 
        self.size.y = y
        self.rect.move(0, 0)
        print("Changing size")
    '''

    def get_width(self):
        return self.size.x

    def get_height(self):
        return self.size.y

    def get_pos_x(self):
        return self.rect.p1.x

    def get_pos_y(self):
        return self.rect.p1.y

    def stop_draw(self):
        self.rect.undraw()
    