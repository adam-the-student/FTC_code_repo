package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name = "YellowFlag", group = "Autonomous")

public class YellowFlag extends LinearOpMode {

    DcMotorEx frontLeftWheel;
    DcMotorEx frontRightWheel;
    DcMotorEx backLeftWheel;
    DcMotorEx backRightWheel;
    ColorSensor color1;
   
    @Override
    public void runOpMode() throws InterruptedException{
        frontLeftWheel = hardwareMap.get(DcMotorEx.class, "motor1");
        frontRightWheel = hardwareMap.get(DcMotorEx.class, "motor2");
        backLeftWheel = hardwareMap.get(DcMotorEx.class, "motor3");
        backRightWheel = hardwareMap.get(DcMotorEx.class, "motor4");
        color1 = hardwareMap.get(ColorSensor.class, "color1");
        resetEncoders();

        waitForStart();
        while(opModeIsActive()){
            
            telemetry.addData("Red", color1.red());
            telemetry.addData("Green", color1.green());
            telemetry.addData("Blue", color1.blue());
            telemetry.update();
            if(color1.red()>=90 && color1.red()<=130 && color1.green() >= 100 && color1.green() <= 160 && color1.blue() >= 65 && color1.blue() <= 100) {
                frontLeftWheel.setTargetPosition(-1440);
                frontRightWheel.setTargetPosition(1440);
                backLeftWheel.setTargetPosition(-1440);
                backRightWheel.setTargetPosition(1440);

                frontLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                frontRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                backLeftWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
                backRightWheel.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

                frontLeftWheel.setPower(0.5);
                frontRightWheel.setPower(0.5);
                backLeftWheel.setPower(0.5);
                backRightWheel.setPower(0.5);

                while(frontLeftWheel.isBusy() && frontRightWheel.isBusy() && backLeftWheel.isBusy() && backRightWheel.isBusy()){}
                frontLeftWheel.setPower(0);
                frontRightWheel.setPower(0);
                backLeftWheel.setPower(0);
                backRightWheel.setPower(0);
                resetEncoders();
            }

              telemetry.update();
        }
    }
    public void resetEncoders(){
        frontLeftWheel.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontRightWheel.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backLeftWheel.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backRightWheel.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
}
