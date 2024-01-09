package CreationalPatterns.FactoryMethod.Interfaces;

import java.util.List;

public interface ILogistic<ITransporter>
{
    void createTransporter();
    void addTransporterInList(ITransporter transporter);
    void addNewTransporterInList();
    void updateNewTransporter(ITransporter transporter);
    void updateTransporterLists();
    ITransporter getNewTransporter();
    List<ITransporter> getTransportersOnRoad();
    List<ITransporter> getTransportersNotOnRoad();
    List<ITransporter> getTransporters();
}
