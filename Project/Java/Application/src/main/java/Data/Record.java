package Data;

import Domain.Notifications;

import java.util.LinkedList;
import java.util.UUID;

public class Record {

    private UUID recordId;
    private Machine machine;
    public LinkedList<Batch> dataBatch;
    public LinkedList<SensorData> sensorData;
    public LinkedList<Notifications> notifications;

    public Record (UUID recordId, Machine machine, LinkedList<Batch> dataBatch, LinkedList<SensorData> sensorData, LinkedList<Notifications> notifications) {
        this.recordId = recordId;
        this.machine = machine;
        this.dataBatch = dataBatch;
        this.sensorData = sensorData;
        this.notifications = notifications;
    };

}
