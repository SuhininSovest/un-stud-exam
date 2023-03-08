package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GetsXSSF {
    //Приватный конструктор
    private GetsXSSF() {}
    static Collection<String> sudentToCollection = new ArrayList<>();
    static Collection<String> universityToCollection = new ArrayList<>();
    static String pathXSSF = "C:\\Users\\Admin\\Documents\\module_gradle\\using_shadow\\un-stud-exam\\universityInfo.xlsx";

    public static void studentWriteExcel() {
        String nameSheet = "Студенты";
        ReadXSSF(nameSheet);
    }
    public static void universityWriteExcel() {
        String nameSheet = "Университеты";
        ReadXSSF(nameSheet);
    }
    public static void ReadXSSF(String listId) {
        String list = listId;
        try(FileInputStream file = new FileInputStream(new File(pathXSSF)))
        {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet datatypeSheet = workbook.getSheet(list);
            // перебираем лист 0
            Iterator<Row> iterator = datatypeSheet.iterator();
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellType() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + " | ");
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + " | ");
                    }
                }
                System.out.println();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
