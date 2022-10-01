# 백준에서 이미 풀은 문제를 조회해, 아직 안 풀은 문제인지 출력하는 프로그램

import urllib.request
from bs4 import BeautifulSoup

def find_problem(find_id):
    # 너무 많이 접속하면 차단되므로 이상한 접속이 아님을 헤더로 밝힘
    header = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36'}

    # 백준 유저 페이지(맨 뒤에 아이디 추가)
    url = "https://www.acmicpc.net/user/"

    for i in find_id:
        print("find : ", i)
        req = urllib.request.Request(url =(url+i), headers=header)  # 리퀘스트 생성
        url_open = urllib.request.urlopen(req)                      # url 접속
        bs_obj = BeautifulSoup(url_open, "html.parser")             # html 파싱
        problem_list = bs_obj.find("div", {"class", "problem-list"})# 문제 a태그 리스트
        for pl in problem_list:
            problem.add(pl.text)

# 푼 문제를 찾을 아이디
find_id = ['yoon6763', 'kangsm423', 'iomanip0107', 'apircity', 'spalqj56', 'iamdek', 'digh0515']

print("==================================\n\n\t백준 문제 크로스체크 프로그램\n\n==================================\n")
problem = set()

while True:
    print(" 1) 푼 문제 리스트 불러오기\t2) 풀었던 문제인지 조회\t3) 종료")
    order = input("실행할 번호를 입력하세요 : ")

    if order == '1':
        print("\n>> 푼 문제 리스트 불러오기\n")
        find_problem(find_id)
        print("\n문제 총 개수 :", len(problem))
    elif order == '2':
        print("\n>> 풀었던 문제인지 조회")
        if len(problem) == 0:
            print("\n먼저 푼 문제 리스트를 불러와주세요.")
        else:
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
    elif order == '3':
        print("\n>> 종료")
        break
    else:
        print("\n>> 잘못된 숫자를 입력")
    input("\n[Enter]")
    print("\n==================================\n")
