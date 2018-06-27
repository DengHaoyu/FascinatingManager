package science.denghaoyu.fascinatingmanager.datastore;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * Created by dhy on 18-3-24.
 */

public class Settings extends DataSupport implements Serializable{
    @Deprecated
    private int maxRowWhenSelect = 50;
    private int rowSelect = 50;
    public int getRowSelect() {
        return rowSelect;
    }

    public void setRowSelect(int rowSelect) {
        this.rowSelect = rowSelect;
    }

    @Deprecated
    public int getMaxRowWhenSelect() {
        return maxRowWhenSelect;
    }
    @Deprecated
    public void setMaxRowWhenSelect(int maxRowWhenSelect) {
        this.maxRowWhenSelect = maxRowWhenSelect;
    }

}
