# -*- coding: utf-8 -*-
"""
Created on Sun Sep 27 20:52:13 2020

@author: KEVIN DANIEL TORRES
"""

def __init__(s):
    lis = list(s)
    Lis = LL(lis)
    Str = ''
    Str = Str.join(Lis)
    return Str

def LL (lis):
    n = len(lis)-1
    index = 0
    con = 0
    Lis = []
    for x in range(n - 1):
        if lis[x] == '[':
            index = 1
            lis.pop(x)
            n = n - 1
        if lis[x] == ']':
            index = 0
            lis.pop(x)
            n = n - 1
        if index == 0:
            Lis.append(lis[x])
            con = 0
        if index == 1:
            Lis.insert(con,lis[x])
            con = con + 1
    return Lis
            
text = 'This_is_a_[Beiju]_text'
Text = __init__(text)
print(Text)
    