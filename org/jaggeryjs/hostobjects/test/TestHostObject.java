package org.jaggeryjs.hostobjects.test;

import org.mozilla.javascript.*;
import org.jaggeryjs.scriptengine.exceptions.ScriptException;

import java.util.Arrays;

public class TestHostObject extends ScriptableObject {
    private static final String hostObjectName = "Tester";

    private String sayHello;


    @Override
    public String getClassName() {
        return hostObjectName;
    }

    public static Scriptable jsConstructor(Context cx, Object[] args, Function ctorObj, boolean inNewExpr)
            throws ScriptException {
        TestHostObject test = new TestHostObject();

        if (args.length == 1) {
            String name = (String) args[0];
            test.sayHello = "Hello " + name;

        } else {
            throw new ScriptException("API configuration not specified");
        }

        return test;
    }

    public static String jsFunction_getSayHello(Context cx, Scriptable thisObj, Object[] args, Function funObj) throws ScriptException {
        TestHostObject test = (TestHostObject) thisObj;
        return test.sayHello;
    }
}