## 멘토님 풀이 ##
# from collections import defaultdict, Counter

# def solution(id_list, report, k):

#     report_dict = defaultdict(set) 
#     report_cntr = Counter()

#     for r in report: # {user1가 신고한 user2들} 인 dict 생성
#         user1, user2 = r.split()
#         report_dict[user1].add(user2)

#     for v in report_dict.values(): # 신고당한횟수 인 dict 생성
#         report_cntr.update(v)

#     blacklist = {x for x in report_cntr if report_cntr[x] >= k} # {신고를 k번 이상 당한 사람들} set 생성

#     return [len(report_dict[user] & blacklist) for user in id_list] # 1과 3을 이용하여 user1이 신고한 사람들중에 k번 이상 신고당한 사람들 숫자 도출


def solution(id_list, report, k):
    answer = {}
    for i in id_list:           # 유저 ID 명단
        answer[i] = 0
    
    dic = {}
    for s in report:            # 신고 현황 (중복제거)
        a, b = s.split()
        if b in dic.keys():
            dic[b].add(a)
        else:
            dic[b] = set()
            dic[b].add(a)

    for value in dic.values():  # 알람 카운트
        if len(value) >= k:
            for i in value:
                answer[i] += 1

    return list(answer.values())

id_list = ["muzi", "frodo", "apeach", "neo"]
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
k = 2

# id_list = ["con", "ryan"]
# report = ["ryan con", "ryan con", "ryan con", "ryan con"]
# k = 3

print(solution(id_list, report, k))
            

    