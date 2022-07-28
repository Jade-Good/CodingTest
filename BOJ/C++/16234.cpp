/*
[인구 이동]

문제)
	N×N크기의 땅이 있고, 땅은 1×1개의 칸으로 나누어져 있다.
	각각의 땅에는 나라가 하나씩 존재하며, r행 c열에 있는 나라에는 A[r][c]명이 살고 있다.
	인접한 나라 사이에는 국경선이 존재한다. 모든 나라는 1×1 크기이기 때문에, 모든 국경선은 정사각형 형태이다.
	오늘부터 인구 이동이 시작되는 날이다.
	인구 이동은 하루 동안 다음과 같이 진행되고, 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속된다.
	국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.
	위의 조건에 의해 열어야하는 국경선이 모두 열렸다면, 인구 이동을 시작한다.
	국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합이라고 한다.
	연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다. 편의상 소수점은 버린다.
	연합을 해체하고, 모든 국경선을 닫는다.
	각 나라의 인구수가 주어졌을 때, 인구 이동이 며칠 동안 발생하는지 구하는 프로그램을 작성하시오.

입력)
	첫째 줄에 N, L, R이 주어진다. (1 ≤ N ≤ 50, 1 ≤ L ≤ R ≤ 100)
	둘째 줄부터 N개의 줄에 각 나라의 인구수가 주어진다. r행 c열에 주어지는 정수는 A[r][c]의 값이다. (0 ≤ A[r][c] ≤ 100)
	인구 이동이 발생하는 일수가 2,000번 보다 작거나 같은 입력만 주어진다.

출력)
	인구 이동이 며칠 동안 발생하는지 첫째 줄에 출력한다. */

#include<iostream>
#include<vector>
#include<queue>
#include<cmath>

using namespace std;

int BFS(vector<vector<int>>& A, int& i, int& j, vector<vector<int>>& group,
			int& G_count, int& L, int& R, vector<vector<int>>& same_G_list) {
	int sum = 0;
	queue<vector<int>> q;
	vector<int> pair(2);
	pair[0] = i;
	pair[1] = j;

	q.push(pair);
	group[i][j] = G_count;

	while (!q.empty()) {
		pair = q.front();
		int now_i = pair[0];
		int now_j = pair[1];
		sum += A[now_i][now_j];
		same_G_list[G_count].push_back(now_i);
		same_G_list[G_count].push_back(now_j);
		//printf("pair[0] : %d    pair[1] : %d     G_count : %d\n", pair[0], pair[1], G_count);

		// left
		int next_i = now_i;
		int next_j = now_j - 1;
		if (next_j >= 0 && group[next_i][next_j] == 0 
					&& abs(A[now_i][now_j] - A[next_i][next_j]) >= L 
					&& abs(A[now_i][now_j] - A[next_i][next_j]) <= R) {
			pair[0] = next_i;
			pair[1] = next_j;
			q.push(pair);
			group[next_i][next_j] = G_count;
		}

		//top
		next_i = now_i - 1;
		next_j = now_j;
		if (next_i >= 0 && group[next_i][next_j] == 0 
					&& abs(A[now_i][now_j] - A[next_i][next_j]) >= L 
					&& abs(A[now_i][now_j] - A[next_i][next_j]) <= R) {
			pair[0] = next_i;
			pair[1] = next_j;
			q.push(pair);
			group[next_i][next_j] = G_count;
		}

		//right
		next_i = now_i;
		next_j = now_j + 1;
		if (next_j < A.size() && group[next_i][next_j] == 0 
					&& abs(A[now_i][now_j] - A[next_i][next_j]) >= L 
					&& abs(A[now_i][now_j] - A[next_i][next_j]) <= R) {
			pair[0] = next_i;
			pair[1] = next_j;
			q.push(pair);
			group[next_i][next_j] = G_count;
		}

		//bottom
		next_i = now_i + 1;
		next_j = now_j;
		if (next_i < A.size() && group[next_i][next_j] == 0 
					&& abs(A[now_i][now_j] - A[next_i][next_j]) >= L 
					&& abs(A[now_i][now_j] - A[next_i][next_j]) <= R) {
			pair[0] = next_i;
			pair[1] = next_j;
			q.push(pair);
			group[next_i][next_j] = G_count;
		}

		q.pop();
	}

	return sum;
}

int main(void) {
	int N, L, R, day = -1, G_count;
	cin >> N >> L >> R;
	vector<vector<int>> A(N, vector<int>(N, 0));

	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++)
			cin >> A[i][j];

	bool flag = true;
	while (flag) {
		flag = false;
		vector<vector<int>> group(N, vector<int>(N, 0)); // 소속 그룹
		vector<int> groupSum(N * N + 1, 0);
		vector<vector<int>> same_G_list(N * N + 1, vector<int>());
		G_count = 0;

		// 모든 나라를 방문하며 BFS 준비
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (group[i][j] == 0) {	// 소속 그룹이 없다면 BFS 시작
					G_count++;
					groupSum[G_count] = BFS(A, i, j, group, 
							G_count, L, R, same_G_list);

					if (groupSum[G_count] > A[i][j])
						flag = true;
						// flag = true면 다음 날 검사를 다시 해야함
				}
			}
		}

		// 그룹 평균 처리
		for (int g = 1; g <= G_count; g++)
		{
			int size = same_G_list[g].size();
			int avg = groupSum[g] / (size / 2);

			for (int c = 0; c < size; c+=2)
			{
				A[same_G_list[g][c]][same_G_list[g][c + 1]] = avg;
			}
		}
		day++;
	}
	cout << day;

	return 0;
}