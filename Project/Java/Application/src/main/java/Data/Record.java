package Data;

import Domain.Notifications;

import java.util.LinkedList;
import java.util.UUID;

public class Record {

    private UUID recordId;
    private Machine machine;
    public LinkedList<Batch> batchData;
    public LinkedList<SensorData> sensorData;
    public LinkedList<Notifications> notifications;

    public Record (UUID recordId, Machine machine, LinkedList<Batch> batchData, LinkedList<SensorData> sensorData, LinkedList<Notifications> notifications) {
        this.recordId = recordId;
        this.machine = machine;
        this.batchData = batchData;
        this.sensorData = sensorData;
        this.notifications = notifications;
    };

    public void setRecordId(UUID recordId) { this.recordId = recordId; }

    public UUID getRecordId() { return this.recordId; }

    public void setMachine(Machine machine) { this.machine = machine; }

    public Machine getMachine() { return this.machine; }

    public void setBatchData(LinkedList<Batch> batchData) { this.batchData = batchData; }

    public LinkedList<Batch> getBatchData() { return this.batchData; }

    public void setSensorData(LinkedList<SensorData> sensorData) { this.sensorData = sensorData; }

    public LinkedList<SensorData> getSensorData() { return this.sensorData; }

    public void setNotifications(LinkedList<Notifications> notifications) { this.notifications = notifications; }

    public LinkedList<Notifications> getNotifications() { return  this.notifications; }

}
