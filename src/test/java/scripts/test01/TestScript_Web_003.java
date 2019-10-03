package scripts.test01;

import testData.aadsData;

public class TestScript_Web_003 {

	public static void main(String[] args) throws Exception {
		try {
			aadsData adata = new aadsData();
			String text = adata.AADS_USER_NAME;
			String text2 = adata.AADS_USER_1_NAME_SIP_PHONE;
			String text3 = adata.AADS_USER_1_STANDARD_CONFIG;

			System.out.println(text);
			System.out.println(text2);
			System.out.println(text3);

		} catch (Exception e) {

		}

	}

}
