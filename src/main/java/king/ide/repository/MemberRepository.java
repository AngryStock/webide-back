package king.ide.repository;

import jakarta.persistence.EntityManager;
import king.ide.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public long save(Member member) {
        em.persist(member);
        return member.getId();
    }
}
