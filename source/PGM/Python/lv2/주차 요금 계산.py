from collections import defaultdict

def solution(fees, records):
    
    basic_t, base_price, unit_t, unit_price = fees
    
    def price(log, fees): # 2
        if len(log) % 2:
            log.append(23*60+59)
        t = sum(log[i+1] - log[i] for i in range(0, len(log), 2))
        return unit_price * -(-max(0, t-basic_t) // unit_t) + base_price
    
    log = defaultdict(list)
    
    for record in records: # 1
        t, n, _ = record.split()
        h, m = map(int, t.split(':'))
        log[n].append(60*h+ m)
    
    return [price(log[n], fees) for n in sorted(log)] # 3
# import math

# def solution(fees, records):
#     parking = {}
#     check = {}
#     answer = {}

#     for i in records:
#         time, number, order = i.split()
#         now = list(map(int,time.split(':')))
#         now_m = now[0] * 60 + now[1]
#         if order == "IN":
#             parking[number] = now_m
#             check[number] = True
#             if number not in answer:
#                 answer[number] = 0
#         else:
#             check[number] = False
#             answer[number] += now_m - parking[number]

#     for i, flag in check.items():
#         if flag:
#             answer[i] += (23*60+59) - parking[i]
#             check[i] = True

#     for num, v in answer.items():
#         if v > fees[0]:  # 요금 계산
#             answer[num] = fees[1] + (math.ceil((v - fees[0])/fees[2]))*fees[3]
#         else:
#             answer[num] = fees[1]

#     return list(dict(sorted(answer.items())).values())



fees = [180, 5000, 10, 600]
records = ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]
# fees = [120, 0, 60, 591]
# records = ["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]
# fees = [1, 461, 1, 10]
# records = ["00:00 1234 IN"]

print(solution(fees, records))