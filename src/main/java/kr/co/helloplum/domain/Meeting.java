package kr.co.helloplum.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "meeting")
@Getter
public class Meeting {

	@Id
	private String _id;
	private String name;
	private LocalDate startDate;
	private LocalDate endDate;
	private String place;
	private String placeDetail;
	private String duration;
	private String host;
	private String password;
	private String info;
	private boolean isConfirmed;

	@Builder
	public Meeting(String name, LocalDate startDate, LocalDate endDate, String place, String placeDetail,
				   String duration, String host, String password, String info) {
		Assert.notNull(name, "name must not be null");
		Assert.notNull(startDate, "startDate must not be null");
		Assert.notNull(endDate, "endDate must not be null");
		Assert.notNull(place, "place must not be null");
		Assert.notNull(placeDetail, "placeDetail must not be null");
		Assert.notNull(duration, "duration must not be null");
		Assert.notNull(host, "host must not be null");
		Assert.notNull(password, "password must not be null");
		Assert.notNull(info, "info must not be null");

		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.placeDetail = placeDetail;
		this.duration = duration;
		this.host = host;
		this.password = password;
		this.info = info;
		this.isConfirmed = false;
	}

}
