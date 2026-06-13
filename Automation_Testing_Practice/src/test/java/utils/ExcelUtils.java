package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    public static Object[] getSingleRowData(String filePath, String sheetName) {

        Object[] data = new Object[4];

        try {
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            XSSFRow row = sheet.getRow(1);

            DataFormatter formatter = new DataFormatter();

            for (int i = 0; i < 4; i++) {
                data[i] = formatter.formatCellValue(row.getCell(i));
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}