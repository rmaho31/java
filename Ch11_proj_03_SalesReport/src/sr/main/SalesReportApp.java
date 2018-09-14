package sr.main;

public class SalesReportApp {

	public static void main(String[] args) {
		double[][] sales = {
				{1540.0, 2010.0, 2450.0, 1845.0}, // Region 1
				{1130.0, 1168.0, 1847.0, 1491.0}, // Region 2
				{1580.0, 2305.0, 2710.0, 1284.0}, // Region 3
				{1105.0, 4102.0, 2391.0, 1576.0} // Region 4
				};
		
		String body = "";
		String header = "Region\t";
		String region = "";
		String qaurter= "";
		for (int i = 0; i < sales.length; i++) {
			double qSum = 0;
			double rSum = 0;
			body += "  " + i + "\t";
			for (int j = 0; j < sales[i].length; j++) {
				body += sales[i][j] + "\t";
				rSum += sales[i][j];
				qSum += sales[j][i];
			}
			
			region += "Region " + i + ": " + rSum + "\n";
			body += "\n";
			header += "Q" + i + "\t";
			qaurter += "Q" + i + ": " + qSum + "\n";
			
		}
		
		System.out.println(header + "\n" + body);
		
		System.out.println("Sales by Region:");
		System.out.println(region);
		System.out.println("Sales by qaurter: ");
		System.out.println(qaurter);
	}

}
