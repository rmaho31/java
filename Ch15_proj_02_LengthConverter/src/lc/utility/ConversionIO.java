package lc.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import sc.db.Conversion;

public class ConversionIO {
	private List<Conversion> conversions = null;
    private Path conversionsPath = null;
    private File conversionsFile = null;
    private final String FIELD_SEP = "\t";

    public ConversionIO() {
        conversionsPath = Paths.get("conversions.txt");
        conversionsFile = conversionsPath.toFile();
        conversions = this.getAll();
    }

    public List<Conversion> getAll() {
        // if the conversions file has already been read, don't read it again
        if (conversions != null) {
            return conversions;
        }

        conversions = new ArrayList<>();

        if (Files.exists(conversionsPath)) { 
            try (BufferedReader in
                    = new BufferedReader(
                            new FileReader(conversionsFile))) {
                // read all conversions stored in the file
                // into the array list
                String line = in.readLine();
                while (line != null) {
                    String[] s = line.split("\t");
                    String fromUnit = s[0];
                    String toUnit = s[1];
                    double conversionValue = Double.parseDouble(s[2]);
                    	
                    Conversion c = new Conversion(fromUnit, toUnit, conversionValue);
                    	
                    conversions.add(c);      

                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        }
        return conversions;
    }

    public Conversion get(int n) {
    	return conversions.get(n);
    }
    	
	private boolean saveAll() {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(conversionsFile)))) {

            for (Conversion c : conversions) {
                out.print(c.getFromUnit() + FIELD_SEP);
                out.print(c.getToUnit() + FIELD_SEP);
                out.println(c.getConversionValue());
            }
            return true;
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean add(Conversion c) {
        conversions.add(c);
        return this.saveAll();
    }

    public boolean delete(Conversion c) {
        conversions.remove(c);
        return this.saveAll();
    }

    public boolean update(Conversion c, int n) {
        Conversion oc = this.get(n);
        int i = conversions.indexOf(oc);
        conversions.remove(i);

        // add the updated product
        conversions.add(i, c);

        return this.saveAll();
    }
}
