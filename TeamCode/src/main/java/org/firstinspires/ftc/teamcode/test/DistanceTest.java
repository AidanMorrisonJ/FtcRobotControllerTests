package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Distance;

/*
 * This OpMode illustrates how to use the REV Robotics 2M Distance Sensor.
 *
 * The OpMode assumes that the sensor is configured with a name of "sensor_distance".
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 *
 * See the sensor's product page: https://www.revrobotics.com/rev-31-1505/
 */
@TeleOp(name = "Test: REV2mDistance", group = "Test")
//@Disabled
public class DistanceTest extends LinearOpMode {

    Distance distance = new Distance(this);
 
    @Override
    public void runOpMode() {
	distance.init();
        telemetry.addData(">>", "Press start to test distance sensor");
        telemetry.update();

        waitForStart();
        while(opModeIsActive()) {
            // generic DistanceSensor methods.
            telemetry.addData("range", String.format("%.01f mm", distance.getDistanceMM()));
            telemetry.update();
        }
    }

}
