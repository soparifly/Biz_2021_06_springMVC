package com.callor.gallery.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
   
   @Qualifier("fileServiceV2")
   protected final FileService fSer;
   
//   localhost:8080/rootPatha/dumy/gallery/detail요청을 했을때 request를 처리할 method
//  원래라면 리퀘스트매의 주소값은 이렇게 정할수 있으나 
//   메소드값이 없으면 GET과 POST를 둘다 처리해버린다 구분하여메소드를 지정하는 이유
//   1. a tag를 클릭했을때  <a href = "${rootPath}/~~~
//   2. 주소창에 직접입력하고 Enter를 눌렀을때  http://localhost...~~~
//   3. 자바크립트  location.href = ${rootPath}/dumy/gallery/detail/로 jsp에서 실행햇을때
//  	@RequestMapping 이친구가 수신을 한다는 이야기이다
//   만약 똑같은함수를 만들고 요청주소는 같고 메서드만 다르게 지정해줫을때 문법상 아무 문제가 없다
//   POST가 작동하고자할때 (form action="${rootPath}/dumy/gallery/detail/로 설정이된다 )
//   		폼태그 내에 input name 이 들어있고 
//   	  input name값은 post의 매개변수로 적동된다는 이야기이다 
//   	JSP, HTML에서 위 코드를 만들고 입력화면을 보여준후 input box에 어떤 문자열을 입력한후
/*
 * 		submit 속성의 어떤 태그가 실행되면
 * 		이함수가  Request를 수신하고 input box에 입력한 문자열은 매개변수로 받는 어떤 이름이 동일한 변수에 담기게된다 
 * 	@RequestMapping < - > 
 */
//   @RequestMapping(value ="dumy/gallery/detail/{id}" )
//   public String dumy() {
//	   
//	   return "home";
//	   
//	   
//   }
//   
   
   @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
    
	   return "redirect:/gallery";
//      return "home";
   }
   
   @RequestMapping(value = {"/",""}, method = RequestMethod.POST)
   public String home(MultipartHttpServletRequest m_file, Model model) throws Exception {
      
//      List<MultipartFile> files = m_file.getFiles("m_file");
//      String fileName = fSer.fileUp(files.get(0));
//      model.addAttribute("file", fileName);
      
      List<String> fileNames = fSer.filesUp(m_file);
      model.addAttribute("files", fileNames);
      
      return "home";
   }
   
      
   
   
   /*
    * MultipartHttpServletRequest 
    * 이 클래스에 @RequestParam을 붙이면 400 오류 난다
    */
   
   @RequestMapping(value = "/sub", method = RequestMethod.POST)
   public String home(@RequestParam("one_file") MultipartFile one_file, MultipartHttpServletRequest m_file) {
      
      log.debug("파일개수 {}", m_file.getFile("m_file").getSize());
      
      /*
         다수의 파일이 업로드되면 파일들의 정보가 m_file 객체에 담기게 된다
         이 객체에서 getFiles() method를 사용하여
         파일들 list를 추출한다.
         List<MultipartFile> type의 객체에 담는다
         
         이 때 getFiles()에는 form에서 설전된
         input tag의 name값을 지정해준다
         
         또한 input tag에는 multiple="multiple"이 설정되어 있어야 한다.
       */
      List<MultipartFile> files = m_file.getFiles("m_file");
      
      for(MultipartFile file : files) {
         log.debug("파일들 {} ", file.getOriginalFilename());
      }
      
      return "home";
   }
   
}