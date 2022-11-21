package Data;

import java.util.LinkedList;
import java.util.UUID;

public class Record {

    private UUID recordId;
    private Machine machine;
    public LinkedList<Batch> data;
    

    /*- recordID: UUID
- machine: Machine
+ data: LinkedList<Batch>
+ sensor: LinkedList<SensorData>
+ notifications: linkedList<Notification>
*/

}
