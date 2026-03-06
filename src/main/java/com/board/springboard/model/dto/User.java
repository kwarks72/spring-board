package com.board.springboard.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

/*
파일 만드는 순서
1. DTO    SQL 컬럼 연결고리 세팅
2. MAPPER.JAVA SQL을 가져올 기능, 명칭 자료형 매개자료 설정
3.MAPPER.XML  MAPPER.JAVA에서 설정한 기능 참고해서 SQL작성
4.SERVICE JAVA  회사에서 요구하는 기능을 바탕으로 서비스 로직을 작성
			필요시 SQL과 연결된 MAPPER활용하여 서비스 로직을 작성한다
4.CONTROLLER.JAVA 어떤 API/ENDPOINT주소에서 어떤 JSP OR HTML템플릿 보여줄 것인가
			     주소에서 템플릿 보여줄 때 가져갈 데이터나 특정 설정이 있다면
				서비스에서 기능을 가져온 후 가져와 로직 세팅
5.JSP파일			유저에게 보여줄 화면 세팅
 */





public class User {
    private Integer id;
    private String name;
    private String email;
    private LocalDateTime create_at;
    private String profile_img;

}
