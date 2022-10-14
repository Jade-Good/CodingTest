level_problem = []

print("\n 문제 리스트 파일 읽는 중...",end="")
f = open("D:\github\CodingTest\problem_list.txt",'r')
line_temp = []

lines = f.readlines()
# print(lines)

for line in lines:
    line = line.rstrip()
    if line == '':
        level_problem.append(line_temp)
        line_temp = []
    else:
        line_temp.append(line)
print("완료\n")
print(len(level_problem))