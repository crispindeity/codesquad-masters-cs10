package cs07;

public class PCB {

    private final long pid;
    private Status processStatus;
    private double processRunTime;
    private final double processMaxRunTime;

    public PCB(Process process) {
        this.pid = process.getId();
        this.processStatus = process.getStatus();
        this.processRunTime = process.getRunTime();
        this.processMaxRunTime = process.getMaxRunTime();
    }
}