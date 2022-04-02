package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Donut", group = "teleop")
public class Donut extends LinearOpMode {

    private DcMotor motor1;
    private DcMotor motor4;
    private DcMotor motor2;
    private DcMotor motor3;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor4 = hardwareMap.dcMotor.get("motor4");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                motor1.setPower(0);
                motor3.setPower(0);
                motor4.setPower(0);
                if(gamepad1.a){
                    motor1.setPower(2);
                    motor3.setPower(2);
                    motor4.setPower(2);
                }
                if (gamepad1.b){
                    motor1.setPower(-2);
                    motor3.setPower(-2);
                    motor4.setPower(-2);
                }

            }
        }
    }
}