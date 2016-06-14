/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package System;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Report {
    private final JTable table;
    private final DefaultTableModel model;
    private final int rowCount;
    private final int colCount;
    
    private String[] columnNames;
    String[][] rowData;
    
    private final String fileName;
    private String fileTitle;
    
    public Report(JTable table, String fileName){
        this.table = table;
        this.model = (DefaultTableModel) table.getModel();
        
        //Report file name
        this.fileName = fileName;
        
        //File data
        this.fileTitle = "";
        
        //Set table dimensions
        this.rowCount = model.getRowCount();
        this.colCount = model.getColumnCount();
        
        //Initialize column names
        initializeColumnNames();
        
        //Initialize row data
        initializeRowData();
    }
    
    public void print(){
        Document document = new Document(PageSize.A4.rotate());
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();
            
            //Document Title
            Paragraph title = new Paragraph(fileTitle + "\n\n");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            
            //Create Table
            PdfPTable table = new PdfPTable(colCount);
            
            //Add columns
            for(int i=0; i<colCount; i++){
                table.addCell(new PdfPCell(new Phrase(columnNames[i])));
            }
            
            //Add rows
            for(String[] data: rowData){
                for(String element: data){
                    table.addCell(element);
                }
            }
            
            document.add(table);
            document.close();
            new FileHandler().openFile(fileName);
            
        } catch (DocumentException ex) {
            System.out.println("Document Exception");
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }
    }
    
    private void initializeColumnNames(){
        this.columnNames = new String[colCount];
        for(int i=0; i<colCount; i++){
            columnNames[i] = table.getColumnName(i);
        }
    }
    
    private void initializeRowData(){
        rowData = new String[rowCount][colCount];
        for(int i=0; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                rowData[i][j] = String.valueOf(model.getValueAt(i, j));
            }
        }
    }
    
    private void addColum(String columnName){
        model.addColumn(columnName);
    }
    
    private void addRow(Object[] rowData){
        model.addRow(rowData);
    }
    
    private void addTwoDimArray(Object[][] rowData){
        for(Object[] data: rowData){
            model.addRow(data);
        }
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }
    
    
}
