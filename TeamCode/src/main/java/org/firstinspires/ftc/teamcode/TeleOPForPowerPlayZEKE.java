package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Current_powerPlay_teleop for ZEKE", group = "teleop")


public class TeleOPForPowerPlayZEKE extends LinearOpMode {
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;
    private DcMotor ArmMotor1;
    private CRServo claw;
    private CRServo wrist;

    @Override
    public void runOpMode() {
        motor1 = hardwareMap.dcMotor.get("frontLeft");
        motor2 = hardwareMap.dcMotor.get("frontRight");
        motor3 = hardwareMap.dcMotor.get("backLeft");
        motor4 = hardwareMap.dcMotor.get("backRight");
        ArmMotor1 = hardwareMap.dcMotor.get("arm");
        claw = hardwareMap.crservo.get("claw");
        wrist = hardwareMap.crservo.get("wrist");

        ArmMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.

            while (opModeIsActive()) {
                // Put loop blocks here.

                double y = gamepad1.left_stick_y;
                double x = -gamepad1.left_stick_x; // Counteract imperfect strafing
                double rx = -gamepad1.right_stick_x;
/*Denominator is the largest motor power (absolute value) or 1
                 This ensures all the powers maintain the same ratio, but only when
                 at least one is out of the range [-1, 1]*/
//                double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
//                double motor1Power = (y + x + rx) / denominator;  //motor1 is top left corner
//                double motor2Power = (y - x - rx) / denominator;  //motor2 is top right corner
//                double motor3Power = (y - x + rx) / denominator;  //motor3 is bottom left corner
//                double motor4Power = (y + x - rx) / denominator;  //motor4 is bottom right corner
//
//                if(gamepad1.left_trigger >= 0.1){
//                    motor1Power = motor1Power/3;
//                    motor2Power = motor2Power/3;
//                    motor3Power = motor3Power/3;
//                    motor4Power = motor4Power/3;
//                }
//
//                motor1.setPower(-motor1Power * .75);  // motor1 is top left
//                motor2.setPower(motor2Power * .75);  // motor2 is top right
//                motor3.setPower(-motor3Power * .75);  // motor3 is bottom left
//                motor4.setPower(motor4Power * .75);  // motor4 is bottom right
                // didnt like this /\
                //                 ||
                double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
                double motor1Power = (y + x + rx) / denominator;  //motor1 is top left corner
                double motor2Power = (y - x - rx) / denominator;  //motor2 is top right corner
                double motor3Power = (y - x + rx) / denominator;  //motor3 is bottom left corner
                double motor4Power = (y + x - rx) / denominator;  //motor4 is bottom right corner

                if(gamepad1.left_trigger >= 0.1){
                    motor1Power = motor1Power/4;
                    motor2Power = motor2Power/4;
                    motor3Power = motor3Power/4;
                    motor4Power = motor4Power/4;
                }
                else if(gamepad1.right_trigger >= 0.1){
                    motor1Power = motor1Power*2;
                    motor2Power = motor2Power*2;
                    motor3Power = motor3Power*2;
                    motor4Power = motor4Power*2;
                }

                motor1.setPower(motor1Power/2);  // motor1 is top left
                motor2.setPower(-motor2Power/2);  // motor2 is top right
                motor3.setPower(motor3Power/2);  // motor3 is bottom left
                motor4.setPower(-motor4Power/2);  // motor4 is bottom right
                // gamepad 2 starts

                // arm starts
                double ArmMotorpower = gamepad2.left_stick_y ;
                ArmMotor1.setPower(ArmMotorpower);


                //claw starts
                double servoPos;

                if(gamepad2.right_bumper){
                    servoPos = 1;
                }else if(gamepad2.left_bumper){
                    servoPos = -1;
                } else {
                    servoPos = 0.0;
                }
                claw.setPower(-servoPos);

                double wristPos = -gamepad2.right_stick_y;
                wrist.setPower(wristPos);

                telemetry.update();

            }
        }
    }
}