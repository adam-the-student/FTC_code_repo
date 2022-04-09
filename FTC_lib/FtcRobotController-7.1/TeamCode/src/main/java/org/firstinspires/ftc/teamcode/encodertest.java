package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "encodertest", group = "Autonomous")
public class encodertest extends LinearOpMode {
    private DcMotorEx motor1;
    private DcMotorEx motor2;
    private DcMotorEx motor3;
    private DcMotorEx motor4;

    @Override
    public void runOpMode() throws InterruptedException {

        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");
        motor4 = hardwareMap.get(DcMotorEx.class, "motor4");
        waitForStart();
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor3.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor4.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor3.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor4.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor1.setPower(2);
        motor2.setPower(2);
        motor3.setPower(2);
        motor4.setPower(2);
        motor1.setTargetPosition(1400);
        motor2.setTargetPosition(1400);
        motor3.setTargetPosition(1400);
        motor4.setTargetPosition(1400);

    }
//hardware maping
}