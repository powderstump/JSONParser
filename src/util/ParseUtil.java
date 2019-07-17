package util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import object.JsonType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseUtil {

    public List<String> findType() throws IOException {
        IOUtil ioUtil = new IOUtil();
        JsonElement element = ioUtil.jsonInput();
        JsonArray array = element.getAsJsonArray();
        String type = "";
        List<String> typeList = new ArrayList<>();
        List<JsonType> jsonTypes = new ArrayList<>();

        for(int idx=0; idx < array.size(); idx++) {
            type = array.get(idx).getAsJsonObject().get("_T").getAsString();
            if(!typeList.contains(type)) {
                typeList.add(type);
                jsonTypes.add(new JsonType(type, array.get(idx).getAsJsonObject()));
            }
        }

        for(JsonType list : jsonTypes) {
            System.out.println(list.getType());
            System.out.println(list.getObject().toString());
            System.out.println(" ");
        }
        System.out.println(array.size());
        return typeList;
    }
}