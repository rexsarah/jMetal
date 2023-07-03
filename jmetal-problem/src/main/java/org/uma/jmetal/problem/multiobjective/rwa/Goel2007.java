package org.uma.jmetal.problem.multiobjective.rwa;


import java.util.ArrayList;
import java.util.List;
import org.uma.jmetal.problem.doubleproblem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.doublesolution.DoubleSolution;

/**
 * Problem Goel2007 (RWA7) described in the paper "Engineering applications of
 * multi-objective evolutionary algorithms: A test suite of box-constrained real-world
 * problems". DOI: https://doi.org/10.1016/j.engappai.2023.106192
 */
public class Goel2007 extends AbstractDoubleProblem {

  public Goel2007() {
    numberOfObjectives(3);
    name("Goel2007");

    int numberOfVariables = 4 ;
    List<Double> lowerLimit = new ArrayList<>(numberOfVariables) ;
    List<Double> upperLimit = new ArrayList<>(numberOfVariables) ;

    for (int i = 0; i < numberOfVariables; i++) {
      lowerLimit.add(0.0);
      upperLimit.add(1.0);
    }

    variableBounds(lowerLimit, upperLimit);
  }


  @Override
  public DoubleSolution evaluate(DoubleSolution solution) {
    double a = solution.variables().get(0);
    double DHA = solution.variables().get(1);
    double DOA = solution.variables().get(2);
    double OPTT = solution.variables().get(3);
    double Xcc;
    double TFmax;
    double TTmax;

    Xcc = 0.153 - 0.322 * a + 0.396 * DHA + 0.424 * DOA + 0.0226 * OPTT
        + 0.175 * a * a + 0.0185 * DHA * a - 0.0701 * DHA * DHA
        - 0.251 * DOA * a + 0.179 * DOA * DHA + 0.0150 * DOA * DOA
        + 0.0134 * OPTT * a + 0.0296 * OPTT * DHA + 0.0752 * OPTT * DOA
        + 0.0192 * OPTT * OPTT;

    TFmax = 0.692 + 0.477 * a - 0.687 * DHA - 0.080 * DOA - 0.0650 * OPTT
        - 0.167 * a * a - 0.0129 * DHA * a + 0.0796 * DHA * DHA
        - 0.0634 * DOA * a - 0.0257 * DOA * DHA + 0.0877 * DOA * DOA
        - 0.0521 * OPTT * a + 0.00156 * OPTT * DHA + 0.00198 * OPTT * DOA
        + 0.0184 * OPTT * OPTT;

    TTmax = 0.370 - 0.205 * a + 0.0307 * DHA + 0.108 * DOA + 1.019 * OPTT
        - 0.135 * a * a + 0.0141 * DHA * a + 0.0998 * DHA * DHA
        + 0.208 * DOA * a - 0.0301 * DOA * DHA - 0.226 * DOA * DOA
        + 0.353 * OPTT * a - 0.0497 * OPTT * DOA - 0.423 * OPTT * OPTT
        + 0.202 * DHA * a * a - 0.281 * DOA * a * a - 0.342 * DHA * DHA * a
        - 0.245 * DHA * DHA * DOA + 0.281 * DOA * DOA * DHA
        - 0.184 * OPTT * OPTT * a - 0.281 * DHA * a * DOA;

    solution.objectives()[0] = Xcc;
    solution.objectives()[1] = TFmax;
    solution.objectives()[2] = TTmax;

    return solution ;
  }
}
