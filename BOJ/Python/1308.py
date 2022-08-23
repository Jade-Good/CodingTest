from datetime import datetime

today = list(map(int, input().split()))
dday = list(map(int, input().split()))

today_date = (datetime(year=today[0], month=today[1], day=today[2]))
dday_date = (datetime(year=dday[0], month=dday[1], day=dday[2]))

dday_days = (dday_date - today_date).days

year_day_1000 = 0
for i in range(today[0], today[0]+1000):
    if i % 400 == 0:
        year_day_1000 += 366
    elif i % 100 == 0:
        year_day_1000 += 365
    elif i % 4 == 0:
        year_day_1000 += 366
    else:
        year_day_1000 += 365

if dday_days >= year_day_1000:
    print("gg")
else:
    print(f"D-{dday_days}")