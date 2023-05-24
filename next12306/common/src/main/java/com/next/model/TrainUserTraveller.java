package com.next.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainUserTraveller {
    private Long id;

    private Long userId;

    private Long travellerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTravellerId() {
        return travellerId;
    }

    public void setTravellerId(Long travellerId) {
        this.travellerId = travellerId;
    }
}