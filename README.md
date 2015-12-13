# SSP

*Heuristic algorithms to solve the Subset Sum Problem*

- - -

SSP is a command-line based application that allows the user to
solve the Subset-Sum Problem (SSP) with heuristic algorithms.
Furthermore, it provides the following fairness analysis methods
to evaluate the quality of Pareto-optimal solutions:
* Max-Min Fairness
* Kalai-Smorodinski Fairness
* Proportional Fairness

## Installation
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

## Usage
Simply run the .jar with neither arguments nor options to access the
SSP main view.
A handy menu-based navigation will guide the user in the use of the app.


### SSP RESOLUTION
A SSP resolution is a complete fairness report about the specified lists and capacity.
In general:
	ssp -s LIST_A LIST_B CAPACITY
i.e.:
	ssp -s {1,2,3,4,5} {6,7,8,9,10} 15


### PARETO-OPTIMAL SOLUTIONS
The following Pareto-optimal determinations are available:
* All Combinations (CMB)
* Optimized Combinations (CMBO)
In general:
	ssp -p LIST_A LIST_B CAPACITY
i.e.:
	ssp -p {1,2,3,4,5} {6,7,8,9,10} 15


### FAIRNESS ANALYSIS
The following fairness analysis methods are available:
* Max-Min Fairness (MM)
* Kalai-Smorodinski Fairness (KS)
* Proportional Fairness (PR)
In general:
	ssp -f SUM_SOLUTIONS MAX_A MAX_B
i.e.:
	ssp -f {2,3} {8,16} 20 40

## Authors
Giacomo Marciani, [giacomo.marciani@gmail.com](mailto:giacomo.marciani@gmail.com)

## REFERENCES
* "Price of Fairness in two agents scenario and Subset Sum problems", 2014, G.Nicosia, A.Pacifici, U.Pferschy
* "Ricerca Operativa", 2009, P.Serafini

## Contributing
Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

## License
SSP is released under the [MIT License](https://opensource.org/licenses/MIT).
Please, read the file LICENSE.md for details.
