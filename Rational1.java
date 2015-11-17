public class Rational{
    //instance variables
    private int numerator;
    private int denominator;
    //end of instance variables

    //Constructors
    public Rational (){
	numerator = 0;
	denominator = 1;}

    public Rational (int n, int d){
	    this();
        if (d != 0){
	    numerator = n;
	    denominator = d;}}
    //end of Constructors

    //overrided toString method
    public String toString(){
	return(numerator + "/" + denominator);}
    //end of toString

    //returns the float form of fraction
    public double floatValue(){
	return ((double)(numerator / denominator));}

    //multiplies two fractions
    public void multiply(Rational that){
	this.numerator *= that.numerator;
	this.denominator *= that.denominator;}
    //divides two fractions
    public void divide(Rational that){
	this.numerator /= that.numerator;
	this.denominator /= that.denominator;}

    //testing stuff
    public static void main (String[] args){
	Rational r = new Rational(2,3); //Stores the rational number 2/3
	Rational s = new Rational(1,2); //Stores the rational number 1/2
	Rational t = new Rational(); //Stores the rational number 0/1
	Rational u = new Rational(1,0); //Stores the rational number 0/1

	System.out.println (r);
	System.out.println (s);
	System.out.println (t);
	System.out.println (u);


	r.multiply(s); //Multiplies r by s
	
	System.out.println (r);
	System.out.println (s);

	r.multiply(u); //Multiplies r by s
	
	System.out.println (r);
	System.out.println (u);}


}
    


    
	

  
