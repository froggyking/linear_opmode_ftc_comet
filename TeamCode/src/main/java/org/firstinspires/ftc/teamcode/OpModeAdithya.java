package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;



@TeleOp(name="OpModeAdithya")
public class OpModeAdithya extends LinearOpMode{




    @Override
    public void runOpMode(){
        DcMotor front_left = hardwareMap.dcMotor.get("front_left");
        DcMotor back_left = hardwareMap.dcMotor.get("back_left");
        DcMotor front_right = hardwareMap.dcMotor.get("front_right");
        DcMotor back_right = hardwareMap.dcMotor.get("back_right");
        DcMotor slide = hardwareMap.dcMotor.get("slide");
        Servo claw = hardwareMap.servo.get("claw");

        front_left.setDirection(DcMotor.Direction.REVERSE);
        back_left.setDirection(DcMotor.Direction.REVERSE);
        front_right.setDirection(DcMotor.Direction.FORWARD);
        back_right.setDirection(DcMotor.Direction.FORWARD);
        slide.setDirection(DcMotor.Direction.FORWARD);

        double num = 0;

        waitForStart();

        while (opModeIsActive()){
            telemetry.addData("clawPos:", claw.getPosition());
            //variable initilisation bc im lazy lol
            double gamepad1Y = gamepad1.left_stick_y;
            double gamepad1X = gamepad1.left_stick_x;
            double gamepad2Y = gamepad1.right_stick_x;




            front_left.setPower(-gamepad1.left_stick_y+gamepad1.left_stick_x+gamepad1.right_stick_x);
            back_left.setPower(gamepad1.left_stick_y-gamepad1.left_stick_x+gamepad1.right_stick_x);
            front_right.setPower(-gamepad1.left_stick_y-gamepad1.left_stick_x-gamepad1.right_stick_x);
            back_right.setPower(gamepad1.left_stick_y-gamepad1.left_stick_x+gamepad1.right_stick_x);




            front_left.setPower(gamepad2Y);
            back_right.setPower(gamepad2Y);
            back_left.setPower(-gamepad2Y);
            front_right.setPower(-gamepad2Y);
//this below is the standard wasd movement


            // front_left.setPower(-gamepad1.left_stick_y+gamepad1.left_stick_x+gamepad1.right_stick_x);
            // back_left.setPower(-gamepad1.left_stick_y-gamepad1.left_stick_x-gamepad1.right_stick_x);
            // front_right.setPower(-gamepad1.left_stick_y+gamepad1.left_stick_x-gamepad1.right_stick_x);
            // back_right.setPower(-gamepad1.left_stick_y-gamepad1.left_stick_x+gamepad1.right_stick_x);


            if (gamepad2.y) {
                slide.setPower(0.88);
            }

            slide.setPower(-gamepad2.left_stick_y);

            if (gamepad2.a){
                claw.setPosition(0); //open
            }
            if (gamepad2.b){
                claw.setPosition(0.1); //close

            }
            telemetry.addData("Slide", slide);

            // if (gamepad2.dpad_up){
            //     num = num+0.0001;
            // }else if (gamepad2.dpad_down){
            //     num = num - 0.0001;
            // }
            //claw.setPosition(num);
            telemetry.addData("OpModeAdithya", num);


            // claw.setPosition(gamepad2.left_stick_x);

            telemetry.update();

        }

    }
}
