package me.deepender.automation.listners;

import me.deepender.automation.utils.ExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        List<Map<String, String>> testDetails = ExcelUtils.getTestDetails();
        List<IMethodInstance> result = new ArrayList<>();
        for (int i = 0; i < methods.size(); i++) {
            for (int j = 0; j < testDetails.size(); j++) {
                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(testDetails.get(j).get("testName"))) {
                    if (testDetails.get(j).get("execute").equalsIgnoreCase("yes")) {
                        methods.get(i).getMethod().setDescription(testDetails.get(j).get("testDescription"));
                        methods.get(i).getMethod().setPriority(Integer.parseInt(testDetails.get(j).get("priority")));
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(testDetails.get(j).get("count")));
                        result.add(methods.get(i));
                    }
                }
            }
        }
        return result;
    }
}
