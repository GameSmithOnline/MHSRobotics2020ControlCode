package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.Collection;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="DriveAndWorkDaddy", group="Teleop")
// Hi Patrick can you hear me?

public class PrintTest extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private CRServo PullInLeft;
    private CRServo PullInRight;
    private DcMotor Lift1;
    private DcMotor Lift2;


    @Override
    public void init() {
        telemetry.addData("Status", "Initialized Daddy");

        leftDrive  = hardwareMap.get(DcMotor.class, "Drive_Left");
        rightDrive = hardwareMap.get(DcMotor.class, "Drive_Right");
        Lift1 = hardwareMap.get(DcMotor.class, "Lift1");
        Lift2 = hardwareMap.get(DcMotor.class, "Lift2");


        //Drive System Direction set

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        //lift system Direction set

        Lift1.setDirection(DcMotor.Direction.FORWARD);
        Lift2.setDirection(DcMotor.Direction.FORWARD);


        telemetry.addData("Status", "Initialized Daddy I wove u plz press my controls UwU ");

    }

    @Override
    public void loop() {


        leftDrive.setPower(gamepad1.left_stick_y);
        rightDrive.setPower(-gamepad1.right_stick_y);


        // Max power = 0 to 1. Negative values reverse direction
        if (gamepad2.dpad_up){
            Lift1.setPower(-1);
            Lift2.setPower(-1);
        }
        // Less power so the arm  does not get crushed or damaged on the way down
        else if (gamepad2.dpad_down){
            Lift1.setPower(0.2);
            Lift2.setPower(0.2);
        }
        else {
            Lift1.setPower(0);
            Lift2.setPower(0);
        }


        if (gamepad1.y){
            PullInLeft.setPower(359);
            PullInRight.setPower(359);
        }
       /* else{
            PullInLeft.setPower(0);
            PullInRight.setPower(0);
        }

         if (gamepad1.a){
             PullInLeft.setPower(-359);
             PullInRight.setPower(-359);
         }else{
             PullInLeft.setPower(0);
             PullInRight.setPower(0);
         }
        */
        telemetry.addData("Status", "Running... is there any thing I can do for you now daddy ^w^");
        telemetry.update();

    }

    @Override
    public void stop() {
    }


}