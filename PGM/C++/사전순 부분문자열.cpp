/*
[ lv2_사전순 부분문자열 ]
문제 설명)
어떤 문자열 s가 주어졌을 때, s로부터 만들 수 있는 부분 문자열 중 사전 순으로 가장 뒤에 나오는 문자열을 찾으려 합니다. 부분 문자열을 만드는 방법은 다음과 같습니다.
 1. s에서 일부 문자를 선택해 새로운 문자열을 만듭니다.
 2. 단, 이때 문자의 순서는 뒤바꾸지 않습니다.
예를 들어 문자열 "xyb"로 만들 수 있는 부분 문자열은 다음과 같습니다.

x
y
b
xy
xb
yb
xyb

이 중 사전 순으로 가장 뒤에 있는 문자열은 "yb"입니다.
문자열 s가 주어졌을 때 s로부터 만들 수 있는 부분 문자열 중 사전 순으로 가장 뒤에 나오는 문자열을 리턴하는 solution 함수를 완성해주세요.

제한 사항)
s는 길이가 1 이상 1,000,000 이하인 문자열입니다.
s는 알파벳 소문자로만 이루어져 있습니다.

입출력 예)
s	result
"xyb"	"yb"
"yxyc"	"yyc"

입출력 예 설명)
 입출력 예 #1 : 앞서 설명한 예와 같습니다.

 입출력 예 #2 : "yxyc"로 만들 수 있는 부분 문자열은 다음과 같습니다.

y
x
c
yx
yy
yc
xy
xc
yxy
yxc
yyc
xyc
yxyc

이 중 사전 순으로 가장 뒤에 나오는 문자열은 "yyc"입니다.
*/
#include <vector>
#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(void) {
    string answer = "", str;

    cin >> str;

    auto iter = str.begin();

    while (iter < str.end()) {
        iter = max_element(iter, str.end());
        answer += *(iter++);
    }

    cout << "\n\n answer \n\n" << answer;

    return 0;
}