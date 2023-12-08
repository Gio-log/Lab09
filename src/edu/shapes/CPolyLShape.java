package edu.shapes;

import java.awt.*;

public class CPolyLShape extends CPoly{
    protected int A;
    protected int B;
    protected int G;

    public CPolyLShape(int x0, int y0, Color f, Color b, int a, int b1, int g) {
        super(x0, y0, f, b, 6);
        A = a;
        B = b1;
        G = g;
    }
    @Override
    protected void updateCoordinates() {
        px[0] = X0;     py[0] = Y0;
        px[1] = X0;     py[1] = Y0 + B;
        px[2] = X0 + A; py[2] = Y0 + B;
        px[3] = X0 + A; py[3] = Y0 + B - G;
        px[4] = X0 + G; py[4] = Y0 + B - G;
        px[5] = X0 + G; py[5] = Y0;
    }
}
