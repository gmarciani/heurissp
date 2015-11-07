package view;

import org.fusesource.jansi.Ansi.Color;

public class AppUI {
	
	private AppUI() {
		throw new AssertionError();
	}
	
	public static final String LOGO_PLACEHOLDER = "\nWELCOME TO GMPARSER\n";
	
	public static final Color LOGO_COLOR = Color.YELLOW;
	public static final Color RESULT_COLOR = Color.GREEN;
	public static final Color LOGON_COLOR = Color.CYAN;
	public static final Color WARNING_COLOR = Color.YELLOW;
	public static final Color EXCEPTION_COLOR = Color.RED;

}
