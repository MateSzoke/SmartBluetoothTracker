package hu.bme.szokemate.smartbluetoothtracker.interactor;

import java.util.logging.Logger;

import hu.bme.szokemate.smartbluetoothtracker.model.ThingSpeak.Field2;


public class GetField2Event {
    private int code;
    private Field2 field;
    private Throwable throwable;

    public GetField2Event() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Field2 getField() {
        return field;
    }

    public void setField(Field2 field) {
        this.field = field;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
