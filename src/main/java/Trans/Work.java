package Trans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Work {

    public static void writeXLSXFile(String path, String outpath) throws IOException {
        try {
            FileInputStream file = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Cell cell = null;
            int row = 1;

            // in this small app, I just need to translate column 3
            cell = sheet.getRow(row).getCell(3);
            while (cell != null) {
                List ls = new ArrayList();
                ls.add(cell.getStringCellValue());
                String result = Trans.tranlateToCn(ls);
                System.out.println(result + row);
                cell.setCellValue(result);
                row += 1;
                XSSFRow sheetrow = sheet.getRow(row);
                if(sheetrow == null){
                    break;
                }
                cell = sheetrow.getCell(3);
            }
            FileOutputStream outFile =new FileOutputStream(new File(outpath));
            workbook.write(outFile);
            outFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // text based GUI
    public static void main(String[] args) throws IOException {
        System.out.println("Type input file path:");
        Scanner input = new Scanner(System.in);
        String inpath = input.nextLine();
        System.out.println("Type output file path:");
        Scanner output = new Scanner(System.in);
        String outpath = input.nextLine();
        writeXLSXFile(inpath, outpath);
    }
}