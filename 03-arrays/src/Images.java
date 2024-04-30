import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {

  public static void main(String[] args) throws IOException {
    final int[][] image = readImage("eye.png");

    final var width = image.length;
    final var height = image[0].length;

    final var out = new int[width][height];

    // Applying a 3x3 kernel
    final float[][] blur = {
        {1f / 9f, 1f / 9f, 1f / 9f},
        {1f / 9f, 1f / 9f, 1f / 9f},
        {1f / 9f, 1f / 9f, 1f / 9f}
    };

    final float[][] sharpen = {
        { 0f, -1f,  0f},
        {-1f,  5f, -1f},
        { 0f, -1f,  0f}
    };

    final float[][] laplacian = {
        { 0f, 1f, 0f},
        { 1f, 4f, 1f},
        { 0f, 1f, 0f}
    };

    final float[][] id = {
        { 0f,  0f,  0f},
        { 0f,  1f,  0f},
        { 0f,  0f,  0f}
    };

    final var kernel = sharpen;

    // Apply the kernel to the image
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {

        float sum = 0;

        for (int kx = -1; kx <= 1; kx++) {
          for (int ky = -1; ky <= 1; ky++) {
            int px = x + kx;
            int py = y + ky;

            // Check boundaries
            if (px >= 0 && px < width && py >= 0 && py < height) {
              sum += image[px][py] * kernel[kx + 1][ky + 1];
            }
          }
        }

        out[x][y] = Math.round(sum);
      }
    }

    // ^^^

    writeImage(out, "out.png");
  }


  /**
   * Renders a grayscale image from the given array and saves it to the specified file.
   *
   * @param imageArray The 2D array of grayscale values
   * @param filename   The name of the file to save the image to
   */
  public static void writeImage(int[][] imageArray, String filename) throws IOException {
    int width = imageArray[0].length;
    int height = imageArray.length;

    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
    WritableRaster raster = image.getRaster();

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        // Ensure the value is within 0 - 255
        int grayValue = imageArray[y][x];
        grayValue = grayValue > 255 ? 255 : Math.max(grayValue, 0);

        // Directly set the value to the raster
        raster.setSample(x, y, 0, grayValue);
      }
    }
    ImageIO.write(image, "png", new File(filename));
  }

  private static int[][] readImage(String filename) throws IOException {

    BufferedImage image = ImageIO.read(new File(filename));

    int width = image.getWidth();
    int height = image.getHeight();

    int[][] greyscaleValues = new int[height][width];


    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        int rgb = image.getRGB(x, y);
        int grey = (rgb & 0xFF); // Masking the blue byte as it represents the greyscale value
        greyscaleValues[y][x] = grey;
      }
    }

    return greyscaleValues;
  }
}
