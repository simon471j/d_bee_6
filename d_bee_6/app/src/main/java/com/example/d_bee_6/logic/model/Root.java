package com.example.d_bee_6.logic.model;


import com.example.d_bee_6.logic.model.Data;

import java.util.List;

public class Root {
    private List<Data> data;
    private int status;

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return this.data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Root{" +
                "data=" + data +
                ", status=" + status +
                '}';
    }
}
