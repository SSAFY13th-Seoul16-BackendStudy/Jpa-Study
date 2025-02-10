package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)    // spring 과 함께 테스트
@SpringBootTest                 // 동일한 역할, 둘 다 적어줘야 함
@Transactional                  // test 끝나고 롤백
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    //@Rollback(value = false)  // 롤백 취소
    public void 회원가입() {
        Member member = new Member();
        member.setName("kim");

        Long savedId = memberService.join(member);

        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() {
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        memberService.join(member1);
        memberService.join(member2);  // 예외 발생

        fail("예외가 발생해야 한다.");
    }
}