package com.bounter.mybatis.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bounter.mybatis.entity.Bounter;


/**
 * Created by simon on 2016/12/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BounterDaoTest {
	
    @Autowired
    private BounterDao bounterDao;

    @Test
    public void testFindById() throws Exception {
    	Long id = 1001L;
    	Bounter bounter = bounterDao.findById(id);
    	System.out.println(bounter.getName());
    }
    
//    @Test
//    public void testFindAll() throws Exception {
//    	List<Bounter> bounterList = bounterDao.findAll();
//    	System.out.println(bounterList.size());
//    }

//    @Test
//    public void testAdd() throws Exception {
//    	Bounter bounter = new Bounter();
//    	bounter.setId(1005L);
//    	bounter.setName("test5");
//    	bounter.setValue("mybatis5");
//    	bounter.setTimestamp(System.currentTimeMillis());
//    	bounterDao.add(bounter);
//    }
    
//    @Test
//    public void testBatchAdd() throws Exception {
//    	List<Bounter> bounterList = new ArrayList<>();
//    	Bounter bounter = new Bounter();
//    	bounter.setId(1008L);
//    	bounter.setName("test8");
//    	bounter.setValue("mybatis8");
//    	bounter.setTimestamp(System.currentTimeMillis());
//    	bounterList.add(bounter);
//    	bounter = new Bounter();
//    	bounter.setId(1007L);
//    	bounter.setName("test7");
//    	bounter.setValue("mybatis7");
//    	bounter.setTimestamp(System.currentTimeMillis());
//    	bounterList.add(bounter);
//    	bounterDao.batchAdd(bounterList);
//    }


//    @Test
//    public void testModify() throws Exception {
//    	Bounter bounter = new Bounter();
//    	bounter.setId(1001L);
//    	bounter.setName("test12");
//    	bounter.setValue("mybatis12");
//    	bounterDao.modify(bounter);
//    }
//    
//    @Test
//    public void testDelete() throws Exception {
//    	bounterDao.deleteById(1008L);
//    }
}