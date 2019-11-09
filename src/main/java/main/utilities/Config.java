package main.utilities;

public class Config {
	public static final int MAX_CLIENTS = 5;
	public static final int DEFAULT_PORT = 5050;
	public static final String DEFAULT_HOST = "127.0.0.1";
	public static final int MAX_BORROWED_ITEMS = 3;
	//20 seconds for 1 day
	//public static final int SIMULATED_DAY = 1 * 20;//UC3_2, UC4_2, UC5_2, UC6_2
	//public static final int SIMULATED_DAY = 1 * 2000;//UC3_1, UC3_4, UC3_5, UC4_1, UC4_4, UC4_5, UC5_3, UC6_1
	public static final int SIMULATED_DAY = 1 * 400;//UC3_3, UC4_3, UC5_1, UC5_4, UC6_3
	public static final int OVERDUE = 20;
	public static final int REGISTRATION_LASTS = 14;
	public static final int TERM_LASTS = 118;
	public static final String CLERK_PASSWORD1 = "admin1";
	public static final String CLERK_PASSWORD2 = "admin2";
	public static final String CLERK_PASSWORD3 = "admin3";
	
	public static boolean REGISTRATION_STARTS = false;
	public static boolean REGISTRATION_ENDS = false;
	public static boolean TERM_ENDS = false;
	
}
