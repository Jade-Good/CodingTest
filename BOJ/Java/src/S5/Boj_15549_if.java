package S5;

public class Boj_15549_if {
	public static void main(String[] args) {
        long x = -9223372036854775808L;

		long temp = Long.parseLong("-9223372036854775808");

		if (x != 0 && x == -x) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
