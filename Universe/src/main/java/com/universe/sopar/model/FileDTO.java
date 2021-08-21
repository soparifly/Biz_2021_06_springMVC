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
public class FileDTO {

	private Long file_seq = 0L;
	private Long file_gseq;
	private String file_originalName;
	private String file_upName;
	
	List<FileDTO> FilesList;
}
