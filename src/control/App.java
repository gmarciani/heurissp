package control;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi.Color;

import model.SSPList;
import model.Solution;

import static org.fusesource.jansi.Ansi.*;

import java.util.Collections;

import view.AppOptions;

public class App {
	
	public static final String NAME = "SSP";
	public static final String DESC = "SSP is a command-line based application that allows the user to\n" +
									  "solve the Subset-Sum Problem (SSP) with heuristic algorithms.\n" +
									  "Furthermore, it provides the following fairness analysis methods\n" +
									  "to evaluate the quality of Pareto-optimal solutions:\n" +
									  "(i) Max-Min (ii) Kalai-Smorodinski (iii) Proportional";
	public static final String VERS = "1.0.0";
	
	public static final String LOGO = "\n   ___|   ___|    _ \\ \n \\___ \\ \\___ \\   |   | \n       |      |  ___/ \n _____/ _____/  _|     \n\n";
	
	public static final Color LOGO_COLOR = Color.YELLOW;
	public static final Color RESULT_COLOR = Color.GREEN;
	public static final Color LOGON_COLOR = Color.CYAN;
	public static final Color WARNING_COLOR = Color.YELLOW;
	public static final Color EXCEPTION_COLOR = Color.RED;
	
	private static App instance;
	
	private Options options;
	private Output output;
	
	private App() {
		AnsiConsole.systemInstall();
		this.options = new AppOptions();
		this.output = Output.getInstance();
	}
	
	public synchronized static App getInstance() {
		if (instance == null)
			instance = new App();		
		return instance;
	}
	
	public Output getOutput() {
		return this.output;
	}
	
	public void play(String[] args) {
		System.out.println(ansi().fg(LOGO_COLOR).bold().a(LOGO).reset());
		System.out.println(DESC + "\n");
		CommandLineParser cmdParser = new DefaultParser();
		CommandLine cmd = null;
		try {
			cmd = cmdParser.parse(this.options, args);
		} catch (ParseException exc) {
			this.getOutput().onException(exc.getMessage());
		}		
		
		if (cmd.hasOption("solve")) {
			final String vals[] = cmd.getOptionValues("solve");
			SSPList a = SSPList.fromString(vals[0]);
			SSPList b = SSPList.fromString(vals[1]);
			int capacity = Integer.valueOf(vals[2]);
			this.solve(a, b, capacity);
		} else if (cmd.hasOption("pareto")) {
			final String vals[] = cmd.getOptionValues("pareto");	
			SSPList a = SSPList.fromString(vals[0]);
			SSPList b = SSPList.fromString(vals[1]);
			int capacity = Integer.valueOf(vals[2]);
			this.pareto(a, b, capacity);
		} else if (cmd.hasOption("fairness")) {
			final String vals[] = cmd.getOptionValues("fairness");
			int nsols = vals.length - 2;
			Solution sols[] = new Solution[nsols];
			for (int n = 0; n < nsols; n ++)
				sols[n] = Solution.fromString(vals[n]);
			int maxA = Integer.valueOf(vals[vals.length - 2]);
			int maxB = Integer.valueOf(vals[vals.length - 1]);
			this.fairness(sols, maxA, maxB);
		} else if (cmd.hasOption("help")) {
			this.help();
		} else if (cmd.hasOption("version")) {
			this.version();
		}		
		this.quit();
	}	
	
	public void solve(final SSPList a, final SSPList b, final int c) {
		Solution psols[] = this.pareto(a, b, c);
		this.fairness(psols, Collections.max(a), Collections.max(b));		
	}
	
	public Solution[] pareto(final SSPList a, final SSPList b, final int c) {
		this.getOutput().onResult("Computing the Pareto optimal solutions for the following SSP instance:");
		this.getOutput().onResult(" * Set-A: " + a);
		this.getOutput().onResult(" * Set-B: " + b);
		this.getOutput().onResult(" * Capacity: " + c);
		this.getOutput().onDefault(" ...");
		this.getOutput().onResult("Computing the Pareto optimal solutions for the following SSP instance:");
		
		Solution psols[] = Pareto.getOptimalSolutions(a, b, c);
		
		for (int i = 1; i <= psols.length; i++)
			this.getOutput().onResult("(" + i + ") " + psols[i - 1]);		
		this.getOutput().onDefault("  .");
		
		return psols;
	}
	
	public Solution[] fairness(Solution sols[], final int maxA, final int maxB) {
		this.getOutput().onResult("Computing the fairest solution in the following set of Pareto-optimal solutions:");
		for (int i = 1; i <= sols.length; i++)
			this.getOutput().onResult("(" + i + ") " + sols[i - 1]);
		this.getOutput().onResult("With maximum value in A: " + maxA);
		this.getOutput().onResult("With maximum value in B: " + maxB);		
		this.getOutput().onDefault(" ...");
		
		Solution fsols[] = new Solution[3];
		
		Solution solMaxMin = Fairness.maxMin(sols);
		Solution solKalaiSmorodinski = Fairness.kalaiSmorodinski(sols, maxA, maxB);
		Solution solProportional = Fairness.proportional(sols);
		
		this.getOutput().onResult("Max-Min Fairness: " + solMaxMin);
		this.getOutput().onResult("Kalai-Smorodinski Fairness: " + solKalaiSmorodinski);
		this.getOutput().onResult("Proportional Fairness: " + solProportional);
		this.getOutput().onDefault("  .");
		
		fsols[0] = solMaxMin;
		fsols[1] = solKalaiSmorodinski;
		fsols[2] = solProportional;
		
		return fsols;
	}
	
	public void help() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("ssp", this.options);
	}
	
	public void version() {
		this.getOutput().onResult("v" + VERS);
	}
	
	public void quit() {
		this.getOutput().onResult("Good bye!");
		AnsiConsole.systemUninstall();
		System.exit(0);
	}

}
