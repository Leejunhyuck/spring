package org.zerock;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.FreeBoard;
import org.zerock.domain.FreeBoardReply;
import org.zerock.persistence.FreeBoardReplyRepository;
import org.zerock.persistence.FreeBoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class FreeBoardTests {
 
  @Autowired
  FreeBoardRepository boardRepo;
  
  @Autowired
  FreeBoardReplyRepository replyRepo;
  
  
  @Test
  public void insertDummy(){
    
    IntStream.range(1,200).forEach(i ->{
      
      FreeBoard board = new FreeBoard();
      board.setTitle("Free Board ... " + i);
      board.setContent("Free Content.... "+ i);
      board.setWriter("user"+ i%10 );
      
      boardRepo.save(board);
    });
      
  } 
  
  @Test
  public void insertReply1Way(){

    FreeBoard board = new FreeBoard();
    board.setBno(199L);
    
    FreeBoardReply reply = new FreeBoardReply();
    reply.setReply("REPLY..............");
    reply.setReplyer("replyer00");
    reply.setBoard(board);
    
    replyRepo.save(reply);
    
  }
  
  @Test
  public void testList1(){
    
    Pageable page = PageRequest.of(0, 10, Sort.Direction.DESC, "bno");
    
    boardRepo.getPage(page).forEach(board ->{
    
      log.info(board[0] +": " +board[1]+":" + board[2]);

      
    });
    
  }


}
