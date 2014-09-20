/*
 *  excel2csv  xls/xlsx/csv/tsv converter
 *  Copyright (C) 2014 Yasunobu OKAMURA
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package info.informationsea.java.excel2csv.table;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 * @author yasu
 */
public class TabTableReader implements TableReader{
    
    private CSVReader m_reader = null;

    @Override
    public String[] readRow() throws IOException {
        return m_reader.readNext();
    }

    @Override
    public void open(String path) throws IOException {
        if (path == null) {
            m_reader = new CSVReader(new InputStreamReader(System.in), '\t', '\0');
        } else {
            m_reader = new CSVReader(new FileReader(path), '\t', '\0');
        }
    }
    
    public void open(Reader reader) throws IOException {
        m_reader = new CSVReader(reader);
    }

    @Override
    public void close() throws IOException {
        m_reader.close();
    }
}
