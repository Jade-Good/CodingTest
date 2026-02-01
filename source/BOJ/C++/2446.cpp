/*
[별 찍기 - 9]
문제)
	예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.

입력)
	첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력)
	첫째 줄부터 2×N-1번째 줄까지 차례대로 별을 출력한다. */

#include<iostream>

using namespace std;

int main(void) {
	int N;
	cin >> N;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < i; j++)
		{
			cout << " ";
		}
		for (int j = 0; j < (N - i) * 2 - 1; j++)
		{
			cout << "*";
		}
		cout << endl;
	}

	for (int i = 2; i <= N; i++)
	{
		for (int j = 0; j < N - i; j++)
		{
			cout << " ";
		}
		for (int j = 0; j < i * 2 - 1; j++)
		{
			cout << "*";
		}
		cout << endl;
	}

	return 0;
}