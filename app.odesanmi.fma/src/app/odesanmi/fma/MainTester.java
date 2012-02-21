package app.odesanmi.fma;

public class MainTester {

	static String API = "7GU7FIOUDBBZ07DE";

	public static void main(String[] args) {

		FMAClient fmaclient = new FMAClient(API);

		try {
			System.out.println(fmaclient.getAllCurators());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
