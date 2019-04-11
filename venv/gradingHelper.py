import subprocess as sp
import os, re, os.path
from subprocess import STDOUT, PIPE

class javaEngine:

    # Class variables

    wrkDir = os.getcwd()

    def __init__(self, newGrdDir='\\NeedGraded\\', javaVersion=''):
        self.grdDir = self.wrkDir + newGrdDir
        if javaVersion == '':
            javaVersion = self.getJavaVersion()
        self.javaPath = r'C:\Program Files\Java\jdk-' + javaVersion + r'\bin'
        self.ioReport = []

    # Method Definitions

    def getJavaVersion(self):
        try:
            output = sp.check_output(['java', '--version'], shell=True)
            return str(output)[7:13]
        except sp.CalledProcessError:
            print('Method: getJavaVersion()\n\tError in finding Java version type!')
            return -1

    def grabJavaFilesFromDir(self, gradingDir=''):
        if gradingDir == '': gradingDir = self.grdDir
        try:
            output = sp.check_output(['dir', '/b', '/a-d', '*.java'], shell=True, cwd=gradingDir)
            ret = str(output)[2:].split(r'\r\n')[:-1]
            return ret
        except sp.CalledProcessError:
            print('Method: grabJavaFilesFromDir()\n\tError in finding directory or pulling files in dir: ' + gradingDir)
            return -1

    def engineJava(self, f, cmd, stdin=''):
        noInput = True
        if stdin == '':
            noInput = False
        # output = file name, output of program, if it ran/compiled, error log
        output = [f, 'OUTPUT', True, 'no error log']
        try:
            if(cmd[0] == 'javac'):
                output[1] = str(sp.check_output(cmd, stderr=sp.STDOUT, env={'PATH': self.javaPath}, timeout=4))
                return output
            proc = sp.Popen(cmd, stdin=PIPE, stdout=PIPE, stderr=STDOUT)
            stdout,stderr = proc.communicate(stdin)
            output[1] = stdout.decode('utf-8')
            if re.search('Exception', str(stdout)):
                output[3] = str(stdout)[re.search("Exception",str(stdout)).start()]
                raise Exception("Exception: Mismatch input with expected input count")
        except sp.CalledProcessError:
            output[2] = False
        except sp.TimeoutExpired:
            print('Timeout error on file: {}, may required input that wasn\'t given'.format(f))
        except Exception as e:
            output[2] = False
            print('{}'.format(e))
        return list(output)

    def compileJava(self, f, gradingDir=''):
        if gradingDir == '': gradingDir = self.grdDir
        cmd = ['javac', gradingDir + f]
        output = self.engineJava(f, cmd)
        return output

    def runJava(self, f, stdin='', gradingDir=''):
        if gradingDir == '': gradingDir = self.grdDir
        cmd = ['java', '-cp', gradingDir, os.path.splitext(f)[0]]
        output = self.engineJava(f, cmd, stdin=stdin)
        return output

    def countComments(self, f, gradingDir=''):
        if gradingDir == '':
            gradingDir = self.grdDir
        file = open(gradingDir + f, 'r')
        fileContent = file.read()
        lines = len(fileContent.split('\n'))
        lineComs = fileContent.count('//')
        blockComs = fileContent.count('/*')
        sumComs = lineComs + blockComs
        ratioComs = round(sumComs / lines, 3)
        output = [lines, sumComs, '{:<.1%}'.format(ratioComs)]
        return output

    def mainReport(self, files='', stdio=('','')):
        if files == '' :
            files = self.grabJavaFilesFromDir()
        containsIO = True
        if stdio == ('',''):
            containsIO = False
        try:
            for i in range(len(files)):
                comp = self.compileJava(files[i])
                run = self.runJava(files[i], stdin=stdio[0])
                cmt = self.countComments(files[i])
                print('---------------------------------------------------')
                print('{:<30} {:>20}'.format(('File ' + str(i)), comp[0]))
                print('---------------------------------------------------')
                print('{:<30} {:>20}'.format('Compiled: ', str(comp[2])))
                print('{:<30} {:>20}'.format('Executed: ', str(run[2])))
                print('{:<30} {:>20}'.format('Lines in program:', cmt[0]))
                print('{:<30} {:>20}'.format('Comments in program:', cmt[1]))
                print('{:<30} {:>20}'.format('Comment to lines ratio:', cmt[2]))
                if containsIO:
                    myInput = stdio[0].decode('utf-8')
                    myInput = myInput.split('\n')
                    print('            ------------Input------------')
                    for ln in myInput:
                        print(ln)
                    myOutput = run[1]
                    print('            -----------Output------------')
                    myOutput = myOutput.split('\r')
                    for ln in myOutput:
                        ln = ln.split('\n')
                        for il in ln:
                            print(il)
                    self.ioReport.append([files[i], myInput, myOutput])
                else:
                    self.ioReport.append([files[i], '', run[1]])
            return self.ioReport

        except Exception as e:
            print('Error with files or directory')

class javaGrader:

    def __init__(self, newGrdDir='\\NeedGraded\\', stdio=('','')):
        je = javaEngine(newGrdDir)
        self.results = je.mainReport(stdio=stdio)

    def getResults(self):
        return self.results




