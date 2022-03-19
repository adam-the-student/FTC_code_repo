package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name = "Skeloton Op Mode", group = "TeleOp")
public class skeletonOp extends OpMode{

    @Override
    public void init() {

    }
    @Override
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
    public static void motorSpeed(int speed1 , int speed2 , int speed3 , int speed4){

        int motor1;
        int motor2;
        int motor3;
        int motor4;

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

}