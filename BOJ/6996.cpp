/*
[애너그램]
문제)
	두 단어 A와 B가 주어졌을 때, A에 속하는 알파벳의 순서를 바꾸어서 B를 만들 수 있다면, A와 B를 애너그램이라고 한다.
	두 단어가 애너그램인지 아닌지 구하는 프로그램을 작성하시오.

입력)
	첫째 줄에 테스트 케이스의 개수(<100)가 주어진다.
	각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 100을 넘지 않는 단어가 공백으로 구분되어서 주어진다.
	단어는 알파벳 소문자로만 이루어져 있다.

출력)
	각 테스트 케이스마다 애너그램인지 아닌지를 예체 출력과 같은 형식으로 출력한다.

출력 형식)
	정확한 출력 형식은 제출에서 언어를 Java로 설정하면 확인할 수 있다. */

#include<iostream>
#include<string>
#include<algorithm>
using namespace std;

int main(void) {
	int N;
	string A,B;

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> A >> B;
		string ta = A, tb = B;
		sort(A.begin(), A.end());
		sort(B.begin(), B.end());
		cout << A << " " << B << endl;

		if (A == B)
			cout << ta << " & " << tb << " are anagrams." << endl;
		else
			cout << ta << " & " << tb << " are NOT anagrams." << endl;
	}
	return 0;
}