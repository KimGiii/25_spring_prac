package com.kingloo.springpractice;

import com.kingloo.springpractice.repository.MemberRepository;
import com.kingloo.springpractice.repository.MemoryMemberRepository;
import com.kingloo.springpractice.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// java 코드를 사용해 직접 Bean 등록
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
