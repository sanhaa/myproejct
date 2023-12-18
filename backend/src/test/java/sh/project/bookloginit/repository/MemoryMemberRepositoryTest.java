package sh.project.bookloginit.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sh.project.bookloginit.domain.Member;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearAll();
    }

    @Test
    @DisplayName("saveTest: 새로운 member가 정상적으로 save 됩니다.")
    public void saveTest() {
        Member member = new Member();
        member.setName("testuser");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); // Optional 은 get으로 받아와야 합니다.

        // STUDY: assertThat(actual).isEqualTo(expected)
        assertThat(member).isEqualTo(result);
    }

    @Test
    @DisplayName("findByNameTest: 해당 name을 가진 member를 찾습니다.")
    public void findByNameTest() {
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        Member result = repository.findByName("member2").get();

        assertThat(member2).isEqualTo(result);
    }

    @Test
    @DisplayName("findAllTest: 저장된 member List 사이즈가 일치합니다.")
    public void findAllTest(){
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("member3");
        repository.save(member3);

        List<Member> result = repository.findAll();

        assertThat(3).isEqualTo(result.size());
    }
}