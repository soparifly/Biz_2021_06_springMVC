# Spring file upload project
	* web client 파일을 선택하여 서버에 Upload하기
	* 이미지 게시판, 이미지 갤러리 등을 만들때 사용한다
	
## 필요한 dependency
	
		<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.10.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.4</version>
		</dependency>

## root- context.xml에 fileupload 설정

	
	<!-- Root Context: defines shared resources visible to all other web components -->
	<!-- file upload와 관련한 bean을 설정하기 -->
	<!-- 단위
	0:개..
	000. : K(killo)
	000,000 :M(mega)
	000,000,000 :G(giga)
	000,000,000,000 :T(tera)
	 -->
	<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<property name="maxUploadSizePerFile" value="3000000"/>
		<property name="maxUploadSize" value="30000000"/>
	</bean>

	</beans>


* maxUploadPerFile :파일 1개의 용량 제한
* maxUploadFile : 전체 파일 용량 제한, 다수 파일을 올릴때 

		