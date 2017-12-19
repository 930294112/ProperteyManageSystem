package com.lanou.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import javax.servlet.http.HttpSession;
import java.io.StringReader;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 17/11/24.
 */
public class Search  {

    public void search(String keyword,HttpSession session){

        List arrayList = new ArrayList();
        try {
            Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("/Users/dllo/Desktop/ProperteyManageSystem/.idea/index"));

            DirectoryReader reader = DirectoryReader.open(directory);
            IndexSearcher indexSearcher = new IndexSearcher(reader);
            Analyzer analyzer = new StandardAnalyzer();
            QueryParser queryParser = new QueryParser("content", analyzer);
            Query query = queryParser.parse(keyword);

            //第二个参数是显示的条数(我限制最大 为10条)
            TopDocs hits = indexSearcher.search(query, 10);

            //totalHits总点击量
            System.out.println("共搜索到结果量"+hits.totalHits);



            //获取结果集
//            ScoreDoc[] scoreDocs = hits.scoreDocs;
//
//            for (ScoreDoc scoreDoc : scoreDocs) {
//                Document document = indexSearcher.doc(scoreDoc.doc);
//                System.out.println(document.get("content"));
//
//        }


//            +++++++++++++++++高亮++++++++++++++++  关键字"百度"

            //高亮评分
            QueryScorer queryScorer = new QueryScorer(query);

            //将原始的字符串拆分成独立的片段
            Fragmenter fragmenter = new SimpleSpanFragmenter(queryScorer);

            //定义高亮显示的html标签
            SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<font color='red'>","</font>");

            //高亮分析器
            Highlighter highlighter = new Highlighter(simpleHTMLFormatter,queryScorer);

            highlighter.setTextFragmenter(fragmenter);


            for (ScoreDoc scoreDoc : hits.scoreDocs) {




                Document document = indexSearcher.doc(scoreDoc.doc);


                String content = document.get("content");


                if (content != null){
                    //TokenStream
                    //分词器做好处理之后得到的一个流,
                    //这个流中存储了分词的各项信息,
                    //可以通过TokenStream有效的获取分词单元


                    TokenStream tokenStream = analyzer.tokenStream("content",new StringReader(content));

                    String hContent = highlighter.getBestFragment(tokenStream, content);

                    if (StringUtil.isEmpty(hContent)){



                    }else {
                        System.out.println("结果"+hContent);



                        String[]  strs= hContent.split(",");

                        System.out.println("截取+++++"+strs[2].toString());


                        String[] split = strs[2].toString().split("=");
                        String s = split[1].toString();



                        System.out.println("截取02+++"+ s);

                        arrayList.add(s);

//   过时啦 有问题
//                        System.out.println(hContent.charAt(56));
//
//                        arrayList.add( hContent.charAt(56));


                    }



                }


            }

            System.out.println("arrayList++++++"+arrayList);
            session.setAttribute("roleId",arrayList);

        } catch (Exception e) {
            e.printStackTrace();
        }





    }


}
