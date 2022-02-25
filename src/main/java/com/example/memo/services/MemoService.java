package com.example.memo.services;

import com.example.memo.models.Memo;
import com.example.memo.repos.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class MemoService {
    private final MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo addMemo(Memo memo) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        memo.setCreatedAt(dtf.format(now));
        memo.setLikes(0);
        return memoRepository.save(memo);
    }

    public List<Memo> findAllMemo() {
        return memoRepository.findAll();
    }

    public Memo findMemoById(Integer id) {
        return memoRepository.findMemoById(id).orElseThrow(()->new UserNotFoundException(id +" not found"));
    }

    public Memo updateMemo(Memo memo) {
        return memoRepository.save(memo);
    }

    public Memo updateMemoLikes(Memo memo) {
        memo.setLikes(memo.getLikes()+1);
        return memoRepository.save(memo);
    }

    public void deleteMemoById(Integer id) {
        memoRepository.deleteMemoById(id);
    }
}
