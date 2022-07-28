# [짝 곱]
# 문제)
# 정수 K (1 ≤ K ≤ 100,000)가 주어진다. 이때, K보다 크거나 같은 서로 다른 소수의 곱 중에서 가장 작은 곱을 찾는 프로그램을 작성하시오.
# 입력)
# 첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 20)이 주어진다. 다음 T개 줄에는 K가 한 줄에 하나씩 주어진다. 
# 출력)
# 각각의 K마다 K보다 크거나 같은 서로 다른 두 소수의 곱 중에서 가장 작은 곱을 출력한다.
# 예제 입력 1 )
# 5
# 1
# 3
# 10
# 300
# 100000
# 예제 출력 1 )
# 6
# 6
# 10
# 301
# 100001
# 힌트)
# K=1인 경우 답은 6 = 2 × 3이다. 6은 서로 다른 두 소수의 곱 중에서 가장 작은 곱이다. 4 = 2 × 2 이기 때문에, 정답이 되지 않는다.
# 세 번째 예제 K=10인 경우에 정답은 10 = 2 × 5 이다.
# 마지막 예제 K=100000인 경우 정답은 100001 = 11 × 9091 이다.

T = range(int(input()))
arr = list()

for i in T:
    arr.append(int(input()))
m = max(arr)

visit = list([True]*(m+1))
prime = []

for i in range(2,m):
    if visit[i]:
        prime.append(i)
        c = 2
        while i*c < m:
            visit[i*c] = False
            c += 1

print(prime)

answer = list(range(len(arr)))
index = 0
for i in arr:
    print("answer :",answer)
    mingap = m+100
    for a in range(len(prime)-1):
        gap = i-prime[a]*prime[a+1]
        # if abs(gap) > mingap and gap <= 0:
        #     print("a break gap :",gap)
        #     break
        for b in range(a+1, len(prime)):
            gap = i - prime[a]*prime[b]
            if mingap > abs(gap) and gap <= 0:
                mingap = gap
                answer[index] = prime[a]*prime[b]
                print("mingap :",mingap," prime[a] :",prime[a]," prime[b] :",prime[b])
                print("a :",a," b :",b)
                break
    index += 1

print(answer)
