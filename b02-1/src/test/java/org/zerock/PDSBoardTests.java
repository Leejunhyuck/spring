package org.zerock;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zerock.domain.PDSBoard;
import org.zerock.domain.PDSfile;
import org.zerock.persistence.PdsBoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class PDSBoardTests {

  @Autowired
  PdsBoardRepository repo;
  

  @Test
  public void testInsertPDS(){
    
    PDSBoard pds = new PDSBoard();
    pds.setPname("DOCUMNET 1 - 2");
    
    PDSfile file1 = new PDSfile();
    file1.setPdsfile("file1.doc");
    
    PDSfile file2 = new PDSfile();
    file2.setPdsfile("file2.doc");
    
    pds.setFiles(Arrays.asList(file1,file2));
    
    log.info("try to save pds");
    
    repo.save(pds);
        
  }
}
