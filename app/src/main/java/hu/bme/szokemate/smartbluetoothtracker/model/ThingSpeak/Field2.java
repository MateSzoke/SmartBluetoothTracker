package hu.bme.szokemate.smartbluetoothtracker.model.ThingSpeak;

import java.util.Date;

/**
 * Created by mate on 2018. 05. 22..
 */

public class Field2 {
    Date created_at;
    int entry_id;

    String field2;

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(int entry_id) {
        this.entry_id = entry_id;
    }

    public String getField2() {
        return "-"+field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }
}
