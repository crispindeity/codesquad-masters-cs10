package cs07;

import lombok.Getter;

@Getter
public class Process {

    private final long id;
    private Status status;
    private final double maxRunTime;
    private double runTime;
    private static int sequence = 0;

    public Process() {
        this.id = sequence;
        this.maxRunTime = (Math.random() * 15) + 3;
        this.status = Status.READY;
        this.runTime = 0;
        sequence++;
    }
}