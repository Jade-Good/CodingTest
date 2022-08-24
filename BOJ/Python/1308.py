from datetime import datetime

today = list(map(int, input().split()))
dday = list(map(int, input().split()))

today_date = datetime(year=today[0], month=today[1], day=today[2])
dday_date = datetime(year=dday[0], month=dday[1], day=dday[2])
dday_days = (dday_date - today_date).days
year_day_1000 = (datetime(year=today[0]+1000, month=today[1], day=today[2])-today_date).days

if dday_days >= year_day_1000:
    print("gg")
else:
    print(f"D-{dday_days}")