package science.denghaoyu.fascinatingmanager.datastore;

import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by dhy on 18-2-4.
 * this class is used to save the information of each connection into
 * database
 */

public class ConnectionItem extends DataSupport implements Serializable{
    private char firstLetter;
    private Date createDate;
    private String connectionName;
    private String address;
    private int port;
    private String comment;


    public char getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(char beginLetter) {
        this.firstLetter = beginLetter;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }



}
