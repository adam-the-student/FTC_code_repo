package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Freight_Frenzy_teleOP", group = "teleop")

public class TeleOPforNorthSummerCupFreightFrenzy extends LinearOpMode {
    private DcMotor motor1;
    private DcMotor motor4;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor turret_motor;
    private DcMotor elbow_motor;
    private DcMotor duckMotor;
    private DcMotor KnuckleMotor;
    CRServo wristServo;
    /**
     * This function is executed when this Op Mode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor4 = hardwareMap.dcMotor.get("motor4");
        elbow_motor = hardwareMap.dcMotor.get("elbowMotor1");
        turret_motor = hardwareMap.dcMotor.get("armMotor1");
        duckMotor = hardwareMap.dcMotor.get("duckMotor1");
        KnuckleMotor = hardwareMap.dcMotor.get("knuckleMotor1");
        wristServo = hardwareMap.crservo.get("s1");

        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor3.setDirection(DcMotorSimple.Direction.REVERSE);
        motor4.setDirection(DcMotorSimple.Direction.REVERSE);

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
                double motor1Power = (y + x +  rx) / denominator;  //motor1 is top left corner
                double motor2Power = (y - x - rx) / denominator;  //motor2 is top right corner
                double motor3Power = (y - x + rx) / denominator;  //motor3 is bottom left corner
                double motor4Power = (y + x -  rx) / denominator;  //motor4 is bottom right corner
                motor1.setPower(motor1Power / 2);  // motor1 is top left
                motor2.setPower(-motor2Power / 2);  // motor2 is top right
                motor3.setPower(motor3Power / 2);  // motor3 is bottom left
                motor4.setPower(-motor4Power / 2);  // motor4 is bottom right

                // gamepad 2 starts
                double Turret = gamepad2.right_stick_x;
                double Arm = gamepad2.right_stick_y;
                turret_motor.setPower(Turret);
                elbow_motor.setPower(Arm*3/4);

                if(turret_motor.getPower() >= 0.1 || turret_motor.getPower() <= -0.1){telemetry.addData("Status of Turrent","Turent is moving");}
                else{telemetry.addData("Status of Turrent","");}
                if(elbow_motor.getPower() >= 0.1 || elbow_motor.getPower() <= -0.1){telemetry.addData("Status of Elbow","Elbow is moving");}
                else{telemetry.addData("Status of Elbow","");}
                telemetry.update();

                if(gamepad1.dpad_down){
                    duckMotor.setPower(0.315);
                } else if(gamepad1.dpad_up){
                    duckMotor.setPower(-0.315);
                } else {
                    duckMotor.setPower(0);
                }

                if(gamepad2.dpad_down){
                    wristServo.setPower(1);
                } else if(gamepad2.dpad_up){
                    wristServo.setPower(-1);
                } else {
                    wristServo.setPower(0);
                }
                if(gamepad2.right_bumper){
                    KnuckleMotor.setPower(0.5);
                } else if(gamepad2.left_bumper){
                    KnuckleMotor.setPower(-0.5);
                } else {
                    KnuckleMotor.setPower(0);
                }
                telemetry.update();
            }
        }
    }
}