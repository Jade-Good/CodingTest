#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(void) {
	int N, M, answer = 0;
	cin >> N >> M;

	vector<int> que(N);	//큐로 사용할 vector

	for (int i = 0; i < N; i++)	//큐에 1~N 값 넣어주기
		que[i] = i + 1;

	int size = N, pick, idx, temp;	//현재 큐의 크기, 찾는 값, 찾는 값의 인덱스, 임시 변수

	for (int i = 0; i < M; i++) {
		cin >> pick;	//찾는 값
		idx = find(que.begin(), que.end(), pick) - que.begin();	//찾는 값의 인덱스
		
		while (que.front() != pick) { //찾는 값이 나올때까지 반복
			if (idx <= size / 2) {		//큐를 왼쪽으로 밀기
				temp = que.front();
				que.erase(que.begin());
				que.push_back(temp);
			}
			else {						//큐를 오른쪽으로 밀기
				temp = que.back();
				que.erase(que.end()-1);
				que.insert(que.begin(), temp);
			}
			answer++;
		}
		que.erase(que.begin());
		size--;
	}
	cout << answer;
	return 0;
}