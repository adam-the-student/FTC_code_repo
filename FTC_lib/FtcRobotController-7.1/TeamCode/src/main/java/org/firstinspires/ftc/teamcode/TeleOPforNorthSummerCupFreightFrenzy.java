package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Freight Frenzy teleOP", group = "teleop")

public class TeleOPforNorthSummerCupFreightFrenzy extends LinearOpMode {
    private DcMotor motor1;
    private DcMotor motor4;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor turret_motor;
    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor4 = hardwareMap.dcMotor.get("motor4");
        turret_motor = hardwareMap.dcMotor.get("armMotor1");

        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.

            while (opModeIsActive()) {
                // Put loop blocks here.
                double y = gamepad1.left_stick_y;
                double x = -gamepad1.left_stick_x * 1.15; // Counteract imperfect strafing
                double rx = -gamepad1.right_stick_x;
                double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
                double motor1Power = (y + x +  rx) / denominator;  //motor1 is top left corner
                double motor2Power = (y - x - rx) / denominator;  //motor2 is top right corner
                double motor3Power = (y - x + rx) / denominator;  //motor3 is bottom left corner
                double motor4Power = (y + x -  rx) / denominator;  //motor4 is bottom right corner
                    motor1.setPower(motor1Power);  // motor1 is top left
                    motor2.setPower(-motor2Power);  // motor2 is top right
                    motor3.setPower(motor3Power);  // motor3 is bottom left
                    motor4.setPower(-motor4Power);  // motor4 is bottom right

                // gamepad 2 starts
                double Turret = gamepad2.right_stick_x;
//                double Arm = gamepad2.left_sticky;
                turret_motor.setpower(Turret);
//                Arm_motor.setpower(Arm);
                telemetry.addData("Turret and arm are moving");

                telemetry.update();
            }
        }

    }
}