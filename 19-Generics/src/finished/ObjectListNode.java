package finished;

public class ObjectListNode {
  Object item;
  ObjectListNode next;

  public ObjectListNode(Object item) {
      this.item = item;
  }
  public ObjectListNode(Object item, ObjectListNode next) {
    this.item = item;
    this.next = next;
  }
}
