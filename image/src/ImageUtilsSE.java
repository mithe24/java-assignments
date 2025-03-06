/**
 * A utility class that provides various image manipulation functions.
 * These methods allow for image transformations such as flipping, rotating, color channel swaps, 
 * grayscale conversions, and drawing geometric shapes on an image.
 */
public class ImageUtilsSE {

    /**
     * Flips the given image horizontally.
     * This method swaps the left and right sides of the image by flipping the image along the vertical axis.
     * 
     * @param image the image to be flipped horizontally.
     */
    public static void flipHorizontal(Image image) {
        int width = image.width();
        int height = image.height();
        Color temp;
        for (int y = 0; y < height/2; y++) {
            for (int x = 0; x < width; x++) {
                temp = image.pixel(x, y);
                image.setPixel(x, y, image.pixel(x, height-1-y));
                image.setPixel(x, height-1-y, temp);
            }
        }
    }

    /**
     * Flips the given image vertically.
     * This method swaps the top and bottom sides of the image by flipping the image along the horizontal axis.
     * 
     * @param image the image to be flipped vertically.
     */
    public static void flipVirtical(Image image) {
        int width = image.width();
        int height = image.height();
        Color temp;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width/2; x++) {
                temp = image.pixel(x, y);
                image.setPixel(x, y, image.pixel(width-1-x, y));
                image.setPixel(width-1-x, y, temp);
            }
        }
    }

    /**
     * Rotates the given image 180 degrees by swapping pixels in the top-left and bottom-right quadrants.
     * This operation modifies the image in-place.
     * 
     * @param image the image to be rotated.
     */
    public static void rotateHalf(Image image) {
        int width = image.width();
        int height = image.height();
        Color temp;
        for (int y = 0; y < height/2; y++) {
            for (int x = 0; x < width/2; x++) {
                temp = image.pixel(x, y);
                image.setPixel(x, y, image.pixel(width - 1 - x, height - 1 - y));
                image.setPixel(width - 1 - x, height - 1 - y, temp);
            }
        }
    }

    /**
     * Switches the red and green color channels for each pixel in the image.
     * This operation modifies the image in-place.
     * 
     * @param image the image whose red and green channels are to be swapped.
     */
    public static void switchRedGreen(Image image) {
        int width = image.width();
        int height = image.height();
        Color CurrentColor;
        Color newColor;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                CurrentColor = image.pixel(x, y);
                newColor = new Color(CurrentColor.green(), CurrentColor.red(), CurrentColor.blue());
                image.setPixel(x, y, newColor);
            }
        }
    }

    /**
     * Switches the red and blue color channels for each pixel in the image.
     * This operation modifies the image in-place.
     * 
     * @param image the image whose red and blue channels are to be swapped.
     */
    public static void switchRedBlue(Image image) {
        int width = image.width();
        int height = image.height();
        Color CurrentColor;
        Color newColor;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                CurrentColor = image.pixel(x, y);
                newColor = new Color(CurrentColor.blue(), CurrentColor.green(), CurrentColor.red());
                image.setPixel(x, y, newColor);
            }
        }
    }

    /**
     * Switches the green and blue color channels for each pixel in the image.
     * This operation modifies the image in-place.
     * 
     * @param image the image whose green and blue channels are to be swapped.
     */
    public static void switchGreenBlue(Image image) {
        int width = image.width();
        int height = image.height();
        Color CurrentColor;
        Color newColor;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                CurrentColor = image.pixel(x, y);
                newColor = new Color(CurrentColor.red(), CurrentColor.blue(), CurrentColor.green());
                image.setPixel(x, y, newColor);
            }
        }
    }

    /**
     * Converts the image to grayscale using the average of the RGB components for each pixel.
     * This operation modifies the image in-place.
     * 
     * @param image the image to be converted to grayscale.
     */
    public static void grayscaleAverage(Image image) {
        int width = image.width();
        int height = image.height();
        int red, green, blue;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                red = image.pixel(x, y).red();
                green = image.pixel(x, y).green();
                blue = image.pixel(x, y).blue();
                image.setPixel(x, y, new Color(blue, green, red));
            }
        }
    }

    /**
     * Converts the image to grayscale using the lightness method.
     * The lightness method uses the average of the maximum and minimum RGB values to compute the grayscale value.
     * 
     * @param image the image to be converted to grayscale.
     */
    public static void grayscaleLightness(Image image) {
        int width = image.width();
        int height = image.height();
        int rgb, min, max;
        Color currentColor;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                currentColor = image.pixel(x, y);
                max = Math.max(currentColor.red(), Math.max(
                    currentColor.green(), 
                    currentColor.blue()));
                min = Math.min(currentColor.red(), Math.min(
                    currentColor.green(),
                    currentColor.blue()));
                rgb = (min+max)/2;
                image.setPixel(x, y, new Color(rgb, rgb, rgb));
            }
        }
    }

    /**
     * Converts the image to grayscale using the luminosity method.
     * This method uses the weighted sum of RGB channels (0.3 * R + 0.59 * G + 0.11 * B) to compute the grayscale value.
     * 
     * @param image the image to be converted to grayscale.
     */
    public static void grayscaleLuminosity(Image image) {
        int width = image.width();
        int height = image.height();
        double red, green, blue;
        int rgb;
        Color currentColor;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                currentColor = image.pixel(x, y);
                red = (double)currentColor.red()*0.3;
                green = (double)currentColor.green()*0.59;
                blue = (double)currentColor.blue()*0.11;
                rgb = (int)(red+green+blue);
                image.setPixel(x, y, new Color(rgb, rgb, rgb));
            }
        }
    }

    /**
     * Adds a filled rectangle to the image with the specified top-left corner, width, height, and color.
     * 
     * @param image the image to which the rectangle will be added.
     * @param x the x-coordinate of the top-left corner of the rectangle.
     * @param y the y-coordinate of the top-left corner of the rectangle.
     * @param width the width of the rectangle.
     * @param height the height of the rectangle.
     * @param color the color of the rectangle.
     */
    public static void addRectangle(Image image, int x, int y, int width, int height, Color color) {
        assert x >= 0 && x+width < image.width();
        assert y >= 0 && y+height < image.height();

        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                image.setPixel(x+j, y+i, color);
            }
        }
    }

    /**
     * Adds a filled circle to the image with the specified center, radius, and color.
     * The circle is drawn using Bresenham's Midpoint Circle algorithm.
     * 
     * @param image the image to which the circle will be added.
     * @param centerX the x-coordinate of the circle's center.
     * @param centerY the y-coordinate of the circle's center.
     * @param radius the radius of the circle.
     * @param color the color of the circle.
     */
    public static void addCircle(Image image, int centerX, int centerY, int radius, Color color) {
        // Bresenham's Midpoint Circle algorithm
        assert radius > 0;
        assert centerX - radius >= 0 && centerX + radius < image.width();
        assert centerY - radius >= 0 && centerY + radius < image.height();

        int x = radius;
        int y = 0;
        int t = 1 - radius;

        while (x >= y) {
            for (int i = centerX - x; i <= centerX + x; i++) {
                image.setPixel(i, centerY + y, color);
                image.setPixel(i, centerY - y, color);
            }
            if (y != x) {
                for (int i = centerX - y; i <= centerX + y; i++) {
                    image.setPixel(i, centerY + x, color);
                    image.setPixel(i, centerY - x, color);
                }
            }
            y++;

            if (t < 0) {
                t = t + 2 * y + 1;
            } else {
                x--;
                t = t + 2 * (y - x) + 1;
            }
        }

    }
}
