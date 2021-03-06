import java.util.*;
import java.io.*;
import java.nio.file.*;

public final class CustomerTextFile implements DAO<Customer> {

    private List<Customer> customers = null;
    private Path customersPath = null;
    private File customersFile = null;

    private final String FIELD_SEP = "\t";

    public CustomerTextFile() throws IOException, FileNotFoundException {
        customersPath = Paths.get("customer.txt");
        customersFile = customersPath.toFile();
        customers = this.getAll();
    }

    @Override
    public List<Customer> getAll() throws IOException, FileNotFoundException {
        // if the customers file has already been read, don't read it again
        if (customers != null) {
            return customers;
        }

        customers = new ArrayList<>();

            BufferedReader in
                    = new BufferedReader(
                            new FileReader(customersFile));
                // read all customers stored in the file
                // into the array list
                String line = in.readLine();
                while (line != null) {
                    String[] columns = line.split(FIELD_SEP);
                    String firstName = columns[0];
                    String lastName = columns[1];
                    String email = columns[2];

                    Customer c = new Customer(
                            firstName, lastName, email);

                    customers.add(c);

                    line = in.readLine();
                
            } 
        return customers;
    }

    @Override
    public Customer get(String email) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean add(Customer c) throws IOException {
        customers.add(c);
        return this.saveAll();
    }

    @Override
    public boolean delete(Customer c) throws IOException {
        customers.remove(c);
        return this.saveAll();
    }

    @Override
    public boolean update(Customer newCustomer) throws IOException {
        // get the old customer and remove it
        Customer oldCustomer = this.get(newCustomer.getEmail());
        int i = customers.indexOf(oldCustomer);
        customers.remove(i);

        // add the updated customer
        customers.add(i, newCustomer);

        return this.saveAll();
    }

    private boolean saveAll() throws IOException {
        PrintWriter out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(customersFile))); 

            // write all customers in the array list
            // to the file
            for (Customer c : customers) {
                out.print(c.getFirstName() + FIELD_SEP);
                out.print(c.getLastName() + FIELD_SEP);
                out.println(c.getEmail());
            }
        return true;
    }
}