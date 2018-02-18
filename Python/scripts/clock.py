from timeit import default_timer as timer

class Clock:
    '''Measures time'''
    def __init__(self):
        self.time = timer()

    def restart(self):
        '''restarts clock back to 0'''
        self.time = timer()


    def getElapsed(self):
        '''gets time elapsed since clock creation or restart'''
        now = timer()
        return now - self.time

