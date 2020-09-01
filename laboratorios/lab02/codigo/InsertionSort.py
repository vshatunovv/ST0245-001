# -*- coding: utf-8 -*-
"""
Created on Sat Aug 29 19:48:31 2020

@author: KEVIN DANIEL TORRES
"""
import random
from time import time
import matplotlib.pyplot as plt

def insertionSort (Array):
    for i in range(1,len(Array)):
        V_aux = Array[i]
        j = i-1
        while j >= 0 and V_aux < Array[j]:
            Array[j+1] = Array[j]
            j -= 1
        Array[j+1] = V_aux
        
    return Array


n= 1000
g_i = [];
g_t = [];
for i in range(0,20):
    A = [random.randint(0,100) for _ in range(n)]
    start_time = time()
    insertionSort (A)
    elapsed_time = time() - start_time
    g_i.append(n)
    g_t.append(elapsed_time) 
    print("Loop:",i)
    print("Time:",elapsed_time)
    print("------------------")
    n = n + 1000
plt.plot(g_i,g_t)       
