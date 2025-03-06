import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * The {@code Image} class represents an image with a 2D array of {@code Color} objects.
 * It allows for creating an image, manipulating its pixels, loading an image from a file, 
 * and displaying the image in a window.
 * <p>
 * The image is represented by a 2D array of pixels, each of which is a {@code Color} object.
 * The class provides functionality to get and set the color of individual pixels, as well as 
 * loading and displaying images from files.
 * </p>
 */
public class Image {

    private Color[][] image;

    /**
     * Constructs an {@code Image} object with the specified width and height, 
     * initializing the background color to black.
     * 
     * @param width the width of the image
     * @param height the height of the image
     * @throws IllegalArgumentException if the width or height is less than or equal to zero
     */
    public Image(int width, int height) {
        assert width > 0;
        assert height > 0;

        image = new Color[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image[y][x] = new Color(Color.BLACK);
            }
        }
    }
    
    /**
     * Constructs an {@code Image} object with the specified width, height, and background color.
     * 
     * @param width the width of the image
     * @param height the height of the image
     * @param bg the background color to initialize the image with
     * @throws IllegalArgumentException if the width or height is less than or equal to zero
     */
    public Image(int width, int height, Color bg) {
        assert width > 0;
        assert height > 0;

        image = new Color[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image[y][x] = new Color(bg.rgb());
            }
        }
    }

    /**
     * Loads an image from the specified file path and returns an {@code Image} object.
     * 
     * @param path the file path of the image to load
     * @return an {@code Image} object representing the loaded image, or {@code null} if loading failed
     */
    public static Image fromFile(String path) {
        BufferedImage bufferedImage = null;

        try {
            bufferedImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (bufferedImage != null) {
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            Image image = new Image(width, height);

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    image.setPixel(x, y, new Color(bufferedImage.getRGB(x, y)));
                }
            }
            return image;

        } else {
            System.out.println("Failed to load image");
            return null;
        }
    }

    /**
     * Returns the width of the image.
     * 
     * @return the width of the image
     */
    public int width() {
        return image[0].length;
    }

    /**
     * Returns the height of the image.
     * 
     * @return the height of the image
     */
    public int height() {
        return image.length;
    }

    /**
     * Returns the color of the pixel at the specified coordinates.
     * 
     * @param x the x-coordinate of the pixel
     * @param y the y-coordinate of the pixel
     * @return the {@code Color} object representing the color of the specified pixel
     * @throws IllegalArgumentException if the x or y coordinate is out of bounds
     */
    public Color pixel(int x, int y) {
        assert x >= 0 && x < image[0].length;
        assert y >= 0 && y < image.length;

        return image[y][x];
    }

    /**
     * Returns the color of the pixel at the specified coordinates.
     * 
     * @param x the x-coordinate of the pixel
     * @param y the y-coordinate of the pixel
     * @return the {@code Color} object representing the color of the specified pixel
     * @throws IllegalArgumentException if the x or y coordinate is out of bounds
     */
    public void setPixel(int x, int y, Color color) {
        assert x >= 0 && x < image[0].length;
        assert y >= 0 && y < image.length;

        image[y][x] = color;
    }

    /**
     * Displays the image in a new window.
     */
    public void display() {
        BufferedImage image = createBufferedImage();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(this.image[0].length, this.image.length);

        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     * Creates a {@code BufferedImage} from the current pixel data.
     * 
     * @return a {@code BufferedImage} object representing the image
     */
    private BufferedImage createBufferedImage() {
        int height = image.length;
        int width = image[0].length;
        BufferedImage buffImage = new BufferedImage(
            width,
            height,
            BufferedImage.TYPE_INT_RGB
        );

        for (int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                buffImage.setRGB(x, y, this.image[y][x].rgb());
            }
        }
        return buffImage;
    }
}
