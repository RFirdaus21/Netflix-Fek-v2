package Helper;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageProcessor {
    private static ImageProcessor instance;
    
    private ImageProcessor() {
        // Private constructor to prevent direct instantiation
    }
    
    public static ImageProcessor getInstance() {
        if (instance == null) {
            instance = new ImageProcessor();
        }
        return instance;
    }
    
    public ImageIcon scaleImage(JLabel imageLabel, String imageName) {
        String imagePath = "src/Images/" + imageName;
        Image image = loadImage(imagePath);
        if (image != null) {
            Image scaledImage = scaleImage(image, imageLabel.getWidth(), imageLabel.getHeight());
            return new ImageIcon(scaledImage);
        }
        return null;
    }
    
    public ImageIcon scaleImage(JLabel imageLabel, String imageName, int width, int height) {
        String imagePath = "src/Images/" + imageName;
        Image image = loadImage(imagePath);
        if (image != null) {
            Image scaledImage = scaleImage(image, width, height);
            return new ImageIcon(scaledImage);
        }
        return null;
    }
    
    private Image loadImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        return icon.getImage();
    }
    
    private Image scaleImage(Image image, int width, int height) {
        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
}
