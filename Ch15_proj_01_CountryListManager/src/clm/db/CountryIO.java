package clm.db;

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

public class CountryIO {
	private List<String> countries = null;
    private Path countriesPath = null;
    private File countriesFile = null;

    public CountryIO() {
        countriesPath = Paths.get("countries.txt");
        countriesFile = countriesPath.toFile();
        countries = this.getAll();
    }

    public List<String> getAll() {
        // if the countries file has already been read, don't read it again
        if (countries != null) {
            return countries;
        }

        countries = new ArrayList<>();

        if (Files.exists(countriesPath)) { 
            try (BufferedReader in
                    = new BufferedReader(
                            new FileReader(countriesFile))) {
                // read all countries stored in the file
                // into the array list
                String line = in.readLine();
                while (line != null) {

                    countries.add(line);

                    line = in.readLine();
                }
            } catch (IOException e) {
                System.out.println(e);
                return null;
            }
        }
        return countries;
    }

    public String get(int n) {
    	return countries.get(n);
    }

    public boolean add(String s) {
        countries.add(s);
        return this.saveCountries();
    }

    public boolean delete(String s) {
        countries.remove(countries.indexOf(s));
        return this.saveCountries();
    }

    private boolean saveCountries() {
        try (PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(countriesFile)))) {
            for (String s : countries) {
                out.print(s + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
