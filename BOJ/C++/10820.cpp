/*
[문자열 분석]
문제)
	문자열 N개가 주어진다.
	이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
	각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.

입력)
	첫째 줄부터 N번째 줄까지 문자열이 주어진다. (1 ≤ N ≤ 100) 문자열의 길이는 100을 넘지 않는다.

출력)
	첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다. */

#include<iostream>
#include<string>
using namespace std;

int main(void) {
	string s;

	while (getline(cin, s))
	{
		int sum[4] = { 0 };
		for (char c : s) {
			if ('a' <= c && c <= 'z')
			{
				sum[0]++;
			}
			else if ('A' <= c && c <= 'Z')
			{
				sum[1]++;
			}
			else if ('0' <= c && c <= '9')
			{
				sum[2]++;
			}
			else if (c == ' ')
			{
				sum[3]++;
			}
		}
		printf("%d %d %d %d \n", sum[0], sum[1], sum[2], sum[3]);
	}
	return 0;
}