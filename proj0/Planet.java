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
        return GRAVITATIONAL_CONSTANT * this.mass * p.mass / (r * r);
    }

    private double calcDistanceDiff(Planet p, char axis) {
        // Calculate the difference between this planet and p along the given axis
        double diff = 0.0;
        if (axis == 'x') {
            diff = this.xxPos - p.xxPos; // Subtract the x-positions
        } else if (axis == 'y') {
            diff = this.yyPos - p.yyPos; // Subtract the y-positions
        }
        if (diff < 0) { // If the difference is negative
            diff = -diff; // Make it positive by multiplying by -1
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

    /** A Planets cannot exert gravitational forces on themselves */
    private boolean equals(Planet p) {
        if(this.xxPos == p.xxPos && this.yyPos == p.yyPos &&
                this.xxVel == p.xxVel && this.yyVel == p.yyVel && this.mass == p.mass)
            return true;
        return false;
    }

    public double calcNetForceExertedByX(Planet[] p) {
        double forces = 0;
        for(Planet sp : p ) {
            if(!this.equals(sp))
                forces += this.calcForceExertedByX(sp);
        }
        return forces;
    }

    public double calcNetForceExertedByY(Planet[] p) {
        double forces = 0;
        for (Planet sp : p) {
            if (!this.equals(sp))
                forces += this.calcForceExertedByY(sp);
        }
        return forces;
    }
}