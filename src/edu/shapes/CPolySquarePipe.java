package edu.shapes;

import java.awt.*;

public class CPolySquarePipe extends CPoly{
    protected int A;
    protected int B;
    protected int G;

    public CPolySquarePipe(int x0, int y0, Color f, Color b, int a, int b1, int g) {
        super(x0, y0, f, b, 10);
        A = a;
        B = b1;
        G = g;
    }

    @Override
    protected void updateCoordinates() {
        px[0] = X0;         py[0] = Y0;
        px[1] = X0 + A;     py[1] = Y0;
        px[2] = X0 + A;     py[2] = Y0 - B;
        px[3] = X0;         py[3] = Y0 - B;
        px[4] = X0;         py[4] = Y0;
        px[5] = X0 + G;     py[5] = Y0 - G;
        px[6] = X0 + A - G; py[6] = Y0 - G;
        px[7] = X0 + A - G; py[7] = Y0 - B + G;
        px[8] = X0 + G;     py[8] = Y0 - B + G;
        px[9] = X0 + G;     py[9] = Y0 - G;
    }
}
