package org.zerock;

import java.util.Collection;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.Board;
import org.zerock.persistence.BoardRepository;

import lombok.Setter;
import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class BoardRespositoryTests {

	 @Setter(onMethod_= {@Autowired} )
	  private BoardRepository boardRepo;

	 @Test
	  public void testInsert() {

		IntStream.range(0,100).forEach((i)->{
			
			
		
		 
	    Board board = new Board();
	    board.setTitle("게시물의 제목"+i);
	    board.setContent("게시물 내용 넣기...."+i);
	    board.setWriter("user00"+i);

	    boardRepo.save(board);
		});
	  }

	 
	 @Test
	  public void testRead(){
	    
	    //해당 게시물 번호가 있는지 우선 확인하고 진행할 것 
	    boardRepo.findById(1L)
	            .ifPresent(board -> log.info(""+board));
	    
	  }

	 
	 @Test
	  public void testUpdate(){
	    
	    log.info("Read First.........................");
	    Board board = boardRepo.findById(1L).get();
	    
	    log.info("Update Title.......................");
	    board.setTitle("수정된 제목입니다");
	    
	    log.info("Call Save( ).......................");
	    boardRepo.save(board);
	    
	  }

	 @Test
	  public void testDelete(){
	    
	    System.out.println("DELETE Entity ");
	    
	    //1.5 
	    //boardRepo.delete(1L);
	    //2.x
	    boardRepo.deleteById(1L);
	    
	    
	  }
	 @Test
	  public void testByWriter() {

	    Collection<Board> results = boardRepo.findByWriter("user00");

	    results.forEach(
	        board -> System.out.println(board)
	    );
	  }

	
}
