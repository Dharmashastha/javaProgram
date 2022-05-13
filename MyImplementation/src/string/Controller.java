package string;

public class Controller {

	public static void main(String[] args) {

		StringMethods call = new StringMethods();

		try {
			System.out.println(call.concat("Gokul", "Ali"));
			System.out.println(call.contains("hello Gokul", "Gokul"));
			System.out.println(call.equals("gokul", "gokul"));
			System.out.println(call.equalsIgnoreCase("Gokul", "gokuL"));
			System.out.println(call.indexOf("Gokul", 'l'));
			System.out.println(call.indexOf("Gokulgokul", 'u', 6));
			System.out.println(call.isEmpty(""));
			System.out.println(call.replace("Gokul", 'k', 'h'));
			System.out.println(call.substring("gokulpushpa", 5));
			System.out.println(call.substring("Gokul", 2, 4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}

	}

}
