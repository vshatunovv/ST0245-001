# -*- coding: utf-8 -*-
"""
Created on Tue Sep  1 10:52:32 2020

@author: KEVIN DANIEL TORRES
"""
import random
from time import time
import matplotlib.pyplot as plt

def merge(arr, l, m, r): 
    n1 = m - l + 1
    n2 = r- m 
    L = [0] * (n1) 
    R = [0] * (n2) 
    for i in range(0 , n1): 
        L[i] = arr[l + i] 
  
    for j in range(0 , n2): 
        R[j] = arr[m + 1 + j] 

    i = 0 
    j = 0
    k = l 
  
    while i < n1 and j < n2 : 
        if L[i] <= R[j]: 
            arr[k] = L[i] 
            i += 1
        else: 
            arr[k] = R[j] 
            j += 1
        k += 1
        
    while i < n1: 
        arr[k] = L[i] 
        i += 1
        k += 1

    while j < n2: 
        arr[k] = R[j] 
        j += 1
        k += 1
  
    
def mergeSort(arr,l,r): 
    if l < r: 
        m = (l+(r-1))//2
        mergeSort(arr, l, m) 
        mergeSort(arr, m+1, r) 
        merge(arr, l, m, r) 
  


n= 1000
g_i = [];
g_t = [];
for i in range(0,20):
    A = [random.randint(0,100) for _ in range(n)]
    start_time = time()
    nl = len(A) 
    mergeSort(A,0,nl-1) 
    elapsed_time = time() - start_time
    g_i.append(n)
    g_t.append(elapsed_time) 
    print("Loop:",i)
    print("Time:",elapsed_time)
    print("------------------")
    n = n + 1000
plt.plot(g_i,g_t)  