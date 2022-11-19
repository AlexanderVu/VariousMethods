package palindrome;

public class IntPalindrome {

	public static void main(String[] args) {
		
		// For Int Palindrome, a Duplicate copy needs to be made to compare and using the While loop

		int A = 595;
		int A1 = A;
		int B = 0;

		while (A != 0) {
			B = B * 10 + A % 10;
			A = A / 10;
		}
		if (A1 == B) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not Palindrome");
		}

	}
}
