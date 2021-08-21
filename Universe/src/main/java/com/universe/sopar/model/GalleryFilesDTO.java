package com.universe.sopar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GalleryFilesDTO {
	private Long g_seq;
	private String g_writer;
	private String g_date;
	private String g_time;
	private String g_title;
	private String g_content;
	private String g_image;
	private Long f_seq;
	private String f_originalName;
	private String f_upName;

}
