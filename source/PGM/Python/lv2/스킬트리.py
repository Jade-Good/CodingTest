# import re

# def solution(skill, skill_trees):
#     return sum(skill.startswith(re.sub('[^' + skill + ']', '', st)) for st in skill_trees)

def solution(skill, skill_trees):
    answer = 0
    
    for st in skill_trees:
        sk_list = list(skill)[::-1]
        
        for c in st:
            if c in skill:
                if sk_list.pop() != c:
                    break
        else:
            answer += 1

    return answer

print(solution("CBD", ["BACDE", "CBADF", "AECB", "BDA"]))