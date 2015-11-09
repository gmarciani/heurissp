package view;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

public final class AppOptions extends Options {
	
	private static final long serialVersionUID = -5103529847964285801L;
	
	public static final String DESCRIPTION_SOLVE = "Solve the problem.";
	public static final String DESCRIPTION_PARETO = "Computes Pareto-optimal solutions.";
	public static final String DESCRIPTION_FAIRNESS = "Computes best faire solution.";
	public static final String DESCRIPTION_HELP = "SSP helper.";
	public static final String DESCRIPTION_VERSION = "SSP version.";
	
	public AppOptions() {
		Option solve = this.optSolve();		
		Option pareto = this.optParetoOptimal();
		Option fairness = this.optFairness();
		Option help = this.optHelp();		
		Option version = this.optVersion();
		
		OptionGroup optGroup = new OptionGroup();
		optGroup.addOption(solve);	
		optGroup.addOption(pareto);
		optGroup.addOption(fairness);
		optGroup.addOption(help);
		optGroup.addOption(version);
		
		super.addOptionGroup(optGroup);
	}	
	
	private Option optSolve() {
		return Option.builder("s")
				.longOpt("solve")
				.desc(AppOptions.DESCRIPTION_SOLVE)
				.hasArgs()
				.numberOfArgs(3)
				.valueSeparator(' ')
				.argName("SET-A SET-B CAPACITY")
				.build();
	}
	
	private Option optParetoOptimal() {
		return Option.builder("p")
				.longOpt("pareto")
				.desc(AppOptions.DESCRIPTION_PARETO)
				.hasArgs()
				.numberOfArgs(3)
				.valueSeparator(' ')
				.argName("SET-A SET-B CAPACITY")
				.build();
	}
	
	private Option optFairness() {
		return Option.builder("f")
				.longOpt("fairness")
				.desc(AppOptions.DESCRIPTION_FAIRNESS)
				.hasArgs()
				.valueSeparator(' ')
				.argName("PARETO_SOLUTIONS MAX_A MAX_B")
				.build();
	}
	
	private Option optHelp() {
		return Option.builder("h")
		.longOpt("help")
		.desc(AppOptions.DESCRIPTION_HELP)
		.hasArg(false)
		.build();
	}
	
	private Option optVersion() {
		return Option.builder("v")
				.longOpt("version")
				.desc(AppOptions.DESCRIPTION_VERSION)
				.hasArg(false)
				.build();
	}

}
