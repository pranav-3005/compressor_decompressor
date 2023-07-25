/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp_decomp;
import java.io.*;
import java.util.zip.GZIPInputStream;
/**
 *
 * @author prana
 */
public class Decompress {
    
    public static void method(File file) throws IOException
    {
        String directory=file.getParent();
        
        FileInputStream fis=new FileInputStream(file);
        GZIPInputStream gzip=new GZIPInputStream(fis);
        FileOutputStream fos=new FileOutputStream(directory+"/decompressedfile");
        
        byte[] buffer=new byte[10244];
        int len;
        
        while( (len=gzip.read(buffer))!=-1 )
        {
            fos.write(buffer, 0, len);
        }
        
        fos.close();
        fis.close();
        gzip.close();
    }
    
    public static void main(String args[]) throws IOException
    {
        File path=new File("/Users/prana/Pictures/compressedfile.gz");
        method(path);
    }
}
