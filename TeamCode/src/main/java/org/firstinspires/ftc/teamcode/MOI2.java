package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Current_powerPlay_auton for ZEKE", group = "teleop")


public class MOI2 extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    private DcMotor backLeft;
    private DcMotor arm;
    private CRServo claw;
    private CRServo wrist;
    private ColorSensor colorSensor1;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        frontRight = hardwareMap.dcMotor.get("frontRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        arm = hardwareMap.dcMotor.get("arm");
        colorSensor1 = hardwareMap.colorSensor.get("colorSensor1");

        waitForStart();

        frontLeft.setDirection(DcMotorEx.Direction.REVERSE);
        backLeft.setDirection(DcMotorEx.Direction.REVERSE);

        resetEncoders();

        frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        resetEncoders();

         frontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
         frontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
         backLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
         backRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
         arm.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        int placeLocation = 0;

        waitForStart();

        moveLeftOrRight(-1220,0.5);

        sleep(1000);
        if (colorSensor1.green() <= 180 && colorSensor1.green() >= 120 && colorSensor1.blue() <= 180 && colorSensor1.blue() >= 120) {
            placeLocation = 2;
            telemetry.addData("Location", "3");
        } else if (colorSensor1.green() <= 650 && colorSensor1.green() >= 450 && colorSensor1.blue() <= 580 && colorSensor1.blue() >= 280) {
            placeLocation = 1;
            telemetry.addData("Location", "2");
        } else {
            placeLocation = 0;
            telemetry.addData("Location", "1");
        }
        telemetry.update();

        parkingFromSignal(placeLocation);

    }

    public void parkingFromSignal(int placeLocation){

        if(placeLocation == 0){
            moveForwardOrBack(1220, 0.5);
        } else if(placeLocation == 1){

        } else {
            moveForwardOrBack(-1220, -0.5);
        }

    }

    public void moveLeftOrRight(int TargetPosition, double power){

        frontLeft.setTargetPosition(TargetPosition);
        frontRight.setTargetPosition(-TargetPosition);
        backLeft.setTargetPosition(-TargetPosition);
        backRight.setTargetPosition(TargetPosition);

        frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        frontRight.setPower(power);
        backLeft.setPower(-power);
        frontLeft.setPower(-power);
        backRight.setPower(power);

        while (frontLeft.isBusy()) {
            telemetry.addData("EncoderStuff",frontLeft.getCurrentPosition());
            telemetry.update();
        }
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        resetEncoders();
    }

    public void moveForwardOrBack(int TargetPosition, double power){

        frontLeft.setTargetPosition(TargetPosition);
        frontRight.setTargetPosition(TargetPosition);
        backLeft.setTargetPosition(TargetPosition);
        backRight.setTargetPosition(TargetPosition);

        frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        frontRight.setPower(power);
        backLeft.setPower(power);
        frontLeft.setPower(power);
        backRight.setPower(power);

        while (frontLeft.isBusy() || frontRight.isBusy() || backLeft.isBusy() || backRight.isBusy()) {
            telemetry.addData("EncoderStuff",frontLeft.getCurrentPosition());
            telemetry.update();
        }
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);

        resetEncoders();
    }

    public void resetEncoders(){
        frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }












}
