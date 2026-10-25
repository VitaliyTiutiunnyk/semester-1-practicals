package semester1.practice07;

public class Vector3D {
    private double x;
    private double y;
    private double z;
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3D() {
        this(0, 0, 0);
    }

    public Vector3D add(Vector3D other) {
        return new Vector3D(
                x + other.x,
                y + other.y,
                z + other.z
        );
    }
    public double dotProduct(Vector3D other) {
        return x * other.x + y * other.y + z * other.z;
    }

    public Vector3D crossProduct(Vector3D other) {
        return new Vector3D(
                y * other.z - z * other.y,
                z * other.x - x * other.z,
                x * other.y - y * other.x
        );
    }
    public boolean isOrthogonalTo(Vector3D other) {
        return dotProduct(other) == 0;
    }
    public boolean isEqualTo(Vector3D other) {
        return x == other.x && y == other.y && z == other.z;
    }
    public void printVector() {
        System.out.println("(" + x + ", " + y + ", " + z + ")");
    }
}
