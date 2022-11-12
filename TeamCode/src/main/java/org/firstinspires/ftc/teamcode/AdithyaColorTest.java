package org.firstinspires.ftc.teamcode;
/*
AOE Robotics Club
2022-2023 Autonoumous Java Code
Keep Confidential
 */

import com.aoe.stem.AOEColorPipeline;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;


@Autonomous(name = "AdithyaColorTest")
public class AdithyaColorTest extends LinearOpMode
{
    OpenCvWebcam webcam;
    String what="";

    @Override
    public void runOpMode()
    {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        AOEColorPipeline aoepipeline = new AOEColorPipeline("2022-2023", webcam,0,0,200,200);
        webcam.setPipeline(aoepipeline);
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode)
            {
            }
        });

        waitForStart();

        while (opModeIsActive())
        {
            telemetry.addData("What", aoepipeline.ColorValue);
            telemetry.update();
            sleep(100);
        }
    }



}
