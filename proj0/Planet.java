public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    static final double GRAVITATIONAL_CONSTANT = 6.67e-11;

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
        return GRAVITATIONAL_CONSTANT * this.mass * p.mass / (r*r);
    }

    private double calcDistanceDiff(Planet p, char axis) {
        double diff = 0.0;
        if (axis == 'x') {
            if(this.xxPos > p.xxPos) {
                diff = this.xxPos - p.xxPos;
            } else {
                diff = -(this.xxPos - p.xxPos);
            }
        } else if (axis == 'y') {
            if(this.yyPos > p.yyPos) {
                diff = this.yyPos - p.yyPos;
            } else {
                diff = -(this.yyPos - p.yyPos);
            }
        }
        return diff;
    }

    public double calcForceExertedByX(Planet p) {
        double force = this.calcForceExertedBy(p);
        double dx = calcDistanceDiff(p, 'x');
        return force * dx / this.calcDistance(p);
    }
    public double calcForceExertedByY(Planet p) {
        double force = this.calcForceExertedBy(p);
        double dy = calcDistanceDiff(p, 'y');
        return force * dy / this.calcDistance(p);
    }

}
