package com.example.memo.repos;

import com.example.memo.models.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface MemoRepository extends JpaRepository<Memo,Long> {
    void deleteMemoById(Long id);

    Optional<Memo> findMemoById(Long id);
}
