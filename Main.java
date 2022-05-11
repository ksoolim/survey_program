package survey;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		InfoDao info = new InfoDao();
		PlaceDao place = new PlaceDao();
		PurposeDao purpose = new PurposeDao();
		// 테이블만들기
		// info.createinfo();
		place.createplace();
	 purpose.createpurpose();
	 
	 //place 테이블 기본 데이터 삽입
	 place.insertplace(new PlaceVo(1, "서부권 (합정, 성수, 망원, 연남, 연희)"));
	 place.insertplace(new PlaceVo(2, "강남, 가로수길"));
	 place.insertplace(new PlaceVo(3, "북촌, 서촌, 삼청동 일대"));
	 

		//int cnt = 0; // 각 테이블의 primary key

	/*	System.out.println("**아래 질문에 하나씩 답변해주세요! :) **");
		System.out.println("Q1. 본인의 연령대에 해당되는 번호를 선택해주세요!");
		System.out.println("(1번 : 14~19세, 2번 : 20~29세, 3번 : 30~39세)");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("Q2. 본인의 성별에 해당되는 번호를 선택해주세요!");
		System.out.println("(1번 : 여성 , 2번 : 남성)");
		int sex = Integer.parseInt(sc.nextLine());

		info.insertinfo(new InfoVo(1,age,sex));
*/
	/*	System.out.println("Q3. 자주 방문하는 플레이스는 어디일까요? 기타항목 선택 후 직접 입력 가능!");
		System.out.println("1번 : 서부권 (합정, 성수, 망원, 연남, 연희)");
		System.out.println("2번 : 강남, 가로수길");
		System.out.println("3번 : 북촌, 서촌, 삼청동 일대");
		System.out.println("4번 : 기타(직접입력)");
		int spot = Integer.parseInt(sc.nextLine());
		if (spot == 4) {		
			System.out.println("입력하세요");	
		 int newspot = Integer.parseInt(sc.nextLine());
		 

		}
		
		
		System.out.println("Q4. 3번 질문 장소의 방문목적은 무엇일까요? 기타항목 선택 후 직접 입력 가능!");
		System.out.println("1번 : 맛집 탐방");
		System.out.println("2번 : 카페 투어");
		System.out.println("3번 : 사진 촬영");
		System.out.println("4번 : 그냥! 특별한 이유없음.");
		int visit = Integer.parseInt(sc.nextLine());
		
		System.out.println("** 참여해 주셔서 감사합니다");
		System.out.println("새로운 설문 시작은 ‘5번’ , 설문결과를 보시려면 ‘6번’을 입력해주세요! **");
*/

	}

}
