package com.example.memo.controllers;


import com.example.memo.models.Memo;
import com.example.memo.services.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/memo")
    public ResponseEntity<List<Memo>> getAllMemos() {
        List<Memo> memos = memoService.findAllMemo();
        return new ResponseEntity<>(memos, HttpStatus.OK);
    }

    @GetMapping("/memo/{id}")
    public ResponseEntity<Memo> getMemoById(@PathVariable("id") Long id) {
        Memo memo = memoService.findMemoById(id);
        return new ResponseEntity<>(memo, HttpStatus.OK);
    }

    @PostMapping("/memo/add")
    public ResponseEntity<Memo> addMemo(@RequestBody Memo memo) {
        Memo newMemo = memoService.addMemo(memo);
        return new ResponseEntity<>(newMemo, HttpStatus.CREATED);
    }

    @PutMapping("/memo/update/{id}")
    public ResponseEntity<Memo> editMemo(@PathVariable("id") Long id, @RequestBody Memo memo) {
        Memo updatedMemo = memoService.updateMemo(id , memo);
        return new ResponseEntity<>(updatedMemo, HttpStatus.OK);
    }

    @PutMapping("/memo/update/likes/{id}")
    public ResponseEntity<Memo> editMemoLikes(@PathVariable("id") Long id){
        Memo updatedMemo = memoService.updateMemoLikes(id);
        return new ResponseEntity<>(updatedMemo, HttpStatus.OK);
    }

    @DeleteMapping("/memo/delete/{id}")
    public ResponseEntity<?> deleteMemo(@PathVariable("id") Long id){
        memoService.deleteMemo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
