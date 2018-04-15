package me.practice.algo.string;

/**
 * Suppose you have strings like A, B…, Z, AA, AB, ….AZ and so on. This is
 * similar to the way the columns of excel are named. Given a number you have to
 * find the corresponding string. (e.g. 27 would map to AA).
 * 
 * @author Vaibhav Maniar
 *
 */
public class CreateString {
	private final static int A_ASCII = 65;

	public static final String create(int num) {
		String str = "";

		while (num > 0) {
			int ch = (num % 26);

			if (ch == 0) {
				str = String.valueOf((char) (ch + 25 + A_ASCII)) + str;
				num = (num / 26) - 1;
			} else {
				str = String.valueOf((char) (ch - 1 + A_ASCII)) + str;
				num = (num / 26);
			}
		}
		return str;

	}
	
	public static final String create(int num, String str) {
		if (num > 0) {
			int ch = (num % 26);

			if (ch == 0) {
				str = String.valueOf((char) (ch + 25 + A_ASCII)) + str;
				num = (num / 26) - 1;
			} else {
				str = String.valueOf((char) (ch - 1 + A_ASCII)) + str;
				num = (num / 26);
			}
			return create(num, str);
		} else
			return str;
	}

	public static void main(String[] args) {
		System.out.println("26 : " + create(26));
		System.out.println("51 : " + create(51));
		System.out.println("52 : " + create(52));
		System.out.println("80 : " + create(80));
		System.out.println("676 : " + create(676));
		System.out.println("702 : " + create(702));
		System.out.println("705 : " + create(705));
		
		System.out.println();
		System.out.println("Through recursion: ");
		String str = "";
		System.out.println("26 : " + create(26, str));
		str = "";
		System.out.println("51 : " + create(51, str));
		str = "";
		System.out.println("52 : " + create(52, str));
		str = "";
		System.out.println("80 : " + create(80, str));
		str = "";
		System.out.println("676 : " + create(676, str));
		str = "";
		System.out.println("702 : " + create(702, str));
		str = "";
		System.out.println("705 : " + create(705, str));
	}
}
