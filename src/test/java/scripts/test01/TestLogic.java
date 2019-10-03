package scripts.test01;

public class TestLogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean s = false;
		try {
			if(true) {
			System.out.println("1");
			s = testtest("t");}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("1");
		System.out.println(s);
	}

	
	public static boolean testtest(String t) throws Exception{
		try {
			String a = "company";
			switch (a) {
				case "company":
					System.out.println("abc");
					break;
				case "last_name":
					System.out.println("def");
					break;
			}
				System.out.println("8");
				if(true)
				{System.out.println("2");
				return true;
				}
		}catch (Exception e) {
				System.out.println("sad");
			}
		return false;
	}
	
}

