--delete data for init
delete from reply;
delete from attachment;
delete from article;
delete from member;
delete from board;

insert into member(mem_id, mem_name, mem_pw, mem_call_cnt, mem_joindate, mem_addr1, mem_addr2, mem_zipcd, mem_tel, mem_email) values('syjun88', '서영준', '3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 0, sysdate, '전남', '순천시', '12345', '010-9820-1234','seo@naver.com');
insert into board values(1,'자유게시판', 'Y');
insert into article(article_no, article_gno, article_title, article_content, article_writer, article_date, article_del_confirm, board_no, mem_id) values(1 ,1 ,'123','123','syjun88','18/08/09','N',1,'syjun88');
insert into attachment values (4, 'sally.png', 'D:\\A_TeachingMaterial\\7.JspSrpgin\\fileUpload','5098a838-a010-4efa-9de4-c2d7974f5100', 1);
insert into reply values(1,'syjun88', sysdate, '123', 'N', 1, 'syjun88');


commit;