package science.denghaoyu.fascinatingmanager.application;

import science.denghaoyu.fascinatingmanager.datastore.ConnectionItem;

/**
 * Created by dhy on 6/27/18.
 */

public class Range {
    private int start;
    private int end;
    private ConnectionItem connection;
    private String tableName;
    public Range(int start, int end){
        this.start = start;
        this.end = end;
    }

    public String getTableName() {return tableName;}
    public void setTableName(String tableName) {this.tableName = tableName;}
    public ConnectionItem getConnection(){return this.connection;}
    public int getStart(){return this.start;}
    public int getEnd(){return this.end;}
    public void setStart(int start){this.start = start;}
    public void setEnd(int end){this.end = end;}
    public void setConnection(ConnectionItem con){this.connection = connection;}
}
