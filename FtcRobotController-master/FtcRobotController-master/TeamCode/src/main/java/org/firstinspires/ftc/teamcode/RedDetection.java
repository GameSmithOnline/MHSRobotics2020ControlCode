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
        LEFT1,
        LEFT2,
        LEFT3,
        LEFT4,
        RIGHT1,
        RIGHT2,
        RIGHT3,
        RIGHT4,
        MIDDLE,
        NOT_FOUND
    }
    private Location location;
    static final Rect Left1_reg = new Rect(
            new Point(0,0),
            new Point(35, 240)
            );
    static final Rect Left2_reg = new Rect(
            new Point(36, 0),
            new Point(71, 240)
    );
    static final Rect Left3_reg = new Rect(
            new Point(71,0),
            new Point(106, 240)
    );
    static final Rect Left4_reg = new Rect(
            new Point(107, 0),
            new Point(142, 240)
    );
    static final Rect Right1_reg = new Rect(
            new Point(320,0),
            new Point(285, 240)
    );
    static final Rect Right2_reg = new Rect(
            new Point(286, 0),
            new Point(251, 240)
    );
    static final Rect Right3_reg = new Rect(
            new Point(251,0),
            new Point(216, 240)
    );
    static final Rect Right4_reg = new Rect(
            new Point(217, 0),
            new Point(182, 240)
    );

    static double THRESHOLD = 0.4;
    public RedDetection(Telemetry t) { telemetry = t;}

    @Override
    public Mat processFrame(Mat input) {
        Imgproc.cvtColor(input, mat, Imgproc.COLOR_RGB2HSV);
        Scalar lowHSV = new Scalar(23, 50, 70);
        Scalar highHSV = new Scalar(32, 255, 255);

        Core.inRange(mat, lowHSV, highHSV, mat);
        //image becomes grey scalled at this point.

        Mat left1 = mat.submat(Left1_reg);
        Mat left2 = mat.submat(Left1_reg);
        Mat left3 = mat.submat(Left1_reg);
        Mat left4 = mat.submat(Left1_reg);
        Mat right1 = mat.submat(Right1_reg);
        Mat right2 = mat.submat(Right1_reg);
        Mat right3 = mat.submat(Right1_reg);
        Mat right4 = mat.submat(Right1_reg);

        double leftValue1 = Core.sumElems(left1).val[0] / Left1_reg.area() / 255;
        double leftValue2 = Core.sumElems(left2).val[0] / Left2_reg.area() / 255;
        double leftValue3 = Core.sumElems(left3).val[0] / Left3_reg.area() / 255;
        double leftValue4 = Core.sumElems(left4).val[0] / Left4_reg.area() / 255;
        double RightValue1 = Core.sumElems(right1).val[0] / Right1_reg.area() / 255;
        double RightValue2 = Core.sumElems(right2).val[0] / Right2_reg.area() / 255;
        double RightValue3 = Core.sumElems(right3).val[0] / Right3_reg.area() / 255;
        double RightValue4 = Core.sumElems(right4).val[0] / Right4_reg.area() / 255;

        left1.release();
        left2.release();
        left3.release();
        left4.release();
        right1.release();
        right2.release();
        right3.release();
        right4.release();

        boolean stoneLeft1 = leftValue1 > THRESHOLD;
        boolean stoneLeft2 = leftValue2 > THRESHOLD;
        boolean stoneLeft3 = leftValue3 > THRESHOLD;
        boolean stoneLeft4 = leftValue4 > THRESHOLD;
        boolean stoneRight1 = RightValue1 > THRESHOLD;
        boolean stoneRight2 = RightValue2 > THRESHOLD;
        boolean stoneRight3 = RightValue3 > THRESHOLD;
        boolean stoneRight4 = RightValue4 > THRESHOLD;

        if (stoneLeft1 && stoneLeft2 && stoneLeft3 && stoneLeft4 && stoneRight1 && stoneRight2 && stoneRight3 && stoneRight4){
            location = Location.NOT_FOUND;

        }
        if (stoneLeft1){
            location = Location.RIGHT1;

        }
        if (stoneLeft2){
            location = Location.RIGHT2;

        }
        if (stoneLeft3){
            location = Location.RIGHT3;

        }
        if (stoneLeft4){
            location = Location.RIGHT4;

        }
        if (stoneRight1){
            location = Location.LEFT1;

        }
        if (stoneRight1){
            location = Location.LEFT2;

        }
        if (stoneRight1){
            location = Location.LEFT3;

        }
        if (stoneRight1){
            location = Location.LEFT4;

        }
        else{
            location = Location.MIDDLE;

        }
        telemetry.update();

        Imgproc.cvtColor(mat, mat, Imgproc.COLOR_GRAY2RGB);

        Scalar colorStone = new Scalar(255, 0, 0);
        Scalar colorSkystone = new Scalar(0, 255, 0);

        Imgproc.rectangle(mat, Left1_reg, location == Location.LEFT1?  colorSkystone:colorStone);
        Imgproc.rectangle(mat, Left2_reg, location == Location.LEFT2?  colorSkystone:colorStone);
        Imgproc.rectangle(mat, Left3_reg, location == Location.LEFT3?  colorSkystone:colorStone);
        Imgproc.rectangle(mat, Left4_reg, location == Location.LEFT4?  colorSkystone:colorStone);
        Imgproc.rectangle(mat, Right1_reg, location == Location.RIGHT1?  colorSkystone:colorStone);
        Imgproc.rectangle(mat, Right2_reg, location == Location.RIGHT2?  colorSkystone:colorStone);
        Imgproc.rectangle(mat, Right3_reg, location == Location.RIGHT3?  colorSkystone:colorStone);
        Imgproc.rectangle(mat, Right4_reg, location == Location.RIGHT4?  colorSkystone:colorStone);

        return mat;
    }

    public Location getLocation() {
        return location;
    }
}
