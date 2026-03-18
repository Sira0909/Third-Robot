package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.systems.Drive;
import org.firstinspires.ftc.teamcode.systems.RPose;

public class robot {
    private robot() {throw new RuntimeException("Stub!");}

    public static final RPose RPose =new RPose();
    public static final Drive drive=new Drive();

    public static final HardwareMap hmap;
}
