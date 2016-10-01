public class Rational {

    private int num;
    private int denom;

    /** 
	greatest common divisor of a and b
	@param a first number
	@param b second number
	@return gcd of a and b
    */
    public static int gcd(int a, int b) {
	if (a==0)
	    return b;
	else if (b==0)
	    return a;
	else
	    return gcd(b%a, a);
    }
    
    public Rational() {
	this.num = 1;
	this.denom = 1;
    }

    public Rational(int num, int denom) {
	if (denom== 0) {
	    throw new IllegalArgumentException("denominator may not be zero");
	}
	this.num = num;
	this.denom = denom;
	if (num != 0) {
	    int gcd = Rational.gcd(num,denom);
	    this.num /= gcd;
	    this.denom /= gcd;
	}
    }

    public String toString() {
	if (denom == 1 || num == 0)
	    return "" + num;
	return num + "/" + denom;
    }

    public int getNumerator() { return this.num; }
    public int getDenominator() { return this.denom; }

    public Rational times(Rational r) {
	return new Rational(this.num * r.num,
			    this.denom * r.denom);
    }

    public static Rational product(Rational a, Rational b) {
	return new Rational(a.num * b.num,
			    a.denom * b.denom);
    }
c static int lcm (int a, int b){
        int retval = 0;
        int g = gcd(a, b);
        
        retval = Math.abs(a*b);
        retval = retval/g;
        
        return retval;
        
    }
    
    public Rational plus(Rational r){
        int lcm = lcm(r.getDenominator(), denom);
        int mthis = lcm/denom;
        int mr = lcm/r.getDenominator();
        
        int numThis = mthis*num;
        int numr = mr*r.getNumerator();
        
        int retnum = numThis+numr;
        
        Rational retval = new Rational(retnum, lcm);
        
        
        return retval;
    }
    
    public static Rational sum(Rational a, Rational b){
        int lcm = lcm(a.getDenominator(), b.getDenominator());
        
        int ma = lcm/a.getDenominator();
        int mb = lcm/b.getDenominator();
        
        int numA = ma * a.getNumerator();
        int numB = mb * b.getNumerator();
        
        Rational retval = new Rational((numA+numB), lcm);
        
        return retval;
    }
    
    public Rational minus(Rational r){
        Rational neg = new Rational((-1*r.getNumerator()), r.getDenominator());
        
        Rational retval = sum(this, neg);
        
        return retval;
    }
    
    public static Rational difference(Rational a, Rational b){
        Rational neg = new Rational((-1*b.getNumerator()), b.getDenominator());
        
        Rational retval = sum(a, neg);
        
        return retval;
    }
    
    public Rational reciprocalOf(){
        if(num == 0){
            throw new ArithmeticException("denominator may not be zero");
        }else{
            Rational retval = new Rational(denom, num);
            return retval;
        }
    }
    
    public Rational dividedBy(Rational r){
        int retnum = num*r.getDenominator();
        int retdenom = denom*r.getNumerator();
        
        Rational retval = new Rational(retnum, retdenom);
        return retval;
    }
    
    public static Rational quotient (Rational a, Rational b){
        int retNom = a.getNumerator()*b.getDenominator();
        int retDenom = a.getDenominator()*b.getNumerator();
        
        Rational retval = new Rational(retNom, retDenom);
        
        return retval;
    }
    
    /** 
	For testing getters.  
	@param args unused
     */

    public static void main (String [] args) {
	Rational r = new Rational(5,7);
	System.out.println("r.getNumerator()=" + r.getNumerator());
	System.out.println("r.getDenominator()=" + r.getDenominator());
    }

    
}
