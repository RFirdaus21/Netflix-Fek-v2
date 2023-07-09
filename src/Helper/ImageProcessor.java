package Helper;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageProcessor {
    public static ImageIcon scaleImage(JLabel imageLabel, String imageName) {
        String imagePath = "src/Images/" + imageName;
        Image image = loadImage(imagePath);
        if (image != null) {
            Image scaledImage = scaleImage(image, imageLabel.getWidth(), imageLabel.getHeight());
            return new ImageIcon(scaledImage);
        }
        return null;
    }

    public static ImageIcon scaleImage(JLabel imageLabel, String imageName, int width, int height) {
        String imagePath = "src/Images/" + imageName;
        Image image = loadImage(imagePath);
        if (image != null) {
            Image scaledImage = scaleImage(image, width, height);
            return new ImageIcon(scaledImage);
        }
        return null;
    }

    private static Image loadImage(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        return icon.getImage();
    }

    private static Image scaleImage(Image image, int width, int height) {
        return image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    
    public static String uploadImage(File selectedFile) {
        try {
            String destinationDirectory = "src/Images/";
            
            String fileName = generateUniqueFileName(selectedFile.getName());
            
            Path destinationPath = Path.of(destinationDirectory + fileName);

            Files.copy(selectedFile.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
            
            return fileName;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    private static String generateUniqueFileName(String originalFileName) {
        long timestamp = System.currentTimeMillis();
        return timestamp + "_" + originalFileName;
    }
    
    public static boolean removeImage(String ImageName){
        String imagePath = "src/Images/"+ImageName;

        File imageFile = new File(imagePath);

        if (!imageFile.exists()){
            return false;
        } 
        
        boolean deleted = imageFile.delete();

        if (!deleted) {
            return false;
        }
        
        return false;
    }
}