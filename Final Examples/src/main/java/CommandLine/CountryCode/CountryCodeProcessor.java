package CommandLine.CountryCode;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryCodeProcessor {
    private Map<String, String> codes;
    private ErrorLogger log;

    public CountryCodeProcessor(String[] args) {
        this.log = new ErrorLogger();
        this.codes =  this.populateCodes(args);
    }

    private boolean verifyInput(String[] args) {
        if (args.length != 1) {
            this.log.log("Exactly one argument expected: the file path");
            return false;
        }
        return true;
    }

    private Map<String, String> populateCodes(String[] args) {
        Map<String, String> codes = new HashMap<>();
        if (!this.verifyInput(args))
            return codes;
        List<String> lines = this.readFile(args[0]);
        return this.processInput(lines);
    }

    private List<String> readFile(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = "";
            while ((line = reader.readLine()) != null)
                lines.add(line);
        } catch (FileNotFoundException e) {
            this.log.log("File not found");
        } catch (IOException e) {
            this.log.log("IO exception");
        }
        return lines;
    }

    private Map<String, String> processInput(List<String> lines) {
        Map<String, String> codes = new HashMap<>();
        int CODE_POS = 3;
        for (String line: lines) {
            int lastComma = line.lastIndexOf(",");
            if (lastComma == line.length() - CODE_POS) {
                String code = line.substring(lastComma + 1);
                String country = line.substring(0, lastComma).replaceAll("\"","");
                codes.put(code, country);
            }
        }
        return codes;
    }

    public Map<String, String> getCodes() {
        return this.codes;
    }

    public ErrorLogger getLog() {
        return this.log;
    }
}
