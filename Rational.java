/*
Rational Gidiots: Emma Vukelj and Wilson Berkow
APCS1 pd9
HW#33
2015-11-17
*/

public class Rational {
    private int p;
    private int q;

    public static void main(String[] args) {
	//=====CONSTRUCTOR======
	System.out.println("\n=====CONSTRUCTOR TESTS=====");
	//Test overloaded constructor
	Rational kramer = new Rational(1,0);
	System.out.println("kramer:\t" + kramer.toString()); //should be 0/1

	//Test overloaded but for legit denominator
	Rational elaine = new Rational(1, 4);
	System.out.println("elaine:\t" + elaine.toString()); //should be 1/4

	//Test default constructor
	Rational george = new Rational();
	System.out.println("george:\t" + george.toString()); //should be 0/1

	//Make more purposeful fraction
	Rational jerry = new Rational(1,2);
	System.out.println("jerry:\t" + jerry.toString());

	//=====floatValue()=====
	System.out.println("\n=====floatValue() tests=====");
	System.out.println("jerry.floatValue()\t" + jerry.floatValue());
	System.out.println("elaine.floatValue()\t" + elaine.floatValue());

	//=====multiply()=====
	System.out.println("\n=====multiply() test=====");
	jerry.multiply(elaine);
	System.out.println("jerry*elaine:\t" + jerry.toString());
	System.out.println("Note: jerry now equals jerry*elaine");

	//=====divide()=====
	System.out.println("\n=====divide() test=====");
	elaine.divide(jerry);
	System.out.println("elaine/jerry:\t" + elaine.toString());
	System.out.println("Note: elaine now equals elaine/jerry" +
			   "\nThis applies to all performed operations.");

	//=====add()======
	System.out.println("\n=====add() test=====");
	elaine.add(jerry);
	System.out.println("elaine+jerry:\t" + elaine.toString());

	//=====subtract()=====
	System.out.println("\n=====subtract() test=====");
	elaine.subtract(jerry);
	System.out.println("elaine-jerry:\t" + elaine.toString());

	//=====gcd()=====
	System.out.println("\n=====gcd() tests=====");
	System.out.println("elaine.gcd():\t" + elaine.gcd() +
			   "\njerry.gcd():\t" + jerry.gcd() +
			   "\ngeorge.gcd():\t" + george.gcd());

	//=====reduce()=====
	System.out.println("\n=====reduce() tests=====");
	elaine.reduce();
	System.out.println("elaine.reduce():\t" + elaine.toString());
	jerry.reduce();
	System.out.println("jerry.reduce():\t" + jerry.toString());
    }
    
    //default constructor, initializes to 0/1
    public Rational() {
	p=0;
	q=1;
    }

    public Rational(int num, int den) {
	this(); //initialize as 0/1
	if (den != 0) { //unless given denominator is valid
	    p = num;
	    q = den;
	}
    }

    //return a half as "1/2"
    public String toString() {
	return (p + "/" + q);
    }

    //get most precise floatValue of fraction w double
    public double floatValue() {
	return ( (double)p/q );
    }

    //multiply this by that(other)
    public void multiply(Rational other) {
	p *= other.p;
        q *= other.q;
    }

    //works like multiply, except you multiply reciprocal
    public void divide(Rational other) {
	p *= other.q;
	q *= other.p;
    }

    //for adding
    private static int lcm(int a, int b) {
	return a * (b / findGcd(a, b));
    }

    //also for adding
    public static int findGcd(int a, int b) {
	if (b == 0) {
	    return a;
	} else {
	    return (findGcd (b, a % b));
	}
    }
    
    public void add(Rational other) {
	int lcm = lcm(q, other.q); //denominator

	int thisHelp = (lcm/q); //make copies of each w right denominator
	Rational thisCopy = new Rational(p*thisHelp, q*thisHelp);

	int othHelp = (lcm/other.q);
	Rational othCopy = new Rational(other.p*othHelp, other.q*othHelp);

	p = thisCopy.p + othCopy.p;
	q = lcm; //make this into the added vers
    }

    public void subtract(Rational other) {
	int lcm = lcm(q, other.q); //denom

	int thisHelp = (lcm/q); //copies of this w right denominator
	Rational thisCopy = new Rational(p*thisHelp, q*thisHelp);

	int othHelp = (lcm/other.q); //copy of other w right denom
	Rational othCopy = new Rational(other.p*othHelp, other.q*othHelp);

	p = thisCopy.p - othCopy.p;
	q = lcm; //update accordingly
    }

    public int gcd() {
	return findGcd(p, q); //bc helper is used in other places so why not
    }

    public void reduce() {
	int gcd = gcd();
	p = p/gcd;
	q = q/gcd;
    }
}
