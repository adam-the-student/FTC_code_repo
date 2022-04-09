package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Autonomous(name = "Autotest", group = "Autonomous")
public class Autotest extends OpMode {
//hardware maping
    private DcMotorEx motor1;
    private DcMotorEx motor2;
    private DcMotorEx motor3;
    private DcMotorEx motor4;

    @Override
    public void init() {


        motor1 = hardwareMap.get(DcMotorEx.class, "motor1");
        motor2 = hardwareMap.get(DcMotorEx.class, "motor2");
        motor3 = hardwareMap.get(DcMotorEx.class, "motor3");
        motor4 = hardwareMap.get(DcMotorEx.class, "motor4");
    }


    @Override
    public void start() {

        //we alternate motor direction to
        motor1.setTargetPosition(1400); //we control how far the motors turn.
        motor2.setTargetPosition(-1400);
        motor3.setTargetPosition(1400);
        motor4.setTargetPosition(-1400);


    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {

    }


}

