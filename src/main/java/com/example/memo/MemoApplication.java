package com.example.memo;

import com.example.memo.models.Memo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemoApplication.class, args);

		String[] tags = {"s", "d"};

        Memo aseel = new Memo("title", "message", "creator", tags , "image");
		System.out.println(aseel.toString());
		aseel.setLikes(aseel.getLikes()+2);
		System.out.println(aseel.toString());

		Memo ashar = new Memo("title", "message", "creator", tags , "image");
		System.out.println(ashar.toString());

	}

}
