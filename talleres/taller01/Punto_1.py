# -*- coding: utf-8 -*-
"""
Created on Fri Jul 29 19:22:02 2020

@author: KEVIN DANIEL TORRES
"""
import math

class Counter():
    """counter."""
    def __init__(self):
        self.x = 0

    def increase(self):
        self.x = self.x + 1

    def increments(self):
        return self.x

    def toString(self):
        print(self.x)   

class Punto2D():
    
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def get_x(self):
        return self.x

    def get_y(self):
        return self.y

    def radio_polar(self):
        r_p = math.sqrt((self.x*self.x) + (self.y*self.y))  
        return r_p

    def angulo_polar(self):
        a_p = math.atan(self.y/self.x)
        return a_p
    def dist_euclidiana(self, other):
        dx = self.x - other.get_x()
        dy = self.y - other.get_y()
        d_e = math.sqrt((dx * dx) + (dy * dy))
        return d_e

coor = Punto2D(7,6)
other = Punto2D(20,30)
coor.radio_polar()
coor.angulo_polar()
coor.dist_euclidiana(other)