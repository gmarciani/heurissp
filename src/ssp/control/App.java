package ssp.control;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.fusesource.jansi.AnsiConsole;

import com.google.common.primitives.Ints;

import ssp.model.SSPList;
import ssp.model.SumSolution;
import ssp.view.AppColor;
import ssp.view.AppOptions;
import ssp.view.Output;

import static org.fusesource.jansi.Ansi.*;

public class App {
	
	public static final String NAME = "SSP";
	public static final String DESC = "SSP is a command-line based application that allows the user to\n" +
									  "solve the Subset-Sum Problem (SSP) with heuristic algorithms.\n" +
									  "Furthermore, it provides the following fairness analysis methods\n" +
									  "to evaluate the quality of Pareto-optimal solutions:\n" +
									  "(i) Max-Min (ii) Kalai-Smorodinski (iii) Proportional";
	public static final String VERS = "1.0.0";
	
	public static final String LOGO = "\n   ___|   ___|    _ \\ \n \\___ \\ \\___ \\   |   | \n       |      |  ___/ \n _____/ _____/  _|     \n\n";
	
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
		System.out.println(ansi().fg(AppColor.LOGO_COLOR).bold().a(LOGO).reset());
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
			SSPList a = SSPList.parse(vals[0]);
			SSPList b = SSPList.parse(vals[1]);
			int capacity = Integer.valueOf(vals[2]);
			this.solve(a, b, capacity);
		} else if (cmd.hasOption("pareto")) {
			final String vals[] = cmd.getOptionValues("pareto");	
			SSPList a = SSPList.parse(vals[0]);
			SSPList b = SSPList.parse(vals[1]);
			int capacity = Integer.valueOf(vals[2]);
			this.pareto(a, b, capacity);
		} else if (cmd.hasOption("fairness")) {
			final String vals[] = cmd.getOptionValues("fairness");
			int nsols = vals.length - 2;
			SumSolution sums[] = new SumSolution[nsols];
			for (int n = 0; n < nsols; n ++)
				sums[n] = SumSolution.parse(vals[n]);
			int maxA = Integer.valueOf(vals[vals.length - 2]);
			int maxB = Integer.valueOf(vals[vals.length - 1]);
			this.fairness(sums, maxA, maxB);
		} else if (cmd.hasOption("help")) {
			this.help();
		} else if (cmd.hasOption("version")) {
			this.version();
		}		
		this.quit();
	}	
	
	public void solve(final SSPList listA, final SSPList listB, final int capacity) {
		SumSolution sums[] = this.pareto(listA, listB, capacity);
		float max_sum_A = 0;
		float max_sum_B = 0;
		for (SumSolution sum : sums) {
			if (sum.getA() >= max_sum_A)
				max_sum_A = sum.getA();
			if (sum.getB() >= max_sum_B)
				max_sum_B = sum.getB();
		}
		this.fairness(sums, max_sum_A, max_sum_B);		
	}
	
	public SumSolution[] pareto(final SSPList listA, final SSPList listB, final int capacity) {
		this.getOutput().onResult("Computing the Pareto optimal sum solutions for the following SSP instance:");
		this.getOutput().onResult(" * List-A: " + listA);
		this.getOutput().onResult(" * List-B: " + listB);
		this.getOutput().onResult(" * Capacity: " + capacity);
		this.getOutput().onDefault(" ...");
		
		SumSolution sums[] = Pareto.getOptimalSums(Ints.toArray(listA), Ints.toArray(listB), capacity);
		
		for (int i = 0; i < sums.length; i++)
			this.getOutput().onResult("(" + (i+1) + ") " + sums[i]);		
		this.getOutput().onDefault("  .");
		
		return sums;
	}
	
	public SumSolution[] fairness(final SumSolution sums[], final float maxA, final float maxB) {
		this.getOutput().onResult("Computing the fairest solution in the following set of sums:");
		for (int i = 0; i < sums.length; i++)
			this.getOutput().onResult("(" + (i+1) + ") " + sums[i]);
		this.getOutput().onResult("With maximum value in A: " + maxA);
		this.getOutput().onResult("With maximum value in B: " + maxB);		
		this.getOutput().onDefault(" ...");		
		
		SumSolution sol_mm = sums[Fairness.sum_maxMin(sums)];
		SumSolution sol_ks = sums[Fairness.sum_kalaiSmorodinski(sums, maxA, maxB)];
		SumSolution sol_pr = sums[Fairness.sum_proportional(sums)];
		
		this.getOutput().onResult("Max-Min Fairness: " + ((sol_mm == null)?"none":sol_mm));
		this.getOutput().onResult("Kalai-Smorodinski Fairness: " + ((sol_ks == null)?"none":sol_ks));
		this.getOutput().onResult("Proportional Fairness: " + ((sol_mm == null)?"none":sol_pr));
		this.getOutput().onDefault("  .");
		
		SumSolution fsols[] = new SumSolution[3];
		fsols[0] = sol_mm;
		fsols[1] = sol_ks;
		fsols[2] = sol_pr;
		
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
