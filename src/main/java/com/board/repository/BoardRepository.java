package com.board.repository;

import com.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // 아래 쿼리문에 nativeQuery=true를 사용하면
    // 실제 테이블 이름을 적용 시켜서 사용할 수 있음
    // 지금 코드는 사용하지 않고 entity 기준으로 사용하며 엔티티 이름에 대한 약어 설정 필수
    @Modifying
    @Query(value="update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id")
    void updateHits(@Param("id") Long id);

}
