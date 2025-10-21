package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryMemberRepository implements MemberRepository {
//    private static Map<Long, Member> store = new HashMap<>();
    // HashMap은 동시성 이슈가 발생 가능. 이런 경우 ConcurrentHashMap을 사용함.
    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
