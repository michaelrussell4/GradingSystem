'''
Developor:      Michael Russell

This program compiles, runs, and grades the assignment as described below

Assignment 1:
Build a Java program that prints out the following information:

My name is [Your Name].
My favorite movie is [Your Favorite Movie].
'''

from gradingHelper import javaGrader

print('{0}\n Running Grader_Assignment1: \n{0}\n'.format('-'*30))



stdio = (b'','My name is.. My favorite movie is...')

jg = javaGrader(stdio=stdio, newGrdDir='\\Assignments\\Assignment1\\')

print(jg.getResults())



