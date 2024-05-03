public class Palindrome {

  public static void main(String[] args) {
    Check.expect(twoIndices(new char[] { 'k', 'a', 'j', 'a', 'k' }), true);
    Check.expect(twoIndices(new char[] { 'k', 'a', 'j', 'a' }), false);
    Check.expect(twoIndices(new char[] {}), true);
    Check.expect(twoIndices(new char[] { 'k' }), true);
    Check.expect(twoIndices(new char[] { 'k', 'a' }), false);

    Check.expect(oneIndex(new char[] { 'k', 'a', 'j', 'a', 'k' }), true);
    Check.expect(oneIndex(new char[] { 'k', 'a', 'j', 'a' }), false);
    Check.expect(oneIndex(new char[] {}), true);
    Check.expect(oneIndex(new char[] { 'k' }), true);
    Check.expect(oneIndex(new char[] { 'k', 'a' }), false);
  }

  public static boolean oneIndex(char[] word) {
    // "the mutable state of the world" consists of
    // this flag and the index `front`.
    boolean isPalindrome = true;

    for (int front = 0; front < word.length / 2; front++) {
      final int back = word.length - 1 - front;
      if (word[front] != word[back]) {
        isPalindrome = false;
        break;
      }
    }
    return isPalindrome;
  }

  public static boolean twoIndices(char[] word) {
    // "the mutable state of the world" consists of
    // two indices `front` and `back` and the flag `isPalindrome`
    int front = 0;
    int back = word.length - 1;
    boolean isPalindrome = true;

    while (front < back) {
      if (word[front] != word[back]) {
        isPalindrome = false;
        break;
      }
      front = front + 1;
      back = back - 1;
    }
    return isPalindrome;
  }
}
