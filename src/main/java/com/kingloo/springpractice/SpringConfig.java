package com.kingloo.springpractice;

import com.kingloo.springpractice.repository.JdbcMemberRepository;
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
        // return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
