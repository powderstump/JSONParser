package object;

import com.google.gson.JsonObject;

public class JsonType {
    private String type;

    private JsonObject object;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public JsonObject getObject() {
        return object;
    }

    public void setObject(JsonObject object) {
        this.object = object;
    }

    public JsonType(String type, JsonObject object) {
        this.type = type;
        this.object = object;
    }
}
