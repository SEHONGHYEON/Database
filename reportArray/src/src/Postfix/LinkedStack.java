package Postfix;

class StackNode {
	int data;
	StackNode link;
}

class LinkedStack{
	private StackNode top;

	public boolean isEmpty() {
		return (top == null);
	}

	public void push(int item) {
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
	}

	public int pop() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!!");
			return 0;
		}else {
			int item = top.data;
			top = top.link;
			return item;
		}
	}
}

class OptExp2 {
	private String exp;

	public int evalPostfix(String postfix) {
		LinkedStack S = new LinkedStack();
		exp = postfix;
		int opr1, opr2, value;
		char testCh;

		for(int i=0; i<7; i++) {
			testCh = exp.charAt(i);
			if(testCh != '+' && testCh != '-' && testCh != '*' && testCh !='/') {
				value = testCh - '0';
				S.push(value);

			}else {
				opr2 = S.pop();
				opr1 = S.pop();
				switch(testCh) {

					case '+' : S.push(opr1 + opr2); break;
					case '-' : S.push(opr1 - opr2); break;
					case '*' : S.push(opr1 * opr2); break;
					case '/' : S.push(opr1 / opr2); break;
				}
			}
		}
		return S.pop();
	}
}