package Lv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class YeahbutHow {

    public static void main(String[] args) throws IOException {
        // Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = br.readLine().toCharArray();

        // 수식 만들기
        StringBuilder sb = new StringBuilder();
        sb.append('(');

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(' && chars[i - 1] == ')') {
                sb.append('+').append('(');
            } else if (chars[i] == ')' && chars[i - 1] == '(') {
                sb.append('1').append(')');
            } else {
                sb.append(chars[i]);
            }
        }

        // Output
        bw.write(sb.toString());
        bw.flush();
    }
}

/*
< 문제 분석 >
- 입력 S : 균형 잡힌 괄호 문자열 (최대 길이 20만)
- '1'과 '+'를 넣어서 제대로된 수식 만들어 출력하기

< 풀이 계획 >
- '(' 뒤에는 '1'을 넣고, ')' 뒤에는 '+'를 넣으면 될 것 같다. (X)
- 시간 복잡도
    - S의 길이 l 만큼만 걸릴듯
    - O(l) = O(200,000) = 0.002초

< 1회 피드백 >
- '('와 ')' 사이에만 '1' 넣기
- ')'와 '(' 사이에만 '+' 넣기
*/
