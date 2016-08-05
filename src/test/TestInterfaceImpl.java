package test;

/**
 * Created by xiwang on 7/25/2016.
 */
public class TestInterfaceImpl implements TestInterface {

    /**
     * This is just a test interface implementation.
     */
    @Override
    public TestResponse testService(TestRequest testRequest) {
        return TestResponse.fake();
    }
}
