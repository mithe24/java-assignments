import java.lang.Math;

/**
 * The {@code ImageUtils} class provides a collection of static utility methods for manipulating images.
 * These methods allow for various transformations and operations such as flipping, rotating, stretching,
 * cropping, and color manipulation. The operations are performed on an {@code Image} object, and a new 
 * image is returned with the applied transformation or manipulation.
 */
public class ImageUtils {

    /**
     * Flips the given image horizontally.
     * 
     * @param image the {@code Image} object to flip
     * @return a new {@code Image} object that is flipped horizontally
     */
    public static Image flipHorizontal(Image image) {
        int width = image.width();
        int height = image.height();
        Image newImage = new Image(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newImage.setPixel(x,y, image.pixel(x, height-1-y));
            }
        }
        return newImage;
    }

    /**
     * Flips the given image vertically.
     * 
     * @param image the {@code Image} object to flip
     * @return a new {@code Image} object that is flipped vertically
     */
    public static Image flipVirtical(Image image) {
        int width = image.width();
        int height = image.height();
        Image newImage = new Image(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newImage.setPixel(x,y, image.pixel(width-1-x, y));
            }
        }
        return newImage;
    }

    /**
     * Rotates the given image 90 degrees counterclockwise (left).
     * 
     * @param image the {@code Image} object to rotate
     * @return a new {@code Image} object rotated 90 degrees counterclockwise
     */
    public static Image rotateLeft(Image image) {
        int width = image.width();
        int height = image.height();
        Image newImage = new Image(height, width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newImage.setPixel(height-1 - y, x, image.pixel(x,y));
            }
        }
        return newImage;
    }

    /**
     * Rotates the given image 90 degrees clockwise (right).
     * 
     * @param image the {@code Image} object to rotate
     * @return a new {@code Image} object rotated 90 degrees clockwise
     */
    public static Image rotateRight(Image image) {
        int width = image.width();
        int height = image.height();
        Image newImage = new Image(height, width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newImage.setPixel(y, width-1 - x, new Color(image.pixel(x,y).rgb()));
            }
        }
        return newImage;
    }

    /**
     * Rotates the given image 180 degrees.
     * 
     * @param image the {@code Image} object to rotate
     * @return a new {@code Image} object rotated 180 degrees
     */
    public static Image rotateHalf(Image image) {
        int width = image.width();
        int height = image.height();
        Image newImage = new Image(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newImage.setPixel(x,y, new Color(image.pixel(width-1 - x, height-1 - y).rgb()));
            }
        }
        return newImage;
    }

    /**
     * Stretches the given image horizontally, doubling its width.
     * 
     * @param image the {@code Image} object to stretch
     * @return a new {@code Image} object with horizontally stretched pixels
     */
    public static Image strechHorizontal(Image image) {
        int width = image.width();
        int height = image.height();
        Color originalPixel;
        Image newImage = new Image(width*2, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                originalPixel = image.pixel(x, y);
                newImage.setPixel(x*2, y, originalPixel);
                newImage.setPixel(x*2 + 1, y, originalPixel);
            }
        }
        return newImage;
    }

    /**
     * Stretches the given image vertically, doubling its height.
     * 
     * @param image the {@code Image} object to stretch
     * @return a new {@code Image} object with vertically stretched pixels
     */
    public static Image strechVertical(Image image) {
        int width = image.width();
        int height = image.height();
        Image newImage = new Image(width, height*2);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newImage.setPixel(x, y*2, image.pixel(x, y));
                newImage.setPixel(x, y*2 + 1, image.pixel(x, y));
            }
        }
        return newImage;
    }

    /**
     * Crops the given image to the specified dimensions and coordinates.
     * 
     * @param image the {@code Image} object to crop
     * @param x the starting x-coordinate of the cropping region
     * @param y the starting y-coordinate of the cropping region
     * @param width the width of the cropping region
     * @param height the height of the cropping region
     * @return a new {@code Image} object representing the cropped region
     * @throws IllegalArgumentException if the cropping parameters are invalid
     */
    public static Image crop(Image image, int x, int y, int width, int height) {
        assert x >= 0 && x < image.width();
        assert y >= 0 && y < image.height();
        assert width > 0 && width < image.width() - x;
        assert height > 0 && height < image.height() - y;

        Image newImage = new Image(width, height);
        for (int ny = 0; ny < height; ny++) {
            for (int nx = 0; nx < width; nx++) {
                newImage.setPixel(nx, ny, image.pixel(x+nx, y+ny));
            }
        }
        return newImage;
    }

    /**
     * Switches the red and green color channels of the given image.
     * 
     * @param image the {@code Image} object whose color channels to switch
     * @return a new {@code Image} object with the red and green channels swapped
     */
    public static Image switchRedGreen(Image image) {
        int width = image.width();
        int height = image.height();
        int red, green, blue;
        Image newImage = new Image(height, width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                red = image.pixel(x, y).red();
                green = image.pixel(x, y).green();
                blue = image.pixel(x, y).blue();
                newImage.setPixel(x, y, new Color(green, red, blue));
            }
        }
        return newImage;
    }

    /**
     * Switches the red and blue color channels of the given image.
     * 
     * @param image the {@code Image} object whose color channels to switch
     * @return a new {@code Image} object with the red and blue channels swapped
     */
    public static Image switchRedBlue(Image image) {
        int width = image.width();
        int height = image.height();
        int red, green, blue;
        Image newImage = new Image(height, width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                red = image.pixel(x, y).red();
                green = image.pixel(x, y).green();
                blue = image.pixel(x, y).blue();
                newImage.setPixel(x, y, new Color(blue, green, red));
            }
        }
        return newImage;
    }

    /**
     * Switches the green and blue color channels of the given image.
     * 
     * @param image the {@code Image} object whose color channels to switch
     * @return a new {@code Image} object with the green and blue channels swapped
     */
    public static Image switchGreenBlue(Image image) {
        int width = image.width();
        int height = image.height();
        int red, green, blue;
        Image newImage = new Image(height, width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                red = image.pixel(x, y).red();
                green = image.pixel(x, y).green();
                blue = image.pixel(x, y).blue();
                newImage.setPixel(x, y, new Color(red, blue, green));
            }
        }
        return newImage;
    }

    /**
     * Converts the given image to grayscale using the average method.
     * 
     * @param image the {@code Image} object to convert
     * @return a new {@code Image} object converted to grayscale using the average method
     */
    public static Image grayscaleAverage(Image image) {
        int width = image.width();
        int height = image.height();
        int rgb, red, green, blue;
        Color currentColor;
        Image newImage = new Image(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                currentColor = image.pixel(x, y);
                red = currentColor.red();
                green = currentColor.green();
                blue = currentColor.blue();
                rgb = (red+green+blue)/3;
                newImage.setPixel(x, y, new Color(rgb, rgb, rgb));
            }
        }
        return newImage;
    }

    /**
     * Converts the given image to grayscale using the lightness method.
     * 
     * @param image the {@code Image} object to convert
     * @return a new {@code Image} object converted to grayscale using the lightness method
     */
    public static Image grayscaleLightness(Image image) {
        int width = image.width();
        int height = image.height();
        int rgb, min, max;
        Color currentColor;
        Image newImage = new Image(width, height);

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
                newImage.setPixel(x, y, new Color(rgb, rgb, rgb));
            }
        }
        return newImage;
    }

    /**
     * Converts the given image to grayscale using the luminosity method.
     * The luminosity method takes the weighted sum of the RGB components
     * with different weights for each channel: 0.3 for red, 0.59 for green, and 0.11 for blue.
     * 
     * @param image The original image to be converted to grayscale.
     * @return A new image in grayscale.
     */
    public static Image grayscaleLuminosity(Image image) {
        int width = image.width();
        int height = image.height();
        double red, green, blue;
        int rgb;
        Color currentColor;
        Image newImage = new Image(width, height);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                currentColor = image.pixel(x, y);
                red = (double)currentColor.red()*0.3;
                green = (double)currentColor.green()*0.59;
                blue = (double)currentColor.blue()*0.11;
                rgb = (int)(red+green+blue);
                newImage.setPixel(x, y, new Color(rgb, rgb, rgb));
            }
        }
        return newImage;
    }

    /**
     * Calculates the average color of the given image by computing the average
     * of the red, green, and blue components for all pixels in the image.
     * 
     * @param image The image for which to calculate the average color.
     * @return The average color of the image as a {@link Color} object.
     */
    public static Color averageColor(Image image) {
        int width = image.width();
        int height = image.height();
        Color pixel;
        int count = 0;
        int red = 0;
        int green = 0;
        int blue = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixel = image.pixel(x, y);
                red = red + pixel.red();
                green = green + pixel.green();
                blue = blue + pixel.blue();
                count++;
            }
        }

        red = red/count;
        green = green/count;
        blue = blue/count;
        return new Color(red, green, blue);
    }

    /**
     * Resamples the given image by averaging the color of each 3x3 block of pixels.
     * The resampling process involves averaging the colors of the pixels in a 3x3 grid,
     * centered on each pixel that is not on the boundary of the image. 
     * This effectively reduces the image's resolution by a factor of 2 in both dimensions.
     * 
     * @param image The image to be resampled.
     * @return A new image with reduced resolution created by averaging pixel blocks.
     */
    public static Image resample(Image image) {
        int width = image.width();
        int height = image.height();
        int red, green, blue;
        Color pixel;
        Image newImage = new Image(width, height);

        for (int y = 1; y < height - 1; y = y + 2) {
            for (int x = 1; x < width - 1; x = x + 2) {
                red = 0;
                green = 0;
                blue = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        pixel = image.pixel(x + i, y + j);
                        red = red + pixel.red();
                        green = green + pixel.green();
                        blue = blue + pixel.blue();
                    }
                }

                red = red/9;
                green = green/9;
                blue = blue/9;
                newImage.setPixel(x, y, new Color(red, green, blue));
            }
        }
        return newImage;
    }
}
