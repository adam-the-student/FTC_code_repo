package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "MOI_Meet1_Auto_inferior", group = "Autonomous")
public class MOI_Meet1_Auto extends LinearOpMode {

    private DcMotorEx frontLeft;
    private DcMotorEx frontRight;
    private DcMotorEx backLeft;
    private DcMotorEx backRight;
    private DcMotorEx arm;
    private ColorSensor color1;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */

    @Override
    public void runOpMode() throws InterruptedException {

        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");
        arm = hardwareMap.get(DcMotorEx.class, "arm");
        color1 = hardwareMap.get(ColorSensor.class, "color1");

        int placeLocation;
        waitForStart();

        strafe(1750,-0.3);
//        //- for left, + for right
//        strafe(time, power);
//        //- for backward, + for forward
//        forward_backward(time, power);
//        //- for counter clockwise, + for clockwise
//        clockwise(0, 0);
        sleep(2000);

        telemetry.addData("red value", color1.red());
        telemetry.addData("green value", color1.green());
        telemetry.addData("blue value", color1.blue());
        telemetry.update();

        sleep(4500);

     if (color1.green() <= 1000 && color1.green() >= 400 && color1.blue() <= 700 && color1.blue() >= 400) {
       placeLocation = 2;
       telemetry.addData("Location", "3");
     } else if (color1.green() <= 4500 && color1.green() >= 1500 && color1.blue() <= 3000 && color1.blue() >= 1000) {
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
     forward_backward(500, -0.5);
     } else if(placeLocation == 1){

     } else {
       forward_backward(500, 0.5);
     }

   }

    public void strafe(int time, double power) {
        frontLeft.setPower(-power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(power);
        sleep(time);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void forward_backward(int time, double power) {
        frontLeft.setPower(-power);
        frontRight.setPower(power);
        backLeft.setPower(-power);
        backRight.setPower(power);
        sleep(time);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void clockwise(int time, double power) {
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
        sleep(time);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }




    // Put initialization blocks here.
//
//        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
//
//        resetEncoders();
//
//        frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        backLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        backRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//
//        resetEncoders();
//
//        // frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        // frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        // backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        // backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        // arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//
//        int placeLocation = 0;
//
//        waitForStart();
//
//        moveLeftOrRight(1220,0.5);
//
//        sleep(1000);
//        if (color1.green() <= 180 && color1.green() >= 120 && color1.blue() <= 180 && color1.blue() >= 120) {
//            placeLocation = 2;
//            telemetry.addData("Location", "3");
//        } else if (color1.green() <= 650 && color1.green() >= 450 && color1.blue() <= 580 && color1.blue() >= 280) {
//            placeLocation = 1;
//            telemetry.addData("Location", "2");
//        } else {
//            placeLocation = 0;
//            telemetry.addData("Location", "1");
//        }
//        telemetry.update();
//
//        parkingFromSignal(placeLocation);
//
//    }
//
//    public void parkingFromSignal(int placeLocation){
//
//        if(placeLocation == 0){
//            moveForwardOrBack(1220, 0.5);
//        } else if(placeLocation == 1){
//
//        } else {
//            moveForwardOrBack(-1220, -0.5);
//        }
//
//    }
//
//    public void moveLeftOrRight(int TargetPosition, double power){
//
//        frontLeft.setTargetPosition(TargetPosition);
//        frontRight.setTargetPosition(-TargetPosition);
//        backLeft.setTargetPosition(-TargetPosition);
//        backRight.setTargetPosition(TargetPosition);
//
//        frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        backLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        backRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//
//        frontRight.setPower(power);
//        backLeft.setPower(-power);
//        frontLeft.setPower(-power);
//        backRight.setPower(power);
//
//        while (frontLeft.isBusy()) {
//            telemetry.addData("EncoderStuff",frontLeft.getCurrentPosition());
//            telemetry.update();
//        }
//        frontLeft.setPower(0);
//        frontRight.setPower(0);
//        backLeft.setPower(0);
//        backRight.setPower(0);
//
//        resetEncoders();
//    }
//
//    public void moveForwardOrBack(int TargetPosition, double power){
//
//        frontLeft.setTargetPosition(TargetPosition);
//        frontRight.setTargetPosition(TargetPosition);
//        backLeft.setTargetPosition(TargetPosition);
//        backRight.setTargetPosition(TargetPosition);
//
//        frontLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        frontRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        backLeft.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//        backRight.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
//
//        frontRight.setPower(power);
//        backLeft.setPower(power);
//        frontLeft.setPower(power);
//        backRight.setPower(power);
//
//        while (frontLeft.isBusy() || frontRight.isBusy() || backLeft.isBusy() || backRight.isBusy()) {
//            telemetry.addData("EncoderStuff",frontLeft.getCurrentPosition());
//            telemetry.update();
//        }
//        frontLeft.setPower(0);
//        frontRight.setPower(0);
//        backLeft.setPower(0);
//        backRight.setPower(0);
//
//        resetEncoders();
//    }
//
//    public void resetEncoders(){
//        frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//        frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//        backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//        backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//        arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//    }


}
