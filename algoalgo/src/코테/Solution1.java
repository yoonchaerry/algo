package 코테;

public class Solution1 {
	
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String msg = "ABCDEF";
		s.Solution(msg);
	}
	
	static String answer;	
	public String Solution(String msg) {
		int size = msg.length();
		BinaryTree tree = new BinaryTree(size);
		for (int i = 0; i < size; i++) {
			tree.add(msg.charAt(i));
		}
		answer = "";
		tree.postOrder();
		System.out.println(answer);
		return answer;
	}

	class BinaryTree{
		char[] nodes;
		int lastIndex;
		
		public BinaryTree(int size) {
			nodes = new char[size + 1]; // 1번부터 사용
		}
		
		public void add(char c) {
			nodes[++lastIndex] = c;
		}
		
		public void postOrder() {
			postOrder(1);
		}

		private void postOrder(int current) {
			// 왼쪽
			if(current * 2 <= lastIndex) {
				postOrder(current * 2);
			}
			// 오른쪽
			if(current * 2 + 1 <= lastIndex) {
				postOrder(current * 2 + 1);
			}
			answer += nodes[current];
			//System.out.print(nodes[current]);
		}
	}
}

