package org.firstinspires.ftc.teamcode.systems.outtake;

import com.qualcomm.robotcore.hardware.Servo;


public class ClawSubsystemNikolas {
    public final Servo clawServo;
    private boolean open;
    private final double openPos = 0;
    private final double closePos = 1;

    public ClawSubsystemNikolas(Servo clawS) {
        clawServo = clawS;
        open = false;
    }

    public void set() {
        if (open) {
            clawServo.setPosition(openPos);
        } else {
            clawServo.setPosition(closePos);
        }
    }
    public void toggle() {
        open = !open;
        set();
    }
    public void open(boolean makeOpen) {
        open = makeOpen;
        set();
    }
    public void openToPosition(double pos) {
        open = true;
        clawServo.setPosition(pos);
    }
}
