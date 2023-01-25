package set;

import java.util.HashSet;
import java.util.Iterator;

public class SetEx1 {
	public static void main(String[] args) {
		/*
		 * set 
		 * - �ߺ� x, ���� x
		 * - �˻��� ���� iterator ���
		 * - HashSet ���� ���
		 * 
		 * set ����
		 * - ���� ���� �� add() ���
		 * 
		 * 
		 * iterator ���� (���� �˻�)
		 * - hasNext() ����ؼ� set�� ���� �ִ��� ������ Ȯ��
		 * - ���� ������ next() ����Ͽ� ���� ������
		 */
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("�ȳ�");
		set.add("������");
		set.add("�� ��Ǯ����");
		set.add("ȭ�� ����.");
		set.add("Hello");
		set.add("�ȳ�");
		set.add("�ȳ�1");
		
		Iterator<String> list = set.iterator();
		
		while (list.hasNext()) {
			System.out.println(list.next());
		}
		
	}
}
