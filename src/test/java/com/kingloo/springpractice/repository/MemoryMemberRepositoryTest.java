package com.kingloo.springpractice.repository;

import com.kingloo.springpractice.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


// 여기서 Test 코드를 돌려서 클래스 단위로 테스트도 가능
class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();

    // 테스트는 서로 의존관계가 없이 설계되어야함
    // 그래서 각 메소드의 테스트가 끝날때마다 데이터가 비워지도록 해주는 코드임
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // Assertions 에 option + Enter 쳐서 바로 assertThat 사용 가능
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result).hasSize(2);
    }
}
