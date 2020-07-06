public class Planet{
	public double xxPos, yyPos, xxVel, yyVel, mass;	/**Characteristics of 
													  planet */
	public String imgFileName;	//Image file name of planet
	private static final double G = 6.67e-11;
	/**Constructor 1 */
	public Planet(double xP, double yP, double xV, 
				  double yV, double m, String img){
		xxPos = xP;
		yyPos= yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	/**Constructor 2*/
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	/**t.calcDistance(u) calculates the distance between t and u.*/
	public double calcDistance(Planet p){
		double xxDist, yyDist, Dist;
		xxDist = this.xxPos - p.xxPos;
		yyDist = this.yyPos - p.yyPos;
		xxDist = Math.abs(xxDist);
		yyDist = Math.abs(yyDist);
		Dist = xxDist * xxDist + yyDist * yyDist;
		Dist = Math.sqrt(Dist);
		return Dist;
	}

	/**t.calcForceExertedBy(u) calculates the force between t and u.*/
	public double calcForceExertedBy(Planet p){
		double Dist = calcDistance(p);
		return this.G * this.mass * p.mass / (Dist * Dist);	
	}

	/**t.calcForceExertedByX(Planet p) to calculate the force on x*/
	public double calcForceExertedByX(Planet p){
		return calcForceExertedBy(p) * Math.abs((this.xxPos - p.xxPos)) / calcDistance(p); 
	}
	/**t.calcForceExertedByY(Planet p) to calculate the force on y*/
	public double calcForceExertedByY(Planet p){
		return calcForceExertedBy(p) * Math.abs((this.yyPos - p.yyPos)) / calcDistance(p); 
	}
	/**t.calcNetForceExertedByX(planet[]) to calculate the net force on x*/
	public double calcNetForceExertedByX(Planet[] L){
		double sum = 0.0d;
		for(int i = 0; i < L.length; i++){
			if(this.equals(L[i]) != true){
				sum += this.calcForceExertedByX(L[i]);
			}else{
				continue;
			}

		}
		return sum;
	}
	/**t.calcNetForceExertedByY(planet[]) to calculate the net force on y*/
	public double calcNetForceExertedByY(Planet[] L){
		double sum = 0.0d;
		for(int i = 0; i < L.length; i++){
			if(this.equals(L[i]) != true){
				sum += this.calcForceExertedByY(L[i]);
			}else{
				continue;
			}
		}
		return sum;
	}
	public void update(double time, double xxForce, double yyForce){
		double xxAccel = xxForce / this.mass;
		double yyAccel = yyForce / this.mass;
		this.xxVel += time * xxAccel;
		this.yyVel += time * yyAccel;
		this.xxPos += time * this.xxVel;
		this.yyPos += time * this.yyVel;
	}
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
	}
}

