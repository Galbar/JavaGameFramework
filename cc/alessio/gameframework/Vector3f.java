package cc.alessio.gameframework;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;

/**
 * Created by alessio on 20/11/14.
 */
public class Vector3f {
    final private static float PI = 3.14159265f;
    private float p_x;
    private float p_y;
    private float p_z;
    private float p_length;

    public float x;
    public float y;
    public float z;

    static private float module(float x, float y, float z) {
        return (float) sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
    }

    private void init(float x, float y, float z) {
        this.x = this.p_x = x;
        this.y = this.p_y = y;
        this.z = this.p_z = z;
        this.p_length = module(x, y, z);
    }

    public Vector3f(float xyz) {
        init(xyz, xyz, xyz);
    }

    public Vector3f(float x, float y) {
        init(x, y, 0);
    }

    public Vector3f(float x, float y, float z) {
        init(x, y, z);
    }

    public Vector3f(Vector3f v, Vector3f u) {
        init(v.x - u.x, v.y - u.y, v.z - u.z);
    }

    public Vector3f(Vector3f v) {
        init(v.x, v.y, v.z);
    }

    public Vector3f() {
        init(0, 0, 0);
    }

    public float length() {
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

    public Vector3f normalize() {
        x /= length();
        y /= length();
        z /= length();
        return this;
    }

    public Vector3f normalized() {
        Vector3f v = new Vector3f(this);
        return v.normalize();
    }

    public Vector3f negative() {
        return new Vector3f(-x, -y, -z);
    }

    public Vector3f add(Vector3f v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    public Vector3f added(Vector3f v) {
        Vector3f u = new Vector3f(this);
        return u.add(v);
    }

    public Vector3f multiply(Vector3f v) {
        x *= v.x;
        y *= v.y;
        z *= v.z;
        return this;
    }

    public Vector3f multiplied(Vector3f v) {
        Vector3f u = new Vector3f(this);
        return u.multiply(v);
    }

    public Vector3f divide(Vector3f v) {
        x /= v.x;
        y /= v.y;
        z /= v.z;
        return this;
    }

    public Vector3f divided(Vector3f v) {
        Vector3f u = new Vector3f(this);
        return u.divide(v);
    }

    public Vector3f add(float f) {
        x += f;
        y += f;
        z += f;
        return this;
    }

    public Vector3f added(float f) {
        Vector3f u = new Vector3f(this);
        return u.add(f);
    }

    public Vector3f multiply(float f) {
        x *= f;
        y *= f;
        z *= f;
        return this;
    }

    public Vector3f multiplied(float f) {
        Vector3f u = new Vector3f(this);
        return u.multiply(f);
    }

    public Vector3f divide(float f) {
        x /= f;
        y /= f;
        z /= f;
        return this;
    }

    public Vector3f divided(float f) {
        Vector3f u = new Vector3f(this);
        return u.divide(f);
    }

    public Vector3f rotateXZ(float degrees) {
        degrees *= (PI/180.0);
        Vector3f tmp = new Vector3f(this);
        z = (float) (tmp.z * cos(degrees) - tmp.x * sin(degrees));
        x = (float) (tmp.z * sin(degrees) + tmp.x * cos(degrees));
        return this;
    }

    public Vector3f rotateXY(float degrees) {
        degrees *= (PI/180.0);
        Vector3f tmp = new Vector3f(this);
        y = (float) (tmp.y * cos(degrees) - tmp.x * sin(degrees));
        x = (float) (tmp.y * sin(degrees) + tmp.x * cos(degrees));
        return this;
    }

    public Vector3f rotateYZ(float degrees) {
        degrees *= (PI/180.0);
        Vector3f tmp = new Vector3f(this);
        z = (float) (tmp.z * cos(degrees) - tmp.y * sin(degrees));
        y = (float) (tmp.z * sin(degrees) + tmp.y * cos(degrees));
        return this;
    }

    public Vector3f rotatedXZ(float degrees) {
        Vector3f r = new Vector3f(this);
        return r.rotateXZ(degrees);
    }

    public Vector3f rotatedXY(float degrees) {
        Vector3f r = new Vector3f(this);
        return r.rotateXY(degrees);
    }

    public Vector3f rotatedYZ(float degrees) {
        Vector3f r = new Vector3f(this);
        return r.rotateYZ(degrees);
    }

    public float dotProduct(Vector3f v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector3f crossProduct(Vector3f v) {
        return new Vector3f(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }

    public float[] asArray() {
        return new float[]{x, y, z};
    }

    public float[] asArray4(float w) {
        return new float[]{x, y, z, w};
    }
}
