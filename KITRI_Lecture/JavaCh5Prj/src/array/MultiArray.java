package array;

public class MultiArray {

	public static void main(String[] args) {
		/*
		 * ������ �迭 - 2���� �̻��� �迭
		 * ���� ���
		 * 	- ������Ÿ��[][] ������ = new ������Ÿ��[ũ��][ũ��];	// []�� ���� �� ��ŭ �� �� �ִ�.
		 * 	
		 * �ʱ�ȭ ���
		 * 	- ������Ÿ��[][] ������ = {
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
