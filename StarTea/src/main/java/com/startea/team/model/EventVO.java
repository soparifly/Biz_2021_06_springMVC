package com.startea.team.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventVO {
	private String event_code;//	event_code
	private String event_date;//	event_date
	private String event_user;//	event_user
	private String event_text;//	event_text
}
