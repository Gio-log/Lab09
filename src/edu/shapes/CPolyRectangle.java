package edu.shapes;

import java.awt.*;

public class CPolyRectangle extends CPoly{
    protected int A;
    protected int B;
    public CPolyRectangle(int x0, int y0, Color f, Color b, int a, int b1) {
        super(x0, y0, f, b, 4);
        A = a;
        B = b1;
    }
    @Override
    protected void updateCoordinates() {
        px[0] = X0;     py[0] = Y0;
        px[1] = X0 + A; py[1] = Y0;
        px[2] = X0 + A;     py[2] = Y0 - B;
        px[3] = X0;     py[3] = Y0 - B;
    }
}
