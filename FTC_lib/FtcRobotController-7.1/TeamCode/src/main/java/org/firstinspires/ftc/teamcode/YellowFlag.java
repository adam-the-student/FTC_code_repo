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

        waitForStart();
        while(opModeIsActive()){
            
            telemetry.addData("Red", color1.red());
            telemetry.addData("Green", color1.green());
            telemetry.addData("Blue", color1.blue());
            telemetry.update();
            if(color1.red()>=90 && color1.red()<=130 && color1.green() >= 100 && color1.green() <= 160 && color1.blue() >= 65 && color1.blue() <= 100){
            
            frontLeftWheel.setPower(-5.0);
            sleep(100);
            frontRightWheel.setPower(5.0);
            sleep(100);
            backLeftWheel.setPower(5.0);
            sleep(100);
            backRightWheel.setPower(-5.0);
            sleep(100);
            
              telemetry.update();
            }
        }
    }
}
