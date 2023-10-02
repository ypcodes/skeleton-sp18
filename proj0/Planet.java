public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    static final double Gconstant = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double xdis_ = this.xxPos - p.xxPos;
        double ydis_ = this.yyPos - p.yyPos;
        return Math.sqrt(xdis_ * xdis_ + ydis_ * ydis_);
    }

    public double calcForceExertedBy(Planet p) {
        double r = this.calcDistance(p);
        return Gconstant * this.mass * p.mass / (r*r);
    }

    public double calForceExertedByX(Planet p) {
      
    }
}
