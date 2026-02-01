#include<iostream>
#include<algorithm>

using namespace std;

int main(void) {
	char arr[16] = { 0 };
	int row, col;
	int answer = 0;

	for (int i = 0; i < 16; i++) {
		cin >> arr[i];
		if (arr[i] != '.') {
			col = i % 4;
			row = i / 4;
			answer += abs((arr[i] - 'A' - i) / 4) + abs((arr[i] - 'A' - i);
		}
	}
	cout << answer;

	return 0;
}