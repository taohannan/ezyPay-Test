package com.ezypay.test.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class SubscriptionDto implements Serializable {

    Double fees;
    SubscriptionType subscriptionType;
    LocalDate startDate;
    LocalDate endDate;
    LocalDate createdDate;
    LocalDate updatedDate;
    List<String> invoiceDate;

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public List<String> getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(List<String> invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }
}
