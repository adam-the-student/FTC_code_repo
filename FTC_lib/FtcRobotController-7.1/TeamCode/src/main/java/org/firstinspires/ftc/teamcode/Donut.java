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
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor4 = hardwareMap.dcMotor.get("motor4");

        // Put initialization blocks here.
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {

                // first set power of all the motors to 0. (they don't move)
                motor1.setPower(0);
                motor3.setPower(0);
                motor4.setPower(0);

                // if the x(a) button is pressed then we do backward donuts.
                if(gamepad1.a){
                    //set power for three motors to do donuts
                    motor1.setPower(1.4);
                    motor2.setPower(1.5);
                    motor3.setPower(1.4);
                    motor4.setPower(1.5);
                }

                // if the o(b) button is pressed then we do regulaur donuts.
                if (gamepad1.b){
                    //set power for three motors to do donuts
                    motor1.setPower(-1.5);
                    motor2.setPower(-1.4);
                    motor3.setPower(-1.5);
                    motor4.setPower(-1.4);
                }


            }
        }
    }
}