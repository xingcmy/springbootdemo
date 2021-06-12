package com.example.demo.servers.tools.msg;

import lombok.Data;

@Data
public class Msg {

    private String send;

    private String msg;

    private String set;

    private String type;

    private String time;

    public Msg(String send, String msg, String set, String type) {
        this.send = send;
        this.msg = msg;
        this.set = set;
        this.type = type;
    }

    public Msg(String msg, String set, String type) {
        this.msg = msg;
        this.set = set;
        this.type = type;
    }

    public Msg(String send, String msg, String set, String type, String time) {
        this.send = send;
        this.msg = msg;
        this.set = set;
        this.type = type;
        this.time = time;
    }
}
