# from collections import defaultdict, Counter
# from itertools import combinations

# def solution(orders, course):
    
#     cntr = defaultdict(Counter) # {2:{'AB': 3, 'CD': 1, ...}, ...}
    
#     for order in orders: # 1 : 각 order에 대해 combinations로 가능한 조합 뽑아서 Counter에 저장
#         for n in course:
#             if n <= len(order):
#                 cntr[n].update(combinations(sorted(order), n))
            
#     answer = []
    
#     for n in cntr:
#         max_cnt = max(cntr[n].values()) # 2 : order 수에 대해 최대 빈도수 구하기
#         if max_cnt > 1:
#             answer += [''.join(k) for k, v in cntr[n].items() if v == max_cnt] # 3 : 2에서 얻은 빈도수랑 같은 콤보세트 구하기
    
#     return sorted(answer) # 4 : 정렬해서 반환

def solution(orders, course):
    dic = {}
    def find_str(s, pick, d, j): # 재귀로 문자 조합
        if len(pick) >= d:          # 찾는 길이(d)의 문자가 완성되면
            pick = ''.join(sorted(list(pick))) # 문자열 오름차순 정렬
            if pick in dic:             # 딕셔너리에 저장
                dic[pick] += 1
            else:
                dic[pick] = 0
            return
        
        for i in range(j,len(s)):   # 문자 조합을 위해 재귀
            find_str(s, pick+s[i], d, i+1)

    for c in course: # 문자열 길이
        for i in orders: # 분해 할 문자열
            find_str(i, "", c, 0)

    temp = []
    for c in course: # 문자열 길이별로 딕셔너리를 분해
        temp.append({k:v for k, v in dic.items() if len(k) == c})

    answer = []
    for d in temp:
        for k, v in d.items(): # 길이별 딕셔너리에서 value 최대값의 key를 저장
            if max(d.values()) == v and max(d.values()) != 0:
                answer.append(k)
    return sorted(answer) # 오름차순 반환

# orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
# course = [2,3,4]
# orders = ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]
# course = [2,3,5]	
orders = ["XYZ", "XWY", "WXA"]
course = [2,3,4]	
print(solution(orders, course))