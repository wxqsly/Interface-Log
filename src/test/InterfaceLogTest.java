package test;

import personal.nicolas.usapp.logutil.InterfaceLogItem;
import personal.nicolas.usapp.logutil.InterfaceLogger;
import personal.nicolas.usapp.logutil.Status;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiwang on 7/20/2016.
 */
public class InterfaceLogTest {
    static InterfaceLogger log = new InterfaceLogger();

    public static void main(String[] args) {
        TestRequest request = new TestRequest();
        request.setName("This is a test request for interface log");
        request.setPageSize(10);
        List<String> conditions = new ArrayList<String>();
        conditions.add("shipper is in Freeport");
        conditions.add("STT number is 123456");
        request.setConditions(conditions);

        long start = System.currentTimeMillis();
        InterfaceLogItem item = new InterfaceLogItem("DDS", "ODM", "getDocuments", request);
        log.printRequest(item);

        TestResponse response = new TestInterfaceImpl().testService(request);
        item.setResponse(response);
        item.setStatus(Status.SUCCESS);

        long end = System.currentTimeMillis();
        item.setDuration(end - start);

        log.printResponse(item);


    }
}
