package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name = "Auto_Duck_Blue", group = "Autonomous")

public class  AutoDuckandParkBlue extends LinearOpMode {
    DcMotorEx frontLeftWheel;
    DcMotorEx frontRightWheel;
    DcMotorEx backLeftWheel;
    DcMotorEx backRightWheel;
    ColorSensor color1;
    DcMotor duckMotor;

    @Override
    public void runOpMode() throws InterruptedException{
        frontLeftWheel = hardwareMap.get(DcMotorEx.class, "motor1");
        frontRightWheel = hardwareMap.get(DcMotorEx.class, "motor2");
        backLeftWheel = hardwareMap.get(DcMotorEx.class, "motor3");
        backRightWheel = hardwareMap.get(DcMotorEx.class, "motor4");
        duckMotor = hardwareMap.get(DcMotor.class, "duckMotor1");

        telemetry.addData("Encoder Status","encoder reseting");
        telemetry.update();

        resetEncoders();
        telemetry.update();

        waitForStart();

        moveForwardOrBack(-180,0.25);
        moveLeftOrRight(-1200,0.25);
        sleep(1000);
        duckMotor.setPower(-0.3);
        sleep(3000);
        duckMotor.setPower(0);
        sleep(1000);
        moveForwardOrBack(-720,0.25);
        sleep(1000);
        moveLeftOrRight(-720,0.25);
        frontLeftWheel.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        frontRightWheel.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        backLeftWheel.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        backRightWheel.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void moveLeftOrRight(int distance, double power) {

        frontLeftWheel.setTargetPosition(distance/2);
        frontRightWheel.setTargetPosition(distance);
        backLeftWheel.setTargetPosition(-distance);
        backRightWheel.setTargetPosition(-distance);

        frontLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        frontRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        frontLeftWheel.setPower(power*0.5);
        frontRightWheel.setPower(power);
        backLeftWheel.setPower(power);
        backRightWheel.setPower(power);

        while(frontLeftWheel.isBusy() && frontRightWheel.isBusy() && backLeftWheel.isBusy() && backRightWheel.isBusy()){}
        frontLeftWheel.setPower(0);
        frontRightWheel.setPower(0);
        backLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        resetEncoders();
        telemetry.update();
    }
    public void moveForwardOrBack(int distance, double power) {

        frontLeftWheel.setTargetPosition(-distance/2);
        frontRightWheel.setTargetPosition(distance);
        backLeftWheel.setTargetPosition(-distance);
        backRightWheel.setTargetPosition(distance);

        frontLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        frontRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        frontLeftWheel.setPower(power*0.5);
        frontRightWheel.setPower(power);
        backLeftWheel.setPower(power);
        backRightWheel.setPower(power);

        while(frontLeftWheel.isBusy() && frontRightWheel.isBusy() && backLeftWheel.isBusy() && backRightWheel.isBusy()){}
        frontLeftWheel.setPower(0);
        frontRightWheel.setPower(0);
        backLeftWheel.setPower(0);
        backRightWheel.setPower(0);
        resetEncoders();
        telemetry.update();
    }
    public void resetEncoders(){
        frontLeftWheel.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backLeftWheel.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backRightWheel.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

}
