package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Controller Teleop", group = "teleop")

public class MOVE extends LinearOpMode {
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
                // Put loop blocks here.

                double y = gamepad1.left_stick_y;
                double x = -gamepad1.left_stick_x * 1.15; // Counteract imperfect strafing
                double rx = -gamepad1.right_stick_x;

              /*Denominator is the largest motor power (absolute value) or 1
                 This ensures all the powers maintain the same ratio, but only when
                 at least one is out of the range [-1, 1]                   */
                double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
                double motor1Power = (y + x +  rx) / denominator;  //motor1 is top left corner
                double motor2Power = (y - x - rx) / denominator;  //motor2 is top right corner
                double motor3Power = (y - x + rx) / denominator;  //motor3 is bottom left corner
                double motor4Power = (y + x -  rx) / denominator;  //motor4 is bottom right corner

                if(gamepad1.circle){
                    motor1.setPower(motor1Power / 2);  // motor1 is top left
                    motor2.setPower(-motor2Power / 2);  // motor2 is top right
                    motor3.setPower(motor3Power / 2);  // motor3 is bottom left
                    motor4.setPower(-motor4Power / 2);  // motor4 is bottom right
                }
                else{
                    motor1.setPower(motor1Power);  // motor1 is top left
                    motor2.setPower(-motor2Power);  // motor2 is top right
                    motor3.setPower(motor3Power);  // motor3 is bottom left
                    motor4.setPower(-motor4Power);  // motor4 is bottom right
                }
                telemetry.update();
            }
        }

    }
}