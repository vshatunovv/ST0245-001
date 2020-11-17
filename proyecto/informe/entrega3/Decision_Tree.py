# -*- coding: utf-8 -*-
"""
Created on Sun Nov 15 11:37:21 2020

@author: KEVIN DANIEL TORRES
"""
from __future__ import print_function
import pandas
from time import time

def unique_vals(rows,col):
    return set([row[col] for row in rows])

def class_counts(rows):
    counts = {}
    for row in rows:
        label = row[-1]
        if label not in counts:
            counts[label] = 0
        counts[label] += 1
    return counts

def is_numeric(value):
    return isinstance(value, int)or isinstance(value, float)

class Question:
    def __init__(self, column, value):
        self.column = column
        self.value = value
        
    def match(self, example):
        val = example[self.column]
        if is_numeric(val):
            return val >= self.value
        else:
            return val == self.value
        
    def __repr__(self):
        condition = "=="
        if is_numeric(self.value):
            condition = ">="
        return "Is %s %s %s?" % (header[self.column], condition, str(self.value))

def partitions(rows, question):
    true_rows, false_rows = [], []
    for row in rows:
        if question.match(row):
            true_rows.append(row)
        else:
            false_rows.append(row)
    return true_rows, false_rows

def gini(rows):
    counts = class_counts(rows)
    impurity = 1
    for lbl in counts:
        prob_of_lbl = counts[lbl] / float(len(rows))
        impurity -= prob_of_lbl**2
    return impurity

def info_gain(left, right, current_uncertainty):
    p = float(len(left)) / (len(left) + len(right))
    return current_uncertainty - p * gini(left) - (1-p) * gini(right)

def find_best_split(rows):
    best_gain = 0
    best_question = None
    current_uncertainty = gini(rows)
    n_features = len(rows[0]) -1
    
    for col in range(n_features):
        values = set([row[col] for row in rows])
        for val in values:
            question = Question(col, val)
            true_rows, false_rows = partitions(rows, question)
            if len(true_rows) == 0 or len(false_rows) == 0:
                continue
            gain = info_gain(true_rows, false_rows, current_uncertainty)
            if gain >= best_gain:
                best_gain, best_question = gain, question
    return best_gain, best_question

class Leaf:
    def __init__(self, rows):
        self.predictions = class_counts(rows)

class Decision_Node:
    def __init__(self, question, true_branch, false_branch):
        self.question = question
        self.true_branch = true_branch
        self.false_branch = false_branch
        
def build_tree(rows):
    gain, question = find_best_split(rows)
    if gain == 0:
        return Leaf(rows)    
    true_rows, false_rows = partitions(rows, question)
    true_branch = build_tree(true_rows)
    false_branch = build_tree(false_rows)
    
    return Decision_Node(question, true_branch, false_branch)

def print_tree(node, spacing=""):
    if isinstance(node, Leaf):
        print (spacing + "Predict", node.predictions)
        return
    print (spacing + str(node.question))
    print (spacing + '--> True:')
    print_tree(node.true_branch, spacing + "  ")
    print (spacing + '--> False:')
    print_tree(node.false_branch, spacing + "  ")
    
def classify(row, node):
    if isinstance(node, Leaf):
        return node.predictions
    if node.question.match(row):
        return classify(row, node.true_branch)
    else:
        return classify(row, node.false_branch)

def print_leaf(counts):
    total = sum(counts.values()) * 1.0
    probs = {}
    for lbl in counts.keys():
        probs[lbl] = str(int(counts[lbl] / total * 100)) + "%"
    return probs

def predic(testing_data):
    pre = []
    for row in testing_data:
        p = list(print_leaf(classify(row, my_tree)))
        p = int(p[0])
        pre.append(p)
        #print ("Actual: %s. Predicted: %s" % (row[-1], print_leaf(classify(row, my_tree))))
    return pre

def p_val(testing_data):
    n = len(testing_data)
    p_v = []
    for i in range(n):
        value = testing_data[i][-1]
        p_v.append(value)
    return p_v

def test_indicators(prediction):
    n = len(prediction)
    p_true = p_val(ttd)
    num_prediction = sum(prediction)
    num_p_true = sum(p_true)
    if num_p_true < num_prediction:
        Vp = num_p_true
        Fp = num_prediction - num_p_true
        Fn = 0
    else:
        Vp = num_p_true
        Fp = num_prediction - num_p_true
        Fn = num_p_true - num_prediction
    
    Vn = num_prediction
    print("Predicciones Positivas: %s Positivos Correctos: %s" % (Vn, num_p_true))
    print("Predicciones Negativas: %s Negativas Correctos: %s" % (n - num_prediction, n - num_p_true))
    return print("Precisión: %s Sensibilidad %s Exactitud: %s" % ((Vp/(Vp + Fp)*100), (Vp/(Vp + Fn)*100), (((Vp + Vn)/(Vp + Vn + Fp + Fn))*100)))
    

#def precision(arr1,)


td = pandas.read_csv('0_train_balanced_15000.csv')
td = td.values.tolist()
header = ["estu_consecutivo.1","estu_exterior","periodo","estu_tieneetnia","estu_tomo_cursopreparacion","estu_cursodocentesies","estu_cursoiesapoyoexterno","estu_cursoiesexterna","estu_simulacrotipoicfes","estu_actividadrefuerzoareas","estu_actividadrefuerzogeneric","fami_trabajolaborpadre","fami_trabajolabormadre","fami_numlibros","estu_inst_cod_departamento","estu_tipodocumento.1","estu_nacionalidad.1","estu_genero.1","estu_fechanacimiento.1","periodo.1","estu_estudiante.1","estu_pais_reside.1","estu_depto_reside.1","estu_cod_reside_depto.1","estu_mcpio_reside.1","estu_cod_reside_mcpio.1","estu_areareside","2estu_valorpensioncolegio","fami_educacionpadre.1","fami_educacionmadre.1","fami_ocupacionpadre.1","fami_ocupacionmadre.1","fami_estratovivienda.1","fami_nivelsisben","fami_pisoshogar","fami_tieneinternet.1","fami_tienecomputador.1","fami_tienemicroondas","fami_tienehorno,fami_tieneautomovil.1","fami_tienedvd","fami_tiene_nevera.1","fami_tiene_celular.1","fami_telefono.1","fami_ingresofmiliarmensual","estu_trabajaactualmente","estu_antecedentes","estu_expectativas","cole_codigo_icfes","cole_cod_dane_establecimiento","cole_nombre_establecimiento","cole_genero","cole_naturaleza","cole_calendario","cole_bilingue","cole_caracter","cole_cod_dane_sede","cole_nombre_sede","cole_sede_principal","cole_area_ubicacion","cole_jornada","cole_cod_mcpio_ubicacion","cole_mcpio_ubicacion","cole_cod_depto_ubicacion","cole_depto_ubicacion","punt_lenguaje,punt_matematicas","punt_biologia,punt_quimica","punt_fisica","punt_ciencias_sociales","punt_filosofia","punt_ingles","desemp_ingles","profundiza","puntaje_prof","desemp_prof","exito"]
ttd = pandas.read_csv('0_test_balanced_5000.csv')
td = td[0:1500]
ttd = ttd[0:5000]
ttd = ttd.values.tolist()


start_time = time()
my_tree = build_tree(td)
Time = time() - start_time
print("Elapsed training time: %s seconds." % Time)

start_time = time()
prediction = predic(ttd)
Time2 = time() - start_time
print("Elapsed testing time: %s seconds." % Time2)
test_indicators(prediction)