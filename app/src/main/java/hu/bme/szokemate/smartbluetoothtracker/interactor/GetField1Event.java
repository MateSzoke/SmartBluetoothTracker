package hu.bme.szokemate.smartbluetoothtracker.interactor;

import java.util.logging.Logger;

import hu.bme.szokemate.smartbluetoothtracker.model.ThingSpeak.Field1;

//Event for getting field1 from ThingSpeak
public class GetField1Event {
    private int code;
    private Field1 field;
    private Throwable throwable;

    public GetField1Event() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Field1 getField() {
        return field;
    }

    public void setField(Field1 field) {
        this.field = field;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
