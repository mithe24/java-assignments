/**
 * The {@code Color} class represents an RGB color with methods to access its individual 
 * red, green, blue components, as well as the combined RGB value.
 * <p>
 * This class allows you to define colors either by specifying the individual RGB values 
 * (ranging from 0 to 255) or by providing a single RGB integer value. It also includes 
 * predefined constants for several common colors.
 * </p>
 */
public class Color {

    /** Constant color for black (RGB: 0,0,0 - hex: 0x000000) */
    public static final int BLACK = 0x000000;
    /** Constant color for white (RGB: 255,255,255 - hex: 0xffffff) */
    public static final int WHITE = 0xffffff;
    /** Constant color for gray (RGB: 128,128,128 - hex: 0x808080) */
    public static final int GRAY = 0x808080;
    /** Constant color for red (RGB: 255,0,0 - hex: 0xff0000) */
    public static final int RED = 0xff0000;
    /** Constant color for maroon (RGB: 128,0,0 - hex: 0x800000) */
    public static final int MAROON = 0x800000;
    /** Constant color for lime (RGB: 0,255,0 - hex: 0x00ff00) */
    public static final int LIME = 0x00ff00;
    /** Constant color for green (RGB: 0,180,0 - hex: 0x008000) */
    public static final int GREEN = 0x008000;
    /** Constant color for navy (RGB: 0,0,128 - hex: 0x000080) */
    public static final int NAVY = 0x000080;
    /** Constant color for yellow (RGB: 255,255,0 - hex: 0xffff00) */
    public static final int YELLOW = 0xffff00;
    /** Constant color for magenta (RGB: 255,0,255 - hex: 0xff00ff) */
    public static final int MAGENTA = 0xff00ff;
    /** Constant color for cyan (RGB: 0,255,255 - hex: 0x00ffff) */
    public static final int CYAN = 0x00ffff;
    /** Constant color for pink (RGB: 255,192,203 - hex: 0xffc0cb) */
    public static final int PINK = 0xffc0cb;
    /** Constant color for orange (RGB: 255,165,0 - hex: 0xffa500) */
    public static final int ORANGE = 0xffa500;

    private int rgb;

    /**
     * Constructs a new {@code Color} object using the specified red, green, and blue 
     * components.
     * 
     * @param red the red component of the color (0-255)
     * @param green the green component of the color (0-255)
     * @param blue the blue component of the color (0-255)
     * 
     * @throws IllegalArgumentException if any component is out of the valid range [0, 255]
     */
    public Color(int red, int green, int blue) {
        assert red <= 0xff && red >= 0x00;
        assert green <= 0xff && green >= 0x00;
        assert blue <= 0xff && blue >= 0x00;

        rgb = ((red&0x0ff)<<16) | ((green&0x0ff)<<8) | (blue&0x0ff);
    }

    /**
     * Constructs a new {@code Color} object using the specified RGB value.
     * 
     * @param rgb the combined RGB value of the color (a 24-bit integer)
     */
    public Color(int rgb) {
        this.rgb = rgb;
    }

    /**
     * Returns the red component of the color.
     * 
     * @return The red component (0-255)
     */
    public int red() {
        return (rgb >> 16) & 0xff;
    }

    /**
     * Returns the green component of the color.
     * 
     * @return The green component (0-255)
     */
    public int green() {
        return (rgb >> 8) & 0xff;
    }

    /**
     * Returns the blue component of the color.
     * 
     * @return The blue component (0-255)
     */
    public int blue() {
        return rgb & 0xff;
    }

    /**
     * Returns the combined RGB value of the color.
     * 
     * @return The RGB value as an integer
     */
    public int rgb() {
        return rgb;
    }
}
