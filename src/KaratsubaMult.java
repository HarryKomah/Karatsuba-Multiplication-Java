import java.math.BigInteger;

public class KaratsubaMult {
	private final static BigInteger ZERO = new BigInteger("0");
	private final static BigInteger TEN = new BigInteger("10");
	private final static Integer thresholdDigit = 8;
	// return the digit of decimals
  static Integer bigDigits(BigInteger big){
    if(big.compareTo(ZERO) == 0) return 0;
    else if(big.compareTo(ZERO) < 0) return big.toString().length() - 1;
    else return big.toString().length();
  }

  static BigInteger tenToPower(Integer exponent){
    return TEN.pow(exponent);
  }
  static BigInteger karatsubaMultiply(BigInteger big1, BigInteger big2){
    if(bigDigits(big1) <= thresholdDigit || bigDigits(big2) <= thresholdDigit){
      return big1.multiply(big2);
    } 

    Integer len = Math.max(bigDigits(big1), bigDigits(big2));
    len = (len&1) == 1 ? len + 1 : len; // make it even numbers.
    BigInteger tenToPowerHalfLen = tenToPower(len/2);

    BigInteger[] aAndb = big1.divideAndRemainder(tenToPowerHalfLen);
    BigInteger[] cAndd = big2.divideAndRemainder(tenToPowerHalfLen);
    BigInteger ac = karatsubaMultiply(aAndb[0], cAndd[0]);
    BigInteger bd = karatsubaMultiply(aAndb[1], cAndd[1]);
    BigInteger abcd = karatsubaMultiply((aAndb[0].add(aAndb[1])), cAndd[0].add(cAndd[1]));
    
    return tenToPower(len).multiply(ac).add(tenToPowerHalfLen.multiply(abcd.subtract(ac.add(bd)))).add(bd);
  }

  static long measureExecutionTime(Runnable task){
    long startTime = System.currentTimeMillis();
    task.run();
    long endTime = System.currentTimeMillis();
    return endTime - startTime;
  }
}
