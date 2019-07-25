insert into z_app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 1000, 'خروس جنگی', 'کاسپین' ,'3.8', 'امتیازی', 1, 2300, '20.1', '1.1', '1-2-689777-63-0-181859', 0, 1);
insert into z_app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 2000, 'طاقچه', 'کاسپین' ,'4.8', 'دانستنی‌ها', 1, 2000, '23.1', '1.1', '', 0, 1);
insert into z_app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 3000, 'ديرين شاه', 'کاسپین' ,'4.8', 'تفننی', 1, 4500, '29.3', '1.5', '1-2-689777-63-0-181857', 0, 1);
insert into z_app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 4000, 'ضربه کاشته', 'گیم' ,'0.8', 'ورزشی', 1, 1800, '40.1', '4.1', '1-2-689777-63-0-181856', 0, 1);
insert into z_app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 5000, 'کمد', 'علی' ,'3.5', 'ابزارها', 0, 1200, '3.5', '1.4', '1-2-689777-63-0-181858', 0, 0);
insert into z_app_product (id, app_Code, name, developer, rate, category, is_Game, install_Count, size_mb, version, shamed, price, in_App_Purchase) values (hibernate_sequence.nextval, 6000, 'Call of Duty', 'EAGames' ,'4.6', 'Strategy', 1, 3500000, '80', '4.3', '1-2-435757-63-0-181890', 25000, 1);

insert into FILE_BODY select * from ZBCK_PERSIST_FILE_BODY;

insert into aps_category(id, name) values (seq_Category.nextval, 'Tools');
insert into aps_category(id, name) values (seq_Category.nextval, 'Games');
insert into aps_category(id, name) values (seq_Category.nextval, 'Maps & Navigation');
insert into aps_category(id, name) values (seq_Category.nextval, 'Shopping');
insert into aps_category(id, name) values (seq_Category.nextval, 'Social');

insert into aps_developer(id, title) values (seq_developer_id.nextval, 'DebugSG');
insert into aps_developer(id, title) values (seq_developer_id.nextval, 'Activision Publishing, Inc');
insert into aps_developer(id, title) values (seq_developer_id.nextval, 'Rooftop Group');
insert into aps_developer(id, title) values (seq_developer_id.nextval, 'پدیدار');
insert into aps_developer(id, title) values (seq_developer_id.nextval, 'اسنپ کو');
insert into aps_developer(id, title) values (seq_developer_id.nextval, 'Instagram');


insert into app (id, title, icon_File_Id, category_id, developer_id) values (seq_app_id.nextval, 'Speed Test', 4, 1, 1);
insert into app (id, title, icon_File_Id, category_id, developer_id) values (seq_app_id.nextval, 'Call of Duty', 1, 2, 2);
insert into app (id, title, icon_File_Id, category_id, developer_id) values (seq_app_id.nextval, 'جنگ ستارگان', 5, 2, 3);
insert into app (id, title, icon_File_Id, category_id, developer_id) values (seq_app_id.nextval, 'دیوار', 2, 4, 4);
insert into app (id, title, icon_File_Id, category_id, developer_id) values (seq_app_id.nextval, 'اسنپ', 3, 3, 5);
insert into app (id, title, icon_File_Id, category_id, developer_id) values (seq_app_id.nextval, 'Instagram', 6, 5, 6);

insert into Collection(id, position, title) values (seq_coll_id.nextval, 3, 'Top New Games');
insert into Collections_Apps(collection_id, app_id) values (seq_coll_id.currval, 2);
insert into Collections_Apps(collection_id, app_id) values (seq_coll_id.currval, 3);

insert into Collection (id, position, title) values (seq_coll_id.nextval, 2, 'به روز شده ها');
insert into Collections_Apps(collection_id, app_id) values (seq_coll_id.currval, 1);
insert into Collections_Apps(collection_id, app_id) values (seq_coll_id.currval, 5);

insert into Collection(id, position, title) values (seq_coll_id.nextval, 1, 'پر دانلودترین ها');
insert into Collections_Apps(collection_id, app_id) values (seq_coll_id.currval, 6);
insert into Collections_Apps(collection_id, app_id) values (seq_coll_id.currval, 2);
insert into Collections_Apps(collection_id, app_id) values (seq_coll_id.currval, 4);


insert into Aps_User(id, username, password) values (seq_user_id.nextval, 'erfan', '$2a$10$fw16weS5K06GiuSRtUyt2.jeSQboQtTvV0Vvx8ZsMSuVJHHgTT9TC');
insert into Aps_User(id, username, password) values (seq_user_id.nextval, 'debugsg', '123');
insert into Aps_User(id, username, password) values (seq_user_id.nextval, 'mohsen', '123');

insert into Aps_App_Rate(id, app_id, user_id, rate) values (seq_App_Rate.nextval, 1, 1, 2);
insert into Aps_App_Rate(id, app_id, user_id, rate) values (seq_App_Rate.nextval, 1, 2, 3);
insert into Aps_App_Rate(id, app_id, user_id, rate) values (seq_App_Rate.nextval, 1, 3, 5);
insert into Aps_App_Rate(id, app_id, user_id, rate) values (seq_App_Rate.nextval, 2, 1, 3);
insert into Aps_App_Rate(id, app_id, user_id, rate) values (seq_App_Rate.nextval, 2, 2, 5);
insert into Aps_App_Rate(id, app_id, user_id, rate) values (seq_App_Rate.nextval, 2, 3, 5);
insert into Aps_App_Rate(id, app_id, user_id, rate) values (seq_App_Rate.nextval, 6, 1, 2);
insert into Aps_App_Rate(id, app_id, user_id, rate) values (seq_App_Rate.nextval, 6, 2, 4);
insert into Aps_App_Rate(id, app_id, user_id, rate) values (seq_App_Rate.nextval, 6, 3, 5);


insert into Aps_App_Comment(id, app_id, user_id, comment_text) values (seq_App_Comment.nextval, 6, 1, 'به نظرم برنامه خوبیه');
insert into Aps_App_Comment(id, app_id, user_id, comment_text) values (seq_App_Comment.nextval, 6, 2, 'از تولید کنندگان برنامه تشکر می کنم');
insert into Aps_App_Comment(id, app_id, user_id, comment_text) values (seq_App_Comment.nextval, 6, 3, 'Great Application. Very thanks');
insert into Aps_App_Comment(id, app_id, user_id, comment_text) values (seq_App_Comment.nextval, 2, 1, 'خیلی بازی باحالیه');
