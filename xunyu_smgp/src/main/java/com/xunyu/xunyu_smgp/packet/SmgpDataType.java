package com.xunyu.xunyu_smgp.packet;

/**
 * @author
 * @description 数据类型
 * @date 2018/5/18 11:18
 */
public enum SmgpDataType {
    /**
     * 无符号整数
     */
    INTEGER(1),
    /**
     * 不强制以 0x00 结尾的定长字符串。当位数不足时，在不明确注明的情况下，应左对齐，右补 0x00。
     * 在明确注明的情况下，以该字段的明确注明为准。
     */
    OCTET_STRING(2)

    ;

    SmgpDataType(int commandId){
        this.commandId = commandId;
    }

    private int commandId;

    public int getCommandId() {
        return commandId;
    }
}
