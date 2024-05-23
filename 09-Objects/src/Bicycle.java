public class Bicycle {

  // Attribute
  private final int circumference; // in millimeters
	private int gear;                // current gear
	private float cadence;           // steps per minute

  // Konstruktor
  public Bicycle(int circumference, int gear, float cadence) {
    this.circumference = circumference;
    this.gear = gear;
    this.cadence = cadence;
  }

  // Methoden
  public void changeGear(int gear) { this.gear = gear; }
  public void changeCadence(float cadence) { this.cadence = cadence; }
  public float currentSpeed() {
    var millimetersPerMinute = circumference * cadence * transmissionRatio(gear);
    var kmPerHour = millimetersPerMinute * 60 / 1_000_000;
    return kmPerHour;
  }
  private float transmissionRatio(int gear) {
    // 1x11 gear setup with a 32-tooth chainring and specific cassette teeth
    int[] cassetteTeeth = { 46, 37, 32, 28, 24, 21, 19, 17, 15, 13, 11 };
    int chainringTeeth = 32;

    if (gear >= 1 && gear <= cassetteTeeth.length) {
      return (float) chainringTeeth / cassetteTeeth[gear - 1];
    } else {
      throw new IllegalArgumentException("Invalid gear: " + gear);
    }
  }

  // Main
  public static void main(String[] args) {
    final Bicycle b = new Bicycle(2000,1, 0);
    System.out.println(b.currentSpeed());
    b.changeCadence(60);
    System.out.println(b.currentSpeed());
    b.changeGear(3);
    System.out.println(b.currentSpeed());
  }
}
