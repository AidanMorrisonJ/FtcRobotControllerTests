
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Arm;
import org.firstinspires.ftc.teamcode.hardware.Grabber;
import org.firstinspires.ftc.teamcode.hardware.Slide;

@TeleOp(name = "Wallace TeleOp Test", group = "Wallace")
//@TeleOp(name = "TeleOp", group = "AWallace")
//@Disabled
public class WallaceTeleOp extends LinearOpMode {
    
    Grabber grabber = new Grabber(this);
    //    DriveTrain drive = new DriveTrain(this);
    Slide slide = new Slide(this);
    Arm arm = new Arm(this);
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
	//	drive.init();
        grabber.init();
	slide.init();
	arm.init();

	// Wait for the game to start (driver presses PLAY)
        telemetry.addData(">", "Press Start." );
        telemetry.update();

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData(">", "Press X to grab." );
            telemetry.addData(">", "Press y to release." );
            telemetry.addData(">", "Press a to turn left." );
            telemetry.addData(">", "Press b to turn right." );
            telemetry.addData(">", "Left stick y: move arm" );
            telemetry.addData(">", "Left stick x: move slide" );
	    
            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
	
	double power = gamepad1.left_stick_y;
	arm.move(power);
	double powerext = gamepad1.left_stick_x;
	slide.move(powerext);
	if (gamepad1.y)
	    {
		grabber.grab();
	    }
	if (gamepad1.x)
	    {
		grabber.release();
	    }
	if (gamepad1.a)
	    {
		grabber.rotate_left();
	    }
	if (gamepad1.b)
	    {
		grabber.rotate_right();
	    }
	}
    }

}


