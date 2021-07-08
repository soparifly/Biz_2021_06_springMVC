package com.callor.gallery.model;

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
public class GalleryFilesDTO {

	private Long g_seq;			//','bigint','NO','','0',''
	private String g_writer;	//','varchar(125)','NO','',NULL,''
	private String g_date;		//','varchar(10)','NO','',NULL,''
	private String g_time;		//','varchar(10)','NO','',NULL,''
	private String g_subject;	//','varchar(50)','NO','',NULL,''
	private String g_content;	//','varchar(1000)','NO','',NULL,''
	private String g_image;		//','varchar(256)','YES','',NULL,''
	private Long f_seq;			//','bigint','NO','','0',''
	private String f_original;	//','varchar(256)','NO','',NULL,''
	private String f_upname;	//','varchar(256)','NO','',NULL,''

}
