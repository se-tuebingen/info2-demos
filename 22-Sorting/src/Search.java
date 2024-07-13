public class Search {
  public static void main(String[] args) {
    int[] array = {10, 13, 14, 29, 37};
    int target = 2;
    int result = binarySearch(array, target);
    if (result == -1) {
      System.out.println("Element not found");
    } else {
      System.out.println("Element found at index: " + result);
    }
  }

  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;

      // Überprüfen, ob das Ziel das mittlere Element ist
      if (array[mid] == target) return mid;
      // Wenn Ziel größer, ignorieren der linken Hälfte
      if (array[mid] < target) left = mid + 1;
      // Wenn Ziel kleiner, ignorieren der rechten Hälfte
      else right = mid - 1;
    }
    // Ziel nicht vorhanden
    return -1;
  }
}
