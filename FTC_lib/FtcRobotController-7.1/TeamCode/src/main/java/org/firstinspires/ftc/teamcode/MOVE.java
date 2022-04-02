package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "move (Blocks to Java)", group = "")
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

                if(gamepad1.dpad_down){
                    motor2.setPower(0);
                }
                // Put loop blocks here.
                motor1.setPower(-gamepad1.left_stick_y);
                motor4.setPower(gamepad1.left_stick_y);
                motor2.setPower(-gamepad1.right_stick_y);
                motor3.setPower(gamepad1.right_stick_y);
                telemetry.update();
            }
        }
    }
}