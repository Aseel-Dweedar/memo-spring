package com.example.memo;

import com.example.memo.models.Memo;
import com.example.memo.repos.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemoApplication.class, args);

		String[] tags = {"s", "d"};

        Memo aseel = new Memo("title", "message", "creator", tags , "image");

		Memo ashar = new Memo("title", "message", "creator", tags , "image");

	}

}
