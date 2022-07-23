package palindrome_project;

import java.math.BigInteger;

import java.util.Scanner;

public class palindrome_complete {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ڿ����� �Է��� �ּ���");
		BigInteger sel = sc.nextBigInteger();	//sel�� �Է¹��� �ڿ����̴�.
		BigInteger sellength = length(sel);
		
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		BigInteger i = BigInteger.ZERO;
		while (a.compareTo(b) != 0) {		//�������� ������ ���� ������ ���� ����
			sel = add(sel, sellength); 
			sellength = length(sel);
			a = backnum(sel, sellength);
			b = sel;
			i = i.add(BigInteger.ONE);
			System.out.println("\n\n");
		}
		System.out.printf("--------------------------\n�� %d�� ����", i);
		sc.close();
	}
	
	
	public static  BigInteger renum(BigInteger num, BigInteger numlength) {		//�������� ������ �Լ�
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
	
	public static BigInteger add(BigInteger num, BigInteger numlenght) {	//�������� ������ ���� ���� ��ȯ�ϴ� �Լ�
		BigInteger backnum = renum(num, numlenght);
		BigInteger result = num.add(backnum);;
		System.out.printf("�Է��� ��:%d\n", num);
		System.out.printf("���� ��:%d\n", backnum);
		System.out.printf("�� ���� ��:%d\n", result);
		return result;
	}
	public static BigInteger backnum(BigInteger num, BigInteger numlenght) { //backnum ��ȯ �Լ�
		BigInteger backnum = renum(num, numlenght);
		return backnum;
	}
	public static BigInteger length(BigInteger sel) { //���ڰ� ���ڸ� ������ �˾Ƴ��� �Լ� 
		BigInteger z = new BigInteger("0");	
		while (sel.compareTo(BigInteger.TEN) != -1) {
			sel = sel.divide(BigInteger.TEN);
			z = z.add(BigInteger.ONE);
		}
		z = z.add(BigInteger.ONE);
		return z;
	}
	public static BigInteger pow(BigInteger base, BigInteger exponent) {//�� ������ �� �ŵ������� ���� �Լ�
		  BigInteger result = BigInteger.ONE;
		  while (exponent.signum() > 0) {
		    if (exponent.testBit(0)) result = result.multiply(base);
		    base = base.multiply(base);
		    exponent = exponent.shiftRight(1);
		  }
		  return result;
		}
}
