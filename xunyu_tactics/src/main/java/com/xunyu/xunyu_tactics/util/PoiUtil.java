package com.xunyu.xunyu_tactics.util;

import org.apache.poi.ss.usermodel.Cell;

/**
 * @author xym
 * @description apache poi util
 * @date 2018/5/10 11:18
 */
public class PoiUtil {

    public static String getKeyword(Cell cell){
        String keyword = "";
        switch (cell.getCellTypeEnum()){
            case NUMERIC:
                long keywordNum = (long)cell.getNumericCellValue();
                keyword = String.valueOf(keywordNum);
                break;
            case STRING:
                keyword = cell.getStringCellValue();
                break;
            case BOOLEAN:
                keyword = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK:
                break;
            default:
        }
        return keyword;
    }
}
