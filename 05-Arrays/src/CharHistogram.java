public class CharHistogram {
  public static void main(String[] args) {

    final var text = "Wenn wir das aber bei der Verarbeitung berücksichtigen, ist das kein Problem.".toLowerCase();
    final var numberOfLetters = 'z' - 'a' + 1;

    final var histogram = new int[26];
    var countedLetters = 0;

    for (int i = 0; i < text.length(); i = i + 1) {
      final char ch = text.charAt(i);

      // require that ch is a letter a-z
      if (ch < 'a' || ch > 'z') { continue; }

      final int offset = ch - 'a';
      histogram[offset] = histogram[offset] + 1;
      countedLetters = countedLetters + 1;
    }

    for (int i = 0; i < histogram.length; i = i + 1) {
      final char letter = (char) (i + 'a');
      final var frequency = ((double) histogram[i]) / countedLetters;
      System.out.println(letter + ": " + frequency);
    }
  }
}
