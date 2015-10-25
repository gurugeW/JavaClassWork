import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
    //start with input image (inImage)
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

    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();   
        for (File f: dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            String fname =inImage.getFileName(); // get the file name
            ImageResource gray = makeGray(inImage); // call makeGray wit inImage,set the new image gray as resulted grayscale image
            // inImage = makeGray(inImage);
            gray.setFileName (f.getParent() + "\\gray-" + inImage.getFileName());// get the file name with path
            System.out.println(gray.getFileName());
            gray.draw();// display image
            gray.save(); // save image
            

        }

    
    
    }


    }


