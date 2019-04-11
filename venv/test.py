import os.path,subprocess
# from subprocess import STDOUT,PIPE
# import os, re
#
# def compile_java(java_file):
#     subprocess.check_call(['javac', java_file])
#
# def execute_java(stdin):
#     # java_class,ext = os.path.splitext(java_file)
#     gradingDir = 'C:/Users/Mike/PycharmProjects/GradingSystem_test/venv/NeedGraded'
#     cmd = ['java', '-cp', gradingDir, os.path.splitext('AnotherTester.java')[0]]
#     proc = subprocess.Popen(cmd, stdin=PIPE, stdout=PIPE, stderr=STDOUT)
#     stdout,stderr = proc.communicate(stdin)
#     print(stderr)
#     print(stdout)
#
# file = os.getcwd() + '\\NeedGraded\\AnotherTester.java'
# compile_java(file)
# file = os.getcwd() + '\\NeedGraded\\AnotherTester'
# execute_java(b'J')

b = b'hello blah\n jfjfjf'
print(str(b))
print(b.decode('utf-8'))