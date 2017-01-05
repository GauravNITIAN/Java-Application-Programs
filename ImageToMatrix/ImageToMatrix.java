/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author GAURAV KUMAR
 */
public class ImageToMatrix {
    
    
     // This function accepts Binary String Matrix
    /*
    Arguments param1 = String[][] result This is binary String Matrix in 0's and 1's forms
              param2 = String OutputLoc  This is the location to store the image to output directory
    
    This function Will Convert the given Matrix into a image from
    */
     public static void BinaryToImage(String[][] result,String OutputLoc) throws IOException
     {
         BufferedImage img = new BufferedImage(result.length, result[0].length, BufferedImage.TYPE_INT_RGB);
         File f = new File(OutputLoc);
         
         for(int row=0;row<result.length;row++)
         {
             for(int col=0;col<result.length;col++)
             {
                 int p = (int)Long.parseLong(signExtend(result[row][col]), 2);
                 img.setRGB(row, col, p);
             }
         }
         
        ImageIO.write(img, "jpg", f);       
     }
    
     
     /*
     
     This Function is Used To convert the Image into Binary Represenatation in the specified 
     Length and breadth of Matrix
     
     Argument String img ----> This is the image location
     */
    public static String[][] ImageToBinary(String img) throws IOException
    {
       
       BufferedImage image = ImageIO.read(new File(img));
       int width = image.getWidth();
       int height = image.getHeight();
       String[][] result = new String[height][width];
       
       
       for (int row = 0; row < height; row++) {
         for (int col = 0; col < width; col++) {
             
             //get pixel value
             int p = image.getRGB(row,col);
       
               result[row][col] = Integer.toBinaryString(p);
      
         }
     }
       
      return result; 
    }
    /*
    This Function Will Convert the Image into 2D Matrix in the range of 0-255 
    Arguments : -String img ----> This is the image location
    
    */
   
    public static int[][] convertTo2DMatrix(String img) throws IOException {
        
        BufferedImage image = ImageIO.read(new File(img));
       int width = image.getWidth();
       int height = image.getHeight();
       int[][] result = new int[height][width];

      for (int row = 0; row < height; row++) {
         for (int col = 0; col < width; col++) {
             
             //get pixel value
             int p = image.getRGB(row,col);
             
             //get alpha
             int a = (p>>24) & 0xff;
             
             //get red
             int r = (p>>16) & 0xff;
             
             //get green
             int g = (p>>8) & 0xff;
             
             
             //get blue
              int b = p & 0xff;
              
             result[row][col] = (a+r+g+b)/4;     
            
         }
      }
      return result;
   }
    
    /*
    
    This method will take Image Location as a argument and Will convert it
    into 2D Matrix in abosolute Range of 32 bits
    */
    
    public static int[][] convertTo2DAbsolute(String img) throws IOException
    {
        
         BufferedImage image = ImageIO.read(new File(img));
         int width = image.getWidth();
         int height = image.getHeight();
         int[][] result = new int[height][width];

         for (int row = 0; row < height; row++) {
             for (int col = 0; col < width; col++) {
             
             //get pixel value
             result[row][col] = image.getRGB(row,col);     
            
         }
      }
      return result;
    }
    
    /*
    
    This is a Utlity Function Used to Bound Checking 
    
    */
   private static String signExtend(String str){
        //TODO add bounds checking
        int n=32-str.length();
        char[] sign_ext = new char[n];
        Arrays.fill(sign_ext, str.charAt(0));

        return new String(sign_ext)+str;
    }
    
 public static void main(String args[]) throws IOException
 {
     
    String res[][]=ImageToMatrix.ImageToBinary("train_1.jpg");
    //ImageToMatrix.BinaryToImage(res);
    
}
}