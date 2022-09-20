package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.drive.DriveSignal;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.trajectorysequence.sequencesegment.SequenceSegment;


@Config
@Autonomous(name = "pidTest", group = "Autonomous")

public class PidForMotor extends LinearOpMode {

    DcMotorEx motor;

    ElapsedTime timer = new ElapsedTime();

    private double lastError = 0;
    private double integralSum = 0;

    public static double Kp = 0.0;
    public static double Ki = 0.0;
    public static double Kd = 0.0;

    public static double targetposition = 5000;

    private final FtcDashboard dashboard = FtcDashboard.getInstance();

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        TelemetryPacket packet = new TelemetryPacket();

        dashboard.setTelemetryTransmissionInterval(25);
        motor = hardwareMap.get(DcMotorEx.class, "leftFront");

        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();

        int targetPosition = 5000;

        while (opModeIsActive()) {
            double power = returnPower(targetPosition, motor.getCurrentPosition());
            packet.put("power", power);
            packet.put("position", motor.getCurrentPosition());
            packet.put("error", lastError);

            motor.setPower(power);

            dashboard.sendTelemetryPacket(packet);

            //drive.goToPositionIntakeSlides(timer, Kp, Ki, Kd, targetPosition);

        }
    }

    public double returnPower(double reference, double state) {
        double error = reference - state;
        integralSum += error * timer.seconds();
        double derivative = (error - lastError) / timer.seconds();
        lastError = error;

        timer.reset();

        double output = (error * Kp) + (derivative * Kd) + (integralSum * Ki);
        return output;
    }

}