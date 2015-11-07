package view;

public final class AppMenus {
	
	private AppMenus() {
		throw new AssertionError();
	}
	
	public static final class MainMenu {

		private MainMenu() {
			throw new AssertionError();
		}
		
		public static final String IDENTIFIER = "main";
		public static final String NAME = "MAIN";
		public static final String DESCRIPTION = "Functions";
		
		public static final int ANALYZE = 1;
		public static final int TRANSFORM = 2;
		public static final int PARSE = 3;
		public static final int HELP = 4;
		public static final int QUIT = 5;
		
		public static final String ANALYZE_DESCRIPTION = "Analyze";
		public static final String TRANSFORM_DESCRIPTION = "Transform";
		public static final String PARSE_DESCRIPTION = "Parse";		
		public static final String HELP_DESCRIPTION = "Help";
		public static final String QUIT_DESCRIPTION = "Quit";

	}
	
	public static final class TransformationMenu {

		private TransformationMenu() {
			throw new AssertionError();
		}
		
		public static final String IDENTIFIER = "transformation";
		public static final String NAME = "TRANSFORMATION";
		public static final String DESCRIPTION = "Choose your transformation";
		
		public static final int GENERATE_CHOMSKY_NORMAL_FORM = 1;
		public static final int REMOVE_UNGENERATIVE_SYMBOLS = 2;
		public static final int REMOVE_UNREACHEABLES_SYMBOLS = 3;
		public static final int REMOVE_USELESS_SYMBOLS = 4;
		public static final int REMOVE_EPSILON_PRODUCTIONS = 5;
		public static final int REMOVE_UNIT_PRODUCTIONS = 6;		
		
		public static final String GENERATE_CHOMSKY_NORMAL_FORM_DESCRIPTION = "Generate Chomsky-Normal-Form";
		public static final String REMOVE_UNGENERATIVE_SYMBOLS_DESCRIPTION = "Remove ungenerative symbols";
		public static final String REMOVE_UNREACHEABLES_SYMBOLS_DESCRIPTION = "Remove unreacheables symbols";
		public static final String REMOVE_USELESS_SYMBOLS_DESCRIPTION = "Remove useless symbols";
		public static final String REMOVE_EPSILON_PRODUCTIONS_DESCRIPTION = "Remove epsilon productions";
		public static final String REMOVE_UNIT_PRODUCTIONS_DESCRIPTION = "Remove unit productions";	

	}
	
	public static final class ParserMenu {

		private ParserMenu() {
			throw new AssertionError();
		}
		
		public static final String IDENTIFIER = "parser";
		public static final String NAME = "PARSER";
		public static final String DESCRIPTION = "Choose your parser";
		
		public static final int CYK = 1;
		public static final int LR1 = 2;
		
		public static final String CYK_DESCRIPTION = "Cocke-Younger-Kasami";
		public static final String LR1_DESCRIPTION = "LR(1) Parser";

	}
}
