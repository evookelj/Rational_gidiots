/*
Rational Gidiots
Emma Vukelj and James Cao
APCS1 pd9
HW#32 -- Irrationality Stops Here
2015-11-17
*/
public class Rational{
    int p;
    int q;

    public static void main(String[] args){
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
    }

    
    //default constructor, initializes to 0/1
    public Rational(){
	p=0;
	q=1;
    }

    public Rational(int num, int den){
	this(); //initialize as 0/1
	if (den != 0) { //unless given denominator is valid
	    p = num;
	    q = den;
	}
    }

    //return a half as "1/2"
    public String toString(){
	return (p + "/" + q);
    }

    //get most precise floatValue of fraction w double
    public double floatValue(){
	return ( (double)p/q );
    }

    //multiply this by that(other)
    public void multiply(Rational other){
	p *= other.p;
        q *= other.q;
    }

    //works like multiply, except you multiply reciprocal
    public void divide(Rational other){
	p *= other.q;
	q *= other.p;
    }
}
