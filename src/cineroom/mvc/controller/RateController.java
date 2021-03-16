package cineroom.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import cineroom.mvc.model.dto.Member;
import cineroom.mvc.model.dto.Movie;
import cineroom.mvc.model.dto.Rate;
import cineroom.mvc.model.service.MemberService;
import cineroom.mvc.model.service.RateService;
import cineroom.mvc.view.EndView;
import cineroom.mvc.view.FailView;

public class RateController {
	private static RateService rateService = new RateService();

	/**
	 * 해당 영화 평점 등록여부 체크
	 */

	public static boolean checkRate(String memberId, int movieNo) {
		boolean result = false;
		try {
			result = rateService.checkRate(memberId, movieNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 평점 입력하기
	 **/
	public static void setMovieRate(Rate rate) {
		try {
			if (checkRate(rate.getMemberId(), rate.getMovieNo())) {
				FailView.printMessage("이미 평점을 등록하셨습니다");
			} else {
				rateService.setMovieRate(rate);
				EndView.printMessage("평점이 등록되었습니다!");
			}
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * 평점 수정하기
	 */

	/**
	 * 평점 삭제하기
	 */
	public static void deleteMovieRate(int rateNo, String memberId) {
		try {
			rateService.deleteMovieRate(rateNo, memberId);
			EndView.printMessage("성공적으로 삭제되었습니다.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}

	}

	/**
	 * 평점 검색하기
	 */
	public static void rateSelectByID(String memberId) {
		try {
			List<Rate> rateList = rateService.rateSelectByID(memberId);
			EndView.printRateList(rateList);
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}
}
