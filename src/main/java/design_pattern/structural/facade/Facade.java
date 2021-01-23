package design_pattern.structural.facade;

public class Facade {
    private final SubsystemA subsystemA = new SubsystemA();
    private final SubsystemB subsystemB = new SubsystemB();
    private final SubsystemC subsystemC = new SubsystemC();

    /**
     * 整合三个子系统的接口
     */
    public void startDota2() {
        subsystemA.openComputer();
        subsystemB.openSteam();
        subsystemC.openDota2();
    }
}
