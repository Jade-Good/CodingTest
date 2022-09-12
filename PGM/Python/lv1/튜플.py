from collections import Counter
from re import findall

def solution(s):
    return [int(n) for n, _ in Counter(findall('\d+', s)).most_common()]

# from collections import Counter

# def solution(s):
#     answer = []

#     for i in '{},':
#         s = s.replace(i," ")
    
#     nums = [int(n) for n in s.split()]
#     cnt = Counter(nums)

#     answer = [n for n, _ in cnt.most_common()]
#     return answer