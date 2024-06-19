// Doubly-linked (=DL) list with a single sentinel node and tracking the length
public class ListDL {
	ListElemDL head;
	int length;

	public ListDL() {
		head = new ListElemDL(0, null, null);
		head.prev = head;
		head.next= head;
		length = 0;
	}

	public void insertFirst(int item) {
		insertBefore(head.next, item);
	}

	public void insertLast(int item) {
		insertBefore(head, item);
	}

	public void insert(int pos, int item) {
		ListElemDL next = getElemByIndex(pos);
		if (next != null) {
			insertBefore(next, item);
		}
	}

	public void insertSorted(int newItem) {
		ListElemDL elem = head.next;
		while (elem != head && elem.item < newItem) {
			elem = elem.next;
		}
		insertBefore(elem, newItem);
	}

	private void insertBefore(ListElemDL next, int item) {
		ListElemDL newElem = new ListElemDL(item, next.prev, next);
		next.prev.next = newElem;
		next.prev = newElem;
		length++;
	}

	public void deleteAtIndex(int pos) {
		ListElemDL elem = getElemByIndex(pos);
		if (elem != null && elem != head) {
			deleteElem(elem);
		}
	}

	public void deleteElem(ListElemDL elem) {
		elem.prev.next = elem.next;
		elem.next.prev = elem.prev;
		length--;
	}

	public int getByIndex(int pos) {
		ListElemDL elem = getElemByIndex(pos);
		return (elem == null || elem == head) ? 0 : elem.item;
	}

	private ListElemDL getElemByIndex(int pos) {
		if (pos < 0 || pos > length) {  // for pos==length we will return the sentinel
			return null;
		}
		ListElemDL elem = head.next;
		for (int i = 0; i < pos; i++) {
			elem = elem.next;
		}
		return elem;
	}

	public void appendList(ListDL otherList) {
		for (ListElemDL elem = otherList.head.next; elem != otherList.head; elem = elem.next) {
			insertLast(elem.item);
		}
	}

	public void print() {
		System.out.print("Liste ( ");
		for (ListElemDL elem = head.next; elem != head; elem = elem.next) {
			System.out.print(elem.item + " ");
		}
		System.out.println(")");
	}

	public void printReversed() {
		System.out.print("Liste rückwärts ( ");
		for (ListElemDL elem = head.prev; elem != head; elem = elem.prev) {
			System.out.print(elem.item + " ");
		}
		System.out.println(")");
	}


	public static void main(String[] args) {
		ListDL list = new ListDL();
		for (int i = 0; i < 10; i++) {
			list.print();
			list.insertLast(i * 2);
		}
		list.insertSorted(29);
		list.insert(3, 111);
		list.print();
		list.deleteAtIndex(3);
		list.deleteAtIndex(0);
		list.printReversed();

		int item3 = list.getByIndex(3);
		System.out.println("Element at position 3: " + item3);
	}

}