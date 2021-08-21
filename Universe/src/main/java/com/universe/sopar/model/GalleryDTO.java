package com.universe.sopar.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GalleryDTO {

	private Long g_seq = 0L;
	private String g_writer;
	private String g_date;
	private String g_time;
	private String g_title;
	private String g_content;
	private String g_image;

	List<FileDTO> filesList;
}
