package yeling.spring.member.service;

import yeling.spring.member.vo.MemberVO;
import yeling.spring.member.vo.UpdateInfo;

public interface MemberService {
	void regist(MemberVO member);
	boolean update(String memberId, UpdateInfo info);
}
