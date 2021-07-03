package com.callor.book.exec;

import com.callor.book.model.BookDTO;

public class Main_01 {

	
	
	public static void main(String[] args) {
		/*
		 *  <VO, DTO를 생성하고 데이터를 담기>>
		 */

//		1. 비어있는 객체를 생성하고, Setter를 사용하여 값을 저장하는 방법 
//			단점, Setter매서드를 필요한 데이터 갯수만큼 나열해야한다
		BookDTO bookDTO = new BookDTO();
		bookDTO.setTitle("자바야 놀자");

		
//		2.필드 생성자를 사용하여 객체를 생성하면서, 값을 매개변수로 주입하는 방법
//			단점, 일부 데이터만 주입하여 객체를 생성할수 없다
//				 일부 데이터를 위하여 별도로 생성자를 또 만들어야한다
//				데이터의 주입 순서가 바뀌면 어떤 값이 저장될지모른다->전적으로 개발자의 책임으로 귀결된다
		BookDTO bookDTO1= new BookDTO("자바야놀자","linke","image","author","price","discount","publisher","isbn","desc","pubdate");
		
//		3.Builder 패턴
		
//									뷸더 함수를 불러오면 다음에 .을 찍을때 객체에 포함된멤버변수들이 메서드로 등장한다
		BookDTO bookDTO2 = BookDTO.builder()
								.title("자바야놀자")
								.isbn("92323")
								.build();
//								내용물 주입을 멈추는 메서드
//								각각의 필요한 변수를 셋팅할때 
//								setter메서드를 사용하지않고
//								변수명 형태의 method를 사용하여 값을 저장 
//								값이 저장되고 생성된 객체를 사용할수 있도록
//								객체 인스턴스 에게 전달하기 위하여 build() method를호출한다
//								장점 new를 이용한 객체생성을 하지않는다
//									필요한 멤버(속성, 멤버변수)만 가지고 있는 객체를 만들 수 있다
//									변수이름을 직접 호출하는 방식으로 값을 저장할 수 있다.
		
		 System.out.println(bookDTO2.toString());
	}
}
