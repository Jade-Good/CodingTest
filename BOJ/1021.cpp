/*
[회전하는 큐]
문제)
지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다.
지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.
지민이는 이 큐에서 다음과 같은 3가지 연산을 수행할 수 있다.
1. 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
2. 왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
3. 오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다.
(이 위치는 가장 처음 큐에서의 위치이다.)
이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.

입력)
첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다.
N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다.
둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다.
위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.

출력)
첫째 줄에 문제의 정답을 출력한다.
*/


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

		//출력 테스트
		/*cout << "\nque : ";
		for (int j : que) {
			cout << j << " ";
		}
		cout << "\npic : " << pick << "  idx : " << idx << endl;*/
		
		while (true) {
			if (que.front() == pick) {	//값을 찾음
				que.erase(que.begin());
				size--;
				break;
			}
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
	}
	cout << answer;
	return 0;
}