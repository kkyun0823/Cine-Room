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
	 * �ش� ��ȭ ���� ��Ͽ��� üũ
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
	 * ���� �Է��ϱ�
	 **/
	public static void setMovieRate(Rate rate) {
		try {
			if (checkRate(rate.getMemberId(), rate.getMovieNo())) {
				FailView.printMessage("�̹� ������ ����ϼ̽��ϴ�");
			} else {
				rateService.setMovieRate(rate);
				EndView.printMessage("������ ��ϵǾ����ϴ�!");
			}
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}
	}

	/**
	 * ���� �����ϱ�
	 */

	/**
	 * ���� �����ϱ�
	 */
	public static void deleteMovieRate(int rateNo, String memberId) {
		try {
			rateService.deleteMovieRate(rateNo, memberId);
			EndView.printMessage("���������� �����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.printMessage(e.getMessage());
		}

	}

	/**
	 * ���� �˻��ϱ�
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
