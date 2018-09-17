package html.main;

public class HtmlConverterApp {
	
	public static void main(String args[]) {
		String html = "<h1>Grocery List</h1>\n" +
				 "<ul>\n" +
				 "    <li>Eggs</li>\n" +
				 "    <li>Milk</li>\n" +
				 "    <li>Butter</li>\n" +
				 "</ul>";
		html = html.replace("<li>", "*");
		html = html.replaceAll("<.+?>", "");
		html = html.replaceAll("\n\u0020+", "\n ");
		System.out.println(html);
	}
}
