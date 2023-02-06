# sovled.ac 레벨 별 문제리스트 파일 저장(레벨별 공백 구분)

import urllib.request
from bs4 import BeautifulSoup
import time
import random


def find_problem(url):
    print(url)
    temp = set()
    # 너무 많이 접속하면 차단되므로 이상한 접속이 아님을 헤더로 밝힘
    header = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36'}

    # 접속 부하 방지로 사이트 차단 방지를 위해 사용자 클릭 처럼 랜덤 sleep
    rand_value = random.randint(1, 3)
    time.sleep(rand_value)

    # 백준 유저 페이지(맨 뒤에 아이디 추가)
    req = urllib.request.Request(url=(url), headers=header)     # 리퀘스트 생성
    url_open = urllib.request.urlopen(req)                      # url 접속
    bs_obj = BeautifulSoup(url_open, "html.parser")             # html 파싱
    tbody = bs_obj.find("tbody", {"class", "css-1d9xc1d"})      # 문제 테이블
    tr_list = tbody.findAll("tr")                               # tr 리스트 : 접속 차단시 여기서 오류남

    for tl in tr_list:
        span = tl.find('td').find('a').find('span')
        # print(span.text)
        temp.add(span.text)
    print(temp)
    return temp


problem = []
sizes = [2, 4, 11, 17, 13, 14, 14, 14, 15, 15]  # B5~S1 페이지 수

url = 'https://solved.ac/problems/level/'

for i in range(len(sizes)):
    temp = set()
    for j in range(1, sizes[i] + 1):
        temp.update(find_problem(url + str(i + 1) + '?page=' + str(j)))
    problem.append(list(temp))

f = open("problem_list.txt", 'w')
for pl in problem:
    for p in pl:
        sp = str(p) + "\n"
        f.write(sp)
    f.write(" \n")
f.close()
