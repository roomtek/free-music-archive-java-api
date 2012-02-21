package app.odesanmi.fma;

public class MainTester {

	static String API = "7GU7FIOUD"; // FMA DEV ID

	public static void main(String[] args) {

		FMAClient fmaclient = new FMAClient(API);

		try {
			System.out.println(fmaclient.getAllCurators());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
