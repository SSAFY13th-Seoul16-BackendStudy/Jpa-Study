package com.japStudy.ssafyStudy.service;

import com.japStudy.ssafyStudy.domain.Member;
import java.util.List;

public interface IMemberService {
    Long join(Member member);
    List<Member> findMembers();
    Member findOne(Long memberId);
}
