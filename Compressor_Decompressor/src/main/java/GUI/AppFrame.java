/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import comp_decomp.Compress;
import comp_decomp.Decompress;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
/**
 *
 * @author prana
 */
public class AppFrame extends JFrame implements ActionListener {
    
    JButton compress;
    JButton decompress;
    AppFrame()
    {
        this.setSize(700, 500);
        this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(null);
        
        //create buttons with borders
        compress= new JButton("Select file to compress");
        compress.setBounds(25, 250, 200,40 );
        compress.addActionListener(this);
        
        decompress= new JButton("Select file to decompress");
        decompress.setBounds(350, 250, 200, 40);
        decompress.addActionListener(this);
        
        //add button to frame
        this.add(compress);
        this.add(decompress);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==compress)
        {
            JFileChooser filech = new JFileChooser();
            int response = filech.showSaveDialog(null);
            
            if(response== JFileChooser.APPROVE_OPTION)
            {
                File file=new File(filech.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                
                try{
                    Compress.method(file);
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
        
        if(e.getSource()==decompress)
        {
            JFileChooser filech=new JFileChooser();
            int response=filech.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(filech.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                
                try{
                    Decompress.method(file);
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }
}
