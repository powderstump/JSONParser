package util;

import com.google.gson.*;

import java.io.*;

public class IOUtil {

    private static final String path = "C://";
    private static final String jsonFile = "json_response.json";
    private static final String outPath = System.getProperty("user.home");
    private static final String outFile = "out_" + jsonFile;
    private static final String jsonPath = path + jsonFile;

    private String prettyPrint(String beforeJson) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        JsonElement element = parser.parse(beforeJson);
        return gson.toJson(element);
    }

    private InputStreamReader commonInput() throws IOException {
        return new InputStreamReader(new FileInputStream(jsonPath));
    }

    public void commonOutput(String prettyJson, String fileName) throws IOException {
        if(fileName.isEmpty())
            fileName = outFile;
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outPath + File.separator + fileName));
        osw.write(prettyJson);
    }

    public void slice() throws IOException {
        commonOutput(prettyPrint(isReaderToString(commonInput())), "");
    }

    private String isReaderToString(InputStreamReader reader) throws IOException {
        char[] buffer = new char[65536];
        StringBuilder sb = new StringBuilder();
        for(int n; (n = reader.read(buffer)) > 0; ) {
            sb.append(buffer, 0, n);
        }
        return sb.toString();
    }

    public JsonElement jsonInput() throws IOException {
        JsonParser parser = new JsonParser();
        return parser.parse(new FileReader(outPath + File.separator + outFile));
    }
}
