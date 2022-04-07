package com.springboot.eqd.service.impl;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.springboot.eqd.domain.BookingDo;
import com.springboot.eqd.domain.BookingDto;
import com.springboot.eqd.service.BookService;
import com.springboot.eqd.utils.BeanCpUtils;
import com.springboot.eqd.utils.DateUtil;
import com.springboot.eqd.utils.GlobalMapUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private static Snowflake snowflake = IdUtil.createSnowflake(10, 10);

    public void storeBooking(@RequestBody BookingDto bookingDto){
        bookingDto.setUuid(snowflake.nextIdStr());
        GlobalMapUtil.addGlobalMap(bookingDto.getGuestName(),bookingDto);
    }

    public Set<String> findAvailableRooms(Date date){
        return GlobalMapUtil.getGlobalRoomMapByDate(DateUtil.dateToString(date));
    }

    public List<BookingDto> findAllBookingByGuest(String guestName){
        List<BookingDo> doList = GlobalMapUtil.getGlobalBookingMapByName(guestName);
        List<BookingDto> dtoList = BeanCpUtils.copyListProperties(doList,BookingDto::new);
        return dtoList;
    }

}
