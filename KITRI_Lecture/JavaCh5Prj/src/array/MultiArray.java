package array;

public class MultiArray {

	public static void main(String[] args) {
		/*
		 * 다차원 배열 - 2차원 이상의 배열
		 * 선언 방법
		 * 	- 데이터타입[][] 변수명 = new 데이터타입[크기][크기];	// []는 차원 수 만큼 들어갈 수 있다.
		 * 	
		 * 초기화 방법
		 * 	- 데이터타입[][] 변수명 = {
		 * 							{    },
		 * 							{    },
		 * 							...
		 * 						  };
		 */
		
		
		int[][] score = {
							{3, 1, 2},
							{1, 2, 3},
							{4, 5, 6}
						};
		
		for (int i=0; i<score.length; i++) {
			for (int j=0; j<score[i].length; j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println();
		}
	}

}
