package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera2;

@Autonomous(name="RedDetection", group = "Auto")
public class RedDetectionAuto extends LinearOpMode {
    OpenCvCamera phoneCam;
    @Override
    public void runOpMode() throws InterruptedException {
        int cameraMonitorViewId = hardwareMap.appContext
                .getResources().getIdentifier("cameraMonitorViewId"
                        , "id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance()
                .createInternalCamera2(OpenCvInternalCamera2.CameraDirection.BACK, cameraMonitorViewId);

        RedDetection detector = new RedDetection(telemetry);
        phoneCam.setPipeline(detector);
        phoneCam.openCameraDeviceAsync(() -> phoneCam.startStreaming(320,240, OpenCvCameraRotation.UPRIGHT));

        waitForStart();
        switch (detector.getLocation()){
            case LEFT:
                break;
            case RIGHT:

                break;

            case NOT_FOUND:

        }



    }
}
