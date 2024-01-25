# Kemeny Optimizer for Tournament Rankings

## Overview
This project implements a Simulated Annealing algorithm to optimize tournament rankings based on the Kemeny score. The Kemeny score is a measure of how well a ranking reflects the underlying preferences of the teams or participants. The goal of the algorithm is to find a ranking that minimizes the Kemeny score, indicating an optimal arrangement of the participants.

## Features
- Calculation of the Kemeny score for a given ranking.
- Generation of neighboring rankings by swapping positions of participants.
- Optimization of rankings using the Simulated Annealing technique.
- Parameter tuning for the algorithm to balance between exploration and exploitation.
- Detailed logging of the optimization process, including the number of uphill moves and the runtime performance.

## Getting Started
### Prerequisites
- Java JDK 11 or higher

### Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/kemeny-optimizer.git
Navigate to the project directory:
sh
Copy code
cd kemeny-optimizer
Usage
Compile the Java files:
sh
Copy code
javac *.java
Run the main application:
sh
Copy code
java Application <path-to-input-file>
Input File Format
The input file should be in the following format:

The first line contains the number of participants.
The following lines contain the participant index, name, and their respective scores in a CSV format.
Example:

php
Copy code
<Number of Participants>
<Participant Index>,<Participant Name>
...
<Participant Index>,<Participant Name>
<Score>,<Participant 1 Index>,<Participant 2 Index>
...
<Score>,<Participant 1 Index>,<Participant 2 Index>
Output
The output includes:

The optimized ranking of participants.
The Kemeny score of the final ranking.
The total runtime of the optimization process.
The number of uphill moves during the simulated annealing.
Example Output:

yaml
Copy code
KEMENY SCORE:  73
RUNTIME:       59ms
UPHILL MOVES:  2
POS  NAME
  1  Michael Schumacher 
  2  Damon Hill 
  ...
