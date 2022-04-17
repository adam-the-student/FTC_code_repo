package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
@Autonomous(name = "encodertest", group = "Autonomous")



public class encodertest extends LinearOpMode {

    DcMotorEx motor1 = null;
    DcMotorEx motor2 = null;
    DcMotorEx motor3 = null;
    DcMotorEx motor4 = null;

    @Override
    public void runOpMode() throws InterruptedException {

        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");
        motor4 = hardwareMap.get(DcMotorEx.class, "motor4");
        motor1.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor4.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();
        int power = 1440;

        drive(-power, power, -power, power,0.1);
        stopDriving();
        sleep(1000);
        drive(-power, -power, power, power,0.1);
        sleep(1000);
        stopDriving();
        drive(power, -power, power, -power,0.1);
        stopDriving();
        sleep(1000);
        drive(power, power, -power, -power,0.1);
        stopDriving();
    }

    public void drive(int power1, int power2, int power3, int power4, double actualPower){
        motor1.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor4.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        motor1.setTargetPosition(power1);
        motor2.setTargetPosition(power2);
        motor3.setTargetPosition(power3);
        motor4.setTargetPosition(power4);

        motor1.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor4.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        motor1.setPower(actualPower);
        motor2.setPower(actualPower);
        motor3.setPower(actualPower);
        motor4.setPower(actualPower);

        while(motor1.isBusy() && motor2.isBusy() && motor3.isBusy() && motor4.isBusy()){

        }
        stopDriving();
        motor1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void stopDriving(){
        motor1.setPower(0);
        motor2.setPower(0);
        motor3.setPower(0);
        motor4.setPower(0);

    }

}