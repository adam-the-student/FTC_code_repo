package org.firstinspires.ftc.teamcode;

import org.opencv.core.Mat;
import org.openftc.easyopencv.OpenCvPipeline;

class EmptyPipeline extends OpenCvPipeline
{
    @Override
    public Mat processFrame(Mat input)
    {
        return input;
    }
}