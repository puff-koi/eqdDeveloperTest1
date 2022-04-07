package com.springboot.eqd.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class BookingDto {
    //假定顾客名字唯一，uuid用不上
    private String uuid;

    @NotEmpty(message = "guestName can not be null!")
    private String guestName;

    @NotEmpty(message = "roomNumber can not be null!")
    private String roomNumber;

    //先精确到日
    @NotNull(message = "date can not be null!")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date date;
}
