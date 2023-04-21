package com.multi.mvc700;

import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

	@MessageMapping("/chat2")
	@SendTo("/topic/messages2")
	public OutputMessage2 send2(Message message) {
		String menu = "";
		switch (message.getText()) {
		case "1":
			menu = "챗 봇>>  1-1)요즘 인기있는 공연, 축제   		1-2) 후기관련		1-3) 휠체어석";
			break;
		case "2":
			menu = "챗 봇>>  2-1) 결제방법 	2-2) 티켓수령안내	 2-3) 취소/환불  ";
			break;
		case "3":
			menu = "챗 봇>>  3-1) 1) 회원가입 	3-2) 회원탈퇴	 3-3) 취소/환불  ";
			break;
		case "4":
			menu = "챗 봇>>  4-1) 결제방법 	4-2) 티켓수령안내	 4-3) 취소/환불  ";
			break;
	
		case "1-1":
			menu = "공연, 축제 메뉴에서 인기순으로 검색하시면 해당 정보를 확인하실 수 있습니다.";
			break;
		case "1-2":
			menu = "행사포스터 클릭 후 하단에서 확인하실 수 있습니다.";
			break;
		case "1-3":
			menu = "해당 공연 공연장에 문의해 주시길 바랍니다.";
			break;
		case "2-1":
			menu = "신용카드결제, 무통장입금";
			break;
		case "2-2":
			menu = "공연 당일 현장 교부처에서 예약번호 및 본인 확인 후 티켓을 수령하실 수 있습니다";
			break;
		case "2-3":
			menu = "My티켓 > 예매/취소내역에서 직접 취소 또는 고객센터 (0000-0000)를 통해서 예매를 취소할 수 있습니다.";
			break;
		case "3-1":
			menu = "로그인→회원가입";
			break;
		case "3-2":
			menu = "마이페이지→회원정보 수정";
			break;
		case "3-3":
			menu = "로그인→아이디/비밀번호 찾기";
			break;
		case "4-1":
			menu = "이벤트를 확인해주세요.";
			break;
		case "4-2":
			menu = "1) 소득공제 대상 : 뮤지컬, 콘서트, 연극, 클래식/무용, 전시 (박물관/미술관 입장권)   (팬클럽 가입 상품, 아카데미 수강 접수 상품, 각 공연장 유료회원가입 상품, 스포츠 등은 제외) *전시(박물관/미술관 입장권)는 2019.07.01 부터 반영";
			break;
		case "4-3":
			menu = "현금영수증 발급 안내를 확인해주세요";
			break;
		}
		OutputMessage2 outputMessage2 = new OutputMessage2(menu);
		return outputMessage2;
	}
	
	//ws프로토콜로 요청을 받음.
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public OutputMessage send(Message message) {
		System.out.println("서버에서 받은 데이터>> " + message); //서버에서 받은 클라이언트의 채팅 내용을 확인 
		Date date = new Date(); //java.util.Date;
		int hour = date.getHours();//시 
		int min = date.getMinutes();//분 
		String time = hour + ":" + min;
		//채팅방에 들어와있는 모든 클라이언트에게 보낼 데이터 
		OutputMessage output = new OutputMessage(message.getFrom(), message.getText(), time);
		return output; //return데이터는 json으로 만들어서 클라이언트 브라우저에 보냄.
		//jackson-databind
	}
}
