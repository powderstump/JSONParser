import util.IOUtil;
import util.ParseUtil;

public class main {

    public static void main(String[] args) throws Exception {
        IOUtil ioUtil = new IOUtil();
        ParseUtil parseUtil = new ParseUtil();

        //String firstArgs = args[0];
        String firstArgs = "a";

        switch (firstArgs) {
            case "s" :  System.out.println("Start!");
                        ioUtil.slice();
                        System.out.println("End!");
                        break;

            case "a" :  System.out.println("Start!");
                        parseUtil.findType();
                        System.out.println("End!");
                        break;
            default  :  break;

        }
    }

}
