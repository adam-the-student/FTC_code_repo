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
        motor1.setPower(-.5);
        motor2.setPower(.5);
        motor3.setPower(-.5);
        motor4.setPower(.5);
        sleep(1000);

    }
//hardware maping
}