package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.Collection;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name="Auto", group="Auto")
// Hi Patrick can you hear me?

public class Auto extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor Drive_RightFront;
    private DcMotor Drive_RightRear;
    private DcMotor Drive_LeftRear;
    private DcMotor Drive_LeftFront;


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


        telemetry.addData("Status", "Initialized Daddy I wove u plz press my controls UwU ");

    }

    @Override
    public void loop() {
        Drive_LeftFront.setPower(1);
        //Thread.sleep(5);

    }




    @Override
    public void stop() {
    }



}

