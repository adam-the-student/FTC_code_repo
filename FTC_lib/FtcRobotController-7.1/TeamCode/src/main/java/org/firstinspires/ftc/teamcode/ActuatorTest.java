package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "extend ")
public class extend1 extends LinearOpMode {

    private Servo linearServo0;

    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        linearServo0 = hardwareMap.get(Servo.class, "linearServo0");

        // Set servo to mid position
        waitForStart();
        while (opModeIsActive()) {
            if (linearServo0.getPosition !=  0 && linearServo0 != 1) {
                linearServo0.setPosition(gamepad1.left_stick_x);
            }
        }
    }
}