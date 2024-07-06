package S3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_2200_계산기 {
    private static List<Term> terms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        terms = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = N; i >= 0; i--) {
            int input = Integer.parseInt(st.nextToken());
            if (input > 0) {
                terms.add(new Term(input, i));
            }
        }

        Collections.reverse(terms);

        int cnt = 0;

        while (terms.size() > 1) {
            int temp;
            if ((temp = coefDiv()) > 1) { // 계수 나누어 떨어짐 : aa *
                cnt += temp;
            } else if (exponDiv()) { // 지수 나누어 떨어짐 : x *
                cnt += 2;
            } else { // 더하기
                cnt += (int) (Math.log10(terms.get(0).coefficient) + 1) + 1;
                terms.remove(0);
            }
        }

        Term lastTerm = terms.get(0);
        if (lastTerm.coefficient > 1)
            cnt += (int) (Math.log10(terms.get(0).coefficient) + 1) + 1;
        if (lastTerm.exponent > 0) {
            cnt += lastTerm.exponent * 2;
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }

    private static int coefDiv() { // 계수

        int gcd = findGCD(); // 각 항의 계수들의 최대공약수
        if (gcd == 1)
            return gcd;
        for (Term term : terms) {
            term.coefficient /= gcd;
        }
        return (int) (Math.log10(gcd) + 1) + 1;
    }

    private static boolean exponDiv() { // 지수
        if (terms.get(0).exponent == 0) {
            return false;
        }

        for (Term term : terms) {
            term.exponent--;
        }

        return true;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int findGCD() {
        int result = terms.get(0).coefficient;
        for (Term term : terms) {
            result = gcd(result, term.coefficient);
        }
        return result;
    }

    private static class Term {
        int coefficient; // 계수
        int exponent; // 지수

        public Term(int coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
        }
    }
}

/*

// 1)
3
1 0 1 11
// ans : 11

//=> x^3 + x + 11
//-> x * x * x + x + 1 1 =


// 2)
3
1 2 0 11

// ans : 11

//=> x^3 + 2x^2 + 11
//-> x + 2 * x * x + 1 1 =
//<- = 1 1 + x * x * 2 + x

//: 역으로 계산해서 최적값을 내면 됨
//1. 나누어 떨어지는 계수 먼저 떼기
//2. 나누어 떨어지는 지수 떼기
//3. 없으면 + 를 떼기

// 3)
1
10 10

// ans : 7
// => 10x + 10
// <- = 1 0 * 1 + x
// -> x + 1 * 1 0 =

 */