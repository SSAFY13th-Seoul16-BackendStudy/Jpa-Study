package com.japStudy.ssafyStudy.repository;

import com.japStudy.ssafyStudy.domain.Member;
import java.util.List;

public interface IMemberRepository {
    void save(Member member);
    Member findOne(Long id);
    List<Member> findAll();
    List<Member> findByName(String name);
}
