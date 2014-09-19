/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.informationsea.java.excel2csv.table;

import au.com.bytecode.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author yasu
 */
public class CSVTableWriter implements TableWriter{
    
    private CSVWriter m_writer = null;

    @Override
    public void open(String path) throws IOException {
        if (path == null) {
            m_writer = new CSVWriter(new OutputStreamWriter(System.out));
        } else {
            m_writer = new CSVWriter(new FileWriter(path));
        }
    }

    @Override
    public void writeRow(String[] row) throws IOException {
        m_writer.writeNext(row);
    }

    @Override
    public void close() throws IOException {
        m_writer.close();
    }
    
}