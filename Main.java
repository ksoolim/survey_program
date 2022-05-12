package survey;

import java.util.Scanner;

public class Main {
	// @SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		InfoDao info = new InfoDao();
		PlaceDao place = new PlaceDao();
		PurposeDao purpose = new PurposeDao();
		
		// 테이블만들기
		// 완료 info.createinfo();
		// 완료 place.createplace();
		// 완료 purpose.createpurpose();

		// place 기본 데이터 입력
		/*
		 * 완료 place.insertplace(new PlaceVo(1, "서부권 (합정, 성수, 망원, 연남, 연희)"));
		 * place.insertplace(new PlaceVo(2, "강남, 가로수길")); 
		 * place.insertplace(new PlaceVo(3, "북촌, 서촌, 삼청동 일대"));
		 */

	/*	int cnt = 1; 
		int newpcode = 3; 
		while (true) {
			System.out.println("cnt = "+cnt);
			System.out.println("** 설문조사를 시작합니다! **");
			System.out.println();

			System.out.println("Q1. 본인의 연령대에 해당되는 번호를 선택해주세요!");
			System.out.println("(1번 : 14~19세,  2번 : 20~29세 , 3번 : 30~39세)");
			int age = Integer.parseInt(sc.nextLine());
			System.out.println("Q2. 본인의 성별에 해당되는 번호를 선택해주세요!");
			System.out.println("(1번 :  여성 , 2번 : 남성)");
			int sex = Integer.parseInt(sc.nextLine());

			info.insertinfo(new InfoVo(cnt, age, sex));

			System.out.println("Q3. 자주 방문하는 플레이스는 어디일까요? 기타항목 선택 후 직접 입력 가능!");
			System.out.println("1번 : 서부권 (합정, 성수, 망원, 연남, 연희)");
			System.out.println("2번 : 강남, 가로수길");
			System.out.println("3번 :  북촌, 서촌, 삼청동 일대리");
			System.out.println("4번 : 기타(직접입력)");
			int spot = Integer.parseInt(sc.nextLine());
			if (spot == 4) {
				System.out.println("입력해주세요");
				String newspot = sc.nextLine();
				newpcode++;

				place.insertplace(new PlaceVo(newpcode, newspot));
			}

			System.out.println("Q4. 3번 질문 장소의 방문목적은 무엇일까요? 기타항목 선택 후 직접 입력 가능!");
			System.out.println("1번 : 맛집탐방");
			System.out.println("2번 : 카페 투어");
			System.out.println("3번 : 사진 촬영");
			System.out.println("4번 : 그냥! 이유없음");
			int visit = Integer.parseInt(sc.nextLine());
			purpose.insertpurpose(new PurposeVo(cnt, cnt, spot, visit));

			if (spot == 4) {

				purpose.insertpurpose(new PurposeVo(cnt, cnt, newpcode, visit));
			}

			System.out.println("** 참여해주셔서 감사합니다!");
			System.out.println("새로운 설문 시작은 ‘0번’ , 설문결과를 보시려면 ‘1번’을 입력해주세요! **");
			int end = Integer.parseInt(sc.nextLine());

			if (end == 0) {
				Object pass;
				cnt++;
			} else {*/
			/*완료	System.out.println("** 설문결과  **");
				System.out.println("설문참여인원 : " + purpose.counttotal()+"명");
				System.out.println("10대 : "+ info.countinfoage1() +"명   20대 : "+info.countinfoage2()+"명  30대 : "+info.countinfoage3()+"명");
				System.out.println("여 : "+ info.countinfosex1() +"명  남 : "+info.countinfosex2()+"명");
				*/
		System.out.println("<플레이스 순위별 결과>");
		System.out.println(purpose.rankplace());
			//	break; 
		//	}

	//	} 
	}
}
