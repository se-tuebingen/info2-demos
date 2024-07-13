public class ObjectNode {

  Object value;
  ObjectNode next;

  public ObjectNode(Object value, ObjectNode next) {
    this.value = value;
    this.next = next;
  }


  public static void main(String[] args) {
    // 1, 2, .
    var list1 = new ObjectNode(true, new ObjectNode(2, null));
    var list2 = new ObjectNode(true, new ObjectNode(false, null));
    System.out.println(list1);

    // this illustrates the unsafety of using Object
    System.out.println(((int) list1.value) + 1);

  }

}
