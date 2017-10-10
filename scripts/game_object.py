import graphics as gfx
from sprite import * 

class GameObject:
    '''Base object for all game objects'''
    def __init__(self, win, x, y, w, h):
        self.sprite = Sprite(gfx.Point(x, y), gfx.Point(w, h), win)
        self.is_alive = True

    def is_colliding(self, obj):
        s1 = self.sprite
        s2 = obj.sprite 

        b1 = s1.get_pos_x()                     < s2.get_pos_x() + s2.get_width()
        b2 = s1.get_pos_x() + s1.get_width()    > s2.get_pos_x()
        b3 = s1.get_pos_y()                     < s2.get_pos_y() + s2.get_height()
        b4 = s1.get_pos_y() + s1.get_height()   > s2.get_pos_y()

        return b1 and b2 and b3 and b4

    def update(self):
        self._update()
        if not self.is_alive:
            self.sprite.stop_draw()

    def _update(self):
        pass
