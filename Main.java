package survey;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		InfoDao info = new InfoDao();
		PlaceDao place = new PlaceDao();
		PurposeDao purpose = new PurposeDao();
		// ���̺����
		// info.createinfo();
		place.createplace();
	 purpose.createpurpose();
	 
	 //place ���̺� �⺻ ������ ����
	 place.insertplace(new PlaceVo(1, "���α� (����, ����, ����, ����, ����)"));
	 place.insertplace(new PlaceVo(2, "����, ���μ���"));
	 place.insertplace(new PlaceVo(3, "����, ����, ��û�� �ϴ�"));
	 

		//int cnt = 0; // �� ���̺��� primary key

	/*	System.out.println("**�Ʒ� ������ �ϳ��� �亯���ּ���! :) **");
		System.out.println("Q1. ������ ���ɴ뿡 �ش�Ǵ� ��ȣ�� �������ּ���!");
		System.out.println("(1�� : 14~19��, 2�� : 20~29��, 3�� : 30~39��)");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("Q2. ������ ������ �ش�Ǵ� ��ȣ�� �������ּ���!");
		System.out.println("(1�� : ���� , 2�� : ����)");
		int sex = Integer.parseInt(sc.nextLine());

		info.insertinfo(new InfoVo(1,age,sex));
*/
	/*	System.out.println("Q3. ���� �湮�ϴ� �÷��̽��� ����ϱ��? ��Ÿ�׸� ���� �� ���� �Է� ����!");
		System.out.println("1�� : ���α� (����, ����, ����, ����, ����)");
		System.out.println("2�� : ����, ���μ���");
		System.out.println("3�� : ����, ����, ��û�� �ϴ�");
		System.out.println("4�� : ��Ÿ(�����Է�)");
		int spot = Integer.parseInt(sc.nextLine());
		if (spot == 4) {		
			System.out.println("�Է��ϼ���");	
		 int newspot = Integer.parseInt(sc.nextLine());
		 

		}
		
		
		System.out.println("Q4. 3�� ���� ����� �湮������ �����ϱ��? ��Ÿ�׸� ���� �� ���� �Է� ����!");
		System.out.println("1�� : ���� Ž��");
		System.out.println("2�� : ī�� ����");
		System.out.println("3�� : ���� �Կ�");
		System.out.println("4�� : �׳�! Ư���� ��������.");
		int visit = Integer.parseInt(sc.nextLine());
		
		System.out.println("** ������ �ּż� �����մϴ�");
		System.out.println("���ο� ���� ������ ��5���� , ��������� ���÷��� ��6������ �Է����ּ���! **");
*/

	}

}
