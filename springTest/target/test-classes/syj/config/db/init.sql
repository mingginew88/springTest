delete from member where mem_id = 's001';

update article set article_title = '123', article_content = '123123' where article_no = 1;

insert into article(article_no, article_gno, article_title, article_content, article_writer, article_date, article_del_confirm, board_no, mem_id) values(2 ,2 ,'123','123','syjun88','18/08/09','N',1,'syjun88');

insert into attachment(attach_no, attach_upload_name, attach_path, attach_name, article_no) values(1, '','','',1);



commit;