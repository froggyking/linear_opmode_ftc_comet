package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "AutonomousAdithyaComet")
public class AutonomousAdithyaComet extends LinearOpMode {

    private DcMotor front_left;
    private DcMotor front_right;
    private DcMotor back_left;
    private DcMotor back_right;
    private DcMotor slide;
    private Servo claw;

    @Override
    public void runOpMode(){

        front_right = hardwareMap.dcMotor.get("front_right");
        back_right = hardwareMap.dcMotor.get("back_right");
        front_left = hardwareMap.dcMotor.get("front_left");
        back_left = hardwareMap.dcMotor.get("back_left");
        slide = hardwareMap.dcMotor.get("slide");
        claw = hardwareMap.servo.get("claw");

        front_right.setDirection(DcMotorSimple.Direction.REVERSE);
        back_right.setDirection(DcMotorSimple.Direction.REVERSE);




        waitForStart();

        while (opModeIsActive()){
            closeClaw(0.5);
            sleep(1000);
            TotalStop();
            driveForward(0.5);
            sleep(1700);
//            driveForward(0.5);
//            sleep(500);
//            driveForward(0.5);
//            sleep(500);
            TotalStop();
            moveRight(0.5);
            sleep(550);
            TotalStop();
            driveForward(0.5);
            sleep(75);
            TotalStop();
            liftSlide(0.45);
            sleep(9050);
            TotalStop();
            driveForward(0.2);
            sleep(125);
            TotalStop();
            openClaw(-0.5);
            sleep(900);
            TotalStopServo();
            driveBackward(0.5);
            sleep(175);
            TotalStop();
            downSlide(0.45);
            sleep(6250);
            TotalStop();
            moveLeft(0.5);
            sleep(600);
            TotalStop();
            driveBackward(0.5);
            sleep(1100);
            TotalStop();

            stop();





        }
        idle();
    }
    public void driveBackward (double power){
        front_right.setPower(power);
        front_left.setPower(power);
        back_right.setPower(-power);
        back_left.setPower(-power);
    }
    public void driveForward (double power){
        front_right.setPower(-power);
        front_left.setPower(-power);
        back_left.setPower(power);
        back_right.setPower(power);
    }
    public void moveRight (double power){
        front_right.setPower(power);
        front_left.setPower(-power);
        back_left.setPower(-power);
        back_right.setPower(power);

    }
    public void moveLeft (double power){
        front_right.setPower(-power);
        front_left.setPower(power);
        back_right.setPower(-power);
        back_left.setPower(power);
    }
    public void liftSlide (double power){
        slide.setPower(power);
    }
    public void downSlide (double power){
        slide.setPower(-power);

    }
    public void openClaw(double position){
        claw.setPosition(position);
    }
    public void closeClaw(double position){
        claw.setPosition(position);
    }
    public void TotalStop(){
        front_right.setPower(0);
        front_left.setPower(0);
        back_right.setPower(0);
        back_left.setPower(0);

    }
    public void TotalStopServo(){
        claw.setPosition(0);
    }
}
