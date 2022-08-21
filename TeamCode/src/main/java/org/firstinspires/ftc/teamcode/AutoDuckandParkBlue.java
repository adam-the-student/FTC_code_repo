package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "Auto_Duck_Blue", group = "Autonomous")

public class  AutoDuckandParkBlue extends LinearOpMode {
    DcMotorEx frontLeftWheel;
    DcMotorEx frontRightWheel;
    DcMotorEx backLeftWheel;
    DcMotorEx backRightWheel;
    //CRServo duckServo;

    //test
    @Override
    public void runOpMode() throws InterruptedException{
        frontLeftWheel = hardwareMap.get(DcMotorEx.class, "motor1");
        frontRightWheel = hardwareMap.get(DcMotorEx.class, "motor2");
        backLeftWheel = hardwareMap.get(DcMotorEx.class, "motor3");
        backRightWheel = hardwareMap.get(DcMotorEx.class, "motor4");
        //hardwareMap.get(CRServo.class, "duckServo");
        frontLeftWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontRightWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backLeftWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backRightWheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        waitForStart();

        moveLeftOrRight(-6000,0.25);
        moveForwardOrBack(2880,0.25);
        moveLeftOrRight(1580,0.25);
        moveForwardOrBack(2100,0.25);
        //duckServo.setPower(0.75);
        sleep(1000);
        moveForwardOrBack(2800,0.25);

    }

    public void moveLeftOrRight(int distance, double power) {

        frontLeftWheel.setTargetPosition(distance);
        frontRightWheel.setTargetPosition(distance);
        backLeftWheel.setTargetPosition(-distance);
        backRightWheel.setTargetPosition(-distance);

        frontLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        frontRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        frontLeftWheel.setPower(power);
        frontRightWheel.setPower(power);
        backLeftWheel.setPower(power);
        backRightWheel.setPower(power);

        while(frontLeftWheel.isBusy() && frontRightWheel.isBusy() && backLeftWheel.isBusy() && backRightWheel.isBusy()){} stopMotor();
    }
    public void moveForwardOrBack(int distance, double power) {

        frontLeftWheel.setTargetPosition(-distance);
        frontRightWheel.setTargetPosition(distance);
        backLeftWheel.setTargetPosition(-distance);
        backRightWheel.setTargetPosition(distance);

        frontLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        frontRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        frontLeftWheel.setPower(power);
        frontRightWheel.setPower(power);
        backLeftWheel.setPower(power);
        backRightWheel.setPower(power);

        while(frontLeftWheel.isBusy() && frontRightWheel.isBusy() && backLeftWheel.isBusy() && backRightWheel.isBusy()){} stopMotor();
    }
    public void stopMotor(){
        frontLeftWheel.setPower(0);
        frontRightWheel.setPower(0);
        backLeftWheel.setPower(0);
        backRightWheel.setPower(0);
    }
}
