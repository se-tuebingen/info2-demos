class Timer {
  int timeInSeconds = 0;
  void tickSeconds(int seconds) {
    this.timeInSeconds += seconds;
  }
  void tickMinutes(int minutes) {
    this.tickSeconds(minutes * 60);
  }
}
public class This {

  public static void main(String[] args) {
    var t = new Timer();
    t.tickMinutes(3);
    System.out.println(t.timeInSeconds);
  }
}
