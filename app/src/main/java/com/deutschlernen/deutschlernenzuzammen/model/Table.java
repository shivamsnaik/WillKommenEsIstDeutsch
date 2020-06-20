package com.deutschlernen.deutschlernenzuzammen.model;

public class Table {
    private boolean spellFirstWordOnly;
    private int tableItemHeight;
    private int textSize;
    private boolean singleColumnFlag;

    public Table(){
        this.spellFirstWordOnly = false;
        this.tableItemHeight = 90;
        this.textSize = 16;
        this.singleColumnFlag = false;
    }

    public boolean getIsSpellFirstWordOnly() {
        return spellFirstWordOnly;
    }
    public void setSpellFirstWordOnly(boolean spellFirstWordOnly) { this.spellFirstWordOnly = spellFirstWordOnly; }

    public int getTableItemHeight() {
        return tableItemHeight;
    }
    public void setTableItemHeight(int tableItemHeight) {
        this.tableItemHeight = tableItemHeight;
    }

    public int getTextSize() {
        return textSize;
    }
    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public boolean getSingleColumnFlag() {
        return singleColumnFlag;
    }
    public void setSingleColumnFlag(boolean singleColumn) {
        this.singleColumnFlag = singleColumn;
    }
}
