package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "AutonomousAdithyaComet")
public class AutonomousAdithyaComet extends LinearOpMode {

    private DcMotor front_left;
    private DcMotor front_right;
    private DcMotor back_left;
    private DcMotor back_right;

    @Override
    public void runOpMode(){

        front_right = hardwareMap.dcMotor.get("front_right");
        back_right = hardwareMap.dcMotor.get("back_right");
        front_left = hardwareMap.dcMotor.get("front_left");
        back_left = hardwareMap.dcMotor.get("back_left");


        front_right.setDirection(DcMotorSimple.Direction.REVERSE);
        back_right.setDirection(DcMotorSimple.Direction.REVERSE);



        waitForStart();

        while (opModeIsActive()){

           moveLeft(0.75);
           sleep(800);
           driveForward(0.75);
           sleep(800);
           moveRight(0.75);
           sleep(800);
           driveForward(0.75);
           sleep(800);
           moveLeft(0.75);
           sleep(800);
           driveForward(0.75);
           sleep(800);
           moveRight(0.75);
           sleep(800);
           driveForward(0.75);
           sleep(800);


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
    public void TotalStop(){
        sleep(1000);
        stop();
    }
}
