package com.kh.admin.common.utils;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * 项目：liquidator-platform-admin
 * 包名：com.fshows.liquidator.platform.admin.common.utils
 * 功能：
 * 时间：2016-08-17
 * 作者：呱牛
 */
public class ExportExcel {
    private static Logger logger = LoggerFactory.getLogger(ExportExcel.class);

    public static void exportToExcel(HttpServletResponse response, String sheetName, String sheetTableTitle, List<Object[]> dataList, Object[] filedName) {
        // 创建工作簿对象
        XSSFWorkbook workbook = new XSSFWorkbook();
        try {
            // 创建工作表
            XSSFSheet sheet = workbook.createSheet(sheetName);
            // 产生表格标题行
            XSSFRow rowM = sheet.createRow(0);
            XSSFCell cellTitle = rowM.createCell(0);

            //sheet样式定义
            // 获取列头样式对象
            XSSFCellStyle columnTopStyle = getColumnTopStyle(workbook);
            // 单元格样式对象
            XSSFCellStyle style = getStyle(workbook);

            sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, filedName.length));
            cellTitle.setCellStyle(columnTopStyle);
            cellTitle.setCellValue(sheetTableTitle);

            // 定义所需列数
            int columnNum = filedName.length + 1;
            // 在索引2的位置创建行(最顶端的行开始的第二行)
            XSSFRow rowRowName = sheet.createRow(2);

            // 将列头设置到sheet的单元格中
            for (int n = 0; n < columnNum; n++) {
                //创建列头对应个数的单元格
                XSSFCell cellRowName = rowRowName.createCell(n);
                //设置列头单元格的数据类型
                cellRowName.setCellType(XSSFCell.CELL_TYPE_STRING);
                XSSFRichTextString text;
                if (n == 0) {
                    text = new XSSFRichTextString("序号");
                } else {
                    text = new XSSFRichTextString(filedName[n - 1].toString());
                }
                //设置列头单元格的值
                cellRowName.setCellValue(text);
                //设置列头单元格样式
                cellRowName.setCellStyle(columnTopStyle);
            }

            //插入数据
            if (dataList != null && !dataList.isEmpty()) {
                for (int i = 0; i < dataList.size(); i++) {
                    //遍历每个对象
                    Object[] obj = dataList.get(i);
                    //创建所需的行数
                    XSSFRow row = sheet.createRow(i + 3);

                    for (int j = 0; j < obj.length + 1; j++) {
                        //设置单元格的数据类型
                        XSSFCell cell = null;
                        if (j == 0) {
                            cell = row.createCell(j, XSSFCell.CELL_TYPE_NUMERIC);
                            cell.setCellValue(i + 1);
                        } else {
                            cell = row.createCell(j, XSSFCell.CELL_TYPE_STRING);
                            if (obj[j - 1] == null) {
                                cell.setCellValue("");
                            } else {
                                cell.setCellValue(obj[j - 1].toString());
                            }
                        }
                        cell.setCellStyle(style);
                    }
                }
            } else {
                XSSFRow rowNoData = sheet.createRow(3);
                XSSFCell noDataCellTitle = rowNoData.createCell(0);
                sheet.addMergedRegion(new CellRangeAddress(3, 5, 0, filedName.length));
                noDataCellTitle.setCellStyle(columnTopStyle);
                noDataCellTitle.setCellValue("无数据");
            }

            //让列宽随着导出的列长自动适应
            for (int colNum = 0; colNum < columnNum; colNum++) {
                int columnWidth = sheet.getColumnWidth(colNum) / 256;
                for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                    XSSFRow currentRow;
                    //当前行未被使用过
                    if (sheet.getRow(rowNum) == null) {
                        currentRow = sheet.createRow(rowNum);
                    } else {
                        currentRow = sheet.getRow(rowNum);
                    }
                    if (currentRow.getCell(colNum) != null) {
                        XSSFCell currentCell = currentRow.getCell(colNum);
                        if (currentCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            int length = currentCell.getStringCellValue().getBytes().length;
                            if (columnWidth < length) {
                                columnWidth = length;
                            }
                        }
                    }
                }
                if (colNum == 0) {
                    sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
                } else {
                    sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
                }
            }
            OutputStream o = response.getOutputStream();
            workbook.write(o);
            o.flush();
            o.close();
        } catch (FileNotFoundException e) {
            //文件不存在
            logger.error("File not found or had opened, error = {}", e.getLocalizedMessage());
        } catch (Exception e) {
            //导出成excel文件失败
            logger.error("Export data failure, error = {}", e.getLocalizedMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                logger.error("workbook close failure, error = {}", e.getLocalizedMessage());
            }
        }
    }

    /*
     * 列头单元格样式
     */
    private static XSSFCellStyle getColumnTopStyle(XSSFWorkbook workbook) {

        // 设置字体
        XSSFFont font = workbook.createFont();
        //设置字体大小
        font.setFontHeightInPoints((short) 14);
        //字体加粗
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        //设置字体名字
//        font.setFontName("Courier New");
        //设置样式;
        XSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

        return style;
    }

    /*
     * 列数据信息单元格样式
     */
    private static XSSFCellStyle getStyle(XSSFWorkbook workbook) {
        // 设置字体
        XSSFFont font = workbook.createFont();
        // 设置字体大小
        font.setFontHeightInPoints((short) 11);
        // 字体加粗
        font.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
        //设置字体名字
//        font.setFontName("Courier New");
        //设置样式;
        XSSFCellStyle style = workbook.createCellStyle();
        //设置底边框;
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        //设置底边框颜色;
        style.setBottomBorderColor(HSSFColor.BLACK.index);
        //设置左边框;
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        //设置左边框颜色;
        style.setLeftBorderColor(HSSFColor.BLACK.index);
        //设置右边框;
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        //设置右边框颜色;
        style.setRightBorderColor(HSSFColor.BLACK.index);
        //设置顶边框;
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        //设置顶边框颜色;
        style.setTopBorderColor(HSSFColor.BLACK.index);
        //在样式用应用设置的字体;
        style.setFont(font);
        //设置自动换行;
        style.setWrapText(false);
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);

        return style;
    }
}
