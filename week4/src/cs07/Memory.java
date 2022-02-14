package cs07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class Memory {

    private static final int NUMBER_OF_PROCESS_CREATION = 5;
    private static final int NUMBER_OF_PROCESS_USED = 3;
    private static final int ZERO = 0;

    Queue<PCB> blockQueue = new LinkedList<>();
    Queue<PCB> readyQueue = new LinkedList<>();
    Queue<PCB> runningQueue = new LinkedList<>();

    public void memoryTransfer() {
        createProcess();
    }

    private void createProcess() {
        List<Process> processes = new ArrayList<>();
        IntStream.range(ZERO, NUMBER_OF_PROCESS_CREATION).forEach(s -> processes.add(new Process()));
        selectUsageProcess(processes);
    }

    private void selectUsageProcess(List<Process> processes) {
        Collections.shuffle(processes);
        IntStream.range(ZERO, NUMBER_OF_PROCESS_USED).forEach(s -> {
            PCB pcb = new PCB(processes.get(s));
            readyQueue.add(pcb);
        });
    }

    private void readyProcess() {
        runProcess();
    }

    private void runProcess() {
        runningQueue.add(readyQueue.poll());
        CPU cpu = new CPU(runningQueue.element());
    }

    private void blockProcess() {

    }

    private void terminatedProcess() {

    }
}