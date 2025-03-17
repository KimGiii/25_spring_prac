package com.kingloo.springpractice;

import com.kingloo.springpractice.repository.JdbcMemberRepository;
import com.kingloo.springpractice.repository.JdbcTemplateMemberRepository;
import com.kingloo.springpractice.repository.MemberRepository;
import com.kingloo.springpractice.repository.MemoryMemberRepository;
import com.kingloo.springpractice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

// java 코드를 사용해 직접 Bean 등록
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //  return new MemoryMemberRepository();
        // 스프링을 쓰는 이유! -> 어셈블리(애플리케이션을 설정하는 코드)만 손대면 다른 코드에 손대지 않아도된다!
        // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
