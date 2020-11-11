package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import static java.lang.Thread.sleep;

@TeleOp(name="MainDriveOmni", group="Teleop")
// Hi Patrick can you hear me?

public class MainDriveOmni extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor Drive_RightFront;
    private DcMotor Drive_RightRear;
    private DcMotor Drive_LeftRear;
    private DcMotor Drive_LeftFront;

    private double speed = 0;

    private double driveMotorPower = 0.4;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized Daddy");

        Drive_RightRear  = hardwareMap.get(DcMotor.class, "Drive_RightRear");
        Drive_RightFront = hardwareMap.get(DcMotor.class, "Drive_RightFront");
        Drive_LeftRear = hardwareMap.get(DcMotor.class, "Drive_LeftRear");
        Drive_LeftFront = hardwareMap.get(DcMotor.class, "Drive_LeftFront");


        //Drive System Direction set

        Drive_LeftFront.setDirection(DcMotor.Direction.REVERSE);
        Drive_RightFront.setDirection(DcMotor.Direction.FORWARD);

        //RearDrives system Direction set

        Drive_LeftRear.setDirection(DcMotor.Direction.REVERSE);
        Drive_RightRear.setDirection(DcMotor.Direction.FORWARD);


        telemetry.addData("Status", "Initialized Daddy I wove u plz press my controls UwU");

        telemetry.addData("Right Rear Position", Drive_RightRear.getCurrentPosition());
        telemetry.addData("Right Rear Power", Drive_RightRear.getPower());
        telemetry.addData("Left Rear Position", Drive_LeftRear.getCurrentPosition());
        telemetry.addData("Left Rear Power", Drive_LeftRear.getPower());
        telemetry.addData("Right Front Position", Drive_RightFront.getCurrentPosition());
        telemetry.addData("Right Front Power", Drive_RightFront.getPower());
        telemetry.addData("Left Front Position", Drive_LeftFront.getCurrentPosition());
        telemetry.addData("Left Front Power", Drive_LeftFront.getPower());



    }



    @Override
    public void loop() {

        if (gamepad1.dpad_up){
            Drive_LeftFront.setPower(driveMotorPower);
            Drive_LeftRear.setPower(driveMotorPower);
            Drive_RightFront.setPower(driveMotorPower);
            Drive_RightRear.setPower(driveMotorPower);
        }
        else if (gamepad1.dpad_down) {
            Drive_LeftFront.setPower(-driveMotorPower);
            Drive_LeftRear.setPower(-driveMotorPower);
            Drive_RightFront.setPower(-driveMotorPower);
            Drive_RightRear.setPower(-driveMotorPower);
        } else {
            Drive_LeftFront.setPower(0);
            Drive_LeftRear.setPower(0);
            Drive_RightFront.setPower(0);
            Drive_RightRear.setPower(0);
        }
       /* else if (gamepad1.dpad_left){
            Drive_LeftFront.setPower(driveMotorPower);
            Drive_LeftRear.setPower(-driveMotorPower);
            Drive_RightFront.setPower(driveMotorPower);
            Drive_RightRear.setPower(-driveMotorPower);
        }
        else if (gamepad1.dpad_right){
            Drive_LeftFront.setPower(-driveMotorPower);
            Drive_LeftRear.setPower(driveMotorPower);
            Drive_RightFront.setPower(driveMotorPower);
            Drive_RightRear.setPower(-driveMotorPower);
        }



        */

      /*  Drive_LeftFront.setPower(gamepad1.left_stick_y);
        Drive_RightFront.setPower(gamepad1.left_stick_y);
        Drive_LeftRear.setPower(gamepad1.left_stick_y);
        Drive_RightRear.setPower(gamepad1.left_stick_y);

        Drive_LeftFront.setPower(gamepad1.left_stick_x);
        Drive_RightFront.setPower(-gamepad1.left_stick_x);
        Drive_LeftRear.setPower(gamepad1.left_stick_x);
        Drive_RightRear.setPower(-gamepad1.left_stick_x);


        Drive_LeftFront.setPower(-gamepad1.left_trigger);
        Drive_LeftRear.setPower(-gamepad1.left_trigger);
        Drive_RightFront.setPower(gamepad1.left_trigger);
        Drive_RightRear.setPower(gamepad1.left_trigger);


        Drive_LeftFront.setPower(gamepad1.left_trigger);
        Drive_LeftRear.setPower(gamepad1.left_trigger);
        Drive_RightFront.setPower(-gamepad1.right_trigger);
        Drive_RightRear.setPower(-gamepad1.right_trigger);


       /* if (gamepad1.left_bumper){
            Drive_LeftFront.setPower(-1);
            Drive_LeftRear.setPower(1);
            Drive_RightFront.setPower(1);
            Drive_RightRear.setPower(-1);
        }

        else if (gamepad1.right_bumper){

            if (speed < 1){
                speed += 0.01;
            }
            Drive_LeftFront.setPower(speed);
            Drive_LeftRear.setPower(-speed);
            Drive_RightFront.setPower(-speed);
            Drive_RightRear.setPower(speed);
        }

        else {
            speed = 0;
            Drive_LeftFront.setPower(0);
            Drive_LeftRear.setPower(0);
            Drive_RightFront.setPower(0);
            Drive_RightRear.setPower(0);
        }
        */

    }
    @Override
    public void stop() {
    }



}
