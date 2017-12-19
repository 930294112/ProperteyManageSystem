package com.lanou.util;

import com.lanou.sys.role.bean.Role;
import com.lanou.sys.role.mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;

/**
 * /Users/dllo/Desktop/Crawler_new_连接数据库/.idea/index
 */
public class Index {

    private SqlSession session;
    private RoleMapper roleMapper;


    public void index() throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream("spring/spring-config.xml");
//
//        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//
//        session = sessionFactory.openSession();
//
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("SSM-mybatis.xml");
        roleMapper = (RoleMapper) context.getBean("roleMapper");




    //    @After
//    public void close(){
//        session.commit();
//        session.close();
//    }
    IndexWriter indexWriter = null;

        try {
            FSDirectory directory = FSDirectory.open(FileSystems.getDefault().getPath("/Users/dllo/Desktop/ProperteyManageSystem/.idea/index"));
            //汉语分词器 HanLPAnalyzer
            Analyzer analyzer = new StandardAnalyzer();

            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

            indexWriter = new IndexWriter(directory, indexWriterConfig);


            //写入之间清除之前的所有索引
            //TODO:实际使用时注意删除这一行
            indexWriter.deleteAll();


//        CostMapper mapper = session.getMapper(CostMapper.class);
            List<Role> all = roleMapper.findAll();

            for (Role role : all) {

//            System.out.println(role.getName());
                //将每个文件写入索引中
                Document doc = new Document();
                doc.add(new Field("content", String.valueOf(role), TextField.TYPE_STORED));
                indexWriter.addDocument(doc);

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (indexWriter != null) {
                try {
                    indexWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }





}


