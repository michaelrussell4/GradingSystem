import subprocess as sp
import os

# Method Definitions

def getJavaVersion():
    try:
        output = sp.check_output(['java', '--version'], shell=True)
        return str(output)[7:13]
    except sp.CalledProcessError:
        print('Method: getJavaVersion()\n\tError in finding Java version type!')
        return -1

def grabJavaFilesFromDir():
    try:
        output = sp.check_output(['dir', '/b', '/a-d', '*.java'], shell=True, cwd=gradingDir)
        return str(output)[2:].split(r'\r\n')[1::-1]
    except sp.CalledProcessError:
        print('Method: grabJavaFilesFromDir()\n\tError in finding directory or pulling files!')
        return -1

def engineJava(f, cmd):
    output = [f, 'OUTPUT', True]
    try:
        output[1] = sp.check_output(cmd, stderr=sp.STDOUT, env={'PATH': javaPath})
    except sp.CalledProcessError:
        output[2] = False
    return list(output)

def compileJava(f):
    cmd = 'javac ' + gradingDir + f
    output = engineJava(f, cmd)
    return output

def runjavaNoInput(f):
    cmd = 'java -cp ' + gradingDir + ' ' + f[:-5]
    output = engineJava(f, cmd)
    return output

def countComments(f):
    file = open(gradingDir + f, 'r')
    fileContent = file.read()
    lines = len(fileContent.split('\n'))
    lineComs = fileContent.count('//')
    blockComs = fileContent.count('/*')
    sumComs = lineComs + blockComs
    ratioComs = round(sumComs / lines, 3)
    output = [lines, sumComs, '{:<.1%}'.format(ratioComs)]
    return output

def main():
    for i in range(len(files)):
        comp = compileJava(files[i])
        run = runjavaNoInput(files[i])
        cmt = countComments(files[i])
        print('---------------------------------------------------')
        print('{:<30} {:>20}'.format(('File ' + str(i)), comp[0]))
        print('---------------------------------------------------')
        print('{:<30} {:>20}'.format('Compiled: ', str(comp[2])))
        print('{:<30} {:>20}'.format('Executed: ', str(run[2])))
        print('{:<30} {:>20}'.format('Lines in program:', cmt[0]))
        print('{:<30} {:>20}'.format('Comments in program:', cmt[1]))
        print('{:<30} {:>20}'.format('Comment to lines ratio:', cmt[2]))


# Variable Definitions

javaVersion = getJavaVersion()
wrkDir = os.getcwd()
# javaVir = sp.check_output(['java','-version'])
javaPath = r'C:\Program Files\Java\jdk-' + javaVersion + r'\bin'
gradingDir = wrkDir + '\\GradingSubmissions\\'
files = grabJavaFilesFromDir()

# Drive

main()


