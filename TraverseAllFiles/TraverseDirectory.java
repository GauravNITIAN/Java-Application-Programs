/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
/**
 *
 * @author GAURAV KUMAR
 */
public class TraverseDirectory {
 
    /*
    Requirements : -
    
    1) You Will Require a org.apache.commons.io jar file that will 
       be available on the internet
    2) Provide a directory from path from the function
    
    This function is Used to Read the File and find the pattern that matches with the
     Mobile number Using Regex Pattern in Java
    
    Arguments : -  String file ---> This is the file location which is of extension .txt
    
    */
    public static void  traveseFile(String file) throws FileNotFoundException, IOException
    {
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        Pattern p = Pattern.compile("^[7-9]\\d{9}");
        String read;
        while((read = buffer.readLine())!= null)
        {
            Matcher r = p.matcher(read);
            if(r.matches())
            {
                System.out.println(read);
            }
        }
        
    }
    
    /*
    
    This Method With take the Directory Path from that path It will List all the Files 
    Form here
    
    */
   public static void recursieTraverseDirectory(String path) throws FileNotFoundException, IOException
    {
        File file = new File(path);       
        //It will List all the files and subdirectores file if it is Set to True
        Collection<File> files = FileUtils.listFiles(file, null, true);     
        for(File file2 : files){
            
            String filter = ".txt";  //Extension for Filtering the file
            if(file2.toString().endsWith(filter))
            { 
                //Function call to Traverse the file with .txt extension
                traveseFile(file2.toString());   
            
            }         
}
    }
   public static void main(String args[]) throws IOException
   {
        String path = "C:\\Users\\GAURAV KUMAR\\Documents\\NetBeansProjects\\Contest";
        
        //Here path is the absolute path from root directory 
       recursieTraverseDirectory(path);  
   }
}
