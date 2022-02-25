package com.example.memo.repos;

import com.example.memo.models.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemoRepository extends JpaRepository<Memo,Integer> {
    void deleteMemoById(Integer id);

    Optional findMemoById(Integer id);
}
