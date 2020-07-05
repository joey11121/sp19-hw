public class Planet{
	public double xxPos, yyPos, xxVel, yyVel, mass;	/**Characteristics of 
													  planet */
	public String imgFileName;	//Image file name of planet
	/**Initializer 1 */
	public Planet(double xP, double yP, double xV, 
				  double yV, double m, String img){
		xxPos = xP;
		yyPos= yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	/**Initializer 2*/
	public Planet(Planet P){
		
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


}

