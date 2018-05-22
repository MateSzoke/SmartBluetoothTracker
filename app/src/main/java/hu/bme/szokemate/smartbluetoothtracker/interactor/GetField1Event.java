package hu.bme.szokemate.smartbluetoothtracker.interactor;

import java.util.logging.Logger;

import hu.bme.szokemate.smartbluetoothtracker.model.ThingSpeak.Field1;


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
        Logger.getAnonymousLogger().info("EVENT SETFIELD TO" + field);
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
