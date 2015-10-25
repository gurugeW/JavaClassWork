
/**
 * Write a description of ImageInversion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;

public class ImageInversion{

    public ImageResource invert(ImageResource img ) 
    {
      ImageResource outImage = new ImageResource (img.getWidth(), img.getHeight());   
    for (Pixel pixel: outImage.pixels())
    {
     Pixel inPixel = img.getPixel(pixel.getX(), pixel.getY());
     pixel.setRed(255 -   inPixel.getRed());  
     pixel.setGreen(255 - inPixel.getGreen());
     pixel.setBlue(255 -  inPixel.getBlue());
    }
        return outImage;
    }
        
public void selectAndInvert()
{
DirectoryResource dr = new DirectoryResource();
 for (File f: dr.selectedFiles())
 {
  ImageResource image = new ImageResource(f);
    ImageResource invertImage = invert(image);
    String fname = (f.getParent() + "\\inverted-" +image.getFileName());
    System.out.println(fname);
    invertImage.setFileName(fname);
    invertImage.draw();
    invertImage.save();
 }
}
}