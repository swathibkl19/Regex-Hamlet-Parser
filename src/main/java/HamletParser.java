import com.sun.org.apache.xpath.internal.axes.MatchPatternIterator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){

        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){

        return hamletData;
    }

    public HamletParser(String hamletData) {
        this.hamletData = hamletData;

    }

    public String changeHamletToLeon(String regexStr1){

      //  return regexStr1.replaceAll("\\bHamlet\\b", "Leon");

        Pattern p = Pattern.compile("\\bHamlet\\b", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(regexStr1);
        String result = m.replaceAll("Leon");
        return result;

    }
   public String changeHoratioToTariq(String regexStr2){
    Pattern p = Pattern.compile("\\bHoratio\\b", Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(regexStr2);
    String result = m.replaceAll("Tariq");
    return result;
}

    public Integer findHoratio(String input) {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find())
            count++;
      return count;
    }

    public Integer findHamlet(String input) {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }

//    public Integer findName(String str){
//        Pattern pattern = Pattern.compile("str1");
//        Matcher matcher = pattern.matcher(str);
//        int count = 0;
//        while (matcher.find())
//            count++;
//        return count;
//
//    }
}
