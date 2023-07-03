package org.uma.jmetal.problem.singleobjective;

import java.util.BitSet;
import java.util.List;
import org.uma.jmetal.problem.binaryproblem.impl.AbstractBinaryProblem;
import org.uma.jmetal.solution.binarysolution.BinarySolution;
import org.uma.jmetal.solution.binarysolution.impl.DefaultBinarySolution;

/**
 * Class representing problem OneMax. The problem consist of maximizing the number of '1's in a
 * binary string.
 */
@SuppressWarnings("serial")
public class OneMax extends AbstractBinaryProblem {
  private int bits;

  /** Constructor */
  public OneMax() {
    this(256);
  }

  /** Constructor */
  public OneMax(Integer numberOfBits) {
    bits = numberOfBits;
  }

  @Override
  public int numberOfVariables() {
    return 1 ;
  }
  @Override
  public int numberOfObjectives() {
    return 1 ;
  }
  @Override
  public int numberOfConstraints() {
    return 0 ;
  }

  @Override
  public String name() {
    return "OneMax" ;
  }

  @Override
  public List<Integer> bitsPerVariable() {
    return List.of(bits);
  }

  @Override
  public BinarySolution createSolution() {
    return new DefaultBinarySolution(bitsPerVariable(), numberOfObjectives());
  }

  /** Evaluate() method */
  @Override
  public BinarySolution evaluate(BinarySolution solution) {
    int counterOnes;

    counterOnes = 0;

    BitSet bitset = solution.variables().get(0);

    for (int i = 0; i < bitset.length(); i++) {
      if (bitset.get(i)) {
        counterOnes++;
      }
    }

    // OneMax is a maximization problem: multiply by -1 to minimize
    solution.objectives()[0] = -1.0 * counterOnes;

    return solution;
  }
}
