package test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xiwang on 7/25/2016.
 */
public class TestResponse {
    private String name = "";

    private int pageSize;

    private List<String> results = new ArrayList<String>();

    public static TestResponse fake() {
        TestResponse fake = new TestResponse();

        fake.setName("Test Response");
        fake.setPageSize(10);

        List<String> results = new ArrayList<String>();
        results.add("123456");
        results.add("789012");

        return fake;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("TestResponse: ").append("\n").append("{").
                append("  name: ").append(name).append(",  pageSize: ").
                append(pageSize).append(",  results: [");

        for (String result : results) {
            sb.append(result).append(", ");
        }

        sb.append("]").append("\n").append("}");
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}