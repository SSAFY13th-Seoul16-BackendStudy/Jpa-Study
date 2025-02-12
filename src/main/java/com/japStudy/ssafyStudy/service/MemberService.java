package com.japStudy.ssafyStudy.service;

import com.japStudy.ssafyStudy.domain.Member;
import com.japStudy.ssafyStudy.repository.IMemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements IMemberService {

    private final IMemberRepository memberRepository;

    @Override
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    private void validateDuplicateMember(Member member){
        List<Member> members = memberRepository.findByName(member.getName());
        if(!members.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다! 회원 이름 :"+member.getName());
        }
    }
}
