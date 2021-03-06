package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "squareTest", group = "Autonomous")
public class squareTest extends OpMode {
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
    public void motorSpeed(int speed1 , int speed2 , int speed3 , int speed4){
        motor1.setVelocity(speed1); //we first sey the speed of all the motors to what ever speed we want
        motor2.setVelocity(speed2);
        motor3.setVelocity(speed3);
        motor4.setVelocity(speed4);
        motor1.setTargetPosition(100); //we control how far the motors turn.
        motor2.setTargetPosition(100);
        motor3.setTargetPosition(100);
        motor4.setTargetPosition(100);
    }
    @Override
    public void start() {
        //we alternate motor direction to
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


}

