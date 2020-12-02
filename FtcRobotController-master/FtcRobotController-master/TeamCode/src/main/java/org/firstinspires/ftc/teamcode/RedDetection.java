package org.firstinspires.ftc.teamcode;

import android.location.Location;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class RedDetection<y> extends OpenCvPipeline {
    Telemetry telemetry;
    Mat mat = new Mat();
    public enum Location {
        LEFT,
        RIGHT,
        NOT_FOUND
    }
    private Location location;
    static final Rect Left_Reg = new Rect(
            new Point(60,35),
            new Point(120, 75)
            );
    static final Rect Right_Reg = new Rect(
            new Point(140, 35),
            new Point(200, 75)
    );
    static double THRESHOLD = 0.4;
    public RedDetection(Telemetry t) { telemetry = t;}

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowHSV = new Scalar(170, 50, 70);
        Scalar highHSV = new Scalar(006, 255, 255);

        Core.inRange(mat, lowHSV, highHSV, mat);
        //image becomes grey scalled at this point.

        Mat left = mat.submat(Left_Reg);
        Mat right = mat.submat(Right_Reg);

        double leftValue = Core.sumElems(left).val[0] / Left_Reg.area() / 255;
        double RightValue = Core.sumElems(left).val[0] / Right_Reg.area() / 255;

        left.release();
        right.release();

        boolean stoneLeft = leftValue > THRESHOLD;
        boolean stoneRight = leftValue > THRESHOLD;

        if (stoneLeft && stoneRight){
            location = Location.NOT_FOUND;

        }
        if (stoneLeft){
            location = Location.RIGHT;

        }
        else{
            location = Location.LEFT;

        }
        telemetry.update();

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);

        Scalar colorStone = new Scalar(255, 0, 0);
        Scalar colorSkystone = new Scalar(0, 255, 0);

        Imgproc.rectangle(mat, Left_Reg, location == Location.LEFT?  colorSkystone:colorStone);
        Imgproc.rectangle(mat, Right_Reg, location == Location.RIGHT?  colorSkystone:colorStone);

        return mat;
    }

    public Location getLocation() {
        return location;
    }
}
