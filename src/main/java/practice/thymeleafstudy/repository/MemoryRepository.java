package practice.thymeleafstudy.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import practice.thymeleafstudy.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class MemoryRepository {

    private static final Map<Integer, Member> store = new HashMap<>();

    public void save(Member member) {
        store.put(member.getNumber(), member);
    }

    public Member findByMember(int no) {
        return store.get(no);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
