import sys
input = sys.stdin.readline
# print = sys.stdout.write

N = int(input())

flower_bed = []
check = [[0]*N for _ in range(N)]
one = []
two = []
thr = []
answer = 0

for i in range(N):
    n = list(map(int,input().strip().split()))
    flower_bed.append(n)

print(flower_bed)