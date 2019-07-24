package util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import object.JsonType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseUtil {

    public List<String> findType() throws IOException {
        IOUtil ioUtil = new IOUtil();
        JsonElement element = ioUtil.jsonInput();
        JsonArray array = element.getAsJsonArray();
        String type = "";
        List<String> typeList = new ArrayList<>();
        List<JsonType> jsonTypes = new ArrayList<>();
        Map<String, Integer> t_count = new HashMap<>();
        List<JsonType> fire = new ArrayList<>();
        String output = "[";

        for(int idx=0; idx < array.size(); idx++) {
            type = array.get(idx).getAsJsonObject().get("_T").getAsString();
            if(!typeList.contains(type)) {
                typeList.add(type);
                jsonTypes.add(new JsonType(type, array.get(idx).getAsJsonObject()));
                t_count.put(type, 1);
            } else {
                t_count.put(type, t_count.get(type)+1);
            }

            if(type.equals("LogWeaponFireCount")){
                fire.add(new JsonType(type, array.get(idx).getAsJsonObject()));
            }
        }

        for(JsonType list : jsonTypes) {
            System.out.println(list.getType() + " : " + t_count.get(list.getType()));
            System.out.println(list.getObject().toString());
            System.out.println(" ");
        }
        System.out.println(array.size());
        for(JsonType list : fire){
            if(list.getObject().toString().contains("FinKA--")){
                output += list.getObject()+",";
            }
        }
        output += "]";
        System.out.println(output);
        ioUtil.commonOutput(output, "LogWeaponFireCount.txt");
        return typeList;
    }
}