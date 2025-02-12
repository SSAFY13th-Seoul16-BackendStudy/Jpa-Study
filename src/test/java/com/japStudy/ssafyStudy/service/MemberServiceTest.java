package com.japStudy.ssafyStudy.service;

import static org.junit.jupiter.api.Assertions.*;

import com.japStudy.ssafyStudy.domain.Member;
import com.japStudy.ssafyStudy.repository.IMemberRepository;
import com.japStudy.ssafyStudy.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

    /**
     * @Autowired 를 통해 interface를 구현한 실제 Bean을 찾아서 자동으로 주입한다.
     * 만약 구현체가 여러개라면 NoUniqueBeanDefinitionException 을 발생시킨다
     *
     * 1. @Primary
     * 구현체 중 우선적으로 사용될 구현체에 어노테이션을 주어 오류를 방지한다.
     *
     * 2. @Bean 을 사용하여 명시적으로 주입할 수 있다.
     *
     */
    @Autowired
    IMemberRepository memberRepository;
    @Autowired
    IMemberService memberService;

    @Bean
    public IMemberService memberService() {
        return new MemberService(memberRepository);
    }
    @Bean
    public IMemberRepository memberRepository() {
        return new MemberRepository();
    }

    @Test
    public void 회원가입() throws Exception{
        //given
        Member member = new Member();
        member.setName("Kim");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test
    public void 중복_회원_예외() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("Kim");
        Member member2 = new Member();
        member2.setName("Kim");

        //when
        memberService.join(member1);

        //then
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
    }

}