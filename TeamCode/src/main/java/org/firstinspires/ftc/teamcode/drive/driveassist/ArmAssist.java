package org.firstinspires.ftc.teamcode.drive.driveassist;

import static org.firstinspires.ftc.teamcode.drive.driveassist.ArmAssist.armpositions.DOWN;
import static org.firstinspires.ftc.teamcode.drive.driveassist.ArmAssist.armpositions.MEDIUM;
import static org.firstinspires.ftc.teamcode.drive.driveassist.ArmAssist.armpositions.UP;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drive.structure.Arm;
import org.firstinspires.ftc.teamcode.drive.structure.Sliders;

public class ArmAssist  extends LinearOpMode {
    public DcMotor arm = null;
    public DcMotor slider = null;
    @Override
    public void runOpMode() throws InterruptedException {

    }
    HardwareMap hwMap = null;
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        // Define and Initialize Motors
        slider = hwMap.get(DcMotor.class,"Slider");
        arm = hwMap.get(DcMotor.class, "Arm");
        slider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setDirection(DcMotorSimple.Direction.FORWARD);
        slider.setDirection(DcMotorSimple.Direction.FORWARD);
        slider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm.setPower(0);
        slider.setPower(0);
    }

    public armpositions position = DOWN;
public enum armpositions{
        UP,
        MEDIUM,
        DOWN,
}
float poz;
public void update(){
        switch(position) {
        case UP: {
            poz = slider.getCurrentPosition();
            slider.setTargetPosition(1000);
            slider.setPower(0.5);
            slider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            while(poz < 1000){

            }
            arm.setTargetPosition(1000);
            arm.setPower(0.5);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
        case MEDIUM: {
            poz = slider.getCurrentPosition();
            slider.setTargetPosition(500);
            slider.setPower(0.5);
            slider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            while(poz < 500){

            }
            arm.setTargetPosition(1000);
            arm.setPower(0.5);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
        case DOWN: {
            poz = slider.getCurrentPosition();
            if(poz > 0) {
                slider.setTargetPosition(0);
                slider.setPower(0.5);
                slider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                while(poz > 0){

                }
            }
            arm.setTargetPosition(1000);
            arm.setPower(0.5);
            arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        }
    }
}
    public void switchToUP(){position = ArmAssist.armpositions.UP;}

    public void switchToMEDIUM() {position = ArmAssist.armpositions.MEDIUM;}

    public void switchToDOWN() {position = ArmAssist.armpositions.DOWN;}

}
