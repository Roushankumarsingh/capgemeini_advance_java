package Junit;
import java.util.* ;

public class Program {
	public static boolean isPalindrome(String str) {
		StringBuilder sb = new StringBuilder(str) ;
		sb.reverse();
		return str.equals(sb.toString()) ;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome("abc")) ;
	}
	public int add(int a , int b) {
		return a + b ;
	}
}
