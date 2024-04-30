public class MovingAverage {
  public static void main(String[] args) {
    double[] data = {11.5, 22.3, 33.4, 46.8, 49.5};
    // Array to hold the smoothed values, with two fewer elements
    double[] smoothed = new double[data.length - 2];

    // Compute moving average for each applicable element
    for (int i = 0; i < data.length - 2; i++) {
        smoothed[i] = (data[i] + data[i + 1] + data[i + 2]) / 3.0;
    }

    // Display the original and smoothed data
    System.out.println("Original: ");
    for (double d : data) {
        System.out.print(d + " ");
    }

    System.out.println("\nSmoothed: ");
    for (double s : smoothed) {
        System.out.print(s + " ");
    }
  }
}
