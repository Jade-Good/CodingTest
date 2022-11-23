# 백준에서 이미 풀은 문제를 조회해, 아직 안 풀은 문제인지 출력하는 프로그램

import sys
import urllib.request
from bs4 import BeautifulSoup
import time
import random

def find_problem(find_id):
    # 너무 많이 접속하면 차단되므로 이상한 접속이 아님을 헤더로 밝힘
    header = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36'}

    # 백준 유저 페이지(맨 뒤에 아이디 추가)
    url = "https://www.acmicpc.net/user/"

    size = len(find_id)
    count = 1

    for i in find_id:
        # # 접속 부하 방지로 사이트 차단 방지를 위해 사용자 클릭 처럼 랜덤 sleep
        # rand_value = random.randint(1, 3)
        # time.sleep(rand_value)

        print(f"[{count}/{size}] find : {i}")
        count += 1

        req = urllib.request.Request(url =(url+i), headers=header)  # 리퀘스트 생성
        url_open = urllib.request.urlopen(req)                      # url 접속
        bs_obj = BeautifulSoup(url_open, "html.parser")             # html 파싱
        problem_list = bs_obj.find("div", {"class", "problem-list"})# 문제 a태그 리스트
        for pl in problem_list:
            problem.add(pl.text)



# 푼 문제를 찾을 아이디
find_id = ['kangsm423','wndnjs1839','yoon6763','iomanip0107','jcw1031','iamdek','digh0515','spalqj56','apircity','ckwnsgur0702','chch_xili']
# find_id = []

print("==================================\n\n\t백준 문제 크로스체크 프로그램\n\n==================================\n")
problem = set()
level_problem = []

while True:
    print(" 1) 푼 문제 리스트 불러오기  2) 크로스 체크  3) 아이디 추가  4) 레벨별 문제 파일 불러오기  0) 종료")
    order = input("실행할 번호를 입력하세요 : ")

    if order == '1':
        print("\n>> 푼 문제 리스트 불러오기\n")
        find_problem(find_id)
        print("\n문제 총 개수 :", len(problem))


    elif order == '2':
        if len(problem) == 0:
                print("\n먼저 푼 문제 리스트를 불러와주세요.\n")
        else:
            order = input("\n>>  1) '문제 텍스트 파일' 크로스체크\t 2) '직접 입력' 크로스체크\n")
            if order == '1':
                level = ""
                level_list = ['B', 'S'] # 브론즈, 실버만 구현

                # 텍스트 파일 읽어오기
                print("\n 문제 리스트 파일 읽는 중...",end="")
                f = open("D:\github\CodingTest\problem_list.txt",'r')
                line_temp = []

                lines = f.readlines()

                for line in lines:
                    line = line.rstrip()
                    if line == '':
                        level_problem.append(line_temp)
                        line_temp = []
                    else:
                        line_temp.append(line)
                print("완료\n")

                # 크로스체크
                while level != " ":
                    level = input('레벨을 입력하세요(ex. B1 / 종료:공백):')
                    if len(level)!=2 or level[0] not in level_list:
                        print('잘못입력하셨습니다.')
                    else:
                        idx = level_list.index(level[0])*5+(5-int(level[1]))
                        print("\n-----level", level, "에서 풀지않은 문제 리스트-----")
                        for p in level_problem[idx]:
                            if p not in problem:
                                print(p)
                        print("\n------------------------------------------")
            elif order == '2':
                print("\n>> 풀었던 문제인지 조회")
                while True:
                    pb_list = input("\n검색할 번호 입력(복수는 공백으로 구분, 공백으로 종료) : ").split()
                    if len(pb_list) == 0:
                        break
                    flag = True
                    for pb in pb_list:
                        if pb in problem:
                            print(pb,"는 이미 풀었습니다.")
                            flag = False
                    if flag:
                        print("모두 풀지 않은 문제입니다.")
            else:
                print('잘못입력하셨습니다.')


    elif order == '3':
        order = input("\n>>  1) 공백 구분\t 2) 줄바꿈 구분(종료 : 0)\n")
        temp = []
        if order == '1':
            temp = sys.stdin.readline().rstrip().split()
        elif order =='2':
            ss = ""
            while ss != "0":
                ss = input()
                temp.append(ss)
        else:
            print('잘못입력하셨습니다.')
        for i in temp[:-1]:
            id = i.replace(" ","")
            if id not in find_id and id != "":
                find_id.append(id)
        print(find_id)


    elif order == '0':
        print("\n>> 종료")
        break
    else:
        print("\n>> 잘못된 숫자를 입력")
    input("\n[Enter]")
    print("\n==================================\n")
