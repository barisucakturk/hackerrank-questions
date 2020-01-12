package com.ucakturk.hackerrank;

import java.util.Optional;

public class ProcessedTransaction {
    private String id;
    private Optional<String> status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Optional<String> getStatus() {
        return status;
    }

    public void setStatus(Optional<String> status) {
        this.status = status;
    }
}
