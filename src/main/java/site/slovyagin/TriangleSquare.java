package site.slovyagin;

public class TriangleSquare {

    public static double triangleSquare(double a, double b, double c) throws IncorectSideException {
        if (a <= 0 || b <= 0 || c <= 0) throw new IncorectSideException("Введена отрицательная либо нулевая сторона");
        double p = (a + b + c) / 2;
        double square = Math.round(Math.sqrt(p * (p - a) * (p - b) * (p - c)) * 100) / 100D;
        if (square <= 0) {
            throw new IncorectSideException("Введенные стороны не образуют треугольник");
        }
        return square;
    }
}