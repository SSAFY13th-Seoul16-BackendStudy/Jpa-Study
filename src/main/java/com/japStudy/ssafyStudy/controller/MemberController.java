package com.japStudy.ssafyStudy.controller;

import com.japStudy.ssafyStudy.domain.Address;
import com.japStudy.ssafyStudy.domain.Member;
import com.japStudy.ssafyStudy.service.IMemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final IMemberService memberService;

    @GetMapping("/member")
    public String member(Model model) {
        model.addAttribute("member", new Member());
        return "members/memberList";
    }

    @GetMapping(value = "/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm",new MemberForm());
        return "members/memberForm";
    }
    @PostMapping("/members/new")
    public String create(@Valid MemberForm memberForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            // form 화면으로 돌려보내기
            return "members/memberForm";
        }
        Address address = new Address(memberForm.getCity(),memberForm.getStreet(),memberForm.getZipcode());
        Member member = new Member();
        member.setName(memberForm.getName());
        member.setAddress(address);
        memberService.join(member);
        return "redirect:/";
    }

}
