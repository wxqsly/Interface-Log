package test;

import java.util.List;

/**
 * Created by xiwang on 7/25/2016.
 */
public class TestRequest {
    private String name;

    private int pageSize;

    private List<String> conditions;

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("TestRequest: ").append("\n").append("{").
                append("  name: ").append(name).append(",  pageSize: ").
                append(pageSize).append(",  conditions: [");

        for (String condition : conditions) {
            sb.append(condition).append(", ");
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

    public List<String> getConditions() {
        return conditions;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }
}
