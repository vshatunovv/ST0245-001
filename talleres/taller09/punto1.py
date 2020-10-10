# -*- coding: utf-8 -*-
"""
Created on Fri Oct  9 22:18:36 2020

@author: KEVIN DANIEL TORRES
"""

class hash_table:
    def __init__(self):
        self.size = 10
        self.slots = [None] * self.size
        self.data = [None] * self.size
        
    def hash_func(self,key):
        suma = 0
        for i in range(len(key)):
            suma = suma + ord(key[i])
        
        return suma%10
    
    def add(self,key,data):
        key_position = self.hash_func(key)
        
        if self.slots[key_position] == None:
            self.slots[key_position] = key
            self.data[key_position] = data
        elif self.slots[key_position] == key:
            self.data[key_position] == data
            
    def get(self,key):
        pos = self.hash_func(key)
        name = self.slots[pos]
        data = self.data[pos]
        if data == None or name == None:
            return False
        else:
            return name, data

H = hash_table()
H.add("Ho",3)
H.add("Homero",315)
H.add("Kevin",6598)
print(H.get("Ho"))
print(H.get("Homero"))
print(H.get("cristian"))

