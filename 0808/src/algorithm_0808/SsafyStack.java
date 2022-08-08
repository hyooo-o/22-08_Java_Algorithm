package algorithm_0808;
public class SsafyStack<E> implements IStack<E>{

	private Node<E> top;
	
	@Override
	public void push(E data) {
		// TODO Auto-generated method stub
		top = new Node<E>(data, top);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("공백스택이여서 작업 불가능");
			return null;
		}
		Node<E> popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("공백스택이여서 작업 불가능");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for (Node temp = top; temp != null ; temp=temp.link) {
			++cnt;
		}
		return cnt;
	}

	

}
