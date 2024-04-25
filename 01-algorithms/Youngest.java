public class Youngest {
  public static void main(String[] args) {
    int[] ages = {35, 21, 25, 55, 45, 26, 24, 21, 19, 33, 37, 65, 25};

    int youngestPerson = 0;
    int youngestAge = ages[youngestPerson];

    int i = 1;

    while (i < ages.length) {
      if (ages[i] < youngestAge) {
        youngestPerson = i;
        youngestAge = ages[youngestPerson];
      }
      i = i + 1;
    }

    System.out.println(youngestPerson);
  }
}
