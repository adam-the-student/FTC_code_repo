package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "squareTest", group = "Autonomous")
public class squareTest extends OpMode {
//hardware maping
    private DcMotor motor1;
    private DcMotor motor2;
    private DcMotor motor3;
    private DcMotor motor4;

    @Override
    public void init() {


        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");
        motor4 = hardwareMap.get(DcMotor.class, "motor4");
    }    @Override
    public void start() {
        motorSpeed(5, 5, 5, 5); // this is up
        motorSpeed(5, -5, -5, 5); // this is right
        motorSpeed(-5, -5, -5, -5); // this is down
        motorSpeed(-5, 5, 5, -5); // this is left
    }


    @Override
    public void loop() {

    }

    @Override
    public void stop() {

    }
    public void motorSpeed(int speed1 , int speed2 , int speed3 , int speed4){

        motor1.setVelocity(speed1);
        motor2.setVelocity(speed2);
        motor3.setVelocity(speed3);
        motor4.setVelocity(speed4);

        motor1.setTargetPosition(10);
        motor2.setTargetPosition(10);
        motor3.setTargetPosition(10);
        motor4.setTargetPosition(10);
    }

}

