package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "encodertest", group = "Autonomous")

public class encodertest extends LinearOpMode {

    DcMotor motor1 = null;
    DcMotor motor2 = null;
    DcMotor motor3 = null;
    DcMotor motor4 = null;

    @Override
    public void runOpMode() throws InterruptedException {

        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor4 = hardwareMap.dcMotor.get("motor4");

        waitForStart();

        motor1.setmode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motor2.setmode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motor3.setmode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motor4.setmode(DcMotorController.RunMode.RUN_USING_ENCODERS);

        drive(-0.5,0.5,-0.5,0.5,1440);
        drive(-0.5,-0.5,-0.5,-0.5,1440);
        drive(0.5,-0.5,0.5,-0.5,1440);
        drive(0.5,0.5,0.5,0.5,1440);

    }
    public  void drive(int power1, int power2, int power3, int power4, int distance){
        motor1.setmode(DcMotorController.RunMode.RESET_ENCODERS);
        motor2.setmode(DcMotorController.RunMode.RESET_ENCODERS);
        motor3.setmode(DcMotorController.RunMode.RESET_ENCODERS);
        motor4.setmode(DcMotorController.RunMode.RESET_ENCODERS);

        motor1.setTargetPosition(distance);
        motor2.setTargetPosition(distance);
        motor3.setTargetPosition(distance);
        motor4.setTargetPosition(distance);

        motor1.setmode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor2.setmode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor3.setmode(DcMotorController.RunMode.RUN_TO_POSITION);
        motor4.setmode(DcMotorController.RunMode.RUN_TO_POSITION);

        motor1.setPower(power1);
        motor2.setPower(power2);
        motor3.setPower(power3);
        motor4.setPower(power4);

        while(motor1.isBusy() && motor2.isBusy() && motor3.isBusy() && motor4.isBusy()){

        }
        stopDriving();
        motor1.setmode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motor2.setmode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motor3.setmode(DcMotorController.RunMode.RUN_USING_ENCODERS);
        motor4.setmode(DcMotorController.RunMode.RUN_USING_ENCODERS);
    }
    public  void stopDriving(){
        motor1.setPower(0);
        motor2.setPower(0);
        motor3.setPower(0);
        motor4.setPower(0);
    }

}