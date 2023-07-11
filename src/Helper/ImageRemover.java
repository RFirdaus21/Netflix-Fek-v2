package Helper;

import java.io.File;

public class ImageRemover {
    private static ImageRemover instance;
    
    private ImageRemover() {
        // Private constructor to prevent direct instantiation
    }
    
    public static ImageRemover getInstance() {
        if (instance == null) {
            instance = new ImageRemover();
        }
        return instance;
    }
    
    public boolean removeImage(String imageName) {
        String imagePath = "src/Images/" + imageName;

        File imageFile = new File(imagePath);

        if (!imageFile.exists()){
            return false;
        } 
        
        boolean deleted = imageFile.delete();

        if (!deleted) {
            return false;
        }
        
        return true;
    }
}
