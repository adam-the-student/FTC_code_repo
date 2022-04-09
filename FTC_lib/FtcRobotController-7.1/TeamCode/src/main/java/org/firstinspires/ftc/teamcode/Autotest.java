package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "Autotest", group = "Autonomous")
public class Autotest extends LinearOpMode {
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
        motor1.setVelocity(1);
        motor2.setVelocity(-1);
        motor3.setVelocity(1);
        motor4.setVelocity(-1);
        motor1.setTargetPosition(1440); //we control how far the motors turn.
        motor2.setTargetPosition(1440);
        motor3.setTargetPosition(1440);
        motor4.setTargetPosition(1440);
    }
//hardware maping
}