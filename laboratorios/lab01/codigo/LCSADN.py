# -*- coding: utf-8 -*-
"""
Created on Tue Aug 25 21:42:39 2020

@author: KEVIN DANIEL TORRES
"""
from time import time

def lcsDNA(s1,s2):
    r = lcsDNAaux(s1, s2, len(s1), len(s2))
    return r

def lcsDNAaux(string1, string2, m, n):
    if (m == 0 or n == 0):
        return 0
    if(string1[m-1] == string2[n-1]):
        return lcsDNAaux(string1, string2,m-1,n-1) + 1
    return max(lcsDNAaux(string1, string2,m-1,n), lcsDNAaux(string1, string2,m,n-1))

s1 = "ctagtgrisadceasvwaasgpscdcfab"
s2 = "gccctsrwgedcsswawafdgpscdcfab"
print(len(s1))
start_time = time()
lcsDNA(s1,s2)
elapsed_time = time() - start_time
print(elapsed_time)
