package science.denghaoyu.fascinatingmanager.datastore;

import org.litepal.crud.DataSupport;

/**
 * Created by dhy on 18-3-24.
 */

public class Settings {
    private int maxRowWhenSelect = 50;

    public int getMaxRowWhenSelect() {
        return maxRowWhenSelect;
    }

    public void setMaxRowWhenSelect(int maxRowWhenSelect) {
        this.maxRowWhenSelect = maxRowWhenSelect;
    }

}
