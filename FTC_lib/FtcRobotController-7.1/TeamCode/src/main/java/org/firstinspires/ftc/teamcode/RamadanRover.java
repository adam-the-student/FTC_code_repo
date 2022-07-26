package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "Auto_Duck_Blue", group = "Autonomous")

public class  AutoDuckBlueNSCFreightFrenzy extends LinearOpMode {
    DcMotorEx motor1;
    DcMotorEx motor2;
    DcMotorEx motor3;
    DcMotorEx motor4;

    @Override
    public void runOpMode() throws InterruptedException{
        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");
        motor4 = hardwareMap.get(DcMotorEx.class, "motor4");
        motor1.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor4.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        waitForStart();

        if (/*camera code for duck on left*/){
            // 2 rotaitions to the left
            moveLeftOrRight(3240, -0.25);
        }
        if (/*camera code for duck in the center*/){
            // 2 rotaitions to the left
            moveLeftOrRight(3240, -0.25);

        }
        if (/*camera code for duck on right*/){
            // 2 rotaitions to the left
            moveLeftOrRight(3240, -0.25);

        }
    }

    public void moveLeftOrRight(int distance, int power) {
        motor1.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
        motor4.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);

        motor1.setTargetPosition(distance);
        motor2.setTargetPosition(distance);
        motor3.setTargetPosition(distance);
        motor4.setTargetPosition(distance);

        motor1.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor2.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor3.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        motor4.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        motor1.setPower(power);
        motor2.setPower(power);
        motor3.setPower(power);
        motor4.setPower(power);

        while(motor1.isBusy() && motor2.isBusy() && motor3.isBusy() && motor4.isBusy()){}
    }
}