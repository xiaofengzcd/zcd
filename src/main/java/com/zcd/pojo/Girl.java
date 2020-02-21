package com.zcd.pojo;

/**
 * @author zcd
 * @description:
 * @create 2020/1/10 16:36
 */
public class Girl {
    private int id;
    private String name;
    private long time;
    private String result;

    public Girl(String name, long time, String result) {
        this.name = name;
        this.time = time;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
