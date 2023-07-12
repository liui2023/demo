package com.example.demo.groovy;

import javax.script.*;

public class TestGroovy {

    public static void main(String[] args) throws ScriptException {
// 创建一个脚本引擎管理器
        ScriptEngineManager factory = new ScriptEngineManager();

        // 创建Groovy脚本引擎
        ScriptEngine engine = factory.getEngineByName("groovy");

        // 为脚本引擎创建一个编译器
        Compilable compilable = (Compilable) engine;

        // 定义Groovy脚本
        String script = "println(\"ScriptEngineManager test : hello world\");";

        // 编译Groovy脚本
        CompiledScript compiledScript = compilable.compile(script);

        // 设置输入参数值
        Bindings bindings = engine.createBindings();
        bindings.put("input", "World");

        // 执行编译过的Groovy脚本并获取结果
        Object result = compiledScript.eval(bindings);

        // 输出结果
        System.out.println(result);  // Prints: Hello, World
    }
}
