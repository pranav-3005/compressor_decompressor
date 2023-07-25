/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;
import java.io.*;
import java.util.zip.GZIPOutputStream;
/**
 *
 * @author prana
 */
public class Compress {
    
    public static void method(File file) throws IOException
    {
        String directory=file.getParent();
        
        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos =new FileOutputStream(directory+"/compressedfile.gz");
        GZIPOutputStream gzip= new GZIPOutputStream(fos);
        
        byte[] buffer=new byte[10244];
        int len;
        
        while(( len=fis.read(buffer) )!=-1)
        {
            gzip.write(buffer, 0,len);
        }
        
        fis.close();
        fos.close();
        gzip.close();
        
    }
    
    public static void main(String args[]) throws IOException
    {
        File path=new File("\\Users\\prana\\Pictures\\ibm as1");
        method(path);
    }
}
