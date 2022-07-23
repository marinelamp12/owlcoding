package palindrome_project;

import java.math.BigInteger;

import java.util.Scanner;

public class palindrome_complete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("자연수를 입력해 주세요");
		BigInteger sel = sc.nextBigInteger();	//sel은 입력받은 자연수이다.
		BigInteger sellength = length(sel);
		
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		BigInteger i = BigInteger.ZERO;
		while (a.compareTo(b) != 0) {		//원래수랑 뒤집은 수가 같을때 까지 시행
			sel = add(sel, sellength); 
			sellength = length(sel);
			a = backnum(sel, sellength);
			b = sel;
			i = i.add(BigInteger.ONE);
			System.out.println("\n\n");
		}
		System.out.printf("--------------------------\n총 %d번 시행", i);
		sc.close();
	}
	
	
	public static  BigInteger renum(BigInteger num, BigInteger numlength) {		//원래수를 뒤집는 함수
		numlength = numlength.subtract(BigInteger.ONE);
		BigInteger numa = BigInteger.ZERO;
		BigInteger numb = BigInteger.ZERO;
		while(numlength.compareTo(BigInteger.ZERO) != -1) {
			numa = num.mod(BigInteger.TEN);
			numb = numb.add((numa.multiply(pow(BigInteger.TEN, numlength))));
			num = num.divide(BigInteger.TEN);
			numlength = numlength.subtract(BigInteger.ONE);
		}
		return numb;
	}
	
	public static BigInteger add(BigInteger num, BigInteger numlenght) {	//원래수와 뒤집운 수의 합을 반환하는 함수
		BigInteger backnum = renum(num, numlenght);
		BigInteger result = num.add(backnum);;
		System.out.printf("입력한 수:%d\n", num);
		System.out.printf("반전 수:%d\n", backnum);
		System.out.printf("두 수의 합:%d\n", result);
		return result;
	}
	public static BigInteger backnum(BigInteger num, BigInteger numlenght) { //backnum 반환 함수
		BigInteger backnum = renum(num, numlenght);
		return backnum;
	}
	public static BigInteger length(BigInteger sel) { //숫자가 몇자리 수인지 알아내는 함수 
		BigInteger z = new BigInteger("0");	
		while (sel.compareTo(BigInteger.TEN) != -1) {
			sel = sel.divide(BigInteger.TEN);
			z = z.add(BigInteger.ONE);
		}
		z = z.add(BigInteger.ONE);
		return z;
	}
	public static BigInteger pow(BigInteger base, BigInteger exponent) {//빅 인테저 형 거듭제곱을 위한 함수
		  BigInteger result = BigInteger.ONE;
		  while (exponent.signum() > 0) {
		    if (exponent.testBit(0)) result = result.multiply(base);
		    base = base.multiply(base);
		    exponent = exponent.shiftRight(1);
		  }
		  return result;
		}
}
