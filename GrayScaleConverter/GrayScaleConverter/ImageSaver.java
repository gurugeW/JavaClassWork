import edu.duke.*;
import java.io.File;
/**
 * Write a description of ImageSaver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageSaver {
    
     public ImageResource makeGray(ImageResource inImage){
     // createing a blank image
     ImageResource outImage = new ImageResource (inImage.getWidth(), inImage.getHeight());
     //for each pixel outImage
     for (Pixel pixel: outImage.pixels()) {
     // loot at corresponding  pixel in inImage
     Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
     //compute the  inPixel's red + green + blue and devide by 3 (average)
     int average = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue())/3 ;
       //set the pixel;s red green blue to average
       pixel.setRed(average);
       pixel.setGreen(average);
       pixel.setBlue(average);         
        }
       return outImage; 
    }
    
  public void doSave() { 
      DirectoryResource dr = new DirectoryResource();
       for (File f : dr.selectedFiles()){
           ImageResource image = new ImageResource(f);
           String fname =image.getFileName();
           String newName = "copy-" + fname;
           //
           ImageResource img = makeGray(image);
           image.setFileName(newName);
           System.out.println(fname);//image.draw(); 
           //img.save();
        }
    }
}
