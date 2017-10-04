from timeit import default_timer as timer

class Clock:
    '''Measures time'''
    def __init__(self):
        self.time = timer()

    def restart(self):
        self.time = timer()


    def getElapsed(self):
        now = timer()
        return now - self.time

