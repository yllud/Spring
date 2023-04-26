package com.multi.myStagebox;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

@Service
public class ApiParsing {

	// 싱글톤으로 만든 dao 찾기
	@Autowired
	PlayDAO dao;
	@Autowired
	PlayDetailDAO dao2;
	@Autowired
	PlaceDAO dao3;
	@Autowired
	PlaceDetailDAO dao4;

	// xml에서 태그 값을 읽어오는 함수
	private static String getTagValue(String tag, Element eElement) {
		Node nValue = null;

		NodeList x = eElement.getElementsByTagName(tag);
		Node test = x.item(0);
		NodeList t = null;
		if (test != null) {
			t = test.getChildNodes();
			if ((Node) t.item(0) != null) {
				nValue = (Node) t.item(0);
			}
		}
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}

	// API 파싱해서 DB에 play 테이블에 추가
	public void apiPlay()
			throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException, SQLException {

		// Stringbuilder를 이용하여 url 조건 설정
//		StringBuilder urlBuilder = null;
//		urlBuilder = new StringBuilder("http://kopis.or.kr/openApi/restful/pblprfr");

//		urlBuilder.append("?" + URLEncoder.encode("service", "UTF-8") + "=e2622608ee6c4fa2a38d5f75a26a7e50"); /* Service Key */
//		urlBuilder.append("&" + URLEncoder.encode("stdate", "UTF-8") + "=20180601"); /* 시작일 */
//		urlBuilder.append("&" + URLEncoder.encode("eddate", "UTF-8") + "=20230230"); /* 종료일 */
//		urlBuilder.append("&" + URLEncoder.encode("cpage", "UTF-8") + "=1"); /* 출력할 페이지 수 */
//		urlBuilder.append("&" + URLEncoder.encode("rows", "UTF-8") + "=10000"); /* 출력할 데이터 수 */
//		urlBuilder.append("&" + URLEncoder.encode("signgucode", "UTF-8") + "=11"); /* 지역 코드 */
//		urlBuilder.append("&" + URLEncoder.encode("shcate","UTF-8") + "=AAAA"); /*장르 코드(연극)*/
//		urlBuilder.append("&" + URLEncoder.encode("shcate", "UTF-8") + "=AAAB"); /* 장르 코드(뮤지컬) */
//		URL url = new URL(urlBuilder.toString());
//		String parsingUrl = "";
//		parsingUrl = url.toString();

		// 20160601~20210630까지 모든 공연 데이터 중 10개만 일단 불러옴
		String parsingUrl = "http://www.kopis.or.kr/openApi/restful/pblprfr?service=e2622608ee6c4fa2a38d5f75a26a7e50&stdate=20160601&eddate=20210630&cpage=1&rows=10&prfstate=02&signgucode=11&signgucodesub=1111&kidstate=";
		System.out.println(parsingUrl);

		// playVO 사용
		PlayVO bag = new PlayVO();

		// 1. 빌더 팩토리 생성.
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		// 2. 빌더 팩토리로부터 빌더 생성
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		// 3. 빌더를 통해 XML 문서를 파싱해서 Document 객체로 가져온다.
		Document doc = dBuilder.parse(parsingUrl);

		// 문서 구조 안정화
		doc.getDocumentElement().normalize();

		// XML 데이터 중 <db> 태그의 내용을 가져온다.
		NodeList nList = doc.getElementsByTagName("db");
		System.out.println("length: " + nList.getLength());
		int result = 0;
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				String id = getTagValue("mt20id", eElement);
				bag.setPlay_id(id);
				bag.setPlay_name(getTagValue("prfnm", eElement));
				bag.setPlay_start(transformDate(getTagValue("prfpdfrom", eElement)));
				bag.setPlay_end(transformDate(getTagValue("prfpdto", eElement)));
				bag.setPlace_name(getTagValue("fcltynm", eElement));
				bag.setPoster(getTagValue("poster", eElement));
				bag.setGenre_name(getTagValue("genrenm", eElement));
				bag.setState(getTagValue("prfstate", eElement));
				bag.setOpenrun(getTagValue("openrun", eElement));

				if (id != null) {
					try {
						System.out.println(getTagValue("prfnm", eElement));
						result = dao.insert(bag);
						// System.out.println(result);

					} catch (Exception e) {
						System.out.println(e.toString());
					}

				}
			}
		}

		System.out.println("처리 개수" + nList.getLength());
		if (result > 0) {
			System.out.println("db 추가 성공");
		} else {
			System.out.println("db 추가 실패");
		}
	}

	// API 파싱해서 DB에 playDetail 테이블 추가
	public void apiPlayDetail()
			throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException, SQLException {

		// api url에 붙여줄 id 리스트를 play 테이블에서 불러온다
		List<String> list = new ArrayList<String>();
		try {
			list = dao.listId();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		for (String id : list) {
			String parsingUrl = "http://www.kopis.or.kr/openApi/restful/pblprfr/" + id
					+ "?service=e2622608ee6c4fa2a38d5f75a26a7e50";
			System.out.println(parsingUrl);
			// playDetailVO 사용
			PlayDetailVO bag = new PlayDetailVO();

			// 1. 빌더 팩토리 생성.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			// 2. 빌더 팩토리로부터 빌더 생성
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// 3. 빌더를 통해 XML 문서를 파싱해서 Document 객체로 가져온다.
			Document doc = dBuilder.parse(parsingUrl);

			// 문서 구조 안정화
			doc.getDocumentElement().normalize();

			// XML 데이터 중 <db> 태그의 내용을 가져온다.
			NodeList nList = doc.getElementsByTagName("db");
			System.out.println("length: " + nList.getLength());
			int result = 0;
			for (int i = 0; i < nList.getLength(); i++) {

				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String playId = getTagValue("mt20id", eElement);
					bag.setPlay_id(playId);
					bag.setPlace_id(getTagValue("mt10id", eElement));
					bag.setPlay_name(getTagValue("prfnm", eElement));
					bag.setPlay_start(transformDate(getTagValue("prfpdfrom", eElement)));
					bag.setPlay_end(transformDate(getTagValue("prfpdto", eElement)));
					bag.setPlace_name(getTagValue("fcltynm", eElement));
					bag.setCasting(getTagValue("prfcast", eElement));
					bag.setCrew(getTagValue("prfcrew", eElement));
					bag.setRuntime(getTagValue("prfruntime", eElement));
					bag.setPlay_age(getTagValue("prfage", eElement));
					bag.setEnterprise(getTagValue("entrpsnm", eElement));
					bag.setPrice(getTagValue("pcseguidance", eElement));
					bag.setPoster(getTagValue("poster", eElement));
					bag.setContent(getTagValue("sty", eElement));
					bag.setGenre_name(getTagValue("genrenm", eElement));
					bag.setState(getTagValue("prfstate", eElement));
					bag.setOpenrun(getTagValue("openrun", eElement));
					bag.setImage(getTagValue("styurl", eElement));
					bag.setPlay_time(getTagValue("dtguidance", eElement));

					// System.out.println(getTagValue("prfnm", eElement));
					// System.out.println(getTagValue("dtguidance", eElement));
					// System.out.println(getTagValue("styurl", eElement));

					if (playId != null) {
						try {
							System.out.println(getTagValue("prfnm", eElement));
							result = dao2.insert(bag);

						} catch (Exception e) {
							System.out.println(e.toString());
						}
					}
				}
			}

			System.out.println("처리 개수" + nList.getLength());
			if (result > 0) {
				System.out.println("db 추가 성공");
			} else {
				System.out.println("db 추가 실패");
			}
		}
	}

	// API 파싱해서 DB에 place 테이블 추가
	public void apiPlace()
			throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException, SQLException {

		// 일단 10개의 공연장 정보 불러오기
		String parsingUrl = "http://www.kopis.or.kr/openApi/restful/prfplc?service=e2622608ee6c4fa2a38d5f75a26a7e50&cpage=1&rows=10";
		System.out.println(parsingUrl);

		// placeVO 사용
		PlaceVO bag = new PlaceVO();

		// 1. 빌더 팩토리 생성.
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		// 2. 빌더 팩토리로부터 빌더 생성
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		// 3. 빌더를 통해 XML 문서를 파싱해서 Document 객체로 가져온다.
		Document doc = dBuilder.parse(parsingUrl);

		// 문서 구조 안정화
		doc.getDocumentElement().normalize();

		// XML 데이터 중 <db> 태그의 내용을 가져온다.
		NodeList nList = doc.getElementsByTagName("db");
		System.out.println("length: " + nList.getLength());
		int result = 0;
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;

				String id = getTagValue("mt10id", eElement);
				
				
				bag.setPlace_id(id);
				bag.setPlace_name(getTagValue("fcltynm", eElement));
				bag.setPlace_cnt(getTagValue("mt13cnt", eElement));
				bag.setKind(getTagValue("fcltychartr", eElement));
				bag.setCity(getTagValue("sidonm", eElement));
				bag.setDistrict(getTagValue("gugunnm", eElement));
				bag.setOpen_year(getTagValue("opende", eElement));

				if (id != null) {
					try {
						System.out.println(getTagValue("fcltynm", eElement));
						result = dao3.insert(bag);
						// System.out.println(result);

					} catch (Exception e) {
						System.out.println(e.toString());
					}

				}
			}
		}

		System.out.println("처리 개수" + nList.getLength());
		if (result > 0) {
			System.out.println("db 추가 성공");
		} else {
			System.out.println("db 추가 실패");
		}
	}
	
	// API 파싱해서 DB에 placeDetail 테이블 추가
	public void apiPlaceDetail()
			throws IOException, ParserConfigurationException, SAXException, ClassNotFoundException, SQLException {

		// api url에 붙여줄 id 리스트를 play 테이블에서 불러온다
		List<String> list = new ArrayList<String>();
		try {
			list = dao3.listId();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		for (String id : list) {
			String parsingUrl = "http://www.kopis.or.kr/openApi/restful/prfplc/"+id+"?service=e2622608ee6c4fa2a38d5f75a26a7e50";
			//String parsingUrl="http://www.kopis.or.kr/openApi/restful/prfplc/FC001247?service=e2622608ee6c4fa2a38d5f75a26a7e50";
			System.out.println(parsingUrl);
			// playDetailVO 사용
			PlaceDetailVO bag = new PlaceDetailVO();

			// 1. 빌더 팩토리 생성.
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

			// 2. 빌더 팩토리로부터 빌더 생성
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// 3. 빌더를 통해 XML 문서를 파싱해서 Document 객체로 가져온다.
			Document doc = dBuilder.parse(parsingUrl);

			// 문서 구조 안정화
			doc.getDocumentElement().normalize();

			// XML 데이터 중 <db> 태그의 내용을 가져온다.
			NodeList nList = doc.getElementsByTagName("db");
			System.out.println("length: " + nList.getLength());
			int result = 0;
			for (int i = 0; i < nList.getLength(); i++) {

				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					
					String placeId = getTagValue("mt10id", eElement);
					bag.setPlace_id(placeId);
					bag.setPlace_name(getTagValue("fcltynm", eElement));
					bag.setPlace_cnt(getTagValue("mt13cnt", eElement));
					bag.setKind(getTagValue("fcltychartr", eElement));
					bag.setOpen_year(getTagValue("opende", eElement));
					bag.setSeat_cnt(getTagValue("seatscale", eElement));
					bag.setTel(getTagValue("telno", eElement));
					bag.setWebsite(getTagValue("relateurl", eElement));
					bag.setAddress(getTagValue("adres", eElement));
					bag.setLatitude(getTagValue("la", eElement));
					bag.setLongitude(getTagValue("lo", eElement));
					
					System.out.println(getTagValue("fcltynm", eElement));
					System.out.println(getTagValue("mt13cnt", eElement));
					System.out.println(getTagValue("fcltychartr", eElement));
					System.out.println(getTagValue("opende", eElement));
					//System.out.println(getTagValue("signgucode", eElement));
					System.out.println(getTagValue("seatscale", eElement));
					System.out.println(getTagValue("telno", eElement));
					System.out.println(getTagValue("relateurl", eElement));
					System.out.println(getTagValue("adres", eElement));
					System.out.println(getTagValue("la", eElement));
					System.out.println(getTagValue("lo", eElement));
					System.out.println("hihihi");
					System.out.println(bag);
					if (placeId != null) {
						try {
							System.out.println(getTagValue("ohohohoh", eElement));
							result = dao4.insert(bag);

						} catch (Exception e) {
							System.out.println(e.toString());
						}
					}
				}
			}

			System.out.println("처리 개수" + nList.getLength());
			if (result > 0) {
				System.out.println("db 추가 성공");
			} else {
				System.out.println("db 추가 실패");
			}
		}
	}
	
	
	// 날짜가 yyyymmdd 형식으로 입력되었을 경우 Date로 변경
	public static Date transformDate(String date) {
		SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyy.mm.dd");

		// Date로 변경하기 위해서는 날짜 형식을 yyyy-mm-dd로 변경해야 한다.
		SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");

		java.util.Date tempDate = null;

		try {
			// 현재 yyyymmdd로된 날짜 형식으로 java.util.Date객체를 만든다.
			tempDate = beforeFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
		String transDate = afterFormat.format(tempDate);

		// 반환된 String 값을 Date로 변경한다.
		Date d = Date.valueOf(transDate);

		return d;
	}

//	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, SQLException, ClassNotFoundException
//	{
//		System.out.println("시작");
//
//		apiPlace();
//		// apiPlayDetail();
//		// apiPlace();
//
//	}
}
