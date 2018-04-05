package org.csf.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Objects;

/**
 * @author Andrew Boytsov
 * @date 06.04.2018
 */

public class CostComputeDto {

    private Long cassetteId;
    private String phoneNumber;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public CostComputeDto() {
    }

    public Long getCassetteId() {
        return cassetteId;
    }

    public void setCassetteId(Long cassetteId) {
        this.cassetteId = cassetteId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isAllEmpty() {
        return Objects.isNull(cassetteId) && StringUtils.isEmpty(phoneNumber) && Objects.isNull(endDate);
    }
}
