/**
 * ImageCoder is a utility class that provides methods to encrypt and decrypt images
 * using a simple algorithm based on pixel color manipulation and a provided key string.
 * <p>
 * The encryption process modifies the RGB values of each pixel in the image using 
 * a combination of the previous pixel's colors and the characters from the given key string.
 * The decryption process reverses the encryption using the same key.
 * </p>
 * <p>
 * The image is modified in place, meaning the original image will be overwritten by 
 * either the encrypted or decrypted result.
 * </p>
 * <p>
 * This class supports basic encryption and decryption methods, both of which iterate over 
 * each pixel of the image and perform pixel-wise operations. The encryption and decryption 
 * algorithms ensure that the output image's color depends on the key and the previous pixel's values.
 * </p>
 * <p>
 * Note: Both methods rely on the key string and the image's current pixel values to determine 
 * the final pixel colors. The key is repeated as necessary if it's shorter than the image size.
 * </p>
 */
public class ImageCoder {

    /**
     * Encrypts an image using given key.
     * The encryption modifies the RGB values of each pixel based on the previous pixel's color,
     * and the corresponding character in the key string.
     *
     * @param image the image to be encrypted.
     * @param key the string to be used as the encryption key.
     *
     * @throws NullPointerException If the image or key is null.
     * @throws StringIndexOutOfBoundsException If the key string is empty.
     *
     * The encryption algorithm works by iterating over each pixel in the image and performing the following steps:
     * <ul>
     *     <li>Retrieving the RGB values of the current pixel.</li>
     *     <li>Using the corresponding character from the key (repeating the key if necessary) to modify the pixel's RGB values.</li>
     *     <li>The new RGB values are modified by the previous pixel's RGB values to add an additional level of encryption.</li>
     *     <li>The modified pixel is then set back into the image.</li>
     * </ul>
     * The result is a visually altered image where each pixel's color depends on both the key and the colors of previous pixels.
     * 
     * Note: The image is encrypted in place, meaning that the original image is overwritten by the encrypted one.
     */
    public static void encrypt(Image image, String key) {
        Color color, encryptedcColor;
        int keyChar;
        int keyIndex = 0;

        int width = image.width();
        int height = image.height();

        int red, green, blue;
        int prevRed = 0;
        int prevGreen = 0;
        int prevBlue = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // Getting pixel
                color = image.pixel(x, y);
                red = color.red();
                green = color.green();
                blue = color.blue();

                keyChar = key.charAt(keyIndex % key.length());
                
                // Encrypting colors
                red = (red + prevRed + keyChar) % 256;
                green = (green + prevGreen + keyChar) % 256;
                blue = (blue + prevBlue + keyChar) % 256;

                encryptedcColor = new Color(red, green, blue);
                image.setPixel(x, y, encryptedcColor);

                prevRed = red;
                prevGreen = green;
                prevBlue = blue;

                keyIndex++;
            }
        }
    }

    /**
     * Decrypts an image using given key.
     * The decryption modifies the RGB values of each pixel based on the previous pixel's color,
     * and the corresponding character in the key string.
     *
     * @param image the image to be decrypted.
     * @param key the string to be used as the decryption key.
     *
     * @throws NullPointerException If the image or key is null.
     * @throws StringIndexOutOfBoundsException If the key string is empty.
     *
     * The decryption algorithm works by iterating over each pixel in the image and performing the following steps:
     * <ul>
     *     <li>Retrieving the RGB values of the current pixel.</li>
     *     <li>Using the corresponding character from the key (repeating the key if necessary) to modify the pixel's RGB values.</li>
     *     <li>The new RGB values are modified by the previous pixel's RGB values to add an additional level of encryption.</li>
     *     <li>The modified pixel is then set back into the image.</li>
     * </ul>
     * The result is a visually altered image where each pixel's color depends on both the key and the colors of previous pixels.
     * 
     * Note: The image is decrypted in place, meaning that the encrypted image is overwritten by the decrypted one.
     */
    public static void decrypt(Image image, String key) {
        Color color, decryptedcColor;
        int keyChar;
        int keyIndex = 0;

        int width = image.width();
        int height = image.height();

        int red, green, blue;
        int decryptedRed, decryptedGreen, decryptedBlue;
        int prevRed = 0;
        int prevGreen = 0;
        int prevBlue = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                // Getting pixel
                color = image.pixel(x, y);
                red = color.red();
                green = color.green();
                blue = color.blue();

                keyChar = key.charAt(keyIndex % key.length());
                
                // Decrypting pixel
                decryptedRed = (red - prevRed - keyChar + 256) % 256;
                decryptedGreen = (green - prevGreen - keyChar + 256) % 256;
                decryptedBlue = (blue - prevBlue - keyChar + 256) % 256;

                decryptedcColor = new Color(decryptedRed, decryptedGreen, decryptedBlue);
                image.setPixel(x, y, decryptedcColor);

                prevRed = red;
                prevGreen = green;
                prevBlue = blue;

                keyIndex++;
            }
        }
    }
}
