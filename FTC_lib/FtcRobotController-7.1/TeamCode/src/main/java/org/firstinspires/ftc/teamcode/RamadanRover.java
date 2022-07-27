package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qaulcomm.robotcore.hardware.CRServo;

@Autonomous(name = "Auto_Duck_Blue", group = "Autonomous")

public class  AutoDuckBlueNSCFreightFrenzy extends LinearOpMode {
    DcMotorEx frontLeftWheel;
    DcMotorEx frontRightWheel;
    DcMotorEx backLeftWheel;
    DcMotorEx backRightWheel;
    CRServo duckServo;


    @Override
    public void runOpMode() throws InterruptedException{
        frontLeftWheel = hardwareMap.get(DcMotorEx.class, "motor1");
        frontRightWheel = hardwareMap.get(DcMotorEx.class, "motor2");
        backLeftWheel = hardwareMap.get(DcMotorEx.class, "motor3");
        backRightWheel = hardwareMap.get(DcMotorEx.class, "motor4");
        hardwareMap.get(CRServo.class, "duckServo");
        frontLeftWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontRightWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backLeftWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backRightWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        waitForStart();

        if (/*camera code for duck on left*/){
            // 2 feet to the left
            moveLeftOrRight(3240, -0.25);
        }
        if (/*camera code for duck in the center*/){
            // 2 feet to the left
            moveLeftOrRight(3240, -0.25);

        }
        if (/*camera code for duck on right*/){
            // 2 feet to the left
            moveLeftOrRight(3240, -0.25);

        }
        moveLeftOrRight(6840,0.25);
        duckServo.setPower(0.75);
        sleep(1000);

    }

    public void moveLeftOrRight(int distance, int power) {
        frontLeftWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontRightWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backLeftWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backRightWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        frontLeftWheel.setTargetPosition(distance);
        frontRightWheel.setTargetPosition(distance);
        backLeftWheel.setTargetPosition(distance);
        backRightWheel.setTargetPosition(distance);

        frontLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        frontRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        frontLeftWheel.setPower(power);
        frontRightWheel.setPower(power);
        backLeftWheel.setPower(power);
        backRightWheel.setPower(power);

        while(motor1.isBusy() && motor2.isBusy() && motor3.isBusy() && motor4.isBusy()){}
    }
}