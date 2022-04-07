package com.springboot.eqd.domain;

import lombok.Data;
import java.util.Date;

@Data
public class BookingDo {
    //db自增id，缓存用不上
    private Integer id;
    //uuid作为标识，假定顾客名字唯一，缓存用不上
    private String uuid;
    private String guestName;
    private String roomNumber;
    private Date date;
}
