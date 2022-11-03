package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "PowerPlay_teleOP", group = "teleop")


public class TeleOpForPowerPlay extends LinearOpMode {
    private DcMotor motor1;
    private DcMotor motor4;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor ArmMotor1;
    private DcMotor ArmMotor2;
    private CRServo claw1;
    private CRServo claw2;
    private CRServo wrist;

    @Override
    public void runOpMode() {
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor4 = hardwareMap.dcMotor.get("motor4");
        ArmMotor1 = hardwareMap.dcMotor.get("m1");
        //ArmMotor2 = hardwareMap.dcMotor.get("m2");
        claw1 = hardwareMap.crservo.get("claw1");
        claw2 = hardwareMap.crservo.get("claw2");
        wrist = hardwareMap.crservo.get("wrist");


        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.

            while (opModeIsActive()) {
                // Put loop blocks here.

                double y = gamepad1.left_stick_y;
                double x = -gamepad1.left_stick_x * 1.15; // Counteract imperfect strafing
                double rx = gamepad1.right_stick_x;

              /*Denominator is the largest motor power (absolute value) or 1
                 This ensures all the powers maintain the same ratio, but only when
                 at least one is out of the range [-1, 1]                   */
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
                double ArmMotorpower = -gamepad2.right_stick_y / 2;
                ArmMotor1.setPower(ArmMotorpower);
                if(ArmMotorpower == 0){
                    ArmMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                }


                //claw starts
                double servoPos;

                if(gamepad2.right_trigger>0){
                    servoPos = gamepad2.right_trigger;
                }else if(gamepad2.left_trigger>0){
                    servoPos = -gamepad2.left_trigger;
                } else {
                    servoPos = 0.0;
                }
                claw1.setPower(servoPos);
                claw2.setPower(-servoPos);

                double wristPos = gamepad2.left_stick_y;
                wrist.setPower(wristPos);

                telemetry.update();

            }
        }
    }
}
