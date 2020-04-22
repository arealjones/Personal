package Functional.functionalcountrycodes;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line);
        } catch (FileNotFoundException e) {
            this.log.log("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private Map<String, String> processInput(List<String> lines) {
        return lines.stream()
                .map(line -> line.replaceAll("\"",""))
                .collect(
                        Collectors.toMap(line -> line.substring(line.lastIndexOf(",")),
                                line -> line.substring(0, line.lastIndexOf(",")))
                );
    }

    public Map<String, String> getCodes() {
        return this.codes;
    }

    public ErrorLogger getLog() {
        return this.log;
    }
}
