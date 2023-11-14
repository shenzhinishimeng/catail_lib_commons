package com.catail.lib_commons.interfaces;

public class StartTakDetailsActivityManager {

    public StartTaskDetailsActivityCallback startTaskDetailsActivityCallback;

    public void registerCallback(StartTaskDetailsActivityCallback callback) {
        this.startTaskDetailsActivityCallback = callback;
    }

    public void unregisterCallback() {
        this.startTaskDetailsActivityCallback = null;
    }


    // 1. 构造器私有化 外部能new
    public StartTakDetailsActivityManager() {
    }

    // 2. 本类内部创建对象实例
    private final static StartTakDetailsActivityManager instance = new StartTakDetailsActivityManager();

    // 3. 提供一个公有的静态方法，返回实例对象
    public static StartTakDetailsActivityManager getInstance() {
        return instance;
    }

}