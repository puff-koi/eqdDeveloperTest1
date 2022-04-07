package com.springboot.eqd.utils;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.springboot.eqd.domain.BookingDo;
import com.springboot.eqd.domain.BookingDto;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class GlobalMapUtil {
    private static final AtomicInteger count = new AtomicInteger(1);
    //客人下所有Booking
    private static final ConcurrentHashMap<String, List<BookingDo>> globalBookingMap = new ConcurrentHashMap<>();
    //房间号去重
    private static final ConcurrentHashMap<String, Set<String>> globalRoomMap = new ConcurrentHashMap<>();

    public static void addGlobalMap(String name,BookingDto bookingDto) {
        BookingDo bookingDo = new BookingDo();
        BeanUtils.copyProperties(bookingDto,bookingDo);
        //实现DB中自增id和uuid，缓存非必要
        bookingDo.setId(count.getAndIncrement());
        addGlobalBookingMap(name,bookingDo);
        addGlobalRoomMap(DateUtil.dateToString(bookingDo.getDate()),bookingDo.getRoomNumber());
    }

    private static void addGlobalBookingMap(String name,BookingDo bookingDo) {
        List<BookingDo> list = globalBookingMap.get(name);
        if (list==null){
            list = new ArrayList<>();
        }
        list.add(bookingDo);
        globalBookingMap.put(name,list);
    }

    private static void addGlobalRoomMap(String date,String roomNum) {
        Set<String> set = globalRoomMap.get(date);
        if (set==null){
            set = new HashSet<>();
        }
        set.add(roomNum);
        globalRoomMap.put(date,set);
    }

    public static List<BookingDo> getGlobalBookingMapByName(String name) {
        List<BookingDo> list = globalBookingMap.get(name);
        return list == null ? new ArrayList<>(): list;
    }

    public static Set<String> getGlobalRoomMapByDate(String date) {
        Set<String>  set = globalRoomMap.get(date);
        return set == null ? new HashSet<>(): set;
    }
}
