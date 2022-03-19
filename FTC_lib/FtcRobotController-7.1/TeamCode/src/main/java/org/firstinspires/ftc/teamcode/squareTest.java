package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Skeloton Op Mode", group = "TeleOp")
public class squareTest extends OpMode{

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

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



    }

}

}