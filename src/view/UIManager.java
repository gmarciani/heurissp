package view;

import static org.fusesource.jansi.Ansi.*;

import java.awt.Menu;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Option.Builder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.fusesource.jansi.AnsiConsole;
import view.AppMenus.*;

public final class UIManager {
	
	public static Options buildCommandLineOptions() {	
		
		Option solve = Option.builder("s")
				.longOpt("solve")
				.desc(AppOptions.DESCRIPTION_SOLVE)
				.hasArgs()
				.numberOfArgs(3)
				.valueSeparator(' ')
				.argName("SET-A SET-B CAPACITY")
				.build();
		
		Option help = Option.builder("h")
				.longOpt("help")
				.desc(AppOptions.DESCRIPTION_HELP)
				.hasArg(false)
				.build();
		
		Option version = Option.builder("v")
				.longOpt("version")
				.desc(AppOptions.DESCRIPTION_VERSION)
				.hasArg(false)
				.build();
		
		OptionGroup optionGroup = new OptionGroup();
		optionGroup.addOption(solve);		
		optionGroup.addOption(help);
		optionGroup.addOption(version);
		
		Options options = new Options();	
		options.addOptionGroup(optionGroup);
		
		return options;
	}	
	
	public static Menus buildMenus() {
		Menu mainMenu = MenuBuilder.hasName(MainMenu.NAME)
				.withDescription(MainMenu.DESCRIPTION)
				.hasChoice(MainMenu.ANALYZE, MainMenu.ANALYZE_DESCRIPTION)
				.hasChoice(MainMenu.TRANSFORM, MainMenu.TRANSFORM_DESCRIPTION)
				.hasChoice(MainMenu.PARSE, MainMenu.PARSE_DESCRIPTION)
				.hasChoice(MainMenu.HELP, MainMenu.HELP_DESCRIPTION)
				.hasChoice(MainMenu.QUIT, MainMenu.QUIT_DESCRIPTION)
				.create();
		
		Menu parserMenu = MenuBuilder.hasName(ParserMenu.NAME)
				.withDescription(ParserMenu.DESCRIPTION)
				.hasChoice(ParserMenu.CYK, ParserMenu.CYK_DESCRIPTION)
				.hasChoice(ParserMenu.LR1, ParserMenu.LR1_DESCRIPTION)
				.create();
		
		Menu transformationMenu = MenuBuilder.hasName(TransformationMenu.NAME)
				.withDescription(TransformationMenu.DESCRIPTION)
				.hasChoice(TransformationMenu.REMOVE_UNGENERATIVE_SYMBOLS, TransformationMenu.REMOVE_UNGENERATIVE_SYMBOLS_DESCRIPTION)
				.hasChoice(TransformationMenu.REMOVE_UNREACHEABLES_SYMBOLS, TransformationMenu.REMOVE_UNREACHEABLES_SYMBOLS_DESCRIPTION)
				.hasChoice(TransformationMenu.REMOVE_USELESS_SYMBOLS, TransformationMenu.REMOVE_USELESS_SYMBOLS_DESCRIPTION)
				.hasChoice(TransformationMenu.REMOVE_EPSILON_PRODUCTIONS, TransformationMenu.REMOVE_EPSILON_PRODUCTIONS_DESCRIPTION)
				.hasChoice(TransformationMenu.REMOVE_UNIT_PRODUCTIONS, TransformationMenu.REMOVE_UNIT_PRODUCTIONS_DESCRIPTION)
				.hasChoice(TransformationMenu.GENERATE_CHOMSKY_NORMAL_FORM, TransformationMenu.GENERATE_CHOMSKY_NORMAL_FORM_DESCRIPTION)
				.create();
		
		Menus menus = new Menus();
		menus.addMenu(mainMenu);
		menus.addMenu(parserMenu);
		menus.addMenu(transformationMenu);
		
		return menus;
	}

	public static void installAnsiConsole() {
		AnsiConsole.systemInstall();
	}

	public static void uninstallAnsiConsole() {
		AnsiConsole.systemUninstall();
	}
	
	public static final void welcome() {
		final String logo = "\n   ___|   \\  |   _ \\                               \n  |      |\\/ |  |   |  _` |   __|  __|   _ \\   __| \n  |   |  |   |  ___/  (   |  |   \\__ \\   __/  |    \n \\____| _|  _| _|    \\__,_| _|   ____/ \\___| _|    \n";
		System.out.println(ansi().fg(AppUI.LOGO_COLOR).bold().a(logo).reset());
	}
	
	public static final void help() {
		
	}
	
	public static final void menu() {
		
	}
	
	public static final void goodbye() {
		
	}

}
