package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name = "ColorSensorTestAdithyaComet")
//@Disabled

public class ColorSensorTestAdithyaComet extends LinearOpMode {

    //-----------------------

    ColorSensor color_sensor;

    @Override
    public void runOpMode() throws InterruptedException{

        //color_sensor = hardwareMap.get(ColorSensor.class, "color_sensor");
        color_sensor = hardwareMap.colorSensor.get("color_sensor");


        //-------------------------

        waitForStart();

        while(opModeIsActive()){
            if (color_sensor.red() > 20){

                //
            }

            telemetry.addData("red: ", color_sensor.red());
            telemetry.addData("green: ", color_sensor.green());
            telemetry.addData("blue: ", color_sensor.blue());
            telemetry.addData("alpha: ", color_sensor.alpha());
            telemetry.update();

        }

    }
}
