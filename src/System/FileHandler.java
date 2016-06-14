/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FileHandler {
    //Keep the status of the last operation
    //Success - True
    //False otherwise
    private boolean lastOperationState = false;
    
    
    //Write string data to a given file
    public void write(String fileName, String[] data){
        FileWriter fw;
        PrintWriter pw = null;
        try{
            fw = new FileWriter(fileName);
            pw = new PrintWriter(fw);
            for(String str: data){
                pw.println(Security.encrypt(str));
            }
            fw.close();
        }catch(IOException e){
            lastOperationState = false;
            return;
        }finally{
            if(pw!=null){
                pw.close();
            }            
        }
        lastOperationState = true;
    }
    
    //Read string data from a given file
    public ArrayList<String> read(String fileName){
        FileReader fr;
        BufferedReader br;
        ArrayList<String> result;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            result = new ArrayList<>();
            String str;
            while((str = br.readLine()) != null){
                result.add(str.trim());
            }
            lastOperationState = true;
        } catch (FileNotFoundException ex) {
            lastOperationState = false;
            return null;
        } catch (IOException ex) {
            lastOperationState = false;
            return null;
        }
        return result;
    }
    
    public void openFile(String fileName){
        try {
                Desktop.getDesktop().open(new File(fileName));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Cannot open the file : " + fileName, "File error", JOptionPane.ERROR_MESSAGE);
            }
    }
    //Return the status of the last operation
    public boolean getStatusOfOperation(){
        return this.lastOperationState;
    }
}
