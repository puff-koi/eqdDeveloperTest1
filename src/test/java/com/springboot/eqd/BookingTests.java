package com.springboot.eqd;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.springboot.eqd.domain.BookingDto;
import com.springboot.eqd.service.BookService;
import com.springboot.eqd.utils.JsonUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingTests {

	@Autowired
	private BookService bookService;

	@Test
	public void bookingtest() throws ParseException {
		try {
			JSONObject json = JsonUtils.readJsonFromClassPath("/json/test.json", JSONObject.class);
			JSONArray array = json.getJSONArray("guest");
			for (int i = 0; i < array.size(); i++) {
				bookService.storeBooking(array.getObject(i, BookingDto.class));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<BookingDto> list = bookService.findAllBookingByGuest("li186");
		System.out.println("li186's booking:");
		for (BookingDto bookingDto:
				list) {
			System.out.println(bookingDto);
		}

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = simpleDateFormat.parse("2022-01-01");
		Set<String> set =  bookService.findAvailableRooms(date);
		System.out.println("2022-01-01's roomNum:");
		for (String roomNum:
				set) {
			System.out.println(roomNum);
		}
	}

}
