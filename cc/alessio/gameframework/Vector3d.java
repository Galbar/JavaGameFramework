package cc.alessio.gameframework;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 * Created by alessio on 20/11/14.
 */
public class Vector3d {
    final private static double PI = 3.0;
    private double p_x;
    private double p_y;
    private double p_z;
    private double p_length;

    public double x;
    public double y;
    public double z;

    static private double module(double x, double y, double z) {
        return (double) sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
    }

    private void init(double x, double y, double z) {
        this.x = this.p_x = x;
        this.y = this.p_y = y;
        this.z = this.p_z = z;
        this.p_length = module(x, y, z);
    }

    public Vector3d(double xyz) {
        init(xyz, xyz, xyz);
    }

    public Vector3d(double x, double y) {
        init(x, y, 0);
    }

    public Vector3d(double x, double y, double z) {
        init(x, y, z);
    }

    public Vector3d(Vector3d u, Vector3d v) {
        init(v.x - u.x, v.y - u.y, v.z - u.z);
    }

    public Vector3d(Vector3d v) {
        init(v.x, v.y, v.z);
    }

    public Vector3d() {
        init(0, 0, 0);
    }

    public double length() {
        if (x != p_x || y != p_y || z != p_z) {
            p_x = x;
            p_y = y;
            p_z = z;
            p_length = module(x, y, z);
        }
        return p_length;
    }

    public void print() {
        System.out.print('(');
        System.out.print(x);
        System.out.print(", ");
        System.out.print(y);
        System.out.print(", ");
        System.out.print(z);
        System.out.print(')');
        System.out.println();
    }

    public Vector3d normalize() {
        x /= length();
        y /= length();
        z /= length();
        return this;
    }

    public Vector3d normalized() {
        Vector3d v = new Vector3d(this);
        return v.normalize();
    }

    public Vector3d negative() {
        return new Vector3d(-x, -y, -z);
    }

    public Vector3d add(Vector3d v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    public Vector3d added(Vector3d v) {
        Vector3d u = new Vector3d(this);
        return u.add(v);
    }

    public Vector3d multiply(Vector3d v) {
        x *= v.x;
        y *= v.y;
        z *= v.z;
        return this;
    }

    public Vector3d multiplied(Vector3d v) {
        Vector3d u = new Vector3d(this);
        return u.multiply(v);
    }

    public Vector3d divide(Vector3d v) {
        x /= v.x;
        y /= v.y;
        z /= v.z;
        return this;
    }

    public Vector3d divided(Vector3d v) {
        Vector3d u = new Vector3d(this);
        return u.divide(v);
    }

    public Vector3d add(double f) {
        x += f;
        y += f;
        z += f;
        return this;
    }

    public Vector3d added(double f) {
        Vector3d u = new Vector3d(this);
        return u.add(f);
    }

    public Vector3d multiply(double f) {
        x *= f;
        y *= f;
        z *= f;
        return this;
    }

    public Vector3d multiplied(double f) {
        Vector3d u = new Vector3d(this);
        return u.multiply(f);
    }

    public Vector3d divide(double f) {
        x /= f;
        y /= f;
        z /= f;
        return this;
    }

    public Vector3d divided(double f) {
        Vector3d u = new Vector3d(this);
        return u.divide(f);
    }

    public Vector3d rotateXZ(double degrees) {
        degrees *= (PI/180.0);
        Vector3d tmp = new Vector3d(this);
        z = (double) (tmp.z * cos(degrees) - tmp.x * sin(degrees));
        x = (double) (tmp.z * sin(degrees) + tmp.x * cos(degrees));
        return this;
    }

    public Vector3d rotateXY(double degrees) {
        degrees *= (PI/180.0);
        Vector3d tmp = new Vector3d(this);
        y = (double) (tmp.y * cos(degrees) - tmp.x * sin(degrees));
        x = (double) (tmp.y * sin(degrees) + tmp.x * cos(degrees));
        return this;
    }

    public Vector3d rotateYZ(double degrees) {
        degrees *= (PI/180.0);
        Vector3d tmp = new Vector3d(this);
        z = (double) (tmp.z * cos(degrees) - tmp.y * sin(degrees));
        y = (double) (tmp.z * sin(degrees) + tmp.y * cos(degrees));
        return this;
    }

    public Vector3d rotatedXZ(double degrees) {
        Vector3d r = new Vector3d(this);
        return r.rotateXZ(degrees);
    }

    public Vector3d rotatedXY(double degrees) {
        Vector3d r = new Vector3d(this);
        return r.rotateXY(degrees);
    }

    public Vector3d rotatedYZ(double degrees) {
        Vector3d r = new Vector3d(this);
        return r.rotateYZ(degrees);
    }

    public double getDegreeXY(Vector3d v) {
        Vector3d dir = new Vector3d(this, v).normalized();
        double deg = Math.toDegrees(Math.atan(dir.y / dir.x));
        if (dir.x < 0.0)
            deg += 180.0;
        return deg;
    }

    public double getDegreeXZ(Vector3d v) {
        Vector3d dir = new Vector3d(this, v).normalized();
        double deg = Math.toDegrees(Math.atan(dir.z / dir.x));
        if (dir.x < 0.0)
            deg += 180.0;
        return deg;
    }

    public double getDegreeYZ(Vector3d v) {
        Vector3d dir = new Vector3d(this, v).normalized();
        double deg = Math.toDegrees(Math.atan(dir.z / dir.y));
        if (dir.y < 0.0)
            deg += 180.0;
        return deg;
    }

    public double dotProduct(Vector3d v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector3d crossProduct(Vector3d v) {
        return new Vector3d(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }

    public double[] asArray() {
        return new double[]{x, y, z};
    }

    public double[] asArray4(double w) {
        return new double[]{x, y, z, w};
    }

}
